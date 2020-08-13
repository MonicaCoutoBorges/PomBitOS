package org.academiadecodigo.gitbusters.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.gitbusters.Game;
import org.academiadecodigo.gitbusters.Game1;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 336;
		config.height = 308;
		config.title = "The Miserables";
		new LwjglApplication(new Game1(), config);

		config.foregroundFPS = 25;
	}
}
