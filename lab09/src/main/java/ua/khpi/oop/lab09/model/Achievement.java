package ua.khpi.oop.lab09.model;

public class Achievement {

    private String title;
    private boolean completed;

    public Achievement(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "Achievement{title='" + title + "', completed=" + completed + "}";
    }
}