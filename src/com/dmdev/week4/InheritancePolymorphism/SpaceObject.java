package com.dmdev.week4.InheritancePolymorphism;

import static com.dmdev.week4.InheritancePolymorphism.utils.Constants.DIAMETER_COEFFICIENT;

public abstract class SpaceObject {
    private double mass;
    private String name;
    private double[] coordinates = new double[3];

    public SpaceObject(double mass, String name, double[] coordinates) throws IllegalAccessException {
        if (mass <= 0) {
            throw new IllegalAccessException("Mass must be greater than 0");
        }
        this.mass = mass;
        this.name = name;
        this.coordinates = coordinates;
    }

    public double calculateDiameter() {
        return Math.pow((getMass() * 3) / DIAMETER_COEFFICIENT, 1 / 3.0);
    }

    public double calculateDistance(SpaceObject other) {
        double dx = this.coordinates[0] - other.coordinates[0];
        double dy = this.coordinates[1] - other.coordinates[1];
        double dz = this.coordinates[2] - other.coordinates[2];
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public abstract String compareMass(SpaceObject spaceObject);

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" + "\n Name: " + getName() + "\n Mass: " + getMass() + "\n Coordinates: [" + coordinates[0] + ", " + coordinates[1] + ", " + coordinates[2] + "]" + "\n}";
    }

    public double getCoordinates(int index) {
        return coordinates[index];
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setName(String name) {
        this.name = name;
    }
}

