package org.academiadecodigo.gitbusters.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Hero extends AbstractCharacter{


    public Hero(){
        setTexture(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/RevolutionaryFoward.png")));
        setRectangle(new Rectangle());
    }

    public void drawHero() {
        getRectangle().x = 3 * 28;
        getRectangle().y = 9 * 28;
        batch.draw(getTexture(), getRectangle().x, getRectangle().y);
    }





}
