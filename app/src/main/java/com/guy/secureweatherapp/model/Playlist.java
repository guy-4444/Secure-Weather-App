package com.guy.secureweatherapp.model;

import java.util.ArrayList;

public class Playlist {

    String name;
    int likes;
    long date;
    boolean onPlayed;
    ArrayList<Song> songs = new ArrayList<>();

    public Playlist() {
    }

    public String getName() {
        return name;
    }

    public Playlist setName(String name) {
        this.name = name;
        return this;
    }

    public int getLikes() {
        return likes;
    }

    public Playlist setLikes(int likes) {
        this.likes = likes;
        return this;
    }

    public long getDate() {
        return date;
    }

    public Playlist setDate(long date) {
        this.date = date;
        return this;
    }

    public boolean isOnPlayed() {
        return onPlayed;
    }

    public Playlist setOnPlayed(boolean onPlayed) {
        this.onPlayed = onPlayed;
        return this;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public Playlist setSongs(ArrayList<Song> songs) {
        this.songs = songs;
        return this;
    }
}
