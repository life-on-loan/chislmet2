package org.example;

public class GaussSolver {
    public double[] countOmegaRoots () {
        // x^3 -1.5x^2+0.6x-0.05=(2x-1)(10x^2-10x+1)
        double x0 = (10.0-Math.sqrt(100.0-4.0*10*1))/(2*10.0);
        double x1 = 1.0/2.0;
        double x2 = (10.0+Math.sqrt(100.0-4.0*10*1))/(2*10.0);
        return new double[]{x0,x1,x2};
    }

    public double[] countIntegralCoefficients () {
        double a = 5.0/18.0;
        double b = 4.0/9.0;
        double c = 5.0/18.0;
        return new double[]{a,b,c};
    }

    public double[] countFk (double[] roots) {
        double f0 = function(roots[0]);
        double f1 = function(roots[1]);
        double f2 = function(roots[2]);
        return new double[]{f0,f1,f2};
    }

    public double countIntegral (double[] functions, double[] coefficients) {
        double sum = 0;
        for (int i = 0; i < functions.length; i++) {
            sum += coefficients[i]*functions[i];
        }
        return sum;
    }

    private double function (double x) {
        return Math.pow(Math.E, Math.pow(x, 3)/3.0);
    }

    public double inaccuracy () {
        double M2n2 = 18369*Math.pow(Math.E,1/3.0);
        return M2n2/(40320.0 * 2800.0);
    }
}
