package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.RPGGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.foregroundFPS = 60;
		config.width = RPGGame.WIDTH;
		config.height = RPGGame.HEIGHT;
		config.resizable = false;

		new LwjglApplication(new RPGGame(), config);
	}
}
