package org.academiadecodigo.gitbusters.map.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Switch extends AbstractMapObject {

    public Switch(){
        setImage(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/Switch/FloorSwitchBlue.png")));
        setRectangle(new Rectangle());
    }
}
