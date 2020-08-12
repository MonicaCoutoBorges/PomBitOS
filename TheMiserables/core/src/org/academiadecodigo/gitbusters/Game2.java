//package org.academiadecodigo.gitbusters;
//
//import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.Rectangle;
//import org.academiadecodigo.gitbusters.characters.Hero;
//import org.academiadecodigo.gitbusters.map.Map;
//
//public class Game2 extends ApplicationAdapter {
//
//    private Hero hero;
//
//    public static SpriteBatch batch;
//
//    private Map map;
//
//    private OrthographicCamera camera;
//
//    public final static int cellSize = 28;
//
//    private float x = cellSize;
//    private float y = cellSize;
//
//    private Texture image;
//
//
//    @Override
//    public void create () {
//
//        camera= new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//
//        batch = new SpriteBatch();
//
//
//        this.map = new Map();
//
//
//        this.hero = new Hero();
//
//        image = hero.getTexture();
//
//
//    }
//
//    @Override
//    public void render () {
//
//        Gdx.gl.glClearColor(0,0,255,1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        batch.begin();
//        map.drawMap();
//        hero.drawHero();
//
//
//        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
//            hero.getRectangle().y = hero.getRectangle().y + Game.cellSize;
//            hero.setTexture(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/Hero/RevolutionaryBack.png")));
//        }
//
//        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
//            hero.getRectangle().y = hero.getRectangle().y - Game.cellSize;
//            hero.setTexture(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/Hero/RevolutionaryFront.png")));
//        }
//
//        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
//            hero.getRectangle().x = hero.getRectangle().x - Game.cellSize;
//            hero.setTexture(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/Hero/RevolutionaryLeft.png")));
//        }
//
//        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
//            hero.getRectangle().x = hero.getRectangle().x + Game.cellSize;
//            hero.setTexture(new Texture(Gdx.files.internal("/Users/codecadet/Desktop/PomBitOS/TheMiserables/core/assets/Hero/RevolutionaryRight.png")));
//        }
//
//        batch.end();
//
//    }
//
//    @Override
//    public void dispose () {
//
//        batch.dispose();
//
//    }
//
//    public void spriteDraw(Texture image, Rectangle rectangle){
//        batch.draw(image, rectangle.x, rectangle.y);
//    }
//}