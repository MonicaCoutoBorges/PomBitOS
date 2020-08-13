package org.academiadecodigo.gitbusters.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import org.academiadecodigo.gitbusters.Game1;

public class GameOverScreen implements Screen {

    private static final int BANNER_WIDTH = 350;
    private static final int BANNER_HEIGHT = 100;

    private static final int TRY_AGAIN_BUTTON_WIDTH = 250;
    private static final int TRY_AGAIN_BUTTON_HEIGHT = 120;
    private static final int MAIN_MENU_BUTTON_WIDTH = 300;
    private static final int MAIN_MENU_BUTTON_HEIGHT = 120;
    private static final int TRY_AGAIN_BUTTON_Y = 100;
    private static final int MAIN_MENU_BUTTON_Y = 230;

    Texture tryAgainButtonActive;
    Texture tryAgainButtonInactive;
    Texture mainMenuButtonActive;
    Texture mainMenuButtonInactive;

    Game1 game;

    Texture gameOverBanner;
    BitmapFont scoreFont;

    public GameOverScreen(Game1 game) {
        this.game = game;

        gameOverBanner= new Texture("Buttons/ExitActive.png");
        //scoreFont = new BitmapFont(Gdx.files.internal("fonts/score.fnt"));

        tryAgainButtonActive = new Texture("ButtonsEnd\\TryAgainActive.png");
        tryAgainButtonInactive = new Texture("ButtonsEnd\\TryAgainInactive.png");
        mainMenuButtonActive = new Texture("ButtonsEnd\\mainMenuActive.png");
        mainMenuButtonInactive = new Texture("ButtonsEnd\\mainMenuInactive.png");
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

        int xTryAgain = Game1.WIDTH / 2 - TRY_AGAIN_BUTTON_WIDTH / 2;

        if(Gdx.input.getX() < xTryAgain + TRY_AGAIN_BUTTON_WIDTH && Gdx.input.getX() > xTryAgain && Game1.HEIGHT - Gdx.input.getY() < TRY_AGAIN_BUTTON_Y + TRY_AGAIN_BUTTON_HEIGHT && Game1.HEIGHT - Gdx.input.getY() > TRY_AGAIN_BUTTON_Y) {
            game.batch.draw(tryAgainButtonActive, xTryAgain , TRY_AGAIN_BUTTON_Y, TRY_AGAIN_BUTTON_WIDTH, TRY_AGAIN_BUTTON_HEIGHT);

            if(Gdx.input.isTouched()) {
                //this.dispose();
                //game.batch.end();
                game.setScreen(new GameScreen(game));

            }

        } else {
            game.batch.draw(tryAgainButtonInactive, xTryAgain, TRY_AGAIN_BUTTON_Y, TRY_AGAIN_BUTTON_WIDTH, TRY_AGAIN_BUTTON_HEIGHT);
        }

        int xMainMenu = Game1.WIDTH / 2 - MAIN_MENU_BUTTON_WIDTH / 2;

        if(Gdx.input.getX() < xMainMenu + MAIN_MENU_BUTTON_WIDTH && Gdx.input.getX() > xMainMenu && Game1.HEIGHT - Gdx.input.getY() < MAIN_MENU_BUTTON_Y + MAIN_MENU_BUTTON_HEIGHT && Game1.HEIGHT - Gdx.input.getY() > MAIN_MENU_BUTTON_Y) {
            game.batch.draw(mainMenuButtonActive, xMainMenu , MAIN_MENU_BUTTON_Y, MAIN_MENU_BUTTON_WIDTH, MAIN_MENU_BUTTON_HEIGHT);

            if(Gdx.input.isTouched()) {
                //this.dispose();
                //game.batch.end();
                game.setScreen(new MainMenuScreen(game));

            }

        } else {
            game.batch.draw(mainMenuButtonInactive, xMainMenu, MAIN_MENU_BUTTON_Y, MAIN_MENU_BUTTON_WIDTH, MAIN_MENU_BUTTON_HEIGHT);
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
