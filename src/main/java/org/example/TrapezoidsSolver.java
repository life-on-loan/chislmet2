package org.example;

public class TrapezoidsSolver {
    public double CompositeTrapezoidFormula (double h, double a, double b) {
        int n = (int) ((b - a) / h);
        double answer = 0;
        double xi = 0;
        double xi1 = xi + h;
        for (int i = 0; i < n; i++) {
            double fxi = function(xi);
            double fxi1 = function(xi1);
            answer += (fxi + fxi1) * h / 2.0;
            xi = xi1;
            xi1 = xi + h;
        }
        return answer;
    }

    private double function (double x) {
        return Math.pow(Math.E, Math.pow(x, 3)/3.0);
    }
    public Double inaccuracy (double fn, double fn2) {
        return Math.abs(fn2 - fn)/3.0;
    }
}
