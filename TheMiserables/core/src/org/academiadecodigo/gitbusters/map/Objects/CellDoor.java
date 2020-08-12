package org.academiadecodigo.gitbusters.map.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class CellDoor extends AbstractMapObject {

    public CellDoor(){
        setImage(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/Doors/DoorBlue.png")));
        setRectangle(new Rectangle());
    }
}
