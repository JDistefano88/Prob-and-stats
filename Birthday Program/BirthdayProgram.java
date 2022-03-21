import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;

public class BirthdayProgram
{
    private Random random = new Random();
    private final int days = 365;
    
    public BirthdayProgram()
    {

    }
    
    public void person(int birthdayNum, int trialNum)
    {
        int successNum = 0; // keeps track of successfull matches

        for(int i = 0; i < trialNum; i++)//makes the amount of arrays according to number of trials
        {
            ArrayList<Integer> birthdayList = randomBirthday(birthdayNum);

            if(duplicateFound(birthdayList))
            {
                successNum++; // goes thorugh those arrays and sees if any matching birthdays and will add to count if they do match
            }
        }

        printStats(successNum, trialNum, birthdayNum);
    }

    private ArrayList<Integer> randomBirthday(int birthdayNum) //generates the random arrays of birthdays 
    {
        ArrayList<Integer> birthdays = new ArrayList<>();

        for(int i = 0; i < birthdayNum; i++)
        {
            birthdays.add(random.nextInt(days) + 1); //picks one day to be the birthday for everyone in the trial
        }

        return birthdays;
    }

    private boolean duplicateFound(ArrayList<Integer> birthdayList)
    {
        return !birthdayList.stream().allMatch(new HashSet<>()::add); //generates a hashSet by going thorugh the arrays and looking for duplicate birthdays. 
    }                                                                 //It will stop when it finds a duplicate. Since HashMaps cannot have duplicate items in them,
                                                                      //the method will return true because of the "!" inverting the boolean expression.  

    private void printStats(int successNum, int trialNum, int birthdayNum)
    {
        System.out.print("Out of " + trialNum + " trials with " + birthdayNum + " people, " +(successNum * 100.f) / trialNum + "% had matching birthdays.\n");
    }
}