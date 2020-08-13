package org.academiadecodigo.gitbusters.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.gitbusters.Game;
import org.academiadecodigo.gitbusters.Game1;

public class Slave extends AbstractCharacter {

    public Slave(){
        setTexture(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/Prisioner/PrisionerFront.png")));

        setRectangle(new Rectangle());
        batch = Game1.batch;
        getRectangle().x = Game.cellSize * 5;
        getRectangle().y = Game.cellSize * 6;

        getRectangle().width = Game.cellSize;
        getRectangle().height = Game.cellSize;
    }

    @Override
    public void drawCharacter() {

        batch.draw(getTexture(), getRectangle().x, getRectangle().y);

    }
}
