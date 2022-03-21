import java.util.*;
class mathamacialOperations
{
    public mathamacialOperations() 
    {

    }
     public double mean(int array[], int numCount)
     {
         int avg = 0;
         for (int i = 0; i < numCount; i++)
         {
            avg += array[i]; // Adds all of the numbers in the array up
         }   
         return (double)avg/(double)numCount; //Divides total number by number of values in the array
     }
     public double median(int array[], int numCount)
     {
        Arrays.sort(array); // Sorts the array by the smallest value to biggest value

         if(numCount % 2 != 0) // If the count of numbers can be evenly divided, then it will return the value half way down the arrray
         {
            return (double)array[numCount / 2];
         }
         else
         {
             return (double) (array[(numCount-1) / 2] + array[numCount / 2])/ 2; //If not, then the value of the number returned is half of ((numCount - 1) /2) 
         }                                                                       //plus the function in the if statement above.
     }
       public int mode(int array[], int numCount)
     {
         int maxCount = 0;
         int maxNumber = 0;
         
         for(int i = 0; i < numCount; i++)
         {
            int count = 0;
            for(int j = 0; j < numCount; j++)
            {
                if(array[j] == array[i])
                {
                    count++; // Checks if the value at one position is the same some where else.
                }            // If it is the same, then the count of numbers is raised
                
                if(count > maxCount)
                {
                    maxCount = count; //Whenever something beats the count of one number, that number position becomes the new maxCount
                    maxNumber = array[i]; //The number in that position that was detected the most is found by looking in the array.
                }
            }
         }
        return maxNumber;
     }
    public double standardDev(int array[], int numCount)
     {
        double mean = 0;
        for(int i = 0; i < numCount; i++)
        {
            mean = mean + array[i]; //Finds the mean of the values first
        }
        mean = mean / numCount;
        double sumOfValues = 0;
        for(int i = 0; i < numCount; i++)
        {
            double tempValues = Math.pow(mean - array[i],2); //Takes the mean and subtracts it by each number in the array and squares each one
            sumOfValues = sumOfValues + tempValues;
        }
        double result = Math.sqrt(sumOfValues / (numCount - 1)); //Returns the square root of the values above devided by one less then the amount of numbers
        return result;
     }

     public static void main(String args[])
    {
        int array[] = {2, 4, 5, 7, 3, 5, 2, 5, 9, 14};
        int numCount = array.length;
        mathamacialOperations ops = new mathamacialOperations();
        System.out.println("Mean = " + ops.mean(array,numCount) + " median = " 
        + ops.median(array,numCount) + " mode = " + ops.mode(array, numCount) + " Standard Deviation = " + ops.standardDev(array, numCount));
    }
 }