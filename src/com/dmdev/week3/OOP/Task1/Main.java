package com.dmdev.week3.OOP.Task1;

public class Main {

    public static void main(String[] args) {

        Room[] rooms = new Room[]{new Room(true), new Room(false)};
        Flat[] flats = new Flat[]{new Flat(101, rooms)};
        Floor[] floors = new Floor[]{new Floor(1, flats)};
        House house = new House(1, floors);

        printAllInformation(house);
    }

    public static void printAllInformation(House house) {
        System.out.println("House number " + house.getHouseNumber() + ", number of floors " + house.getFloors().length);
        for (Floor floor : house.getFloors()) {
            floor.print();
        }
    }
}



