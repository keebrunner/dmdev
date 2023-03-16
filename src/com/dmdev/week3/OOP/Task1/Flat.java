package com.dmdev.week3.OOP.Task1;

public class Flat {
    private int flatNumber;
    private Room[] rooms;


    public Flat(int flatNumber, Room[] rooms) {
        this.flatNumber = flatNumber;
        this.rooms = rooms;
    }

    public void print() {
        System.out.println("Flat " + flatNumber + ", number of rooms " + rooms.length);
        for (Room room : rooms) {
            room.print();
        }
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }
}
