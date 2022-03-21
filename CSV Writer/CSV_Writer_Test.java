import java.io.IOException;

public class CSV_Writer_Test
{
    public static void main(String args[]) throws IOException
    {
        CSV_Writer test = new CSV_Writer();
        int times = 100;
        test.outputSingleLine(times);
    }
}