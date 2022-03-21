import java.io.FileWriter;
import java.util.Random;
import java.io.BufferedWriter;

public class CSV_Writer 
{
    private FileWriter file;
    private BufferedWriter buff;
    Random r = new Random();
    int id;
    int number;

    public CSV_Writer()
    {
        try
        {
            file = new FileWriter("Example.csv");
        }
        catch(Exception e)
        {
            System.out.println("ERROR OCCURED: " + e.toString());
        }
    }

    public void outputSingleLine(int userInput)
    {
        buff = new BufferedWriter(file);

        try
        {
            buff.write(userInput);
            for(int i = 1; i <= userInput; i++)
            {
                id = i;
                number = r.nextInt(1000);
                buff.write(id + ", " + number + "\n");
            }
            buff.close();
        }

        catch(Exception e)
        {
            System.out.println("Write out error(or close error):" + e.toString());
        }
    }
}