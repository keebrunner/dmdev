package com.dmdev.week3.OOP.Task1;

public class Room {
    private boolean passable;

    public Room(boolean passable) {
        this.passable = passable;
    }

    public void print() {
        if (passable) {
            System.out.println("The room is a passable");
        } else {
            System.out.println("The room is a unpassable");
        }
    }

    public boolean isPassable() {
        return passable;
    }

    public void setPassable(boolean passable) {
        this.passable = passable;
    }
}