package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.RPGGame;

 
public class PreferencesScreen implements Screen{

	private RPGGame game;
	private Stage stage;

	private int playerHealth = 200;
	private int playerStrength = 10;
	private String playerName = "Billy Bob";
	
	private int enemyHealth = 100;
	private int enemyStrength = 3;
	private String enemyName = "Shithead";
	
	private Label playerHealthLabel;
	private Label enemyHealthLabel;
	private Label playerNameLabel;
	private Label enemyNameLabel;
	
	private Label menuLabel;
	
	private Button button;
	
	int score;

	
	public PreferencesScreen(RPGGame game){
		this.game = game;
		/// create stage and set it as input processor
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
		Skin skin = new Skin(Gdx.files.internal("neon/skin/neon-ui.json"));

		// music volume
		final Slider volumeMusicSlider = new Slider(0, 100, 1, false, skin);
		volumeMusicSlider.setValue(100);


		// music on/off
		final CheckBox musicCheckbox = new CheckBox(null, skin);
		musicCheckbox.setChecked(true);

		final Label volumeValue = new Label("" + (int) volumeMusicSlider.getValue(), skin);
		
		playerHealthLabel = new Label( "Player Health: " +  playerHealth, skin );
		enemyHealthLabel =  new Label( "Enemy Health: " +  enemyHealth, skin );
		playerNameLabel = new Label( "Player Name: " +  playerName, skin );
		enemyNameLabel = new Label( "Enemy Name: " +  enemyName, skin );;		
		menuLabel = new Label( "Player Options", skin );;

		button = new TextButton("Attack Enemy", skin);

		
		volumeMusicSlider.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				volumeValue.setText("" + (int)volumeMusicSlider.getValue());
				return false;
			}
		});
		
		button.addListener(new ClickListener() {
			  @Override
			    public void clicked(InputEvent event, float x, float y) {
			      	enemyHealth -= playerStrength * 2;
			      	
			      	playerHealth -= enemyStrength * 2;
			      	
			      	if (enemyHealth <= 0) {
			      		enemyHealth = 0;
			      		System.out.println("You win!");
			      	}
			      	
			      	if (playerHealth <= 0) {
			      		playerHealth = 0;
			      		System.out.println("You lose!");
			      		System.exit(0);
			      	}
			      	
			      	playerHealthLabel.setText("Player Health: " +  playerHealth);
			      	enemyHealthLabel.setText("Enemy Health: " +  enemyHealth);
			      	
			      	
			    };
		});

		
		
		table.setTransform(false);
		table.align(Align.bottom);		
		table.add(menuLabel).colspan(3);
		table.row().pad(10,0,0,10);
		table.add(enemyNameLabel).left();
		table.add(playerNameLabel).right();
		table.row().pad(10,0,0,10);
		table.add(enemyHealthLabel).left();
		table.add(playerHealthLabel).right();
		table.row().pad(10,0,0,10);
		table.add(button).colspan(3);

	}

	@Override
	public void render(float delta) {
		// clear the screen ready for next set of images to be drawn
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// tell our stage to do actions and draw itself
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		
		game.batch.begin();
		game.font.draw(game.batch, "" + score, RPGGame.WIDTH / 2 - 20, RPGGame.HEIGHT / 2 + 300);		
		
		game.batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// change the stage's viewport when the screen size is changed
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}