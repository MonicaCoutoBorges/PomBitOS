package org.academiadecodigo.gitbusters.Sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import javax.sound.sampled.spi.AudioFileReader;

public class Sound {

    private static Music switchMusic = Gdx.audio.newMusic(Gdx.files.internal("MusicAndSounds/switchMusic.mp3"));
    private static Music backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("MusicAndSounds/backgroundMusic.mp3"));
    private static Music menuMusic = Gdx.audio.newMusic(Gdx.files.internal("MusicAndSounds/MenuMusic.mp3"));
    private static com.badlogic.gdx.audio.Sound switchSound = Gdx.audio.newSound(Gdx.files.internal("MusicAndSounds/ButtonPress.mp3"));

    public Sound(){

    }

    public static void lesMiserablesPlay(){
        switchMusic.play();
    }

    public static void backgroundPlay(){
        backgroundMusic.setLooping(true);
        backgroundMusic.play();
    }

    public static void backGroundStop(){
        backgroundMusic.stop();
    }

    public static void switchSoundPlay(){
        switchMusic.setLooping(true);
        switchSound.play();
    }

    public static void switchMusicStop(){
        switchMusic.stop();
    }

    public static void menuMusicPlay(){
        menuMusic.play();
    }

    public static void menuMusicStop(){
        menuMusic.stop();
    }

}
