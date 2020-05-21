package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.RPGGame;

/**
 * Creates an options screen that allows the user to manipulate settings such as
 * volume, brightness?, and other future features. Returns to the previous menu
 * afterwards.
 * 
 * @author Brenton Haliw
 *
 */
public class OptionsScreen implements Screen {

	RPGGame game;
	Stage stage;

	// Textures for the text and sliders will appear here
	Texture volumeLabel;
	public static final int VOLUME_LABEL_WIDTH = 130;
	public static final int VOLUME_LABEL_HEIGHT = 47;
	public static final int VOLUME_LABEL_Y = RPGGame.HEIGHT - (VOLUME_LABEL_HEIGHT * 5);
	
	Texture returnButton;
	public static final int RETURN_BUTTON_WIDTH = 123;
	public static final int RETURN_BUTTON_HEIGHT = 60;
	public static final int RETURN_BUTTON_Y = RPGGame.HEIGHT - (RETURN_BUTTON_HEIGHT);

	
	Texture optionsMenuBanner;
	public static final int OPTIONS_BANNER_WIDTH = 375;
	public static final int OPTIONS_BANNER_HEIGHT = 80;
	public static final int OPTIONS_BANNER_Y = RPGGame.HEIGHT - (OPTIONS_BANNER_HEIGHT * 2);
	
	Table table;
	
	Slider volumeSlider;


	public OptionsScreen(RPGGame game) {
		this.game = game;
		volumeSlider = new Slider(0, 100, 0.1f, false, new Skin(Gdx.files.internal("golden-spiral/skin/golden-ui-skin.json")));
		table = new Table();

		// Creating the textures here
		volumeLabel = new Texture("Volume_Label.png");
		optionsMenuBanner = new Texture("Options_Menu_Banner.png");
		returnButton = new Texture("Return_Button_Inactive.png");
		
		stage = new Stage(new ScreenViewport());
		
	}

	@Override
	public void show() {
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		
		// Create a table that fills the screen. Everything else will go inside
		// this table.
		Table table = new Table();
		table.setFillParent(true);
		//table.setDebug(true);
		stage.addActor(table);

		// temporary until we have asset manager in
		Skin skin = new Skin(Gdx.files.internal("golden-spiral/skin/golden-ui-skin.json"));

		// music volume
		final Slider volumeMusicSlider = new Slider(0, 100, 0.1f, false, skin);
		volumeMusicSlider.setSize(300, 20);
		volumeMusicSlider.setValue(100);
		
		final Label volumeMusicLabel = new Label("Music Volume:", skin );
		final Label sliderValue = new Label("" + (int) volumeMusicSlider.getValue(), skin );
		
		volumeMusicSlider.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				sliderValue.setText("" + (int)volumeMusicSlider.getValue());
				return false;
			}
		});

		table.row().pad(10,10,10,10);
		table.add(volumeMusicLabel).left();
		table.add(volumeMusicSlider);
		table.add(sliderValue).colspan(0);
		table.row().pad(10,10,10,10);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.15f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		
		
		game.batch.draw(returnButton, RPGGame.WIDTH / 2 - RETURN_BUTTON_WIDTH / 2, 0, RETURN_BUTTON_WIDTH, RETURN_BUTTON_HEIGHT);
		game.batch.draw(volumeLabel, RPGGame.WIDTH / 2 - VOLUME_LABEL_WIDTH / 2, VOLUME_LABEL_Y, VOLUME_LABEL_WIDTH, VOLUME_LABEL_HEIGHT);
		game.batch.draw(optionsMenuBanner, RPGGame.WIDTH / 2 - OPTIONS_BANNER_WIDTH / 2, OPTIONS_BANNER_Y, OPTIONS_BANNER_WIDTH, OPTIONS_BANNER_HEIGHT);
		
		game.batch.end();
		
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
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
