package com.dmdev.week3.OOP.Task1;

public class House {
    private int houseNumber;
    private Floor[] floors;

    public House(int houseNumber, Floor[] floors) {
        this.houseNumber = houseNumber;
        this.floors = floors;
    }

    public void print() {
        System.out.println("House " + houseNumber + ", number of floors " + floors.length);
        for (Floor floor : floors) {
            floor.print();
        }
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public void setFloors(Floor[] floors) {
        this.floors = floors;
    }
}
