package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.RPGGame;

public class MainMenuScreen implements Screen {

	/////////// TEXTURE INSTANCE VARIABLES ////////////////
	Texture titleBanner;
	public static final int TITLE_HEIGHT = 115;
	public static final int TITLE_WIDTH = 650;
	public static final int TITLE_Y = RPGGame.HEIGHT - (TITLE_HEIGHT * 2);

	Texture newGameButtonInactive;
	Texture newGameButtonActive;
	public static final int NEW_GAME_HEIGHT = 55;
	public static final int NEW_GAME_WIDTH = 185;
	public static final int NEW_GAME_BUTTON_Y = RPGGame.HEIGHT - NEW_GAME_HEIGHT - 300;

	Texture loadGameButtonInactive;
	Texture loadGameButtonActive;
	public static final int LOAD_GAME_HEIGHT = 55;
	public static final int LOAD_GAME_WIDTH = 200;
	public static final int LOAD_GAME_BUTTON_Y = RPGGame.HEIGHT - LOAD_GAME_HEIGHT - 400;

	Texture optionsButtonInactive;
	Texture optionsButtonActive;
	public static final int OPTIONS_HEIGHT = 53;
	public static final int OPTIONS_WIDTH = 138;
	public static final int OPTIONS_BUTTON_Y = RPGGame.HEIGHT - OPTIONS_HEIGHT - 500;

	Texture exitGameButtonInactive;
	Texture exitGameButtonActive;
	public static final int EXIT_GAME_HEIGHT = 45;
	public static final int EXIT_GAME_WIDTH = 185;
	public static final int EXIT_GAME_BUTTON_Y = RPGGame.HEIGHT - EXIT_GAME_HEIGHT - 600;;

	/////////// RPG Game instance variable ///////////
	RPGGame game;
	
	Music mainMusic;
	Sound buttonSelectSFX;

	public MainMenuScreen(RPGGame game) {
		this.game = game;

		///////////////////////////////////////////////////////
		////////////// TEXTURES FOR BUTTONS ///////////////////
		///////////////////////////////////////////////////////
		titleBanner = new Texture("KOTF_Title.png");
		newGameButtonInactive = new Texture("New_Game_Button_Inactive.png");
		newGameButtonActive = new Texture("New_Game_Button_Active.png");
		loadGameButtonInactive = new Texture("Load_Game_Button_Inactive.png");
		loadGameButtonActive = new Texture("Load_Game_Button_Active.png");
		optionsButtonInactive = new Texture("Options_Button_Inactive.png");
		optionsButtonActive = new Texture("Options_Button_Active.png");
		exitGameButtonInactive = new Texture("Exit_Game_Button_Inactive.png");
		exitGameButtonActive = new Texture("Exit_Game_Button_Active.png");
		
		
		///////////////////////////////////////////////////////
		//////////// SOUND EFFECTS AND MUSIC //////////////////
		///////////////////////////////////////////////////////
		mainMusic = Gdx.audio.newMusic(Gdx.files.internal("music/David_Hilowitz_-_05_-_Solitude.mp3"));
		buttonSelectSFX = Gdx.audio.newSound(Gdx.files.internal("sfx/150222__pumodi__menu-select.mp3"));

	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.15f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		mainMusic.setVolume(1f);
		mainMusic.play();

		game.batch.begin();

		int w = RPGGame.WIDTH / 2 - LOAD_GAME_WIDTH / 2;
		int x = RPGGame.WIDTH / 2 - EXIT_GAME_WIDTH / 2;
		int y = RPGGame.WIDTH / 2 - NEW_GAME_WIDTH / 2;
		int z = RPGGame.WIDTH / 2 - OPTIONS_WIDTH / 2;

		///////////////// KOTF TITLE BANNER /////////////////
		game.batch.draw(titleBanner, RPGGame.WIDTH / 2 - TITLE_WIDTH / 2, TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT);

		///////////////// NEW GAME BUTTON /////////////////
		if (Gdx.input.getX() < y + NEW_GAME_WIDTH && Gdx.input.getX() > y
				&& RPGGame.HEIGHT - Gdx.input.getY() < NEW_GAME_BUTTON_Y + NEW_GAME_HEIGHT
				&& RPGGame.HEIGHT - Gdx.input.getY() > NEW_GAME_BUTTON_Y) {
			game.batch.draw(newGameButtonActive, RPGGame.WIDTH / 2 - NEW_GAME_WIDTH / 2, NEW_GAME_BUTTON_Y,
					NEW_GAME_WIDTH, NEW_GAME_HEIGHT);
			if (Gdx.input.justTouched()) {
				buttonSelectSFX.play();
			}
		} else {
			game.batch.draw(newGameButtonInactive, RPGGame.WIDTH / 2 - NEW_GAME_WIDTH / 2, NEW_GAME_BUTTON_Y,
					NEW_GAME_WIDTH, NEW_GAME_HEIGHT);
		}

		///////////////// LOAD GAME BUTTON /////////////////
		if (Gdx.input.getX() < w + LOAD_GAME_WIDTH && Gdx.input.getX() > w
				&& RPGGame.HEIGHT - Gdx.input.getY() < LOAD_GAME_BUTTON_Y + LOAD_GAME_HEIGHT
				&& RPGGame.HEIGHT - Gdx.input.getY() > LOAD_GAME_BUTTON_Y) {
			game.batch.draw(loadGameButtonActive, RPGGame.WIDTH / 2 - LOAD_GAME_WIDTH / 2, LOAD_GAME_BUTTON_Y,
					LOAD_GAME_WIDTH, LOAD_GAME_HEIGHT);
			if (Gdx.input.justTouched()) {
				buttonSelectSFX.play();
			}
		} else {
			game.batch.draw(loadGameButtonInactive, RPGGame.WIDTH / 2 - LOAD_GAME_WIDTH / 2, LOAD_GAME_BUTTON_Y,
					LOAD_GAME_WIDTH, LOAD_GAME_HEIGHT);
		}

		///////////////// OPTIONS MENU BUTTON /////////////////
		if (Gdx.input.getX() < z + OPTIONS_WIDTH && Gdx.input.getX() > z
				&& RPGGame.HEIGHT - Gdx.input.getY() < OPTIONS_BUTTON_Y + OPTIONS_HEIGHT
				&& RPGGame.HEIGHT - Gdx.input.getY() > OPTIONS_BUTTON_Y) {
			game.batch.draw(optionsButtonActive, RPGGame.WIDTH / 2 - OPTIONS_WIDTH / 2, OPTIONS_BUTTON_Y, OPTIONS_WIDTH,
					OPTIONS_HEIGHT);
			if (Gdx.input.justTouched()) {
				buttonSelectSFX.play();
				this.dispose();
				game.setScreen(new OptionsScreen(game));
			}
		} else {
			game.batch.draw(optionsButtonInactive, RPGGame.WIDTH / 2 - OPTIONS_WIDTH / 2, OPTIONS_BUTTON_Y,
					OPTIONS_WIDTH, OPTIONS_HEIGHT);
		}

		///////////////// EXIT GAME BUTTON /////////////////
		if (Gdx.input.getX() < x + EXIT_GAME_WIDTH && Gdx.input.getX() > x
				&& RPGGame.HEIGHT - Gdx.input.getY() < EXIT_GAME_BUTTON_Y + EXIT_GAME_HEIGHT
				&& RPGGame.HEIGHT - Gdx.input.getY() > EXIT_GAME_BUTTON_Y) {
			game.batch.draw(exitGameButtonActive, RPGGame.WIDTH / 2 - EXIT_GAME_WIDTH / 2, EXIT_GAME_BUTTON_Y,
					EXIT_GAME_WIDTH, EXIT_GAME_HEIGHT);
			if (Gdx.input.justTouched()) {
				buttonSelectSFX.play();
				Gdx.app.exit();
			}
		} else {
			game.batch.draw(exitGameButtonInactive, RPGGame.WIDTH / 2 - EXIT_GAME_WIDTH / 2, EXIT_GAME_BUTTON_Y,
					EXIT_GAME_WIDTH, EXIT_GAME_HEIGHT);
		}

		game.batch.end();

	}

	@Override
	public void resize(int width, int height) {

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
	public void dispose() {

	}

}
