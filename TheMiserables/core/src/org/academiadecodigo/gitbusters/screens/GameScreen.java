package org.academiadecodigo.gitbusters.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.gitbusters.Game;
import org.academiadecodigo.gitbusters.Game1;
import org.academiadecodigo.gitbusters.characters.Hero;
import org.academiadecodigo.gitbusters.map.Map;
import org.academiadecodigo.gitbusters.map.Objects.AbstractMapObject;
import org.academiadecodigo.gitbusters.map.Objects.CellDoor;
import org.academiadecodigo.gitbusters.map.Objects.FinalGate;
import org.academiadecodigo.gitbusters.map.Objects.Switch;

import java.util.Iterator;

public class GameScreen implements Screen {

    private Hero hero;

    private Map map;

    private OrthographicCamera camera;

    public final static int cellSize = 28;

    private float x = cellSize;
    private float y = cellSize;

    private Texture image;

    private int counter = 0;

    private boolean switchOn = false;

    Game1 game;


    public GameScreen (Game1 game){
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


        this.map = new Map();


        this.hero = new Hero();

        image = hero.getTexture();


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        map.drawMap();
        hero.drawCharacter();


        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {

            hero.setTexture(new Texture(Gdx.files.internal("Hero/RevolutionaryBack.png")));
            float y = hero.getRectangle().y;
            hero.getRectangle().y += Game.cellSize;
            for (AbstractMapObject object : map.getObjects()) {
                if (hero.getRectangle().overlaps(object.getRectangle())) {
                    hero.getRectangle().y = y;
                }
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {

            hero.setTexture(new Texture(Gdx.files.internal("Hero/RevolutionaryFront.png")));
            float y = hero.getRectangle().y;
            hero.getRectangle().y -= Game.cellSize;
            for (AbstractMapObject object : map.getObjects()) {
                if (hero.getRectangle().overlaps(object.getRectangle())) {
                    hero.getRectangle().y = y;
                }
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

            hero.setTexture(new Texture(Gdx.files.internal("Hero/RevolutionaryLeft.png")));
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

            hero.setTexture(new Texture(Gdx.files.internal("Hero/RevolutionaryRight.png")));
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
                System.out.println("entrou");
                for (CellDoor cellDoor : map.getCellDoors()) {
                    if (cellDoor.getColor() == CellDoor.DoorType.BLUE) {
                        map.getObjects().removeValue(cellDoor,true);
                        map.getCellDoors().removeValue(cellDoor,true);
                        // MapArray.map0[(int) x / cellSize][(int) y / cellSize] = '_';
                        map.getMapArray()[4][5] = '_';
                        switchOn = true;


/**
 Floor floor = new Floor();
 floor.setImage(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/Floor/Floor.png")));
 floor.setRectangle(new Rectangle());
 floor.getRectangle().x = x;
 floor.getRectangle().y = y;
 floor.getRectangle().width = Game.cellSize;
 floor.getRectangle().height = Game.cellSize;
 Game.batch.draw(floor.getImage(), x, y);
 */
                    }
                }
            }
        }

        if (map.getCellDoors().isEmpty()){
            for (AbstractMapObject object: map.getObjects()){
                if (object instanceof FinalGate){
                    map.getMapArray()[4][11] = '_';
                    map.getMapArray()[5][11] = '_';
                    map.getMapArray()[6][11] = '_';
                }
            }
        }


        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        game.batch.dispose();
        image.dispose();
    }

 //   public void spriteDraw(Texture image, Rectangle rectangle){
   //     game.batch.draw(image, rectangle.x, rectangle.y);
    //}

}
