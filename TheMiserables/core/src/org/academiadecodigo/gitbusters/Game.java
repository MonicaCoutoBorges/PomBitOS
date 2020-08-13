package org.academiadecodigo.gitbusters;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.gitbusters.characters.Guard;
import org.academiadecodigo.gitbusters.characters.Hero;
import org.academiadecodigo.gitbusters.characters.Slave;
import org.academiadecodigo.gitbusters.map.Map;
import org.academiadecodigo.gitbusters.map.MapArray;
import org.academiadecodigo.gitbusters.map.Objects.*;

public class Game extends ApplicationAdapter {

    private Hero hero;
    private Slave slave;
    private Guard guard;

    public static SpriteBatch batch;

    private Map map;

    private OrthographicCamera camera;

    public final static int cellSize = 28;

    private float x = cellSize;
    private float y = cellSize;

    private Texture image;

    private int counter = 0;

    private boolean switchOn = false;

    private boolean movingDown = true;

    private GameStatus gameStatus = GameStatus.MAINMENU;


    @Override
    public void create() {

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch = new SpriteBatch();


        this.map = new Map();


        this.hero = new Hero();

        this.slave = new Slave();

        this.guard = new Guard();


    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        map.drawMap();
        hero.drawCharacter();
        guard.drawCharacter();
        slave.drawCharacter();


        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {

            hero.setTexture(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/Hero/RevolutionaryBack.png")));
            float y = hero.getRectangle().y;
            hero.getRectangle().y += Game.cellSize;
            for (AbstractMapObject object : map.getObjects()) {
                if (hero.getRectangle().overlaps(object.getRectangle())) {
                    hero.getRectangle().y = y;
                }
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {

            hero.setTexture(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/Hero/RevolutionaryFront.png")));
            float y = hero.getRectangle().y;
            hero.getRectangle().y -= Game.cellSize;
            for (AbstractMapObject object : map.getObjects()) {
                if (hero.getRectangle().overlaps(object.getRectangle())) {
                    hero.getRectangle().y = y;
                }
            }
        }

        if (guard.getRectangle().y != Game.cellSize && movingDown){
            guard.getRectangle().y -= 2;
            if(hero.getRectangle().x == guard.getRectangle().x && hero.getRectangle().y < guard.getRectangle().y) {
                System.exit(420);
            }
        }

        if (guard.getRectangle().y == cellSize){
            guard.setTexture(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/Guard/GuardBack.png")));
            movingDown = false;
        }

        if (guard.getRectangle().y != 5 * cellSize && !movingDown){
            guard.getRectangle().y += 2;
            if(hero.getRectangle().x == guard.getRectangle().x && hero.getRectangle().y > guard.getRectangle().y) {
                System.exit(420);
            }
        }

        if (guard.getRectangle().y == 5 * cellSize){
            guard.setTexture(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/Guard/GuardFront.png")));
            movingDown = true;
        }

        if (hero.getRectangle().overlaps(guard.getRectangle())){
            System.exit(1);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

            hero.setTexture(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/Hero/RevolutionaryLeft.png")));
            float x = hero.getRectangle().x;
            float y = hero.getRectangle().y;
            hero.getRectangle().x -= Game.cellSize;
            for (AbstractMapObject object : map.getObjects()) {
                if (hero.getRectangle().overlaps(object.getRectangle())) {
                    hero.getRectangle().x = x;
                }
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

            hero.setTexture(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/Hero/RevolutionaryRight.png")));
            float x = hero.getRectangle().x;
            hero.getRectangle().x += Game.cellSize;
            for (AbstractMapObject object : map.getObjects()) {
                if (hero.getRectangle().overlaps(object.getRectangle())) {
                    hero.getRectangle().x = x;
                }
            }
        }

        for (Switch aSwitch : map.getSwitches()) {
            if (hero.getRectangle().overlaps(aSwitch.getRectangle()) && aSwitch.getColor() == Switch.SwitchType.BLUE && !switchOn) {
                for (CellDoor cellDoor : map.getCellDoors()) {
                    if (cellDoor.getColor() == CellDoor.DoorType.BLUE) {
                        map.getObjects().removeValue(cellDoor,true);
                        map.getCellDoors().removeValue(cellDoor,true);
                        // MapArray.map0[(int) x / cellSize][(int) y / cellSize] = '_';
                        map.getMapArray()[4][5] = '_';
                        map.getMapArray()[4][11] = '_';
                        map.getMapArray()[5][11] = '_';
                        map.getMapArray()[6][11] = '_';
                        switchOn = true;
                    }
                }
            }
        }

        /**
        if (map.getCellDoors().isEmpty()){
            System.out.println("entrou");
            for (AbstractMapObject object: map.getObjects()){
                if (object instanceof FinalGate){
                    System.out.println("entrou");
                    map.getMapArray()[4][11] = '_';
                    map.getMapArray()[5][11] = '_';
                    map.getMapArray()[6][11] = '_';
                }
            }
        }
         */


        batch.end();

    }

    @Override
    public void dispose() {

        batch.dispose();

    }

    public void spriteDraw(Texture image, Rectangle rectangle) {
        batch.draw(image, rectangle.x, rectangle.y);
    }
}
