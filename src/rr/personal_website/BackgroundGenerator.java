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
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				smalls.add(ImageIO.read(new File(s)));
			} catch (IOException e) {
				System.out.print(e);
			}
		}
		
		
		BufferedImage background = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB );
		Graphics2D backgroundGraphics = background.createGraphics();
		
		backgroundGraphics.setColor(new Color(117,205,200));
		backgroundGraphics.fillRect(0, 0, width, height);
		for (int i = 0; i < 50; i++) {
			
			Random rand = new Random();
			//Choose a small image
			BufferedImage img = smalls.get(Math.abs(rand.nextInt()) % smalls.size());
			int xPos = Math.abs(rand.nextInt()) % (width - (int)(img.getWidth()*SMALL_IMAGE_SCALE));
			int yPos = Math.abs(rand.nextInt()) % (height - (int)(img.getHeight()*SMALL_IMAGE_SCALE));
			double rotation = rand.nextDouble() % (2 * Math.PI);
			AffineTransform at = new AffineTransform();
			at.translate(xPos, yPos);
			at.rotate(rotation);
			at.scale(SMALL_IMAGE_SCALE,SMALL_IMAGE_SCALE);
			backgroundGraphics.drawImage(img, at, null);
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
