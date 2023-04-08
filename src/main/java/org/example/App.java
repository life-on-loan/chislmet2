package org.example;

import java.math.BigDecimal;


public class App 
{
    public static void main( String[] args )
    {
        double h1 = 0.1;
        double h2 = 0.05;
        double h3 = 0.025;
        double a = 0;
        double b = 1;
        TrapezoidsSolver tSolver = new TrapezoidsSolver();
        double tAns1 = tSolver.CompositeTrapezoidFormula(h1, a, b);
        double tAns11 = tSolver.CompositeTrapezoidFormula(h1 * 2, a, b);
        double tAns2 = tSolver.CompositeTrapezoidFormula(h2, a, b);
        double tAns22 = tSolver.CompositeTrapezoidFormula(h2 * 2, a, b);
        double tAns3 = tSolver.CompositeTrapezoidFormula(h3, a, b);
        double tAns33 = tSolver.CompositeTrapezoidFormula(h3 * 2, a, b);
        Double tInac1 = tSolver.inaccuracy(tAns1, tAns11);
        Double tInac2 = tSolver.inaccuracy(tAns2, tAns22);
        Double tInac3 = tSolver.inaccuracy(tAns3, tAns33);
        System.out.println("Составная формула трапеций");
        System.out.println("h = " + h1 + "      answer = " + tAns1 + "   inac = " + new BigDecimal(tInac1).toPlainString());
        System.out.println("h = " + h2 + "     answer = " + tAns2 + "   inac = " + new BigDecimal(tInac2).toPlainString());
        System.out.println("h = " + h3 + "    answer = " + tAns3 + "   inac = " + new BigDecimal(tInac3).toPlainString());

        GregorySolver gSolver = new GregorySolver();
        double gAns1 = gSolver.GregoryFormula(h1, a, b);
        double gAns11 = gSolver.GregoryFormula(h1 * 2, a, b);
        double gAns2 = gSolver.GregoryFormula(h2, a, b);
        double gAns22 = gSolver.GregoryFormula(h2 * 2, a, b);
        double gAns3 = gSolver.GregoryFormula(h3, a, b);
        double gAns33 = gSolver.GregoryFormula(h3 * 2, a, b);
        double gInac1 = gSolver.inaccuracy(gAns1, gAns11);
        double gInac2 = gSolver.inaccuracy(gAns2, gAns22);
        double gInac3 = gSolver.inaccuracy(gAns3, gAns33);
        System.out.println("Формула Грегори");
        System.out.println("h = " + h1 + "      answer = " + gAns1 + "   inac = " + new BigDecimal(gInac1).toPlainString());
        System.out.println("h = " + h2 + "     answer = " + gAns2 + "   inac = " + new BigDecimal(gInac2).toPlainString());
        System.out.println("h = " + h3 + "    answer = " + gAns3 + "    inac = " + new BigDecimal(gInac3).toPlainString());

        GaussSolver gaussSolver = new GaussSolver();
        double[] xi = gaussSolver.countOmegaRoots();
        double[] Ak = gaussSolver.countIntegralCoefficients();
        double[] fi = gaussSolver.countFk(xi);
        double ans = gaussSolver.countIntegral(fi, Ak);
        System.out.println("Формула Гаусса");
        System.out.println("answer = " + ans);
        double inac = gaussSolver.inaccuracy();
        System.out.println("inac = " + new BigDecimal(inac).toPlainString());
    }
}
