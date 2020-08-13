package org.academiadecodigo.gitbusters;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
import org.academiadecodigo.gitbusters.screens.MainMenuScreen;

public class Game2 extends Game {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;


    public static SpriteBatch batch;




    @Override
    public void create() {

        batch = new SpriteBatch();
        this.setScreen(new MainMenuScreen(this));

    }

    @Override
    public void render() {

        super.render();


    }

    @Override
    public void dispose() {

        batch.dispose();

    }
}
