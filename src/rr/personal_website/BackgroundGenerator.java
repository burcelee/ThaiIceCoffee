package rr.personal_website;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class BackgroundGenerator {
	
	private static final double SMALL_IMAGE_SCALE = .7;
	private static String[] smallImages = {"donut.png","computer.png"};
	
	public static void GenerateBackground(String filename) {
		int width = 1920;
		int height = 1080;
		ArrayList<BufferedImage> smalls = new ArrayList<BufferedImage>();
		for (String s : smallImages) {
			try {
				BufferedImage buf = ImageIO.read(new File(s));
				smalls.add(buf);
			} catch (IOException e) {
				System.out.print(e);
			} catch (OutOfMemoryError e) {
				//this looks horrible, but is required since Bluehost
				// occasionally prevents ImageIO.read from creating a
				// separate thread. For whatever reason
				System.err.println("ERROR: Prevented from reading background images");
				return;
			}
		}
		
		BufferedImage background = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB );
		Graphics2D backgroundGraphics = background.createGraphics();
		
		backgroundGraphics.setColor(new Color(117,205,200));
		backgroundGraphics.fillRect(0, 0, width, height);
		Random rand = new Random();
		
		for (int i = 0; i < 100; i++) {
			//Choose a small image
			BufferedImage img = smalls.get(Math.abs(rand.nextInt()) % smalls.size());
			BufferedImage imgColorized = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
			int r = rand.nextInt(255);
    		int g = rand.nextInt(255);
    		int b = rand.nextInt(255);
    		int randomColor = new Color(r,g,b).getRGB();
			for (int w = 0; w < img.getWidth(); w++) {
		        for (int h = 0; h < img.getHeight(); h++) {
		        	int color = img.getRGB(w, h);
		        	if (color == Color.red.getRGB()) {
		        		imgColorized.setRGB(w, h, randomColor);
		        	}
		        	else {
		        		imgColorized.setRGB(w, h, color);
		        	}
		        }
		    }
			int xPos = Math.abs(rand.nextInt()) % (width - (int)(img.getWidth()*SMALL_IMAGE_SCALE));
			int yPos = Math.abs(rand.nextInt()) % (height - (int)(img.getHeight()*SMALL_IMAGE_SCALE));
			double rotation = Math.toRadians(rand.nextInt(360));
			AffineTransform at = new AffineTransform();
			at.translate(xPos, yPos);
			at.rotate(rotation);
			at.scale(SMALL_IMAGE_SCALE,SMALL_IMAGE_SCALE);
			backgroundGraphics.drawImage(imgColorized, at, null);
		}
		
		try {
		File f = new File(filename);
		f.createNewFile();
		ImageIO.write(background, "png", f);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
