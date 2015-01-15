package com.forks.Main;

import javax.swing.JFrame;

/**
 * 
 * @author anti-cookie
 * @游戏JFrame类
 */
public class Game {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame("Artifact");
		window.add(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
}
