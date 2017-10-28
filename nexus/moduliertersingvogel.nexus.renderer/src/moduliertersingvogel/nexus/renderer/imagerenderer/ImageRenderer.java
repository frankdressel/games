package moduliertersingvogel.nexus.renderer.imagerenderer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Random;

import javax.imageio.ImageIO;

import moduliertersingvogel.nexus.model.Ebene;
import moduliertersingvogel.nexus.model.Ebenenfarbe;
import moduliertersingvogel.nexus.model.Ebenenstatus;
import moduliertersingvogel.nexus.model.Gestalt;
import moduliertersingvogel.nexus.model.Nexus;
import moduliertersingvogel.nexus.model.Positioniert;
import moduliertersingvogel.nexus.model.Spiel;
import moduliertersingvogel.nexus.model.Spieler;
import moduliertersingvogel.nexus.model.Zug;
import moduliertersingvogel.nexus.renderer.IRenderer;

public class ImageRenderer implements IRenderer {

	int sizeOfebene = 100;
	private double radiusX = 0.6;
	private double radiusY = 0.5;
	Map<Polygon, Positioniert> map = new HashMap<>();

	Map<Spieler, Color> farben = new HashMap<>();

	private Random randomGenerator = new Random();

	@Override
	public BufferedImage renderebenen(Spiel spiel) {
		AxisBounds axisBounds = new AxisBounds(spiel);

		BufferedImage ebenenImage = createEmptyImage(axisBounds);

		Graphics2D graphics = setUpGraphics(ebenenImage);

		int coordinationNumberOfLattice = 6;

		for (Ebene ebene : spiel.getEbenen()) {
			Coordinates coordinates = new Coordinates(ebene, axisBounds,
					coordinationNumberOfLattice, 1);

			graphics.setColor(ebene.getFarbe() == Ebenenfarbe.GRUEN ? Color.GREEN
					: (ebene.getFarbe() == Ebenenfarbe.ORANGE ? Color.ORANGE
							: Color.RED));

			Polygon polygon = null;
			if (ebene.getStatus() != Ebenenstatus.LEER) {
				polygon = new Polygon(coordinates.getX(), coordinates.getY(),
						coordinationNumberOfLattice);
				graphics.fillPolygon(polygon);
			} else {
				polygon = new Polygon(coordinates.getX(), coordinates.getY(),
						coordinationNumberOfLattice);
				graphics.drawPolygon(polygon);
			}
			map.put(polygon, ebene);
		}

		graphics.dispose();

		try {
			System.out.println(new File("test.png").getAbsolutePath());
			ImageIO.write(ebenenImage, "png", new File("test.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ebenenImage;
	}

	@Override
	public List<Positioniert> getPositioniertAtLocation(int x, int y) {
		List<Positioniert> found = new ArrayList<>();
		for (Entry<Polygon, Positioniert> entry : map.entrySet()) {
			if (entry.getKey().contains(x, y)) {
				found.add(entry.getValue());
			}
		}
		return found;
	}

	@Override
	public BufferedImage rendergestalten(Spiel spiel) {
		AxisBounds axisBounds = new AxisBounds(spiel);

		BufferedImage gestaltImage = createEmptyImage(axisBounds);

		Graphics2D graphics = setUpGraphics(gestaltImage);

		Set<Gestalt> gestalten = new HashSet<>();
		for (Zug zug : spiel.getZuege()) {
			gestalten.add(zug.getGestalt());
		}

		for (Gestalt gestalt : gestalten) {
			Spieler spieler = gestalt.getSpieler();
			Color color = farben.get(spieler);
			if (color == null) {
				color = new Color(randomGenerator.nextInt(255),
						randomGenerator.nextInt(255),
						randomGenerator.nextInt(255));
				farben.put(spieler, color);
			}

			if (gestalt instanceof Nexus) {
				int coordinationNumberOfLattice = 4;

				Color colors[] = new Color[4];
				colors[0] = Color.BLACK;
				colors[1] = farben.get(spieler);
				colors[2] = Color.BLACK;
				colors[3] = farben.get(spieler);

				float scale = 0.5f;

				for (int i = 0; i < colors.length; i++) {
					Coordinates coordinates = new Coordinates(gestalt,
							axisBounds, coordinationNumberOfLattice, scale);

					graphics.setColor(colors[i]);

					Polygon polygon = new Polygon(coordinates.getX(),
							coordinates.getY(), coordinationNumberOfLattice);
					graphics.fillPolygon(polygon);
					map.put(polygon, gestalt);

					scale = scale - 0.1f;
				}
			}
		}

		graphics.dispose();

		return gestaltImage;
	}

	private Graphics2D setUpGraphics(BufferedImage ebenenImage) {
		Graphics2D graphics = ebenenImage.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		return graphics;
	}

	private BufferedImage createEmptyImage(AxisBounds axisBounds) {
		BufferedImage ebenenImage = new BufferedImage(
				(int) ((axisBounds.getUpperAxisBound().x
						- axisBounds.getLowerAxisBound().x + 1)
						* sizeOfebene * (radiusX / radiusY)),
				(axisBounds.getUpperAxisBound().y
						- axisBounds.getLowerAxisBound().y + 1)
						* sizeOfebene, BufferedImage.TYPE_INT_ARGB);
		return ebenenImage;
	}

	private class AxisBounds {
		Point lowerAxisBound = new Point();
		Point upperAxisBound = new Point();

		public Point getLowerAxisBound() {
			return lowerAxisBound;
		}

		public Point getUpperAxisBound() {
			return upperAxisBound;
		}

		private AxisBounds(Spiel spiel) {
			for (Ebene ebene : spiel.getEbenen()) {
				int x = ebene.getX();
				int y = ebene.getY();
				lowerAxisBound.x = Math.min(lowerAxisBound.x, x);
				lowerAxisBound.y = Math.min(lowerAxisBound.y, y);
				upperAxisBound.x = Math.max(upperAxisBound.x, x);
				upperAxisBound.y = Math.max(upperAxisBound.y, y);
			}
		}
	}

	private class Coordinates {
		int x[];
		int y[];

		public int[] getX() {
			return x;
		}

		public int[] getY() {
			return y;
		}

		private Coordinates(Positioniert positioniert, AxisBounds axisBounds,
				int numberOfCorners, float scaling) {
			x = new int[numberOfCorners];
			y = new int[numberOfCorners];
			for (int i = 0; i < numberOfCorners; i++) {
				double angle = Math.PI * 2 / numberOfCorners * i + Math.PI
						/ numberOfCorners;
				// x and y uses different radii. This is because spacing between
				// the hexagonal elements is different in x and y-direction.
				// Different scaling factors compensate this but on the other
				// hand lead to non-quadratic shapes.
				double xRaw = positioniert.getX() + radiusX * Math.sin(angle)
						* scaling;
				x[i] = (int) ((xRaw - axisBounds.getLowerAxisBound().x + radiusX) * sizeOfebene);
				double yRaw = positioniert.getY() + radiusY * Math.cos(angle)
						* scaling;
				y[i] = (int) ((yRaw - axisBounds.getLowerAxisBound().y + 0.5 + Math
						.abs(positioniert.getX()) * 0.5) * sizeOfebene);
			}
		}
	}
}
