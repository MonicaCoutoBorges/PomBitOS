package org.academiadecodigo.gitbusters;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.gitbusters.screens.GameOverScreen;
import org.academiadecodigo.gitbusters.screens.MainMenuScreen;


public class Game1 extends Game {
	// window Size  que vai ser utilizada na Class DesktopLauncher utilizando o config.
	public static final int WIDTH = 336;
	public static final int HEIGHT = 308;


	public static SpriteBatch batch;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new GameOverScreen(this));

	}
	@Override
	public void render () {
		super.render();

	}
	
	@Override
	public void dispose () {

	}
}
