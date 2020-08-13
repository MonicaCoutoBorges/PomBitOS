package org.academiadecodigo.gitbusters.map.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class AbstractMapObject {

    private Texture image;
    private Rectangle rectangle;

    public void setImage(Texture image) {
        this.image = image;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Texture getImage() {
        return image;
    }
}
