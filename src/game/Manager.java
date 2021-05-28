package game;

import java.awt.Graphics;
import java.util.ArrayList;

public class Manager {
	Player p;
	ArrayList<Slash> slash = new ArrayList<Slash>();
	//ArrayList<Basic_Enemy> goomba = new ArrayList<Basic_Enemy>();
	Basic_Enemy goomba = new Basic_Enemy(600,650,30,50);
	Boss bowser = new Boss(1200, 600, 60, 100);
	int steel = 0;
	int shell = 0;
	
	public Manager(Player p) {
		this.p = p;
	}

	public void draw(Graphics g) {
	if (p.isActive==true) {
		p.draw(g);
	}
	else {
		//System.out.println("you lose");
	}
	//	for (Basic_Enemy fight : goomba) {
		//	fight.draw(g);
		//}
		goomba.draw(g);
	if (bowser.isActive==true) {
		bowser.draw(g);
	}

		for (Slash slice : slash) {
		//	System.out.println("draw");
			slice.draw(g);
		}
	}

	public void checkCollision() {
			if (p.collisionBox.intersects(goomba.collisionBox) && goomba.isActive == true) {
				if (steel >= 10) {
					p.lives-=1;
					steel = 0;
				}
			}
			if (p.collisionBox.intersects(bowser.collisionBox) && bowser.isActive == true) {
				if (steel >= 15) {
					p.lives-=1;
					steel = 0;
				}
			}
			for (int i = 0; i < slash.size(); i++) {
				if (goomba.collisionBox.intersects(slash.get(i).collisionBox)) {
					goomba.lives-=1;
				}
			}
			for (int i = 0; i < slash.size(); i++) {
				if (bowser.collisionBox.intersects(slash.get(i).collisionBox)) {
					if (shell >= 10) {
						bowser.lives-=1;
						shell = 0;
					}
				}
			}
		}
	

	private void purgeObjects() {
		for (int i = 0; i < slash.size(); i++) {
			if (slash.get(i).isActive == false) {
				slash.remove(i);
			}
			if (p.lives<=0) {
				p.isActive=false;
				//System.out.println("Player dead");
			}
			if (goomba.lives<=0) {
				goomba.isActive=false;
				//System.out.println("Goomba dead");
			}
			if (bowser.lives<=0) {
				bowser.isActive=false;
				//System.out.println("Bowser dead");
			}
			}
		}


	public void addEnemy() {
		//goomba.add(new Basic_Enemy(600, 650, 30, 50));
	}

	public void update() {
		goomba.update();
		p.pUpdate();
		bowser.update();
		if (p.lives<=0) {
			p.isActive = false;
		}
		for (int i = 0; i < slash.size(); i++) {
			slash.get(i).update();
		}
		checkCollision();
		purgeObjects();
		steel+=1;
		shell +=1;
	}

	public void addSlash(Slash s) {
		slash.add(s);
	}

}
