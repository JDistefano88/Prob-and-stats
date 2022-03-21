import java.util.HashSet;
import java.util.Set;

public class Set_Operations 
{  
    public Set_Operations()
    {

    }

    public Set<Integer> union(Set<Integer> a, Set<Integer> b)
    {
      Set<Integer> aUnionB = new HashSet<>(a); 
      aUnionB.addAll(b); // adds all of the elements of b into a without copying them.
      return aUnionB;
    }

    public Set<Integer> intersection(Set<Integer> a, Set<Integer> b)
    {
        Set<Integer> aIntersectionU = new HashSet<>(a); // finds what is in both A and B and displays only the similar elements
        aIntersectionU.retainAll(b);
        return aIntersectionU;
    }

    public Set<Integer> compliment(Set<Integer> a, Set<Integer> b)
    {
        Set<Integer> aComplimentB = new HashSet<>(a);
        aComplimentB.removeAll(b); //removes all of the elements of B in set A
        return aComplimentB;
    }
    public Set<Integer> compliment2(Set<Integer> a, Set<Integer> b)
    {
        Set<Integer> bComplementA = new HashSet<>(b);
        bComplementA.removeAll(a); // removes all of the elements of A in set B
        return bComplementA;
    }
        
} 
