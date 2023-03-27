package com.dmdev.week4.InheritancePolymorphism.utils;

import com.dmdev.week4.InheritancePolymorphism.StarSystem;
import com.dmdev.week4.InheritancePolymorphism.Star;

public final class SpaceUtils {

    private SpaceUtils() {
    }

    public static String calculateGravityForce(StarSystem object1, StarSystem object2) {
        double G = Constants.GRAVITATIONAL_CONSTANT;
        double m1 = object1.getMass();
        double m2 = object2.getMass();
        double r = object1.calculateDistance(object2);
        double force = G * m1 * m2 / (r * r);
        String description = "The force of gravity between " + object1.getName() + " and "
                + object2.getName() + " is " + force + " N.";
        return description;
    }

    public static String isStar(StarSystem object) {
        String description;
        if (object instanceof Star) {
            description = object.getName() + " is a star.";
        } else {
            description = object.getName() + " is not a star.";
        }
        return description;
    }
}

