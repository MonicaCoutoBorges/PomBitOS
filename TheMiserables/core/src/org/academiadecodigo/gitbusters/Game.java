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

	public final static SpriteBatch batch = new SpriteBatch();

	private OrthographicCamera camera;


	@Override
	public void create () {

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 336, 308);

		hero.createHero();

	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(0,0,255,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		hero.drawHero();
		batch.end();
	}
	
	@Override
	public void dispose () {

	}

	public void spriteDraw(Texture image, Rectangle rectangle){
		batch.draw(image, rectangle.x, rectangle.y);
	}
}
