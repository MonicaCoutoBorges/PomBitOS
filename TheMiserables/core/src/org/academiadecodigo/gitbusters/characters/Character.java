package org.academiadecodigo.gitbusters.characters;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public interface Character {

void createCharacter();

Rectangle getCharacterDraw();

Texture getCharacter();

void drawCharacter();

}
