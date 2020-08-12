package org.academiadecodigo.gitbusters.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class AbstractCharacter implements Character{

    private Texture texture;

    private Rectangle rectangle;

    public SpriteBatch batch;

    private Character character;

    @Override
    public Rectangle getCharacterDraw() {
        return rectangle;
    }

    @Override
    public Texture getCharacter() {
        return texture;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void createCharacter() {

    }
}
