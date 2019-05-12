package com.attila.main;

public class User {
    public String getName() {
        return Username;
    }

    public int getScore() {
        return score;
    }

    private String Username;
    private int score;


    public User(String username, int score) {
        Username = username;
        this.score = score;
    }
}
