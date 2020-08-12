package org.academiadecodigo.gitbusters.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class AbstractCharacter implements Character{

    private Texture texture;

    private Rectangle rectangle;

    public SpriteBatch batch;

    @Override
    public Rectangle getCharacterDraw() {
        return null;
    }

    @Override
    public Texture getCharacter() {
        return null;
    }

    @Override
    public void createCharacter() {

        heroDraw = new Rectangle();
        heroDraw.x = 200;
        heroDraw.y = 20;
        heroDraw.width = 28;
        heroDraw.height = 28;
    }
}
