package com.dmdev.week4.InheritancePolymorphism;

import static com.dmdev.week4.InheritancePolymorphism.utils.Constants.DIAMETER_COEFFICIENT;

public class NaturalSatellite extends Planet implements GeoStationary {
    // Distance from the planet in kilometers
    private double distanceFromPlanet;
    // Whether the satellite is geostationary
    private boolean isGeoStationary;
    // Whether this natural satellite is tidally locked to its parent planet
    private boolean isTidalLocked;

    public NaturalSatellite(double mass,
                            String name,
                            double[] coordinates,
                            double distanceFromPlanet,
                            boolean isGeoStationary,
                            boolean isTidalLocked)
            throws IllegalAccessException {
        super(mass, name, coordinates);
        this.distanceFromPlanet = distanceFromPlanet;
        this.isGeoStationary = isGeoStationary;
        this.isTidalLocked = isTidalLocked;
    }

    @Override
    // Distance from planet must be greater than the planet's radius
    public boolean isGeoStationary() {
        if (distanceFromPlanet < calculateDiameter() / 2) {
            return false;
        }
        return isGeoStationary;
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
        return "Natural Satellite {" +
                "\n Name: " + getName() +
                "\n Mass: " + getMass() +
                "\n Distance from Planet: " + distanceFromPlanet +
                "\n Is Geo-Stationary: " + isGeoStationary +
                "\n Is Tidal Locked: " + isTidalLocked +
                "\n Coordinates: [" + getCoordinates(0) + ", " + getCoordinates(1) + ", " + getCoordinates(2) + "]" +
                "\n}";
    }

    public double getDistanceFromPlanet() {
        return distanceFromPlanet;
    }

    public void setDistanceFromPlanet(double distanceFromPlanet) {
        this.distanceFromPlanet = distanceFromPlanet;
    }

    public boolean isTidalLocked() {
        return isTidalLocked;
    }

    public void setTidalLocked(boolean tidalLocked) {
        isTidalLocked = tidalLocked;
    }

    public void setGeoStationary(boolean geoStationary) {
        isGeoStationary = geoStationary;
    }
}
