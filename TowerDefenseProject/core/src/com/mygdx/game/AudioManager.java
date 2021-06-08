package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioManager {
    private static AudioManager instace;
    private int volume = 1;

    private Sound soundPressButton;
    private Music musicMenu;
    private Music musicGame;
    private Music musicWin;


    private AudioManager()
    {
        musicMenu =  Gdx.audio.newMusic(Gdx.files.internal("MusicMenu.mp3"));
        musicGame =  Gdx.audio.newMusic(Gdx.files.internal("MusicGame.mp3"));
        musicWin =  Gdx.audio.newMusic(Gdx.files.internal("MusicWinGame.mp3"));
        soundPressButton = Gdx.audio.newSound(Gdx.files.internal("soundButtonPress.wav"));
    }
    public static AudioManager getInstance()
    {
        if(instace==null)
        {
            instace = new AudioManager();
        }
        return instace;
    }

    public void PlaySound(int id)
    {
        if(id == 0)
        {
            soundPressButton.play(volume);
            //System.out.println("sonando primer sonido");
        }
    }


    public void PlayMusicMenu()
    {
        musicMenu.play();
        musicMenu.setVolume(0.4f);
        musicMenu.setLooping(true);
        musicGame.stop();
        musicWin.stop();
    }

    public void PlayMusicGame()
    {
        musicGame.play();
        musicGame.setVolume(0.4f);
        musicGame.setLooping(true);
        musicMenu.stop();
        musicWin.stop();
    }

    public void PlayMusicWin()
    {
        musicWin.play();
        musicWin.setVolume(0.5f);
        musicWin.setLooping(true);
        musicMenu.stop();
        musicGame.stop();
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
