package cs.easel;

import junit.framework.TestCase;
import junit.framework.TestResult;

import cs.easel.DrawPanel;
import cs.easel.DrawTest;
import cs.easel.Launcher;

/**
 * Created by Devan on 4/1/2015.
 */
public class test {
    public class interpolTest extends TestCase {
        protected double x1;
        protected double x2;
        protected double mu;
        public void setUp() {
            x1 = 1;
            x2 = 1;
            mu = 1;
        }

        void runTest(TestResult result) {
            double res = cosineInterpolation(x1, x2, mu);
            assertEquals(res, 1);
        }

    }



    public double cosineInterpolation(double x1, double x2, double normal)
    {
        double ft = normal * 3.1415927;
        double f = (1 - Math.cos(ft)) * .5;
        return  x1 * (1 - f) + x2 * f;
    }
}
