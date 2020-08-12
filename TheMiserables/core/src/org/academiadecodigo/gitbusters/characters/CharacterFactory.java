package org.academiadecodigo.gitbusters.characters;

public class CharacterFactory {


    private Character character;

    public enum CharacterType {
        HERO,
        SLAVE,
        GUARD
    }

    public Character createCharacter(CharacterType characterType) {
        switch (characterType) {
            case HERO:
                character = new Hero();
                break;

            case SLAVE:
                character = new Slave();
                break;

            case GUARD:
                character = new Guard();
                break;
        }
        return character;
    }   

}
