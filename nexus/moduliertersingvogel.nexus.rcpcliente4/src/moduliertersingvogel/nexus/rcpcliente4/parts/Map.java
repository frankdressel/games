package moduliertersingvogel.nexus.rcpcliente4.parts;

import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.net.URI;

import javax.inject.Inject;
import javax.inject.Named;

import moduliertersingvogel.nexus.model.Zugliste;
import moduliertersingvogel.nexus.rcpcliente4.client.SimpleClient;
import moduliertersingvogel.nexus.rcpcliente4.util.ImageUtil;
import moduliertersingvogel.nexus.renderer.imagerenderer.ImageRenderer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class Map {
	private Zugliste zugListe;
	@Inject
	public void init(Composite parent, @Named("gameuri") final URI gameURI){
		
		final SimpleClient simpleClient=new SimpleClient();
		
		Composite container=new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout());
		
		final Combo combo=new Combo(container, SWT.DROP_DOWN);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Selected: "+combo.getItem(combo.getSelectionIndex()));
				zugListe=simpleClient.getZuege(gameURI, combo.getItem(combo.getSelectionIndex()));
			}
		});
		combo.addTraverseListener(new TraverseListener() {
			public void keyTraversed(TraverseEvent e) {
				if (e.detail == SWT.TRAVERSE_RETURN) {
					e.doit = false;
					e.detail = SWT.TRAVERSE_NONE;
					String newText = combo.getText();
					try {
						combo.add(newText);
						combo.setSelection(new Point(0, newText.length()));
						simpleClient.createNewSpieler(gameURI, newText);
					} catch (NumberFormatException ex) {
					}
				}
			}
		});
		combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		final Composite composite = new Composite(container, SWT.NONE);
		BufferedImage awtBufferedImage=new ImageRenderer().renderebenen(simpleClient.getSpiel(gameURI));
		final ImageData swtImageData = convertToSWT(awtBufferedImage);
		final Image originalSWTImage=new Image(Display.getCurrent(),swtImageData);
		
		composite.setBackgroundImage(new Image(Display.getCurrent(),swtImageData));
		composite.addControlListener(new ControlListener() {
			
			@Override
			public void controlResized(ControlEvent e) {
				Point size = composite.getSize();
				composite.setBackgroundImage(ImageUtil.resize(originalSWTImage, size.x, size.y));
			}
			
			@Override
			public void controlMoved(ControlEvent e) {
				}
		});
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}
		
	/**
     * Converts a buffered image to SWT <code>ImageData</code>.
     *
     * @param bufferedImage  the buffered image (<code>null</code> not
     *         permitted).
     *
     * @return The image data.
     */
    public static ImageData convertToSWT(BufferedImage bufferedImage) {
        if (bufferedImage.getColorModel() instanceof DirectColorModel) {
            DirectColorModel colorModel
                    = (DirectColorModel) bufferedImage.getColorModel();
            PaletteData palette = new PaletteData(colorModel.getRedMask(),
                    colorModel.getGreenMask(), colorModel.getBlueMask());
            ImageData data = new ImageData(bufferedImage.getWidth(),
                    bufferedImage.getHeight(), colorModel.getPixelSize(),
                    palette);
            WritableRaster raster = bufferedImage.getRaster();
            int[] pixelArray = colorModel.getComponentSize();
            for (int y = 0; y < data.height; y++) {
                for (int x = 0; x < data.width; x++) {
                    raster.getPixel(x, y, pixelArray);
                    int pixel = palette.getPixel(new RGB(pixelArray[0],
                            pixelArray[1], pixelArray[2]));
                    data.setPixel(x, y, pixel);
                }
            }
            return data;
        }
        else if (bufferedImage.getColorModel() instanceof IndexColorModel) {
            IndexColorModel colorModel = (IndexColorModel)
                    bufferedImage.getColorModel();
            int size = colorModel.getMapSize();
            byte[] reds = new byte[size];
            byte[] greens = new byte[size];
            byte[] blues = new byte[size];
            colorModel.getReds(reds);
            colorModel.getGreens(greens);
            colorModel.getBlues(blues);
            RGB[] rgbs = new RGB[size];
            for (int i = 0; i < rgbs.length; i++) {
                rgbs[i] = new RGB(reds[i] & 0xFF, greens[i] & 0xFF,
                        blues[i] & 0xFF);
            }
            PaletteData palette = new PaletteData(rgbs);
            ImageData data = new ImageData(bufferedImage.getWidth(),
                    bufferedImage.getHeight(), colorModel.getPixelSize(),
                    palette);
            data.transparentPixel = colorModel.getTransparentPixel();
            WritableRaster raster = bufferedImage.getRaster();
            int[] pixelArray = new int[1];
            for (int y = 0; y < data.height; y++) {
                for (int x = 0; x < data.width; x++) {
                    raster.getPixel(x, y, pixelArray);
                    data.setPixel(x, y, pixelArray[0]);
                }
            }
            return data;
        }
        return null;
    }
}
