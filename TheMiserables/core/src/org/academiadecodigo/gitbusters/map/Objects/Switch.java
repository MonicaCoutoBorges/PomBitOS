package org.academiadecodigo.gitbusters.map.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Switch extends AbstractMapObject {


    public enum SwitchType {
        BLUE,
        PINK
    }

    private SwitchType color;

    public SwitchType getColor() {
        return color;
    }

    public Switch(SwitchType switchType){
        if (switchType == SwitchType.BLUE) {
            setImage(new Texture(Gdx.files.internal("Switch/FloorSwitchBlue.png")));
            color = SwitchType.BLUE;
        } else if (switchType == SwitchType.PINK){
            setImage(new Texture(Gdx.files.internal("Switch/FloorSwitchPink.png")));
            color = SwitchType.PINK;
        }

        setRectangle(new Rectangle());
    }
}
