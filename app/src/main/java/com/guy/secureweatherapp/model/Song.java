package com.guy.secureweatherapp.model;

public class Song {
    String singer;
    String name;

    public Song(String singer, String name) {
        this.singer = singer;
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public Song setSinger(String singer) {
        this.singer = singer;
        return this;
    }

    public String getName() {
        return name;
    }

    public Song setName(String name) {
        this.name = name;
        return this;
    }
}
