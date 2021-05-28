package game;

import javax.swing.JFrame;

public class GameRunner {
static JFrame frame = new JFrame();
static MetroidvaniaPanel mp = new MetroidvaniaPanel();

static int WIDTH = 1530;
static int HEIGHT = 830;

public static void main(String[] args) {
	frame.add(mp);
	frame.addKeyListener(mp);
	frame.setVisible(true);
	frame.setSize(WIDTH, HEIGHT);
	frame.setTitle("Metroidvania");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}