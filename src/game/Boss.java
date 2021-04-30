package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Boss extends GObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	public Boss(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		if (needImage) {
		    loadImage ("Pogchamp.png");
		}
	}

	public void draw(Graphics g) {
		if (isActive == true) {
			if (gotImage) {
				g.drawImage(image, x, y, width, height, null);
			} else {
				g.setColor(Color.MAGENTA);
				g.fillRect(x, y, width, height);
			}
		}
	}

	Random r = new Random();
	int Dash = 0;
	int Gravity = 20;
	int Jump = 1;
	int LEFT = 0;
	int RIGHT = 1;
	int DIRECTION = LEFT;
	int counter = 0;
	int lives = 10;
	boolean isActive = false;
	int speedx = 10;
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	public void update() {
		super.update();
		// if (counter == 2) {
		// System.out.println("counter works");
		// }
		if (isActive == true) {
			if (DIRECTION == RIGHT) {
				x += speedx;
			} else if (DIRECTION == LEFT) {
				x -= speedx;
			}
		}
		if (x <= 0 && DIRECTION == LEFT) {
			DIRECTION = RIGHT;
		}
		if (x >= 1450 && DIRECTION == RIGHT) {
			DIRECTION = LEFT;
		}
		counter++;
		if (counter >= 40) {
			if (counter >= 65) {
				if (y < 570 + Gravity) {
					// System.out.println("down");
					y += Gravity;
				}
				if (y >= 600) {
					speedx = 10;
					counter = 0;
				}
			} else {
				// System.out.println("up");
				y -= 20;
				speedx = 0;
			}
		}

	}
}
