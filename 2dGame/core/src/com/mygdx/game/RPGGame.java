package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.MainMenuScreen;
import screens.PreferencesScreen;

public class RPGGame extends Game {

	public SpriteBatch batch;
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 720;
	public BitmapFont font;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("score.fnt"));
		font.getData().setScale(.5f);
		
		//this.setScreen(new PreferencesScreen(this));
		this.setScreen(new MainMenuScreen(this));
		
	}
	
	@Override
	public void render () {
		super.render();
	}

}
