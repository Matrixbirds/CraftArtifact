package com.forks.gsm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.forks.Audio.JukeBox;
import com.forks.Handlers.Keys;
import com.forks.Main.GamePanel;
import com.forks.gsm.inter.GameState;
import com.forks.gsm.inter.GameStateMachine;

public class MenuState implements GameState {

	
	private BufferedImage head;
	private int currentChoice = 0;
	private String [] options = {
			"Start",
			"Quit"
	};
	private Color titleColor;
	private Font titleFont;
	private Font font;
	private Font font2;
	protected GameStateMachine gsm;
	
	public MenuState(GameStateMachine gsm) {
		this.gsm = gsm;
		init();
	}
	
	private void init() {
		try {
			head = ImageIO.read(
					getClass().getResourceAsStream("/HUD/Hud.gif")).getSubimage(0, 12, 12, 11);
			
			// titles and fonts
						titleColor = Color.WHITE;
						titleFont = new Font("Times New Roman", Font.PLAIN, 28);
						font = new Font("Arial", Font.PLAIN, 14);
						font2 = new Font("Arial", Font.PLAIN, 10);
						
						// load sound fx
						JukeBox.load("/SFX/menuoption.mp3", "menuoption");
						JukeBox.load("/SFX/menuselect.mp3", "menuselect");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		// TODO Auto-generated method stub
		handleInput();
	}

	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		// draw bg
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
				
				// draw title
				g.setColor(titleColor);
				g.setFont(titleFont);
				g.drawString("A R T I F A C T", 70, 90);
				
				// draw menu options
				g.setFont(font);
				g.setColor(Color.WHITE);
				g.drawString("Start", 145, 165);
				g.drawString("Quit", 145, 185);
				
				// draw floating head
				if(currentChoice == 0) g.drawImage(head, 125, 154, null);
				else if(currentChoice == 1) g.drawImage(head, 125, 174, null);
				
				// other
				g.setFont(font2);
				g.drawString("2013 Mike S.", 10, 232);
	}
	
	private void select() {
		if(currentChoice == 0) {
			JukeBox.play("menuselect");
//			PlayerSave.init();
//			gsm.setState(GameStateManager.LEVEL1ASTATE);
			gsm.setGameState(new GameLogicState());
		}
		else if(currentChoice == 1) {
			System.exit(0);
		}
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ENTER)) select();
		if(Keys.isPressed(Keys.UP)) {
			if(currentChoice > 0) {
				JukeBox.play("menuoption", 0);
				currentChoice--;
			}
		}
		if(Keys.isPressed(Keys.DOWN)) {
			if(currentChoice < options.length - 1) {
				JukeBox.play("menuoption", 0);
				currentChoice++;
			}
		}
	}
}