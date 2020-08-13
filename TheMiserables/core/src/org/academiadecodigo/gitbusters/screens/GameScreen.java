package org.academiadecodigo.gitbusters.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.gitbusters.Game;
import org.academiadecodigo.gitbusters.Game1;
import org.academiadecodigo.gitbusters.characters.Hero;
import org.academiadecodigo.gitbusters.map.Map;

import java.util.Iterator;

public class GameScreen implements Screen {

    private Hero hero;
    private Map map;

    private OrthographicCamera camera;

    public final static int cellSize = 28;

    private float x = cellSize;
    private float y = cellSize;

    private Texture image;

    Game1 game;


    public GameScreen (Game1 game){
        this.game = game;
    }

    @Override
    public void show() {
        camera= new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.map = new Map();


        this.hero = new Hero();

        image = hero.getTexture();


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,255,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        map.drawMap();
        hero.drawHero();


//		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
//			hero.getRectangle().x -= cellSize * Gdx.graphics.getDeltaTime();
//		}
//
//		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
//			hero.getRectangle().x += cellSize * Gdx.graphics.getDeltaTime();
//		}
//
//		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
//			hero.getRectangle().y -= cellSize * Gdx.graphics.getDeltaTime();
//		}
//
//		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
//			hero.getRectangle().y += cellSize * Gdx.graphics.getDeltaTime();
//		}

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            hero.getRectangle().y += Game.cellSize;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            hero.getRectangle().y -= Game.cellSize;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            hero.getRectangle().x -= Game.cellSize;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            hero.getRectangle().x += Game.cellSize;
        }

        for (Iterator<Rectangle> iter = map.getObjectRectangles().iterator(); iter.hasNext();){
            Rectangle mapObject = iter.next();
            if (hero.getRectangle().overlaps(mapObject)){
                System.exit(1);
            }
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
        game.batch.dispose();
        image.dispose();
    }

 //   public void spriteDraw(Texture image, Rectangle rectangle){
   //     game.batch.draw(image, rectangle.x, rectangle.y);
    //}

}
