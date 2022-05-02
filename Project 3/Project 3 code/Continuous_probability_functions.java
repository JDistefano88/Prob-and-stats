//This code was made with help with Joey DiLizza
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

public class Continuous_probability_functions {
    /**
	 * Calculates the probability of a random variable falling between the intervals [a,b]
	 * Creates a polynomial function using the terms in the c array
	 * Integrates the function at the bounds using Simpson's Rule
	 * @param a lower bound of the interval
	 * @param b upper bound of the interval
	 * @param c an array holding the terms of a polynomial ie. [0] = constant [1] = x [2] = x^2 ...
	 * @return probability
	 */
	public double probDensFunc(double a, double b, double... c ) {
		return probDensFuncArray(a, b, c);
	}
	
	public double probDensFuncArray(double a, double b, double[] c ) {
		PolynomialFunction f = new PolynomialFunction(c);
		SimpsonIntegrator simp = new SimpsonIntegrator();
		return simp.integrate(100, f, a, b);
	}
	
	public void testProbDensFunc(double a, double b, double c, double d, double... cons) {
		System.out.println("Density Functions Probability:");
		System.out.println("P(1 < Y < 2) = " + probDensFunc(a, b, cons));
		System.out.println("E(Y): " + expecVProbDensFuncArray(c, d, cons));
		System.out.println("V(Y): " + varianceProbDensFuncArray(c, d, cons) + "\n");
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public double expecVProbDensFunc(double a, double b, double... c) {
		return expecVProbDensFuncArray(a, b, c);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public double expecVProbDensFuncArray(double a, double b, double[] c) {
		PolynomialFunction f = new PolynomialFunction(funcTimesY(c));
		SimpsonIntegrator simp = new SimpsonIntegrator();
		return simp.integrate(100000, f, a, b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public double varianceProbDensFunc(double a, double b, double... c) {
		PolynomialFunction f = new PolynomialFunction(funcTimesY(c));
		// g(y) = f(y^2)
		PolynomialFunction g = new PolynomialFunction(funcTimesYArray(f.getCoefficients()));
		
		SimpsonIntegrator simp = new SimpsonIntegrator();
		
		// V(Y) = E(Y^2) - E(Y)^2
		return simp.integrate(1000, g, a, b) - Math.pow(simp.integrate(1000, f, a, b), 2);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public double varianceProbDensFuncArray(double a, double b, double[] c) {
		PolynomialFunction pFunct = new PolynomialFunction(funcTimesY(c));
		// gFunct(y) = pFunct(y^2)
		PolynomialFunction gFunct = new PolynomialFunction(funcTimesYArray(pFunct.getCoefficients()));
		
		SimpsonIntegrator simp = new SimpsonIntegrator();
		
		// V(Y) = E(Y^2) - E(Y)^2
		return simp.integrate(1000, gFunct, a, b) - Math.pow(simp.integrate(1000, pFunct, a, b), 2);
	}
	
	/**
	 * funcTimesYArray with parameterized list 
	 * a PolynomialFunction.
	 * @param c coefficient array
	 * @return returns an array representing a coefficient array of yf(y)
	 */
	private double[] funcTimesY(double... c) {
		return funcTimesYArray(c);

	}
	
	/**
	 * This function performs the same as funcTimesY() but takes an array and takes the coefficient array from 
	 * a PolynomialFunction.
	 * @param c coefficient array
	 * @return returns an array representing a coefficient array of yf(y)
	 */
	private double[] funcTimesYArray(double[] c) {
		double[] newFunc = new double[c.length+2];
		for(int i = 0; i < c.length; i++) {
			if (c[i] == 0) {
				newFunc[i] = 0;
			} else {
				newFunc[i+1] = c[i];
			}			
		}
		return newFunc;
	}
	
	/**
	 * Finds the probability that a random variable will fall between the interval [c,d] in a uniform dist.
	 * @param a lower bound of the density function
	 * @param b upper bound of the density function
	 * @param c lower bound of the probability interval
	 * @param d upper bound of the probability interval
	 * @return probability that a random variable falls between [c,d]
	 */
	public double UniformDist(double c, double d, double a, double b) {
		double[] coef = new double[1];
		coef[0] = 1 / (b - a);
		PolynomialFunction f = new PolynomialFunction(coef);
		SimpsonIntegrator simp = new SimpsonIntegrator();
		
		return simp.integrate(1000, f, c, d);
	}
	
	/**
	 * Calculates the expected value in a uniform distribution
	 * @param a lower bound 
	 * @param b upper bound
	 * @return E(Y)
	 */
	public double expecVaUniformDist(double a, double b) {
		return (a + b) / 2;
	}
	
	/**
	 * Calculates the variance in a uniform distribution
	 * @param a lower bound
	 * @param b upper bound
	 * @return V(Y)
	 */
	public double variUniformDist(double a, double b) {
		return Math.pow((b - a), 2) / 12;
	}
	
	public void testUniformDist(double c, double d, double a, double b) {
		System.out.println("Uniform Dist: " + UniformDist(c, d, a, b));
		System.out.println("E(Y): " + expecVaUniformDist(a, b));
		System.out.println("V(Y): " + variUniformDist(a, b) + "\n");
	}

    public void runAllDiscreteDist() {
		System.out.println();
	}
	
	public void runAllContinuous(double a, double b, double c, double d, double...cons) {
		testProbDensFunc(a, b, c, d, cons);
		testUniformDist(a, b, c, d);
	}
}
