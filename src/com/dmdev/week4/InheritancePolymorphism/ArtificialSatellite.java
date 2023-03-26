package com.dmdev.week4.InheritancePolymorphism;

import static com.dmdev.week4.InheritancePolymorphism.utils.Constants.DIAMETER_COEFFICIENT;

public class ArtificialSatellite extends Planet implements GeoStationary {
    // Whether this artificial satellite is in geosynchronous orbit around its parent planet
    private boolean isGeoSynchronous;
    // Whether the satellite is geostationary
    private boolean isGeoStationary;

    public ArtificialSatellite(double mass,
                               String name,
                               double[] coordinates,
                               boolean isGeoSynchronous,
                               boolean isGeoStationary)
            throws IllegalAccessException {
        super(mass, name, coordinates);
        this.isGeoSynchronous = isGeoSynchronous;
        this.isGeoStationary = isGeoStationary;
    }

    public boolean isGeoSynchronous() {
        return isGeoSynchronous;
    }

    @Override
    // Mass of the satellite must be at least 100 kilograms
    public boolean isGeoStationary() {
        if (getMass() < 100) {
            return false;
        }
        return isGeoStationary;
    }

    @Override
    public double calculateDiameter() {
        return Math.pow((getMass() * 3) / DIAMETER_COEFFICIENT, 1 / 3.0);
    }

    @Override
    public String compareMass(SpaceObject spaceObject) {
        double difference = Math.abs(getMass() - spaceObject.getMass());
        if (difference < 1) {
            return "The difference in mass between " + getName() + " and " + spaceObject.getName() + " is negligible.";
        } else if (getMass() > spaceObject.getMass()) {
            return getName() + " is " + difference + " times heavier than " + spaceObject.getName() + ".";
        } else {
            return spaceObject.getName() + " is " + difference + " times heavier than " + getName() + ".";
        }
    }

    @Override
    public String toString() {
        return "Artificial Satellite {" +
                "\n Name: " + getName() +
                "\n Mass: " + getMass() +
                "\n Is Geosynchronous: " + isGeoSynchronous() +
                "\n Is Geo-Stationary: " + isGeoStationary() +
                "\n Coordinates: [" + getCoordinates(0) + ", " + getCoordinates(1) + ", " + getCoordinates(2) +
                "\n}";
    }

    public void setGeoSynchronous(boolean geoSynchronous) {
        isGeoSynchronous = geoSynchronous;
    }

    public void setGeoStationary(boolean geoStationary) {
        isGeoStationary = geoStationary;
    }
}
