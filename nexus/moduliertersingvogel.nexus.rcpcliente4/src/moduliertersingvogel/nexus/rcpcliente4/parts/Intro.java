package moduliertersingvogel.nexus.rcpcliente4.parts;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import javax.inject.Inject;

import moduliertersingvogel.nexus.rcpcliente4.Activator;
import moduliertersingvogel.nexus.rcpcliente4.client.SimpleClient;
import moduliertersingvogel.nexus.rcpcliente4.util.ImageUtil;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.BundleContext;

public class Intro {
	@Inject
	public void init(Composite parent, final MApplication application,
			final MWindow window, final MPart part) {
		final Composite composite = new Composite(parent, SWT.NONE);
		try {
			InputStream openStream = FileLocator.openStream(Activator
					.getContext().getBundle(), new Path(
					"/images/intro_small.png"), false);
			final Image image = new Image(Display.getCurrent(), openStream);
			composite.setBackgroundImage(image);
			composite.addControlListener(new ControlListener() {

				@Override
				public void controlResized(ControlEvent e) {
					Point size = composite.getSize();
					composite.setBackgroundImage(ImageUtil.resize(image,
							size.x, size.y));
				}

				@Override
				public void controlMoved(ControlEvent e) {
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		composite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				URI newGame = new SimpleClient().createNewGame();
				application.getContext().set("gameuri", newGame);
				// For whatever reasons, I cannot delete the part from the
				// model? part.getParent().getChildren().remove(part); does not
				// work.
				part.setVisible(false);
				MPart mapPart = MBasicFactory.INSTANCE.createPart();
				mapPart.setContributionURI("platform:/plugin/moduliertersingvogel.nexus.rcpcliente4/moduliertersingvogel.nexus.rcpcliente4.parts.Map");
				window.getChildren().add(mapPart);
			}
		});
	}
}
