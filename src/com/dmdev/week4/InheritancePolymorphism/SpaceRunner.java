package com.dmdev.week4.InheritancePolymorphism;

import static com.dmdev.week4.InheritancePolymorphism.utils.SpaceUtils.calculateGravityForce;
import static com.dmdev.week4.InheritancePolymorphism.utils.SpaceUtils.isStar;

public class SpaceRunner {

    public SpaceRunner() throws IllegalAccessException {
    }

    public static void main(String[] args) throws IllegalAccessException {
        StarSystem Kepler186 = new Star(1.0773e+30, "Kepler186", new double[]{-115.4796965, -27.9015035, 4.9276284}, "G", 5074);
        System.out.println(Kepler186.toString());

        StarSystem Kepler186b = new Planet(3.92e24, "Kepler186b", new double[]{-115.4796965, -27.9015034, 4.9276284}, "CO2/N2/O2/Ar/H2O/CH4/Ne/Xe/O3", 0);
        System.out.println(Kepler186b.toString());

        StarSystem Kepler186c = new Planet(2.44e24, "Kepler186c", new double[]{-115.73534774, -28.04415599, 5.51102359}, "CO2/CH4/H2O/N2", 0);
        System.out.println(Kepler186c.toString());

        StarSystem Kepler186d = new Planet(3.89e24, "Kepler186d", new double[]{-115.4796965, -27.9015035, 4.9276284}, "H/He/N2/Ar/CO2/H2O", 2);
        System.out.println(Kepler186d.toString());

        StarSystem Kepler186dN1 = new NaturalSatellite(2.2e20, "Kepler-186d I", new double[]{-115.4796965, -27.9015035, -24997572.0723716}, 78000, true, true);
        System.out.println(Kepler186dN1.toString());

        StarSystem Kepler186dN2 = new NaturalSatellite(2.2e20, "Kepler-186d II", new double[]{-115.4796965, -27.9015035, 25000272.0723716}, 78000, true, true);
        System.out.println(Kepler186dN2.toString());

        StarSystem Kepler186e = new Planet(1.47e24, "Kepler186e", new double[]{-115.4796965, -27.9015033, 5.1584335}, "H2/He/CH4/NH3", 4);
        System.out.println(Kepler186e.toString());

        StarSystem Kepler186eN1 = new NaturalSatellite(1.8e20, "Kepler-186e I", new double[]{-115.4766, -27.8962, 5.1658}, 1500, true, false);
        System.out.println(Kepler186eN1.toString());

        StarSystem Kepler186eN2 = new NaturalSatellite(1.2e20, "Kepler-186e II", new double[]{-115.4757, -27.9009, 5.1649}, 900, false, true);
        System.out.println(Kepler186eN2.toString());

        StarSystem Kepler186eN3 = new NaturalSatellite(8.5e19, "Kepler-186e III", new double[]{-115.4805, -27.9019, 5.1581}, 600, true, true);
        System.out.println(Kepler186eN3.toString());

        StarSystem Kepler186eN4 = new NaturalSatellite(7.2e19, "Kepler-186e IV", new double[]{-115.4837, -27.9024, 5.1554}, 400, false, false);
        System.out.println(Kepler186eN4.toString());

        StarSystem Kepler186f = new Planet(1.68e24 * 1.4, "Kepler186f", new double[]{-115.4758, -27.9008, 5.4082}, "N2/O2/Ar/CO2/CH4/H2O", 5);
        System.out.println(Kepler186f.toString());

        StarSystem Kepler186fN1 = new NaturalSatellite(1.02588e+23, "Kepler-186f I", new double[]{-115.4758, -27.9008, 1361915.3047}, 5716, true, true);
        System.out.println(Kepler186fN1.toString());

        StarSystem Kepler186fA1 = new ArtificialSatellite(120e23, "Kepler-186f AI", new double[]{-115.4796, -27.9015, 5.2584}, true, true);
        System.out.println(Kepler186fA1.toString());

        StarSystem Kepler186fA2 = new ArtificialSatellite(150e23, "Kepler-186f AII", new double[]{-115.4796, -27.8015, 5.4584}, true, true);
        System.out.println(Kepler186fA2.toString());

        StarSystem Kepler186fA3 = new ArtificialSatellite(200e23, "Kepler-186f AIII", new double[]{-115.4796, -28.0015, 5.1584}, true, true);
        System.out.println(Kepler186fA3.toString());

        StarSystem Kepler186fA4 = new ArtificialSatellite(250e23, "Kepler-186f AIV", new double[]{-115.4796, -27.8515, 5.3084}, true, true);
        System.out.println(Kepler186fA4.toString());

        StarSystem Kepler186AST1 = new Asteroid(1e18, "Kepler186AST1", new double[]{-115.4696965, -27.9015035, 4.9276284}, "M-type", "Stony");
        System.out.println(Kepler186AST1.toString());

        StarSystem Kepler186AST2 = new Asteroid(1e18, "Kepler186AST2", new double[]{-115.4796965, -27.8815035, 4.9276284}, "M-type", "Stony");
        System.out.println(Kepler186AST2.toString());

        StarSystem Cybernova = new Comet(1.0e18, "Cybernova", new double[]{-138.5756358, 20.4638731, -14.2273062}, 76.0, 11.0);
        System.out.println(Cybernova.toString());

        StarSystem Circuitron = new Comet(2.0e19, "Circuitron", new double[]{-78.3837572, -76.26688, 19.082563}, 3.3, 4.0);
        System.out.println(Circuitron.toString());

        System.out.println(calculateGravityForce(Kepler186, Kepler186f));
        System.out.println(calculateGravityForce(Kepler186e, Kepler186AST1));
        System.out.println(calculateGravityForce(Kepler186d, Circuitron));
        System.out.println(calculateGravityForce(Kepler186f, Kepler186fA4));
        System.out.println(isStar(Cybernova));
    }
}

