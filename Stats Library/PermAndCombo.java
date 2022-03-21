public class PermAndCombo{

    public PermAndCombo(){
        
    }
    public double factorial(int n){
        if( n == 1 || n == 0){
            return 1;
        }
        return (n * factorial(n-1));
    }

    /*Runs the permutation equation. It takes the factorial of n and divides it
    by the factorial of (n-r) */

    public double permutation(int n, int r){
        double per = factorial(n) / factorial(n-r); 
        return per;
    }

    /*Runs the combination equation. It takes the factorial of n and divides it by the
    factorial of r times the factoral of (n-r). */

    public double combination(int n , int r ){
        double combo = factorial(n) / (factorial(r) * factorial(n-r)); 
        return combo;
    }

    /*The binomial method will return the combination of integer n and integer r.
    It then mulitplies by p raised to r. From there it is muliplied again but now
    by q raised to the (n-y). */

    public double binomial(int n, int r, double p, double q){
        double bin = combination(n, r)*(Math.pow(p, r)*Math.pow(q, (n-r)));
        System.out.printf("binomial distribution = %.4f \n", bin);
        return bin; 
    }

    /*The geometric method will take q and raise it to the power of (y-1).
    Afterwards, it will be multiplied by p to get the final result.  */

    public double geometric(double q, double p, int r){
        double geo = Math.pow(q, (r-1))*p;
        System.out.printf("Geometric distribution = %.4f \n", geo);
        return geo;
    }

    /*The hypergeometric method takes 3 combinations and will multiply or divide them.
    The first combination of r and y is multiplied by the combination of (N-r) and (n-y).
     Once that is done, it is divided by the combination of N and n to get the final answer.*/

    public double hyperGeometric(int N, int n, int r, int y){
        double hyper = (combination(r, y)*combination((N-r),(n-r))) / combination(N, n);
        System.out.printf("HyperGeometric distribution = %.4f \n" , hyper);
        return hyper;
    }

    /*The poisson method will take the "a" value which represents lambda is raised to the 
    power of y. After, it is divided by y factorial. The answer of that is then multiplied
    by e to the power of negative lambda */

    public double poisson(int a, int y){
        double pDist = (Math.pow(a, y)*Math.pow(Math.E, -a)/ factorial(y));
        System.out.printf("Poisson distribution = %.4f \n" , pDist, "%");
        return pDist;
    }
    public static void main(String args[]){
        PermAndCombo pAndC = new PermAndCombo();
        int a = 2, N=20, n = 5, r = 4, y = 3; 
        double q = .2, p = .8;
        System.out.println("combination of " + n + " and " + r + " is " + pAndC.combination(n,r) + "\nPermutation of " + n + " and " + r + " is " + pAndC.permutation(n, r));
        pAndC.binomial(n, r, p, q); pAndC.geometric(q, p, r); pAndC.hyperGeometric(N, n, r, y); pAndC.poisson(a, y);
    }
}