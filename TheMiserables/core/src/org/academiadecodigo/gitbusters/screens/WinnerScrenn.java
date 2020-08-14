package org.academiadecodigo.gitbusters.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.gitbusters.Game2;
import org.academiadecodigo.gitbusters.Sound.Sound;

public class WinnerScrenn implements Screen {


    private static final int WINNING_IMG_WIDTH = Game2.WIDTH;
    private static final int WINNING_IMG_HEIGHT = Game2.HEIGHT;
    private static final int WINNING_IMG_Y = 0;
    private static final int WINNING_IMG_X = Game2.WIDTH / 2 - WINNING_IMG_WIDTH / 2;


    Game2 game;

    Texture winning;




    public WinnerScrenn (Game2 game) {

        this.game = game;

        winning = new Texture(Gdx.files.internal("Victory/Victory.png"));

        Sound.menuMusicPlay();


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
            try{
                Thread.sleep(500);
            } catch(InterruptedException ex) {
                ex.getMessage();
            }
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
