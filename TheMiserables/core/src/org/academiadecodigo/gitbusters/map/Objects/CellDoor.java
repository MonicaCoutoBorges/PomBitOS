package org.academiadecodigo.gitbusters.map.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class CellDoor extends AbstractMapObject {


    public enum DoorType{
        BLUE,
        PINK
    }

    private DoorType color;

    public DoorType getColor() {
        return color;
    }

    public CellDoor(DoorType doorType){
        if (doorType == DoorType.BLUE) {
            setImage(new Texture(Gdx.files.internal("Doors/DoorBlue.png")));
            color = DoorType.BLUE;
        } else if (doorType == DoorType.PINK){
            setImage(new Texture(Gdx.files.internal("Doors/DoorPink.png")));
            color = DoorType.PINK;
        }

        setRectangle(new Rectangle());
    }
}
