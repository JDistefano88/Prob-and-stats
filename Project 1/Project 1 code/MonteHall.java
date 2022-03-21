import java.util.Random;
public class MonteHall
{
    double firstChoice = 0;
    double switchChoice = 0;

    Random ran = new Random();
    {
        for(int i = 0; i < 10000; i++)
        {
            int[] curtans = {0,0,0};
            curtans[ran.nextInt(3)] = 1; //randomly places the winner behind one door each time the game is played

            int choice = ran.nextInt(3); //choice is random each time
            int revealed;

            do
            {
                revealed = ran.nextInt(3);
            }
            while(curtans[revealed] == 1 || revealed == choice); /*if the revealed door is the correct one and the user picked it, count it as a win. 
                                                                   Otherwise dont count it as a win and user switches choices */

            firstChoice += curtans[choice];
            switchChoice += curtans[3 - choice - revealed];
        }
    }
}
