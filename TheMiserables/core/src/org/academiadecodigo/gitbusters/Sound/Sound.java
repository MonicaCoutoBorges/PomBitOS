package org.academiadecodigo.gitbusters.Sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import javax.sound.sampled.spi.AudioFileReader;

public class Sound {

    private Music switchMusic;
    private Music backgroundMusic;
    private com.badlogic.gdx.audio.Sound switchSound;

    public Sound(){
        switchMusic = Gdx.audio.newMusic(Gdx.files.internal("MusicAndSounds/switchMusic.mp3"));
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("MusicAndSounds/backgroundMusic.mp3"));
        switchSound = Gdx.audio.newSound(Gdx.files.internal("MusicAndSounds/ButtonPress.mp3"));


    }

    public void lesMiserablesPlay(){
        switchMusic.play();
    }

    public void backgroundPlay(){
        backgroundMusic.setLooping(true);
        backgroundMusic.play();
    }

    public void backGroundStop(){
        backgroundMusic.stop();
    }

    public void switchSoundPlay(){
        switchSound.play();
    }

}
