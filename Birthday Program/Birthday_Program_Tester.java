public class Birthday_Program_Tester 
{
    public static void main(String args[])
    {
        BirthdayProgram fun = new BirthdayProgram();

        for(int i = 0; i < 4; i++) // runs program 4 times to get a range of percentages for matching birthdays
        {
            fun.person(23, 10000); //(amount of people, amount of trials)
        }
    }
}