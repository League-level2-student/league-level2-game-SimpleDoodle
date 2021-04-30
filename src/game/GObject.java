package game;

import java.awt.Rectangle;

public class GObject {
	int x;
	int y;
	int width;
	int height;
	int speedx = 0;
	int speedy = 0;
	boolean isActive = true;
	static int sword = 0;	
	int lives = 0;
	Rectangle collisionBox;
	
	public GObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speedx = speedx;
		this.speedy = speedy;
		collisionBox = new Rectangle(x,y,width,height);
	}
	
	public void update() {
		collisionBox.setBounds(x,y,width,height);
	}
}