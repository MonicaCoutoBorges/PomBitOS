package org.academiadecodigo.gitbusters.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.gitbusters.Game;

public class Hero extends AbstractCharacter{

    private SpriteBatch batch;

    public Hero(){
        setTexture(new Texture(Gdx.files.internal("Hero/RevolutionaryFront.png")));
        setRectangle(new Rectangle());
        batch = Game.batch;
    }

    public void drawHero() {
        getRectangle().x = 3 * 28;
        getRectangle().y = 9 * 28;
        getRectangle().width = 28;
        getRectangle().height = 28;
        batch.draw(getTexture(), getRectangle().x, getRectangle().y);
    }





}
