package org.academiadecodigo.gitbusters.map;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.gitbusters.Game;
import org.academiadecodigo.gitbusters.map.Objects.*;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private char[][] mapArray;
    private List<AbstractMapObject> objects;
    private AbstractMapObject[][] map;
    private SpriteBatch batch;


    public Map(){
         this.mapArray = MapArray.map0;
         this.batch = Game.batch;
         objects = new ArrayList<>();
    }

    public void drawMap(){

        map = new AbstractMapObject[11][12];


        for(int i = mapArray.length-1; i >= 0; i--){
            for(int j = 0; j < mapArray[i].length ; j++){
                switch (mapArray[i][j]){
                    case '_':
                        Floor floor = new Floor();
                        objects.add(floor);
                        map[i][j] = floor;
                        floor.getRectangle().x = j * Game.cellSize;
                        floor.getRectangle().y = (mapArray.length -1 - i) * Game.cellSize;
                        batch.draw(floor.getImage(),floor.getRectangle().x,floor.getRectangle().y);
                        break;
                    /**case 'T':
                        FinalGate finalGate = new FinalGate();
                        objects.add(finalGate);
                        map[i][j] = finalGate;
                        finalGate.getRectangle().x = (j + 1) * 28;
                        finalGate.getRectangle().y = (i + 1) * 28;
                        batch.draw(finalGate.getImage(),finalGate.getRectangle().x,finalGate.getRectangle().y);
                        break;
                    case 'X':
                        Wall wall = new Wall();
                        objects.add(wall);
                        map[i][j] = wall;
                        wall.getRectangle().x = (j + 1) * 28;
                        wall.getRectangle().y = (i + 1) * 28;
                        batch.draw(wall.getImage(),wall.getRectangle().x,wall.getRectangle().y);
                        break;
                    case 'Y':
                        CellDoor cellDoor = new CellDoor();
                        objects.add(cellDoor);
                        map[i][j] = cellDoor;
                        cellDoor.getRectangle().x = (j + 1) * 28;
                        cellDoor.getRectangle().y = (i + 1) * 28;
                        batch.draw(cellDoor.getImage(),cellDoor.getRectangle().x,cellDoor.getRectangle().y);
                        break;
                    case 'K':
                        Switch aSwitch = new Switch();
                        objects.add(aSwitch);
                        map[i][j] = aSwitch;
                        aSwitch.getRectangle().x = (j + 1) * 28;
                        aSwitch.getRectangle().y = (i + 1) * 28;
                        batch.draw(aSwitch.getImage(),aSwitch.getRectangle().x,aSwitch.getRectangle().y);
                        break;*/
                }
            }
        }

    }

}
