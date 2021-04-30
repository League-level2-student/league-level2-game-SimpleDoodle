package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Boss extends GObject {
	public Boss(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		if (isActive == true) {
			g.setColor(Color.MAGENTA);
			g.fillRect(x, y, width, height);
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

	;
	int speedx = 10;

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
