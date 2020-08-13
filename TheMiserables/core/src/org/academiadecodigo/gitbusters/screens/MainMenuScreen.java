package org.academiadecodigo.gitbusters.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.gitbusters.Game2;

public class MainMenuScreen implements Screen {




    //Buttons Size.. podem ir no 3 5 argumento do draw
    private static final int EXIT_BUTTON_WIDTH = 250;
    private static final int EXIT_BUTTON_HEIGHT = 120;
    private static final int PLAY_BUTTON_WIDTH = 300;
    private static final int PLAY_BUTTON_HEIGHT = 120;
    private static final int EXIT_BUTTON_Y = 100;
    private static final int PLAY_BUTTON_Y = 230;

    final Game2 game;

    Texture playButtonActive;
    Texture playButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;


    public MainMenuScreen (final Game2 game){
        this.game = game;
        playButtonActive = new Texture("Buttons/PlayActive.png");
        playButtonInactive = new Texture("Buttons/PlayInactive.png");
        exitButtonActive = new Texture("Buttons/ExitActive.png");
        exitButtonInactive = new Texture("Buttons/ExitInactive.png");



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();


        int xExitButton = Game2.WIDTH / 2 - EXIT_BUTTON_WIDTH / 2;

        if(Gdx.input.getX() < xExitButton + EXIT_BUTTON_WIDTH && Gdx.input.getX() > xExitButton && Game2.HEIGHT - Gdx.input.getY() < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT && Game2.HEIGHT - Gdx.input.getY() > EXIT_BUTTON_Y) {
            game.batch.draw(exitButtonActive, xExitButton , EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);

            if(Gdx.input.isTouched()){
                Gdx.app.exit();
            }

        } else {
            game.batch.draw(exitButtonInactive, xExitButton, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        }



        int xPlayButton = Game2.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2;

        if(Gdx.input.getX() < xPlayButton + PLAY_BUTTON_WIDTH && Gdx.input.getX() > xPlayButton && Game2.HEIGHT - Gdx.input.getY() < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT && Game2.HEIGHT - Gdx.input.getY() > PLAY_BUTTON_Y) {
            game.batch.draw(playButtonActive, xPlayButton , PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);

            if(Gdx.input.isTouched()) {

                game.setScreen(new GameScreen(game));
                //this.dispose();
            }

        } else {
            game.batch.draw(playButtonInactive, xPlayButton, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
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
        //img.dispose();

    }
}
