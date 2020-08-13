package org.academiadecodigo.gitbusters.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.gitbusters.Game2;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Game2.WIDTH;
		config.height = Game2.HEIGHT;
		config.resizable = false;
		config.title = "The Miserables";
		new LwjglApplication(new Game2(), config);

		config.foregroundFPS = 25;
	}
}
