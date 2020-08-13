package org.academiadecodigo.gitbusters.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.gitbusters.Game2;
import org.academiadecodigo.gitbusters.screens.GameScreen;

public class Hero extends AbstractCharacter{


    private SpriteBatch batch;


    public Hero(){

        setTexture(new Texture(Gdx.files.internal("Hero/RevolutionaryFront.png")));

        setRectangle(new Rectangle());
        batch = Game2.batch;
        getRectangle().x = GameScreen.cellSize;
        getRectangle().y = GameScreen.cellSize;

        getRectangle().width = GameScreen.cellSize;
        getRectangle().height = GameScreen.cellSize;
    }

    public void drawCharacter() {

        batch.draw(getTexture(), getRectangle().x, getRectangle().y);
    }





}
