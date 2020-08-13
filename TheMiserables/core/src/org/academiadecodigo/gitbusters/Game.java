package org.academiadecodigo.gitbusters;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.gitbusters.characters.Hero;
import org.academiadecodigo.gitbusters.map.Map;
import org.academiadecodigo.gitbusters.map.MapArray;
import org.academiadecodigo.gitbusters.map.Objects.AbstractMapObject;
import org.academiadecodigo.gitbusters.map.Objects.CellDoor;
import org.academiadecodigo.gitbusters.map.Objects.Floor;
import org.academiadecodigo.gitbusters.map.Objects.Switch;

public class Game extends ApplicationAdapter {

    private Hero hero;

    public static SpriteBatch batch;

    private Map map;

    private OrthographicCamera camera;

    public final static int cellSize = 28;

    private float x = cellSize;
    private float y = cellSize;

    private Texture image;

    private int counter = 0;

    private boolean switchOn = false;


    @Override
    public void create() {

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch = new SpriteBatch();


        this.map = new Map();


        this.hero = new Hero();

        image = hero.getTexture();


    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        map.drawMap();
        hero.drawCharacter();


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
                System.out.println("entrou");
                for (CellDoor cellDoor : map.getCellDoors()) {
                    if (cellDoor.getColor() == CellDoor.DoorType.BLUE) {
                        map.getObjects().removeValue(cellDoor,true);
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
