package org.academiadecodigo.gitbusters.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import org.academiadecodigo.gitbusters.Game2;
import org.academiadecodigo.gitbusters.Sound.Sound;


public class GameOverScreen implements Screen {


    private static final int GAMEOVER_IMG_WIDTH = Game2.WIDTH;
    private static final int GAMEOVER_IMG_HEIGHT = Game2.HEIGHT;
    private static final int GAMEOVER_IMG_Y = 0;
    private static final int GAMEOVER_IMG_X = Game2.WIDTH / 2 - GAMEOVER_IMG_WIDTH / 2;

    private static final int BANNER_WIDTH = 350;
    private static final int BANNER_HEIGHT = 100;

    private static final int TRY_AGAIN_BUTTON_WIDTH = 85;
    private static final int TRY_AGAIN_BUTTON_HEIGHT = 24;
    private static final int MAIN_MENU_BUTTON_WIDTH = 130;
    private static final int MAIN_MENU_BUTTON_HEIGHT = 30;
    private static final int TRY_AGAIN_BUTTON_Y = 118;
    private static final int MAIN_MENU_BUTTON_Y = 68;

    Texture tryAgainButtonActive;
    Texture tryAgainButtonInactive;
    Texture mainMenuButtonActive;
    Texture mainMenuButtonInactive;

    Texture gameOverImg;

    Game2 game;

    Texture gameOverBanner;

    BitmapFont scoreFont;



    public GameOverScreen(Game2 game) {
        this.game = game;

        //gameOverBanner= new Texture("Buttons/ExitActive.png");
        //scoreFont = new BitmapFont(Gdx.files.internal("fonts/score.fnt"));

        gameOverImg = new Texture(Gdx.files.internal("GameOver/GameOver.png"));

        tryAgainButtonActive = new Texture(Gdx.files.internal("Buttons/ExitActive.png"));
        tryAgainButtonInactive = new Texture(Gdx.files.internal("Buttons/ExitInactive.png"));
        mainMenuButtonActive = new Texture(Gdx.files.internal("Buttons/ExitActive.png"));
        mainMenuButtonInactive = new Texture(Gdx.files.internal("Buttons/ExitInactive.png"));

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
        // game.batch.draw(gameOverBanner, Gdx.graphics.getWidth() / 2 - BANNER_WIDTH  / 2, Gdx.graphics.getHeight() - BANNER_HEIGHT -15, BANNER_WIDTH, BANNER_HEIGHT );
        //GlyphLayout tryAgainLayout = new GlyphLayout(scoreFont, "Try Again");
        //GlyphLayout mainMenuLayout = new GlyphLayout(scoreFont, "Main Menu");

        game.batch.draw(gameOverImg, GAMEOVER_IMG_X, GAMEOVER_IMG_Y, GAMEOVER_IMG_WIDTH, GAMEOVER_IMG_HEIGHT);


        int xTryAgain = Game2.WIDTH / 2 - TRY_AGAIN_BUTTON_WIDTH / 2;

        if(Gdx.input.getX() < xTryAgain + TRY_AGAIN_BUTTON_WIDTH && Gdx.input.getX() > xTryAgain && Game2.HEIGHT - Gdx.input.getY() < TRY_AGAIN_BUTTON_Y + TRY_AGAIN_BUTTON_HEIGHT && Game2.HEIGHT - Gdx.input.getY() > TRY_AGAIN_BUTTON_Y) {
           // game.batch.draw(tryAgainButtonActive, xTryAgain , TRY_AGAIN_BUTTON_Y, TRY_AGAIN_BUTTON_WIDTH, TRY_AGAIN_BUTTON_HEIGHT);
            if(Gdx.input.isTouched()) {
                //this.dispose();
                //game.batch.end();

                Sound.menuMusicStop();

                game.setScreen(new GameScreen(game));


            }
        } else {
            // game.batch.draw(tryAgainButtonInactive, xTryAgain, TRY_AGAIN_BUTTON_Y, TRY_AGAIN_BUTTON_WIDTH, TRY_AGAIN_BUTTON_HEIGHT);
        }


        int xMainMenu = Game2.WIDTH / 2 - MAIN_MENU_BUTTON_WIDTH / 2;

        if(Gdx.input.getX() < xMainMenu + MAIN_MENU_BUTTON_WIDTH && Gdx.input.getX() > xMainMenu && Game2.HEIGHT - Gdx.input.getY() < MAIN_MENU_BUTTON_Y + MAIN_MENU_BUTTON_HEIGHT && Game2.HEIGHT - Gdx.input.getY() > MAIN_MENU_BUTTON_Y) {
            //game.batch.draw(mainMenuButtonActive, xMainMenu , MAIN_MENU_BUTTON_Y, MAIN_MENU_BUTTON_WIDTH, MAIN_MENU_BUTTON_HEIGHT);
            if(Gdx.input.isTouched()) {
                //this.dispose();
                //game.batch.end();
                try{
                    Thread.sleep(500);
                } catch(InterruptedException ex) {
                    ex.getMessage();
                }
                game.setScreen(new MainMenuScreen(game));

            }
        } else {
          //  game.batch.draw(mainMenuButtonInactive, xMainMenu, MAIN_MENU_BUTTON_Y, MAIN_MENU_BUTTON_WIDTH, MAIN_MENU_BUTTON_HEIGHT);
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
    }
}
