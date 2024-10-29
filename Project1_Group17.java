import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class deneme
{
    public static void main(String[] args)
    {
        cls();
        String selection;
        Scanner input = new Scanner(System.in);
        while (true)
        {
            cls();
            greetingPage();
            printOptions();
            selection = input.nextLine();
            selection = selection.toUpperCase();
            while (!isValidEntry(selection, "A","B","C","D","E"))
            {
                cls();
                System.err.println("\n\n        INVALID ENTRY!!");
                printOptions();
                selection = input.nextLine();
                selection = selection.toUpperCase();
            }
            
            switch (selection)
            {
                case "A":
                    Objective1();
                    break;
                case "B":
                    break;
                case "C":
                    break;
                case "D":
                    break;
                case "E":
                    input.close();
                    exitPage();
                    return;
            }
        }
    }

    //  MAIN METHODS FOR HOMEPAGE
    public static void greetingPage()
    {
        System.out.println("         _       _         _                                   ");
        System.out.println("        ( )  _  ( )       (_ )                                 ");
        System.out.println("        | | ( ) | |   __   | |    ___    _     ___ ___     __  ");
        System.out.println("        | | | | | | /'__`\\ | |  /'___) /'_`\\ /' _ ` _ `\\ /'__`\\ ");
        System.out.println("        | (_/ \\_) |(  ___/ | | ( (___ ( (_) )| ( ) ( ) |(  ___/ ");
        System.out.println("        `\\_______/'`\\____)(___)`\\____)`\\___/'(_) (_) (_)`\\____) \n\n");
    }
    public static void printOptions()
    {
        System.out.println("        A)   Statistical Information about an array\n");
        System.out.println("        B)   Matrix Operations\n");
        System.out.println("        C)   Text Encryption/Decryption\n");
        System.out.println("        D)   Tic-tac-toe HotSeat\n");
        System.out.println("        E)   EXIT\n\n\n");
        System.out.print("        Please select an option from the list above(A-E)): ");
    }
    public static void printCrypOptions()
    {
        System.out.println("        A)   Encryption\n");
        System.out.println("        B)   Decryption\n");
        System.out.println("        C)   Return to the Main Menu\n");
        System.out.print("        Please select an option from the list above(A-C)): ");
    }
    public static boolean isValidEntry(String ans, String... Check )
    {
        // .equals method must be used. Because when we use ==, it compares the their memory references
        for(String c: Check)
        {
            if(c.equals(ans))
                return true;
        }
        return false;
    }
    public static void cls()
    {
        try
        {
            if (System.getProperty("os.name").contains("Windows")) // For Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            
            else // For Linux and MacOS
            {  
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex)
        {
            System.err.println("Error on cls!!!!");
        }
    }
    public static void returnHomePage()
    {
        cls();
        System.out.println("Returning to homepage");
        try
        {
            for(int i = 0; i < 3; i++)
            {
                System.out.println(".");
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Error! Returning Now");
        }
    }
    public static void loadingPage()
    {
        cls();
        try
        {
            for (int i = 0; i < 2; i++)
            {
                System.out.println("Loading");
                for(int j = 0; j < 3; j++)
                {
                    System.out.println(".");
                    Thread.sleep(400);
                }
                cls();
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Error! Returning Now");
        }
    }
    public static void exitPage()
    {
        cls();
        System.out.println("Exiting from the program");
        try
        {
            for(int i = 0; i < 3; i++)
            {
                System.out.println(".");
                Thread.sleep(500);
            }
            System.out.println("\n\nEXIT! SEE YOU NEXT TIME\n");
        }
        catch (InterruptedException e)
        {
            System.out.println("Error! Returning Now");
        }
    }
    public static int strToInt(String s)
    {
        int ans = 0;
        int mult = 1;
        int size = s.length();
        for(int i = size-1; i >= 0; i--)
        {
            char c = s.charAt(i);
            ans += (c - '0') * mult;
            mult *= 10;
        }
        return ans;
    }
    public static boolean isValidDouble(String input)
    {
        try
        {
            Double.parseDouble(input);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false; // If conversion fails, return false
        }
    }
    // The function for either returning the main page or redo the objective
    public static boolean loopAsk()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\nPRESS \"1\", to go back\n\nPRESS \"2\", to do the operation again");
        System.out.print("Your choice (1 or 2): ");
        String case1Loop = scan.nextLine();
        while (!isValidEntry(case1Loop, "1", "2"))
        {
            cls();
            System.err.println("\n        INVALID ENTRY!!");
            System.out.println("\n\n\nPRESS \"1\", to go back\n\nPRESS \"2\", to do the operation again\n");
            System.out.print("Your choice (1 or 2): ");
            case1Loop = scan.nextLine();
        }
        if (case1Loop.equals("2"))
            return true;
        return false;
    }
    // ----------------------------------------------------------------------------------------
    // OBJECTIVE 1 MAIN METHOD
    // Contains information about the objective and main menu of the objective 1 UI
    // Directs the user to corresponding methods according to their input
    public static void Objective1()
    {
        cls();
        Scanner scanA = new Scanner(System.in);
        System.out.println("Objective 1");
        System.out.println("------------");
        System.out.println("-> In this objective, you need to create an array that contains double variables");
        System.out.println("-> The program would provide you the following information about your array");
        System.out.println("-> Median, Arithmetic mean, Geometric mean, and Harmonic mean\n");
        System.out.println("IMPORTANT NOTES");
        System.out.println("----------------");
        System.out.println("*  The median of even-length array is calculated by taking the average of the middle two elements\n");
        System.out.println("*  The values that are '<= 0' are ignored while calculating the geometric mean of the array\n\n\n");

        
        double arr[] = fillArray();
        callMethodsForObj1(arr);

        if (loopAsk())
        {
            loadingPage();
            Objective1();
        }
        else
            returnHomePage();
    } 
    
    // This method calls all the methods for the first objective
    public static void callMethodsForObj1(double arr[])
    {
        cls();
        printArray(arr);
        System.out.printf("Median of your array:            %f\n\n", median(arr, arr.length));
        System.out.printf("Arithmetic mean of your array:   %f\n\n", arithmeticMean(arr, arr.length));
        System.out.printf("Geometric mean of your array:    %f\n\n", geometricMean(arr, arr.length));
        System.out.printf("Harmonic mean of your array:     %f\n\n", harmonicMean(arr, arr.length));
    }

    // This method returns an array that the user will create
    public static double[] fillArray()
    {
        cls();

        // ! this method must take an integer input for array's size, between 1-10
        // ! then asks user to fill each element with valid double values
    }
    
    // This method takes an array as input and prints it
    public static void printArray(double arr[])
    {
        int size = arr.length;
        if (size <= 0)
            return;
        System.out.printf("Your array is -> [%.3f", arr[0]);
        for (int i = 1; i < size; i++)
            System.out.printf("   %.3f", arr[i]);
        
        System.out.println("]\n\n");
    }

    // This method takes an array and its size as input, returns the median of the array
    // The array is first sorted, then the mean is selected based on the size of the array
    // O(logn) space complexity and O(n logn) time complexity. n=number of elements in the array
    public static double median(double arr[], int size)
    {
        Arrays.sort(arr);
        // if the array size is even, take the average of the middle two value
        if (size % 2 == 0)
            return (arr[size/2] + arr[(size/2) - 1]) / 2.0;
        return arr[size/2];
    }


    // This method takes an array and its size as input, returns the arithmetic mean (average) of the array
    // With an array of size n, the formula of the arithmetic mean is: (a1 + a2 + ... + an) / n
    // O(n) time complexity. n=size of the array
    public static double arithmeticMean(double arr[], int size)
    {
        double aritMean = 0;
        for (double i : arr)
            aritMean += i;

        return aritMean / (double)size;
    }


    // This method takes an array and its size as input, returns the geometric mean of the array.
    // With an array of size n, the formula of the geometric mean is: pow((a1 * a2 * ... * an), 1/n)
    // O(n) time complexity. n=size of the array
    public static double geometricMean(double arr[], int size)
    {
        double geoMean = 1;
        double count = (double)size;
        for (double i : arr)
        {
            // if there are any elements equal to zero, ignores them
            if (i <= 0.0)
            {
                count -= 1.0;
                continue;
            }
            geoMean *= i;
        }
        return Math.pow(geoMean, 1.0/count);
    }


    // This method takes and array and its size as input, returns the harmonic mean of the array by using recursive harmonicSummation method in the summation process
    // With an array of size n, the formula of the harmonic mean is: n / [(1/a1) + (1/a2) + ... + (1/an)]
    // O(n) time complexity and O(n) space complexity. n=size of the array
    public static double harmonicMean(double arr[], int size)
    {
        return (double)size / harmonicSummation(arr, size-1);
    }

    // This method is a recursive approach for harmonic summation step of the harmonic mean calculation
    // Takes an array and an index as input and calculates the harmonic summation recursively until it reaches the first element of the array.
    public static double harmonicSummation(double arr[], int index)
    {
        if (index == 0)
            return 1.0 / arr[index];
        
        return 1.0/arr[index] + harmonicSummation(arr, index-1);
    }
}
