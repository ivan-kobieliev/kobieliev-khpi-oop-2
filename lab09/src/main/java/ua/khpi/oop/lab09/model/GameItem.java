package ua.khpi.oop.lab09.model;

public class GameItem {

    private String itemName;
    private int power;

    public GameItem(String itemName, int power) {
        this.itemName = itemName;
        this.power = power;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "GameItem{name='" + itemName + "', power=" + power + "}";
    }
}