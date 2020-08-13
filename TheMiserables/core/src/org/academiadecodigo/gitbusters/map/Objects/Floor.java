package org.academiadecodigo.gitbusters.map.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Floor extends AbstractMapObject {

    public Floor(){
        setImage(new Texture(Gdx.files.internal("Floor/Floor.png")));
        setRectangle(new Rectangle());
    }
}
