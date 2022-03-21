import java.io.FileWriter;
import java.util.*;

import java.io.BufferedWriter;

public class CSV_Writer 
{
    private FileWriter file;
    private BufferedWriter buff;
    Random r = new Random();
    int id, number, saltNumber;
    double smooth_data;
    
    Set<Integer> smoothed  = new HashSet<Integer>();



    public CSV_Writer()
    {
        try
        {
            file = new FileWriter("Graph.csv"); //writes everything to a csv file to use in Excel
        }
        catch(Exception e)
        {
            System.out.println("ERROR OCCURED: " + e.toString());
        }
    }

    /*Below writes, salts, and smooths the graph of x^2. each type of results are written to their own column of data.
     The number integer will write x^2 all the way to the amount of times the user specifies. The saltNumber will take
     a number from the x^2 column and will add a number from -100 to 100 so the data is scrambled a bit. Once that is done
     smoothedNumber will add all of the salted numbers into an array list. It then takes the average of two numbers and
     displays it on the next column. The two numbers that are used moves down the salted column until the end. In the
     beginning, it displays the first salted data value again. */

    public void outputSingleLine(int userInput)
    {
        int upperBound = 100;
        int lowerBound = -100;
        buff = new BufferedWriter(file);
        List<Integer> smoothedNumber = new ArrayList<Integer>(smoothed);

        try
        {
            buff.write(userInput);
            for(int i = 0; i <= userInput; i++)
            {
                id = i;
                number = id * id;
                saltNumber = (id * id) + (r.nextInt(upperBound - lowerBound)+lowerBound);
                smoothedNumber.add(saltNumber);
                if(i == 0){
                    smooth_data = smoothedNumber.get(i);
                }
                else{
                    smooth_data = (smoothedNumber.get(i) + smoothedNumber.get(i -1))/2; 
                }
                buff.write(id + ", " + number);
                buff.write("," + saltNumber);
                buff.write("," + smooth_data + "\n");  
            }
            
                buff.close();
            }
        catch(Exception e)
        {
            System.out.println("Write out error(or close error):" + e.toString()); //Error in case anything goes wrong
        }
    }
}