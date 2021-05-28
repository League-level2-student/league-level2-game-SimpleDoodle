package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Slash extends GObject {
	public  BufferedImage right;
	public  BufferedImage left;
	public  BufferedImage up;
	public  BufferedImage down;
	public  BufferedImage image;
	public  boolean needImage = true;
	public  boolean gotImage = false;
	public Slash(int x, int y, int width, int height) {
		super(x, y, width, height);
		if (needImage) {
			loadImage("SlashRight.png", "SlashLeft.png", "SlashUp.png", "SlashDown.png");
		}
		image = right;
	}
	void loadImage(String imageFile, String imageFile2, String imageFile3, String imageFile4) {
		if (needImage) {
			try {
				right = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				left = ImageIO.read(this.getClass().getResourceAsStream(imageFile2));
				up = ImageIO.read(this.getClass().getResourceAsStream(imageFile3));
				down = ImageIO.read(this.getClass().getResourceAsStream(imageFile4));
				gotImage = true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No image");
			}
			needImage = false;
		}
	}
	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);
		}
	}

	public void update() {
		super.update();
		sword += 1;
		if (sword >= 10) {
			sword = 0;
			isActive = false;
		}
	}
}
