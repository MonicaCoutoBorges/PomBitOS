package org.academiadecodigo.gitbusters.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.gitbusters.Game;
import org.academiadecodigo.gitbusters.map.Objects.AbstractMapObject;
import org.academiadecodigo.gitbusters.map.Objects.Floor;

public class Map {

    private char[][] mapArray;
    private AbstractMapObject[] objects;
    private AbstractMapObject[][] map;
    private 


    public Map(MapArray mapArray){
         this.mapArray = MapArray.map0;
    }

    public void drawMap(){

        map = new AbstractMapObject[11][12];


        for(int i = 0; i < mapArray.length; i++){
            for(int j = 0; j < mapArray[i].length; j++){
                switch (mapArray[i][j]){
                    case '_':
                        map[i][j] = new Floor();
                        map[i][j].getRectangle().x = (j + 1) * 28;
                        map[i][j].getRectangle().y = (i + 1) * 28;
                        break;
                    case 'T':
                        map[i][j] = new Floor();
                        map[i][j].getRectangle().x = (j + 1) * 28;
                        map[i][j].getRectangle().y = (i + 1) * 28;
                        break;
                    case 'X':
                        map[i][j] = new Floor();
                        map[i][j].getRectangle().x = (j + 1) * 28;
                        map[i][j].getRectangle().y = (i + 1) * 28;
                        break;
                    case 'Y':
                        map[i][j] = new Floor();
                        map[i][j].getRectangle().x = (j + 1) * 28;
                        map[i][j].getRectangle().y = (i + 1) * 28;
                        break;
                    case 'K':
                        map[i][j] = new Floor();
                        map[i][j].getRectangle().x = (j + 1) * 28;
                        map[i][j].getRectangle().y = (i + 1) * 28;
                        break;
                }
            }
        }

    }

}
