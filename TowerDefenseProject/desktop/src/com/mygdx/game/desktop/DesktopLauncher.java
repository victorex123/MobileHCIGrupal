package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MainClass;
import com.mygdx.game.Sandbox;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.forceExit = false;

		config.width = 1280;
		config.height = 720;

		new LwjglApplication(new MainClass(), config);
	}
}
