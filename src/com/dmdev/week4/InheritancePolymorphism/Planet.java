package com.dmdev.week4.InheritancePolymorphism;

import com.dmdev.week4.InheritancePolymorphism.utils.Constants;

import static com.dmdev.week4.InheritancePolymorphism.utils.Constants.DIAMETER_COEFFICIENT;

public class Planet extends StarSystem {
    //Composition of the atmosphere
    private String atmosphereComposition;
    private int numberOfSatellites;

    public Planet(double mass,
                  String name,
                  double[] coordinates,
                  String atmosphereComposition,
                  int numberOfSatellites)
            throws IllegalAccessException {
        super(mass, name, coordinates);
        this.atmosphereComposition = atmosphereComposition;
        this.numberOfSatellites = numberOfSatellites;
    }

    public Planet(double mass, String name, double[] coordinates) throws IllegalAccessException {
        super(mass, name, coordinates);
    }

    public double calculateSurfaceGravity() {
        double radius = calculateDiameter() / 2;
        return (Constants.GRAVITATIONAL_CONSTANT * getMass()) / (radius * radius);
    }

    @Override
    public double calculateDiameter() {
        return Math.pow((getMass() * 3) / DIAMETER_COEFFICIENT, 1 / 3.0);
    }

    @Override
    public String compareMass(StarSystem starSystem) {
        double difference = Math.abs(getMass() - starSystem.getMass());
        if (difference < 1) {
            return "The difference in mass between " + getName() + " and " + starSystem.getName() + " is negligible.";
        } else if (getMass() > starSystem.getMass()) {
            return getName() + " is " + difference + " times heavier than " + starSystem.getName() + ".";
        } else {
            return starSystem.getName() + " is " + difference + " times heavier than " + getName() + ".";
        }
    }

    @Override
    public String toString() {
        return "Planet {" +
                "\n Name: " + getName() +
                "\n Mass: " + getMass() +
                "\n Atmosphere Composition: " + atmosphereComposition +
                "\n Number of Satellites: " + numberOfSatellites +
                "\n Coordinates: [" + getCoordinates(0) + ", " + getCoordinates(1) + ", " + getCoordinates(2) + "]" + "\n}";
    }

    public String getAtmosphereComposition() {
        return atmosphereComposition;
    }

    public void setAtmosphereComposition(String atmosphereComposition) {
        this.atmosphereComposition = atmosphereComposition;
    }

    public int getNumberOfSatellites() {
        return numberOfSatellites;
    }

    public void setNumberOfSatellites(int numberOfSatellites) {
        this.numberOfSatellites = numberOfSatellites;
    }
}
