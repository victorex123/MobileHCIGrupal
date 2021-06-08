package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;

public class Sandbox implements Screen {
	MainClass game;
	WorldController controller;
	WorldRenderer renderer;
	int isPC;
	SpriteBatch batch;
	Texture img;

	public Sandbox(MainClass game)
	{
		this.game = game;

		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		//testSensors();

		Level lvl = new Level();

		controller = new WorldController(lvl);
		renderer = new WorldRenderer(lvl);

		//To check if is mobile or desktop version.
		isPC = Gdx.app.getVersion();
		if (isPC == 0)
		{
			Gdx.app.debug("VERSION", "Computer");
			InputComputer ic = new InputComputer(controller.level);
			Gdx.input.setInputProcessor(ic);
		}
		else
		{
			Gdx.app.debug("VERSION", "Android: " + isPC);
			GestureDetector gd = new GestureDetector(new InputMobile(controller.level));
			Gdx.input.setInputProcessor(gd);
		}
	}
	private void testSensors()
	{
		Gdx.app.debug("SENSORS", "Accelerometer: " + Gdx.input.isPeripheralAvailable(Input.Peripheral.Accelerometer));
		Gdx.app.debug("SENSORS", "Compass: " + Gdx.input.isPeripheralAvailable(Input.Peripheral.Compass));
		Gdx.app.debug("SENSORS", "Gyroscope: " + Gdx.input.isPeripheralAvailable(Input.Peripheral.Gyroscope));
		Gdx.app.debug("SENSORS", "Vibrator: " + Gdx.input.isPeripheralAvailable(Input.Peripheral.Vibrator));
		Gdx.app.debug("SENSORS", "Vector rotation: " + Gdx.input.isPeripheralAvailable(Input.Peripheral.RotationVector));
		Gdx.app.debug("SENSORS", "Pressure: " + Gdx.input.isPeripheralAvailable(Input.Peripheral.Pressure	));
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		controller.update(Gdx.graphics.getDeltaTime());

		renderer.render();
	}

	@Override
	public void resize(int width, int height)
	{
		renderer.resize(width,height);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose () {
		renderer.dispose();
	}
}
