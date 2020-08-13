package org.academiadecodigo.gitbusters.map.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Wall extends AbstractMapObject{

    public Wall(){
        setImage(new Texture(Gdx.files.internal("Wall/Wall.png")));
        setRectangle(new Rectangle());
    }
}
