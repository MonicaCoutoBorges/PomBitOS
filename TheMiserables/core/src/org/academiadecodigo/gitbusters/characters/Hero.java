package org.academiadecodigo.gitbusters.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.gitbusters.Game;
import org.academiadecodigo.gitbusters.Game1;

public class Hero extends AbstractCharacter{


    private SpriteBatch batch;


    public Hero(){

        setTexture(new Texture(Gdx.files.internal("Hero/RevolutionaryFront.png")));

        setRectangle(new Rectangle());
        batch = Game1.batch;
        getRectangle().x = Game.cellSize;
        getRectangle().y = Game.cellSize;

        getRectangle().width = Game.cellSize;
        getRectangle().height = Game.cellSize;
    }

    public void drawCharacter() {

        batch.draw(getTexture(), getRectangle().x, getRectangle().y);
    }





}
