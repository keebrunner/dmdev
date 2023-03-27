package com.dmdev.week4.InheritancePolymorphism;

public class Star extends StarSystem {
    private String starType;
    private double temperature;

    public Star(double mass, String name, double[] coordinates, String starType, double temperature) throws IllegalAccessException {
        super(mass, name, coordinates);
        this.starType = starType;
        this.temperature = temperature;
    }

    @Override
    public double calculateDiameter() {
        return Math.pow((getMass() * 2) / (Math.PI * 10), 1 / 3.0);
    }

    @Override
    public String compareMass(StarSystem starSystem) {
        double difference = Math.abs(this.getMass() - starSystem.getMass());
        if (difference < 1e-10) {
            return "Masses are equal";
        } else if (this.getMass() > starSystem.getMass()) {
            return "The mass of " + getName() + " is greater than the mass of " + starSystem.getName() + " by " + difference + " kg";
        } else {
            return "The mass of " + starSystem.getName() + " is greater than the mass of " + getName() + " by " + difference + " kg";
        }
    }

    @Override
    public String toString() {
        return "Star {" +
                "\n Name: " + getName() +
                "\n Mass: " + getMass() + "\n" +
                "Star type: " + starType + "\n" +
                "Temperature: " + temperature + " K" +
                "\n Coordinates: [" + getCoordinates(0) + ", " + getCoordinates(1) + ", " + getCoordinates(2) + "]" +
                "\n}";
    }

    public String getStarType() {
        return starType;
    }

    public void setStarType(String starType) {
        this.starType = starType;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
