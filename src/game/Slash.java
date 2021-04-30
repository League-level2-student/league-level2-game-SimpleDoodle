package game;

import java.awt.Color;
import java.awt.Graphics;

public class Slash extends GObject {
	public Slash(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
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
