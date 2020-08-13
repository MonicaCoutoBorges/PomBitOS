package org.academiadecodigo.gitbusters.map;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import org.academiadecodigo.gitbusters.Game;
import org.academiadecodigo.gitbusters.map.Objects.*;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private char[][] mapArray;
    private Array<AbstractMapObject> objects;
    private Array<Switch> switches;
    private Array<CellDoor> cellDoors;
    private Array<FinalGate> finalGates;
    private AbstractMapObject[][] map;
    private SpriteBatch batch;
    private int switchCounter = 0;

    public void setMapArray(char[][] mapArray) {
        this.mapArray = mapArray;
    }

    public Map(){
         this.batch = Game.batch;
         objects = new Array<AbstractMapObject>();
         cellDoors = new Array<CellDoor>();
         switches = new Array<Switch>();
         finalGates = new Array<FinalGate>();
    }

    public Array<Switch> getSwitches() {
        return switches;
    }

    public Array<AbstractMapObject> getObjects() {
        return objects;
    }

    public Array<CellDoor> getCellDoors() {
        return cellDoors;
    }

    public Array<Rectangle> getObjectRectangles(){
        Array<Rectangle> rectangles = new Array<>();
        for (AbstractMapObject object : objects){
            rectangles.add(object.getRectangle());
        }

        return rectangles;
    }

    public char[][] getMapArray() {
        return mapArray;
    }

    public Array<FinalGate> getFinalGates() {
        return finalGates;
    }

    public void drawMap(){

        map = new AbstractMapObject[11][12];

        this.mapArray = MapArray.map0;

        for(int i = mapArray.length-1; i >= 0; i--){
            for(int j = 0; j < mapArray[i].length ; j++){
                switch (mapArray[i][j]){
                    case '_':
                        Floor floor = new Floor();
                        map[i][j] = floor;
                        floor.getRectangle().x = j * Game.cellSize;
                        floor.getRectangle().y = (mapArray.length -1 - i) * Game.cellSize;
                        floor.getRectangle().width = Game.cellSize;
                        floor.getRectangle().height = Game.cellSize;
                        batch.draw(floor.getImage(),floor.getRectangle().x,floor.getRectangle().y);
                        break;
                    case 'T':
                        FinalGate finalGate = new FinalGate();
                        map[i][j] = finalGate;
                        finalGate.getRectangle().x = j * 28;
                        finalGate.getRectangle().y = (mapArray.length -1 - i) * Game.cellSize;
                        finalGate.getRectangle().width = Game.cellSize;
                        finalGate.getRectangle().height = Game.cellSize;
                        objects.add(finalGate);
                        finalGates.add(finalGate);
                        batch.draw(finalGate.getImage(),finalGate.getRectangle().x,finalGate.getRectangle().y);
                        break;
                    case 'X':
                        Wall wall = new Wall();
                        map[i][j] = wall;
                        wall.getRectangle().x = j * 28;
                        wall.getRectangle().y = (mapArray.length -1 - i) * Game.cellSize;
                        wall.getRectangle().width = Game.cellSize;
                        wall.getRectangle().height = Game.cellSize;
                        batch.draw(wall.getImage(),wall.getRectangle().x,wall.getRectangle().y);
                        objects.add(wall);
                        break;
                    case 'Y':
                        CellDoor cellDoor;
                        if (switchCounter == 0) {
                            cellDoor = new CellDoor(CellDoor.DoorType.BLUE);
                        } else {
                            cellDoor = new CellDoor(CellDoor.DoorType.PINK);
                        }
                        map[i][j] = cellDoor;
                        cellDoor.getRectangle().x = j * 28;
                        cellDoor.getRectangle().y = (mapArray.length -1 - i) * Game.cellSize;
                        cellDoor.getRectangle().width = Game.cellSize;
                        cellDoor.getRectangle().height = Game.cellSize;
                        cellDoors.add(cellDoor);
                        objects.add(cellDoor);
                        batch.draw(cellDoor.getImage(),cellDoor.getRectangle().x,cellDoor.getRectangle().y);
                        break;
                    case 'K':
                        Switch aSwitch;
                        if (switchCounter == 0) {
                            aSwitch = new Switch(Switch.SwitchType.BLUE);
                        } else {
                            aSwitch = new Switch(Switch.SwitchType.PINK);
                        }
                        map[i][j] = aSwitch;
                        aSwitch.getRectangle().x = j * 28;
                        aSwitch.getRectangle().y = (mapArray.length -1 - i) * Game.cellSize;
                        aSwitch.getRectangle().width = Game.cellSize;
                        aSwitch.getRectangle().height = Game.cellSize;
                        switches.add(aSwitch);
                        batch.draw(aSwitch.getImage(),aSwitch.getRectangle().x,aSwitch.getRectangle().y);
                        break;
                    default:
                        // System.out.println("I love myself!");
                }
            }
        }

    }

}
