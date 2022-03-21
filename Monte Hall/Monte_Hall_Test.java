public class Monte_Hall_Test
{
    public static void main(String[] args)
    {
        MonteHall gameshow = new MonteHall();

        System.out.println("The win percentage if a person stays with their first choice is  " +  (gameshow.firstChoice / 10000) * 100  + "%");
        System.out.println("The win percentage if a person changes their choice is " + gameshow.switchChoice / 10000 * 100 + "%");
    }
}