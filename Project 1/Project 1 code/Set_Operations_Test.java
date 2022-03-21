import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Set_Operations_Test 
{
    public static void main(String args[])
    {
        Set_Operations test = new Set_Operations();
        Set<Integer> a = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> b = new HashSet<Integer>(Arrays.asList(2, 7, 8, 3, 6));
        System.out.print("Set a = " + a + "\tSet b = " + b + "\n"); //seems long but is the way to make the output more clean
        System.out.print("Union of a and b is " + test.union(a, b) + "\nIntersection of a and b is " + test.intersection(a, b)
        + "\nComplement a of b is " + test.compliment(a, b) + "\nComplement b of a is " + test.compliment2(a, b));
    }    
}
