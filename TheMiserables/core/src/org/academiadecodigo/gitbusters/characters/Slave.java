package org.academiadecodigo.gitbusters.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.gitbusters.Game2;
import org.academiadecodigo.gitbusters.screens.GameScreen;

public class Slave extends AbstractCharacter {

    public Slave(){
        setTexture(new Texture(Gdx.files.internal("Prisioner/PrisionerFront.png")));

        setRectangle(new Rectangle());
        batch = Game2.batch;
        getRectangle().x = GameScreen.cellSize * 5;
        getRectangle().y = GameScreen.cellSize * 7;

        getRectangle().width = GameScreen.cellSize;
        getRectangle().height = GameScreen.cellSize;
    }

    @Override
    public void drawCharacter() {

        batch.draw(getTexture(), getRectangle().x, getRectangle().y);

    }
}
