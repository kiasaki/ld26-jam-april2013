package ld26_kiasaki_dagothig.states;

import ld26_kiasaki_dagothig.helpers.FontFactory;
import ld26_kiasaki_dagothig.helpers.KeyListenerImpl;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class GameOverState extends BasicGameState {

	public static final int ID = 4;
	private GameContainer gc;
	private StateBasedGame sbg;
	
	private long started;
	private UnicodeFont uFont = FontFactory.get().getFont(60, java.awt.Color.WHITE);
	private UnicodeFont uFontSmall = FontFactory.get().getFont(18, java.awt.Color.WHITE);
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		this.gc = gc;
		this.sbg = sbg;
		this.started = System.currentTimeMillis();
	}

	@Override
	public void keyReleased(int key, char c) {
		if (key == Input.KEY_ESCAPE) {
			exitGame();					
		}
	} 
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// Game over
		uFont.drawString(gc.getWidth()/2-(uFont.getWidth("GAME OVER")/2), gc.getHeight()/2-25, "GAME OVER");
		// Info
		uFontSmall.drawString(gc.getWidth()/2-(uFontSmall.getWidth("Press escape...")/2), gc.getHeight()/2+125, "Press escape to continue...");
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
	}

	public void exitGame(){
		if (System.currentTimeMillis() - this.started > 2000){
			sbg.enterState(MenuState.ID, new FadeOutTransition(Color.white, 700), new FadeInTransition(Color.white));
		}
	}

	@Override
	public int getID() {
		return ID;
	}
	
}
