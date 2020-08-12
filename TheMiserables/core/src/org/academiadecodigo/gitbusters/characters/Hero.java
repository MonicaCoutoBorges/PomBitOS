package org.academiadecodigo.gitbusters.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Hero extends AbstractCharacter{

    private Texture hero;
    private Rectangle heroDraw;


    public Rectangle getHeroDraw() {
        return heroDraw;
    }

    public Texture getHero() {
        return hero;
    }

    public void createHero() {
        hero = new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/RevolutionaryFoward.png"));

        heroDraw = new Rectangle();
        heroDraw.x = 200;
        heroDraw.y = 20;
        heroDraw.width = 28;
        heroDraw.height = 28;

    }

    public void drawHero() {
        batch.draw(hero, heroDraw.x, heroDraw.y);
    }





}
