package org.academiadecodigo.gitbusters;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.gitbusters.Sound.Sound;
import org.academiadecodigo.gitbusters.characters.Guard;
import org.academiadecodigo.gitbusters.characters.Hero;
import org.academiadecodigo.gitbusters.characters.Slave;
import org.academiadecodigo.gitbusters.map.Map;
import org.academiadecodigo.gitbusters.map.Objects.*;
import org.academiadecodigo.gitbusters.screens.GameOverScreen;
import org.academiadecodigo.gitbusters.screens.GameScreen;
import org.academiadecodigo.gitbusters.screens.MainMenuScreen;
import org.academiadecodigo.gitbusters.screens.WinnerScrenn;

public class Game2 extends Game {

    public static final int WIDTH = 336;
    public static final int HEIGHT = 308;


    public static SpriteBatch batch;




    @Override
    public void create() {

        batch = new SpriteBatch();

        this.setScreen(new MainMenuScreen(this));

    }

    //someone there ?

    @Override
    public void render() {

        super.render();


    }

    @Override
    public void dispose() {

        batch.dispose();

    }

    @Override
    public void setScreen (Screen screen) {
        if (this.screen != null) this.screen.hide();
        this.screen = screen;
        if (this.screen != null) {
            this.screen.show();
            this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
    }
}
