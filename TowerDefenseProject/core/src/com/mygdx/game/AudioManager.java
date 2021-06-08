package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioManager {
    private static AudioManager instace;
    private int volume = 1;

    private Music musicMenu;
    private Music musicGame;


    private AudioManager()
    {
        musicMenu =  Gdx.audio.newMusic(Gdx.files.internal("MusicMenu.mp3"));
        musicGame =  Gdx.audio.newMusic(Gdx.files.internal("MusicGame.mp3"));
    }
    public static AudioManager getInstance()
    {
        if(instace==null)
        {
            instace = new AudioManager();
        }
        return instace;
    }


    public void PlayMusicMenu()
    {
        musicMenu.play();
        musicMenu.setVolume(0.4f);
        musicMenu.setLooping(true);
        musicGame.stop();
    }

    public void PlayMusicGame()
    {
        musicGame.play();
        musicGame.setVolume(0.4f);
        musicGame.setLooping(true);
        musicMenu.stop();
    }

    public void MuteVolume()
    {
        this.volume = 0;
        musicGame.pause();
    }

    public void DesmutedVolume()
    {
        this.volume = 1;
        musicGame.play();
    }

}
