package ua.khpi.oop.lab09.model;

public class Player {

    private String name;
    private int level;

    public Player(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', level=" + level + "}";
    }
}