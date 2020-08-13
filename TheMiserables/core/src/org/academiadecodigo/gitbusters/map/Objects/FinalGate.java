package org.academiadecodigo.gitbusters.map.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class FinalGate extends AbstractMapObject {

    public FinalGate(){
        setImage(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/FinalDoor/FinalDoorLeft.png")));
        setRectangle(new Rectangle());
    }
}
