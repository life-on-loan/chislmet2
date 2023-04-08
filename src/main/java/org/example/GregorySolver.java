package org.example;

public class GregorySolver {
    public double GregoryFormula(double h, double a, double b) {
        int n = (int) ((b - a) / h);
        double answer = 0;
        double xi = 0.0;
        double xi1 = xi + h;
        for (int i = 0; i < n; i++) {
            double fxi = function(xi);
            double fxi1 = function(xi1);
            answer += (fxi + fxi1) * h / 2.0;
            xi = xi1;
            xi1 = xi + h;
        }
        double fx0 = function(a);
        double fx1 = function(a + h);
        double fx2 = function(a + 2 * h);
        double fxn = function(b);
        double fxn1 = function(b - h);
        double fxn2 = function(b - 2 * h);
        answer += h * h / 12.0 * ((-3.0 * fx0 + 4.0 * fx1 - fx2 + 3.0 * fxn - 4.0 * fxn1 + fxn2) / (2.0 * h));
        return answer;
    }

    private double function(double x) {
        return Math.pow(Math.E, Math.pow(x, 3) / 3);
    }

    public double inaccuracy(double fn, double fn2) {
        return Math.abs(fn2 - fn) / 15.0;
    }
}
