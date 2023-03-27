package com.dmdev.week4.InheritancePolymorphism;

import static com.dmdev.week4.InheritancePolymorphism.utils.Constants.DIAMETER_COEFFICIENT;

public class Comet extends StarSystem {
    private double orbitPeriod;
    private double nucleusSize;

    public Comet(double mass, String name, double[] coordinates, double orbitPeriod, double nucleusSize) throws IllegalAccessException {
        super(mass, name, coordinates);
        this.orbitPeriod = orbitPeriod;
        this.nucleusSize = nucleusSize;
    }

    @Override
    public double calculateDiameter() {
        return Math.pow((getMass() * 3) / DIAMETER_COEFFICIENT, 1 / 3.0) * 2;
    }

    @Override
    public String compareMass(StarSystem starSystem) {
        double difference = Math.abs(this.getMass() - starSystem.getMass());
        if (this.getMass() < starSystem.getMass()) {
            return "Mass of the current object is less than that of " + starSystem.getName() + " by " + difference + " kg";
        } else if (this.getMass() > starSystem.getMass()) {
            return "Mass of the current object is greater than that of " + starSystem.getName() + " by " + difference + " kg";
        } else {
            return "Mass of the current object is equal to the mass of " + starSystem.getName();
        }
    }

    public double getOrbitPeriod() {
        return orbitPeriod;
    }

    public void setOrbitPeriod(double orbitPeriod) {
        this.orbitPeriod = orbitPeriod;
    }

    public double getNucleusSize() {
        return nucleusSize;
    }

    public void setNucleusSize(double nucleusSize) {
        this.nucleusSize = nucleusSize;
    }

    @Override
    public String toString() {
        return "Comet {" +
                "\n Name: " + getName() +
                "\n Mass: " + getMass() +
                "\n Orbit Period: " + orbitPeriod + " years" +
                "\n Nucleus Size: " + nucleusSize + " km" +
                "\n Coordinates: [" + getCoordinates(0) + ", " + getCoordinates(1) + ", " + getCoordinates(2) + "]" +
                "\n}";
    }
}