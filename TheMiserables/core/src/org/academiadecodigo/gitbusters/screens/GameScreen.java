package org.academiadecodigo.gitbusters.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.gitbusters.Game2;
import org.academiadecodigo.gitbusters.GameStatus;
import org.academiadecodigo.gitbusters.Sound.Sound;
import org.academiadecodigo.gitbusters.characters.Guard;
import org.academiadecodigo.gitbusters.characters.Hero;
import org.academiadecodigo.gitbusters.characters.Slave;
import org.academiadecodigo.gitbusters.map.Map;
import org.academiadecodigo.gitbusters.map.MapArray;
import org.academiadecodigo.gitbusters.map.Objects.AbstractMapObject;
import org.academiadecodigo.gitbusters.map.Objects.CellDoor;
import org.academiadecodigo.gitbusters.map.Objects.FinalGate;
import org.academiadecodigo.gitbusters.map.Objects.Switch;

public class GameScreen implements Screen {


    private Hero hero;
    private Slave slave;
    private Guard guard;

    private Map map;

    private OrthographicCamera camera;

    public final static int cellSize = 28;

    private float x = cellSize;
    private float y = cellSize;

    private Texture image;

    private int counter = 0;

    private boolean levelCompleted = false;

    private boolean switchOn = false;

    private boolean guardMovingDown = true;

    private boolean slaveEscaped = false;


    private GameStatus gameStatus = GameStatus.MAINMENU;

    Game2 game;



    public GameScreen (Game2 game){

        this.game = game;

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


        this.map = new Map();

        this.hero = new Hero();

        this.slave = new Slave();

        this.guard = new Guard();

        Sound.backgroundPlay();

        map.setMapArray(MapArray.map0);

    }

    @Override
    public void show() {


    }

    public Map getMap() {
        return map;
    }

    @Override
    public void render(float delta) {


        Gdx.gl.glClearColor(0, 0, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        map.drawMap();
        hero.drawCharacter();
        guard.drawCharacter();
        slave.drawCharacter();

        if (levelCompleted){
            for (FinalGate finalGate: map.getFinalGates()){
                map.getFinalGates().removeValue(finalGate,true);
                map.getObjects().removeValue(finalGate,true);
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

            hero.setTexture(new Texture(Gdx.files.internal("Hero/RevolutionaryLeft.png")));
            float x = hero.getRectangle().x;
            float y = hero.getRectangle().y;
            hero.getRectangle().x -= (float) GameScreen.cellSize / 4;
            for (AbstractMapObject object : map.getObjects()) {
                if (hero.getRectangle().overlaps(object.getRectangle())) {
                    hero.getRectangle().x = x;
                }
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

            hero.setTexture(new Texture(Gdx.files.internal("Hero/RevolutionaryRight.png")));
            float x = hero.getRectangle().x;
            hero.getRectangle().x += (float) GameScreen.cellSize / 4;
            for (AbstractMapObject object : map.getObjects()) {
                if (hero.getRectangle().overlaps(object.getRectangle())) {
                    hero.getRectangle().x = x;
                }
            }
        }

        for (Switch aSwitch : map.getSwitches()) {
            if (hero.getRectangle().overlaps(aSwitch.getRectangle()) && aSwitch.getColor() == Switch.SwitchType.BLUE && !switchOn) {
                Sound.backGroundStop();
                Sound.switchSoundPlay();
                Sound.lesMiserablesPlay();
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
                        levelCompleted = true;

                    }
                }
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {

            hero.setTexture(new Texture(Gdx.files.internal("Hero/RevolutionaryBack.png")));
            float y = hero.getRectangle().y;
            hero.getRectangle().y += (float) GameScreen.cellSize / 4;
            for (AbstractMapObject object : map.getObjects()) {
                if (hero.getRectangle().overlaps(object.getRectangle())) {
                    hero.getRectangle().y = y;
                }
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {

            hero.setTexture(new Texture(Gdx.files.internal("Hero/RevolutionaryFront.png")));
            float y = hero.getRectangle().y;
            hero.getRectangle().y -= (float) GameScreen.cellSize / 4;
            for (AbstractMapObject object : map.getObjects()) {
                if (hero.getRectangle().overlaps(object.getRectangle())) {
                    hero.getRectangle().y = y;
                }
            }
        }

        if (guard.getRectangle().y != GameScreen.cellSize && guardMovingDown){
            guard.getRectangle().y -= 2;
            if(hero.getRectangle().x < guard.getRectangle().x + (float)16 && hero.getRectangle().x > guard.getRectangle().x - (float)16 && hero.getRectangle().y < guard.getRectangle().y) {
                guard.setTexture(new Texture(Gdx.files.internal("Guard/GuardBack.png")));
                Sound.backGroundStop();
                Sound.switchMusicStop();
                map.cleanArrays();
                resetMap();
                game.setScreen(new GameOverScreen(game));
                // System.exit(420);
            }
        }

        if (guard.getRectangle().y == cellSize){
            guard.setTexture(new Texture(Gdx.files.internal("Guard/GuardBack.png")));
            guardMovingDown = false;
        }

        if (guard.getRectangle().y != 5 * cellSize && !guardMovingDown){
            guard.getRectangle().y += 2;
            if(hero.getRectangle().x < guard.getRectangle().x + (float)16 && hero.getRectangle().x > guard.getRectangle().x - (float)16 && hero.getRectangle().y > guard.getRectangle().y) {
                guard.setTexture(new Texture(Gdx.files.internal("Guard/GuardFront.png")));
                Sound.backGroundStop();
                Sound.switchMusicStop();
                map.cleanArrays();
                resetMap();

                game.setScreen(new GameOverScreen(game));
                //System.exit(420);
            }
        }



        if (guard.getRectangle().y == 5 * cellSize){
            guard.setTexture(new Texture(Gdx.files.internal("Guard/GuardFront.png")));
            guardMovingDown = true;
        }

        if (hero.getRectangle().overlaps(guard.getRectangle())){

            Sound.backGroundStop();
            Sound.switchMusicStop();
            map.cleanArrays();
            resetMap();

            game.setScreen(new GameOverScreen(game));
            //System.exit(1);
        }



        if (slave.getRectangle().overlaps(guard.getRectangle())){

            resetMap();
            Sound.backGroundStop();
            Sound.switchMusicStop();
            map.cleanArrays();
            game.setScreen(new GameOverScreen(game));

            //System.exit(1);
        }

        if (levelCompleted && slave.getRectangle().y > 5 * GameScreen.cellSize) {
            slave.getRectangle().y -= 4;
            /**
             if (!guardMovingDown && slave.getRectangle().x == guard.getRectangle().x) {
             System.exit(420);
             }
             */
        }

        if (slave.getRectangle().y == 5 * GameScreen.cellSize && !slaveEscaped) {
            slave.setTexture(new Texture(Gdx.files.internal("Prisioner/PrisionerRight.png")));
            slave.getRectangle().x += 4;
            if (slave.getRectangle().x > 336){
                slave.getTexture().dispose();
                Rectangle rectangle = slave.getRectangle();
                rectangle = null;
                slaveEscaped = true;
            }
        }

        if (hero.getRectangle().x > (map.getMapArray()[0].length -1) * GameScreen.cellSize){
            /// a imagem de WINNING ESTÁ A APARECER AQUI
            Sound.switchMusicStop();
            Sound.backGroundStop();
            resetMap();
            map.cleanArrays();
            game.setScreen(new WinnerScrenn(game));
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


        game.batch.end();
    }

    public void resetMap(){
        map.getMapArray()[4][5] = 'Y';
        map.getMapArray()[4][11] = 'T';
        map.getMapArray()[5][11] = 'T';
        map.getMapArray()[6][11] = 'T';
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
        Gdx.input.setInputProcessor(null);
        game.batch.dispose();
        image.dispose();
    }

    public void spriteDraw(Texture image, Rectangle rectangle){
        game.batch.draw(image, rectangle.x, rectangle.y);
    }

}
