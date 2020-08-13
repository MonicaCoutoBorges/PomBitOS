package org.academiadecodigo.gitbusters.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.gitbusters.Game;

public class Slave extends AbstractCharacter {

    public Slave(){
        setTexture(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/Prisioner/PrisionerFront.png")));

        setRectangle(new Rectangle());
        batch = Game.batch;
        getRectangle().x = Game.cellSize * 5;
        getRectangle().y = Game.cellSize * 7;

        getRectangle().width = Game.cellSize;
        getRectangle().height = Game.cellSize;
    }

    @Override
    public void drawCharacter() {

        batch.draw(getTexture(), getRectangle().x, getRectangle().y);

    }
}
