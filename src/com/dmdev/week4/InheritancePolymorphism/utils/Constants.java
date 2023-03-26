package com.dmdev.week4.InheritancePolymorphism.utils;

public enum Constants {
    ;
    public static final double GRAVITATIONAL_CONSTANT = 6.6743e-11;
    public static final double DIAMETER_COEFFICIENT = Math.pow(4 * Math.PI, 1 / 3.0);
    /*// Minimum mass of a star in kilograms. (0.08 mass of Solar)
    public static final double MIN_STAR_MASS = 1.5912e+29;*/

    private final double value;

    Constants(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
