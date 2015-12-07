package alpha;

import java.awt.geom.AffineTransform;

import javax.swing.*;
import javax.imageio.*;
import java.io.File;

import java.awt.*;
import java.awt.image.*;

public class ImageUtil {
	public static BufferedImage loadImage(String fileName) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(fileName));
		} catch (Exception e) {
		}
		return img;
	}

	/*
	 * Creates an ImageIcon if the path is valid.
	 * 
	 * @param String - resource path
	 * 
	 * @param String - description of the file
	 */
	public static ImageIcon createImageIcon(String fileName) {
		try {
			return new ImageIcon(fileName);
		} catch (NullPointerException e) {
			System.err.println("Couldn't find file: " + fileName);
			return null;
		}
	}

	public static Image scaleImage(ImageIcon srcImg, int size) {
		return scaleImage(srcImg, size, size);
	}

	public static Image scaleImage(ImageIcon srcImg, int width, int height) {
		return scaleImage(srcImg.getImage(), width, height);
	}

	public static Image scaleImage(Image srcImg, int width, int height) {
		BufferedImage resizedImage = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
				BufferedImage.TYPE_INT_ARGB);
		Graphics g = resizedImage.createGraphics();
		g.drawImage(srcImg, 0, 0, width, height, null);
		return resizedImage;
	}

	public static BufferedImage rotateImage(BufferedImage image, int deg) {
		Graphics2D g2d = image.createGraphics();
		AffineTransform tx = AffineTransform.getTranslateInstance(0, 0);
		tx.rotate(Math.toRadians(deg), image.getWidth() / 2, image.getHeight() / 2);
		g2d.clearRect(0, 0, image.getWidth(), image.getHeight());
		g2d.drawImage(image, tx, null);
		return image;
	}
}