package org.academiadecodigo.gitbusters.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.gitbusters.Game2;
import org.academiadecodigo.gitbusters.screens.GameScreen;

public class Guard extends AbstractCharacter {

    public Guard(){

        setTexture(new Texture(Gdx.files.internal("Guard/GuardFront.png")));

        setRectangle(new Rectangle());
        batch = Game2.batch;
        getRectangle().x = GameScreen.cellSize * 5;
        getRectangle().y = GameScreen.cellSize * 5;

        getRectangle().width = GameScreen.cellSize;
        getRectangle().height = GameScreen.cellSize;
    }

    @Override
    public void drawCharacter() {
        batch.draw(getTexture(), getRectangle().x, getRectangle().y);

    }
}
