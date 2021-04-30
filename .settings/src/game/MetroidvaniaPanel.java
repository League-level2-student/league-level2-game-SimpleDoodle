package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MetroidvaniaPanel extends JPanel implements KeyListener, ActionListener {
	Font titleFont;
	Font enterFont;
	Font instructionsFont;
	Font endFont;
	Font enderFont;
	Font paused;
	Font unpaused;
	Font movement;
	Font backmenu;
	Font enterroom;
	Font attack;
	Font jump;
	Font instructitle;
	Font lostitle;
	Font lostenter;
	int MENU = 0;
	int GAME = 1;
	int PAUSE = 2;
	int INSTRUCT = 3;
	int LOST = 4;
	int BOSSROOM = 1;
	int wRoom = 0;
	int currentState = MENU;
	Timer frameDraw;
	Player player = new Player(150, 650, 30, 50);
	Manager mm = new Manager(player);
	int RIGHT = 0;
	int LEFT = 1;
	int UP = 2;
	int DOWN = 3;
	int Direction = RIGHT;

	void updateMenuState() {

	}

	void updateGameState() {
		mm.update();
	}

	void updatePauseState() {

	}

	void updateInstructState() {

	}

	void updateVoidState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("A Metroidvania", 520, 120);
		g.setFont(enterFont);
		g.setColor(Color.WHITE);
		g.drawString("Press ENTER to start", 615, 300);
		g.setFont(instructionsFont);
		g.setColor(Color.WHITE);
		g.drawString("Press SPACE for instructions", 570, 480);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 700, GameRunner.WIDTH, 100);
		if (wRoom != BOSSROOM) {
			g.setColor(Color.BLACK);
			g.fillRect(1300, 600, 80, 100);
		}
		if (wRoom == BOSSROOM) {
			mm.goomba.isActive = false;
			g.setColor(Color.RED);
			if (mm.bowser.lives <= 0) {
				g.setColor(Color.BLACK);
			}
			g.fillRect(10, 720, 50, 50);
			if (mm.bowser.lives <= 1) {
				g.setColor(Color.BLACK);
			}
			g.fillRect(80, 720, 50, 50);
			if (mm.bowser.lives <= 2) {
				g.setColor(Color.BLACK);
			}
			g.fillRect(150, 720, 50, 50);
			if (mm.bowser.lives <= 3) {
				g.setColor(Color.BLACK);
			}
			g.fillRect(220, 720, 50, 50);
			if (mm.bowser.lives <= 4) {
				g.setColor(Color.BLACK);
			}
			g.fillRect(290, 720, 50, 50);
			if (mm.bowser.lives <= 5) {
				g.setColor(Color.BLACK);
			}
			g.fillRect(360, 720, 50, 50);
			if (mm.bowser.lives <= 6) {
				g.setColor(Color.BLACK);
			}
			g.fillRect(430, 720, 50, 50);
			if (mm.bowser.lives <= 7) {
				g.setColor(Color.BLACK);
			}
			g.fillRect(500, 720, 50, 50);
			if (mm.bowser.lives <= 8) {
				g.setColor(Color.BLACK);
			}
			g.fillRect(570, 720, 50, 50);
			if (mm.bowser.lives <= 9) {
				g.setColor(Color.BLACK);
			}
			g.fillRect(640, 720, 50, 50);
			mm.draw(g);
		}
		g.setColor(Color.BLACK);
		g.setColor(Color.RED);
		if (mm.p.lives <= 0) {
			g.setColor(Color.BLACK);
			currentState = LOST;
		}
		g.fillRect(10, 20, 50, 50);
		if (mm.p.lives <= 1) {
			g.setColor(Color.BLACK);
		}
		g.fillRect(80, 20, 50, 50);
		if (mm.p.lives <= 2) {
			g.setColor(Color.BLACK);
		}
		g.fillRect(150, 20, 50, 50);
		if (mm.p.lives <= 3) {
			g.setColor(Color.BLACK);
		}
		g.fillRect(220, 20, 50, 50);
		if (mm.p.lives <= 4) {
			g.setColor(Color.BLACK);
		}
		g.fillRect(290, 20, 50, 50);
		mm.draw(g);

	}

	void drawPauseState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
		g.setFont(paused);
		g.setColor(Color.WHITE);
		g.drawString("GAME PAUSED", 520, 250);
		g.setFont(unpaused);
		g.setColor(Color.WHITE);
		g.drawString("Press ENTER to resume", 635, 350);
	}

	void drawInstructState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
		g.setFont(movement);
		g.setColor(Color.WHITE);
		g.drawString("Use the arrow keys to move", 570, 250);
		g.setFont(attack);
		g.setColor(Color.WHITE);
		g.drawString("Press X to attack", 625, 350);
		g.setFont(jump);
		g.setColor(Color.WHITE);
		g.drawString("Press Z to jump", 630, 410);
		g.setFont(backmenu);
		g.setColor(Color.WHITE);
		g.drawString("Press ENTER to return to the menu", 400, 600);
		g.setFont(enterroom);
		g.setColor(Color.WHITE);
		g.drawString("The UP arrow to enter rooms", 565, 470);
		g.setFont(instructitle);
		g.setColor(Color.WHITE);
		g.drawString("INSTRUCTIONS", 480, 150);
	}

	void drawLostState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
		g.setColor(Color.WHITE);
		g.setFont(lostitle);
		g.drawString("YOU LOST", 580, 200);
		g.setFont(lostenter);
		g.setColor(Color.WHITE);
		g.drawString("Press ENTER to continue", 600, 440);
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == PAUSE) {
			drawPauseState(g);
		} else if (currentState == INSTRUCT) {
			drawInstructState(g);
		} else if (currentState == LOST) {
			drawLostState(g);
		}

	}

	public MetroidvaniaPanel() {
		titleFont = new Font("Arial", Font.PLAIN, 72);
		enterFont = new Font("Arial", Font.PLAIN, 28);
		endFont = new Font("Arial", Font.PLAIN, 48);
		enderFont = new Font("Arial", Font.PLAIN, 18);
		instructionsFont = new Font("Arial", Font.PLAIN, 28);
		paused = new Font("Arial", Font.PLAIN, 72);
		unpaused = new Font("Arial", Font.PLAIN, 28);
		movement = new Font("Arial", Font.PLAIN, 28);
		attack = new Font("Arial", Font.PLAIN, 28);
		jump = new Font("Arial", Font.PLAIN, 28);
		backmenu = new Font("Arial", Font.PLAIN, 48);
		enterroom = new Font("Arial", Font.PLAIN, 28);
		instructitle = new Font("Arial", Font.PLAIN, 72);
		lostitle = new Font("Arial", Font.PLAIN, 72);
		lostenter = new Font("Arial", Font.PLAIN, 28);

		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU) {
				currentState = GAME;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState == MENU) {
				currentState = INSTRUCT;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if (currentState == GAME) {
				currentState = PAUSE;
				System.out.println("paused");
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			if (currentState == GAME) {
				currentState = LOST;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == PAUSE) {
				currentState = GAME;
				System.out.println("unpaused");
			}
			if (currentState == INSTRUCT) {
				currentState = MENU;
			}
			if (currentState == LOST) {
				mm.p.lives = 5;
				mm.p.x = 150;
				mm.p.y = 650;
				mm.p.isActive = true;
				wRoom = 0;
				mm.bowser.lives = 10;
				mm.bowser.isActive = false;
				mm.goomba.isActive = true;
				mm.bowser.x = 1200;
				mm.bowser.y = 600;
				mm.goomba.x = 600;
				mm.goomba.y = 650;
				mm.bowser.counter = 0;
				mm.bowser.DIRECTION = LEFT;
				mm.goomba.DIRECTION = RIGHT;
				currentState = MENU;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_Z) {
			player.up();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (player.y != 650) {
				Direction = DOWN;
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Direction = UP;
			if (player.x >= 1300 && player.x <= 1380 && player.y == 650 && currentState == GAME && wRoom != BOSSROOM) {
				wRoom = BOSSROOM;
				mm.bowser.isActive = true;
				player.x = 150;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left();
			Direction = LEFT;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right();
			Direction = RIGHT;
		}
		if (currentState == GAME) {
			if (e.getKeyCode() == KeyEvent.VK_X) {
				if (Direction == RIGHT) {
					mm.addSlash(player.getSlashRight());
				}
				if (Direction == LEFT) {
					mm.addSlash(player.getSlashLeft());
				}
				if (Direction == UP) {
					mm.addSlash(player.getSlashUp());
				}
				if (Direction == DOWN) {
					mm.addSlash(player.getSlashDown());
				}
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_Z) {
			player.speedy = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.speedx = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Direction = RIGHT;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == PAUSE) {
			updatePauseState();
		}
		repaint();
	}

}
