public class CPF_tester {
    public static void main(String[] args) {
		Continuous_probability_functions test = new Continuous_probability_functions();
        //(a) and (b) are the bounds of the probability functions wher ethe term "y" falls
        //(c) and (d) is the interval of the distribution itself
        //cons represents the list of coefficients of a polynomial
        test.testProbDensFunc(1, 2, 0, 2, 0, 0, .375);
        
        test.testUniformDist(45, 55, 2, 55);
    }
}
