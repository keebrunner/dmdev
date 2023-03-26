package com.dmdev.week4.InheritancePolymorphism;

import static com.dmdev.week4.InheritancePolymorphism.utils.Constants.DIAMETER_COEFFICIENT;

public class Asteroid extends SpaceObject {
    private String composition;
    private String classification;

    public Asteroid(double mass, String name, double[] coordinates, String composition, String classification) throws IllegalAccessException {
        super(mass, name, coordinates);
        this.composition = composition;
        this.classification = classification;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    @Override
    public double calculateDiameter() {
        return Math.pow((getMass() * 3) / DIAMETER_COEFFICIENT, 1 / 3.0);
    }

    @Override
    public String compareMass(SpaceObject spaceObject) {
        double difference = Math.abs(this.getMass() - spaceObject.getMass());
        if (this.getMass() < spaceObject.getMass()) {
            return "Mass of the current object is less than that of " + spaceObject.getName() + " by " + difference + " kg";
        } else if (this.getMass() > spaceObject.getMass()) {
            return "Mass of the current object is greater than that of " + spaceObject.getName() + " by " + difference + " kg";
        } else {
            return "Mass of the current object is equal to the mass of " + spaceObject.getName();
        }
    }

    @Override
    public String toString() {
        return "Asteroid {" +
                "\n Name: " + getName() +
                "\n Mass: " + getMass() +
                "Composition: " + composition +
                "\n Classification: " + classification +
                "\n Coordinates: [" + getCoordinates(0) + ", " + getCoordinates(1) + ", " + getCoordinates(2) +
                "\n}";
    }
}
