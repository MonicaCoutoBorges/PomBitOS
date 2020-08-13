package org.academiadecodigo.gitbusters.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.gitbusters.Game2;

public class WinnerScrenn implements Screen {


    private static final int WINNING_IMG_WIDTH = 300;
    private static final int WINNING_IMG_HEIGHT = 120;
    private static final int WINNING_IMG_Y = 230;
    private static final int WINNING_IMG_X = Game2.WIDTH / 2 - WINNING_IMG_WIDTH / 2;

    Game2 game;

    Texture winning;




    public WinnerScrenn (Game2 game) {

        this.game = game;

        winning = new Texture("Floor/Floor.png");


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        if(Gdx.input.isTouched()){
            game.setScreen(new MainMenuScreen(game));
        } else {
            game.batch.draw(winning, WINNING_IMG_X, WINNING_IMG_Y, WINNING_IMG_WIDTH, WINNING_IMG_HEIGHT);
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
