package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Printer {
	private static final String PATH = "/resources/image.bmp";

	public static int[][] retrieveImage(char white, char black) {
		try {
			BufferedImage image = ImageIO.read(Printer.class.getResource(PATH));
			int[][] imageSymbols = new int[image.getWidth()][image.getHeight()];

			for (int x = 0; x < image.getWidth(); x++) {
				for (int y = 0; y < image.getHeight(); y++) {
					int color = image.getRGB(x, y);
					if (color == Color.BLACK.getRGB()) {
						imageSymbols[x][y] = black;
					} else if (color == Color.WHITE.getRGB()) {
						imageSymbols[x][y] = white;
					}
				}
			}
			return imageSymbols;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
