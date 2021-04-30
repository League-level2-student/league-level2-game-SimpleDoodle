package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Basic_Enemy extends GObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	public Basic_Enemy(int x, int y, int width, int height) {
		super(x, y, width, height);
		if (needImage) {
		    loadImage ("Ghost.png");
		}
	}
	public void  draw(Graphics g){
		if (isActive == true) {
			if (gotImage) {
				g.drawImage(image, x, y, width, height, null);
			} else {
				g.setColor(Color.GREEN);
				g.fillRect(x, y, width, height);
			}
		}
		}
	int lives = 1;
	int LEFT = 0;
	int RIGHT= 1;
	int DIRECTION = RIGHT;
	public void update() {
		super.update();
		speedx = 5;
		if (x == 600) {
			DIRECTION = RIGHT;
		}
		if (x==1200) {
			DIRECTION = LEFT;
		}
		if (DIRECTION == RIGHT) {
			x+=speedx;
		}
		else if (DIRECTION == LEFT) {
			x-=speedx;
		}
	}
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
}
