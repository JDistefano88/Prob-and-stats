public class PermAndCombo
{
    public PermAndCombo()
    {
        
    }
    public int factorial(int n)
    {
        int f = 1;
        int i = 1;
        while(i <=n)
        {
            f *= i; // multiply f by an increasing amount until it hits "n"
            i++;
        }
        return f;
    }

    public int permutation(int n, int r)
    {
        int per = factorial(n) / factorial(n-r); //Runs the permutation equation
        return per;

    }

    public int combination(int n , int r )
    {
        int combo = factorial(n) / (factorial(r) * factorial(n-r)); //Runs the combination equation
        return combo;
    }
    public static void main(String args[])
    {
        PermAndCombo pAndC = new PermAndCombo();
        int n = 6, r = 4;
        System.out.println("Permutatiion of " + n + " and " + r + " is " + pAndC.permutation(n, r));
        System.out.println("combination of " + n + " and " + r + " is " + pAndC.combination(n,r));
    }
}