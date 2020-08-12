package org.academiadecodigo.gitbusters;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.gitbusters.characters.Hero;

public class Game extends ApplicationAdapter {

	private Hero hero = new Hero();

	//private Texture hero;
	//private Rectangle heroDraw;

	private Texture guard;
	private Texture slave;


	private Rectangle guardDraw;
	private Rectangle slaveDraw;

	private final static SpriteBatch batch = new SpriteBatch();

	private OrthographicCamera camera;


	@Override
	public void create () {
		//guard = new Texture(Gdx.files.internal());
		//slave = new Texture(Gdx.files.internal());


		camera = new OrthographicCamera();
		camera.setToOrtho(false, 336, 308);

		hero.createHero();
		//hero = new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/RevolutionaryFoward.png"));

//		heroDraw = new Rectangle();
//		heroDraw.x = 200;
//		heroDraw.y = 20;
//		heroDraw.width = 28;
//		heroDraw.height = 28;

	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(0,0,255,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(hero.getHero(), hero.getHeroDraw().x, hero.getHeroDraw().y);
		batch.end();
	}
	
	@Override
	public void dispose () {

	}

	public void spriteDraw(Texture image, Rectangle rectangle){
		batch.draw(image, rectangle.x, rectangle.y);
	}
}
