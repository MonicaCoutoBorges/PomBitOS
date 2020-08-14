package org.academiadecodigo.gitbusters.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.gitbusters.Game2;
import org.academiadecodigo.gitbusters.Sound.Sound;

public class MainMenuScreen implements Screen {



    private static final int MAINMENU_IMG_WIDTH = Game2.WIDTH;
    private static final int MAINMENU_IMG_HEIGHT = Game2.HEIGHT;
    private static final int MAINMENU_IMG_Y = 0;
    private static final int MAINMENU_IMG_X = Game2.WIDTH / 2 - MAINMENU_IMG_WIDTH / 2;

    //Buttons Size.. podem ir no 3 5 argumento do draw
    private static final int EXIT_BUTTON_WIDTH = 50;
    private static final int EXIT_BUTTON_HEIGHT = 28;
    private static final int PLAY_BUTTON_WIDTH = 130;
    private static final int PLAY_BUTTON_HEIGHT = 28;
    private static final int EXIT_BUTTON_Y = 35;
    private static final int PLAY_BUTTON_Y = 115;

    final Game2 game;

    Texture playButtonActive;
    Texture playButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;

    Texture mainMenuImg;



    public MainMenuScreen (final Game2 game){
        this.game = game;

        mainMenuImg = new Texture(Gdx.files.internal("Menu/TheMiserables.png"));

        playButtonActive = new Texture(Gdx.files.internal("Buttons/PlayActive.png"));
        playButtonInactive = new Texture(Gdx.files.internal("Buttons/PlayInactive.png"));
        exitButtonActive = new Texture(Gdx.files.internal("Buttons/ExitActive.png"));
        exitButtonInactive = new Texture(Gdx.files.internal("Buttons/ExitInactive.png"));

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

        game.batch.draw(mainMenuImg, MAINMENU_IMG_X, MAINMENU_IMG_Y, MAINMENU_IMG_WIDTH, MAINMENU_IMG_HEIGHT);


        int xExitButton = Game2.WIDTH / 2 - EXIT_BUTTON_WIDTH / 2;

        if(Gdx.input.getX() < xExitButton + EXIT_BUTTON_WIDTH && Gdx.input.getX() > xExitButton && Game2.HEIGHT - Gdx.input.getY() < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT && Game2.HEIGHT - Gdx.input.getY() > EXIT_BUTTON_Y) {
           // game.batch.draw(exitButtonActive, xExitButton , EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);

            if(Gdx.input.isTouched()){
                Gdx.app.exit();
            }

        } else {
            //game.batch.draw(exitButtonInactive, xExitButton, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        }



        int xPlayButton = Game2.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2;

        if(Gdx.input.getX() < xPlayButton + PLAY_BUTTON_WIDTH && Gdx.input.getX() > xPlayButton && Game2.HEIGHT - Gdx.input.getY() < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT && Game2.HEIGHT - Gdx.input.getY() > PLAY_BUTTON_Y) {
            //game.batch.draw(playButtonActive, xPlayButton , PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);

            if(Gdx.input.isTouched()) {

                Sound.menuMusicStop();

                game.setScreen(new GameScreen(game));
                //this.dispose();
            }

        } else {
            //game.batch.draw(playButtonInactive, xPlayButton, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
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
