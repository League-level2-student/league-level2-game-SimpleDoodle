package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import javax.imageio.ImageIO;

public class Player extends GObject {
	int lives = 5;
	int Gravity = 10;
	int counter = 0;
	boolean isActive = true;
	boolean hasJump = true;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;


	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		speedx = 0;
		speedy = 0;
		if (needImage) {
			loadImage("Silksong.png");
		}
	}
	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No image");
			}
			needImage = false;
		}
	}
	public void pUpdate() {
		super.update();
		if (y < 640 + Gravity) {
			y += Gravity;
			hasJump = false;
		}
		if (x >= 10 && speedx < 0) {
			x += speedx;
		} else if (x <= 1480 && speedx > 0) {
			x += speedx;
		}
		y += speedy;
		if (speedy == -20) {
			counter++;
			if (counter >= 20) {
				speedy = 0;
				hasJump = false;
			}
		} else {
			counter = 0;
			if (y == 640 + Gravity) {
				hasJump = true;
			}
		}
	}

	public Slash getSlashRight() {
		if (sword == 0) {
			return new Slash(x + width, y - 20, 50, 70);

		}
		return new Slash(0, 0, 0, 0);
	}

	public Slash getSlashLeft() {
		if (sword == 0) {
			return new Slash(x - width - 20, y - 20, 50, 70);
		}
		return new Slash(0, 0, 0, 0);
	}

	public Slash getSlashUp() {
		if (sword == 0) {
			return new Slash(x - width / 2 - 5, y - 25 - height / 2, 70, 50);
		}
		return new Slash(0, 0, 0, 0);

	}

	public Slash getSlashDown() {
		if (sword == 0) {
			return new Slash(x - width / 2 - 5, y + height, 70, 50);
		}
		return new Slash(0, 0, 0, 0);

	}

	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
		}
	}

	public void up() {
		if (hasJump == true) {
			speedy = -20;
		}
	}

	public void left() {
		speedx = -10;

	}

	public void right() {

		speedx = 10;

	}

}
