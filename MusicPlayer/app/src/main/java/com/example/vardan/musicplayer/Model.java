package com.example.vardan.musicplayer;

public class Model {
    private int musicLink;
    private String name;
    private int image;
    private boolean pause;


    Model(String name, int musicLink, int image, boolean pause) {
        this.name = name;
        this.musicLink = musicLink;
        this.image = image;
        this.pause = pause;
    }

    public int getMusicLink() {
        return musicLink;
    }

    public void setMusicLink(int musicLink) {
        this.musicLink = musicLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
