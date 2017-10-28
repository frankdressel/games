package moduliertersingvogel.nexus.rcpcliente4.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class ImageUtil {
	public static Image resize(Image image, int width, int height) {

	      if (image == null)
	         return null;

	      final Image scaled = new Image(Display.getDefault(), width, height);
	      GC gc = new GC(scaled);
	      gc.setAntialias(SWT.ON);
	      gc.setInterpolation(SWT.HIGH);
	      gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, width, height);
	      gc.dispose();

	      return scaled;
	   }

}
