import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Project1_Group17
{
    private static final Scanner scanner = new Scanner(System.in);
    private static double[] Objective1Product;
    public static void main(String[] args)
    {
        cls();
        String selection;
        while (true)
        {
            cls();
            greetingPage();
            printOptions();
            selection = scanner.nextLine();
            selection = selection.toUpperCase();
            while (!isValidEntry(selection, "A","B","C","D","E"))
            {
                cls();
                System.err.println("\n\n        INVALID ENTRY!!");
                printOptions();
                selection = scanner.nextLine();
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
                    scanner.close();
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
        System.out.println("\n\n\nPRESS \"1\", to go back\n\nPRESS \"2\", to do the operation again");
        System.out.print("Your choice (1 or 2): ");
        String case1Loop = scanner.nextLine();
        while (!isValidEntry(case1Loop, "1", "2"))
        {
            cls();
            System.err.println("\n        INVALID ENTRY!!");
            System.out.println("\n\n\nPRESS \"1\", to go back\n\nPRESS \"2\", to do the operation again\n");
            System.out.print("Your choice (1 or 2): ");
            case1Loop = scanner.nextLine();
        }
        if (case1Loop.equals("2"))
            return true;
        return false;
    }
    public static void beklermisin()
    {
        // 3 saniye bekle, sonra ekranı temizle
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interruption cut: " + e.getMessage());
            Thread.currentThread().interrupt();  // İş parçacığının kesildiğini bildirir
        }
        cls();
    }
    // ----------------------------------------------------------------------------------------
    // OBJECTIVE 1 MAIN METHOD
    // Contains information about the objective and main menu of the objective 1 UI
    // Directs the user to corresponding methods according to their input
    public static void Objective1()
    {
        cls();
        double arr[] = fillArray();
        callMethodsForObj1(arr);
        
        interfaceChange("1", null);
        
    } 
    
    // This method calls all the methods for the first objective
    public static void callMethodsForObj1(double arr[])
    {
        cls();
        printArray(arr);
        //ObjectiveProduct[0][0] = ;
        System.out.printf("Median of your array:            %f\n\n", median(arr, arr.length));
        System.out.printf("Arithmetic mean of your array:   %f\n\n", arithmeticMean(arr, arr.length));
        try
        {
            System.out.printf("Geometric mean of your array:    %f\n\n", geometricMean(arr, arr.length));
        }
        catch(IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
        }
        try
        {
            System.out.printf("Harmonic mean of your array:     %f\n\n", harmonicMean(arr, arr.length));
        }
        catch(IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
        }
    }

    // This method returns an array that the user will create
    public static double[] fillArray()
    {
        int size = getSize();
        double array[] = new double[size];
        
        for (int i = 0; i < size; i++)
        {
            boolean flag = true;
            while(flag)
            {
                double val = 0.0;
                try
                {
                    cls();
                    printArray(array);
                    System.out.printf("Please enter a number for %d. element in the array\n\n", i+1);
                    System.out.print("Enter a double (max 8 digits before the decimal): ");
                    val = scanner.nextDouble();
                    //to clear the buffer after nextDouble() since it only reads the next token and leaves an empty line for the next scan
                    scanner.nextLine(); 

                    // java automatically sets the number as +/- infinity if it over/underflows. So we check if the number is finite or not
                    // also we check if the number has more than 8 digits before the decimal part.
                    if(!Double.isFinite(val) || Math.abs(val) >= Math.pow(10, 8))
                    {
                        throw new RuntimeException("!NUMBER IS NOT IN THE RANGE!");
                    }
                    else if(val <= 0.0)
                    {
                        throw new IllegalArgumentException("You have entered a negative value. If you continue, the value will be ignored while calculating the geometric and the harmonic mean!");
                    }
                    
                    array[i] = val;
                    flag = false;
                    
                }
                catch (IllegalArgumentException e)
                {
                    cls();
                    double invalidVal = val; // store the old value
                    String choice ="s";
                    System.err.print(e.getMessage());
                    System.out.println("\n\nTo change the value, PRESS 1\nTo continue, PRESS 2\n\n\nYour choice (1 or 2): ");
                    choice = scanner.nextLine();

                    while (!isValidEntry(choice, "1", "2"))
                    {
                        cls();
                        System.err.println("INVALID ENTRY!!");
                        System.out.println("\n\nTo change the value, PRESS 1\nTo continue, PRESS 2\n\n\nYour choice (1 or 2): ");
                        choice = scanner.nextLine();
                    }

                    if (choice.equals("2"))
                    {
                        array[i] = invalidVal; // Assign the invalid value
                        flag = false;
                    }  
                }
                catch(InputMismatchException e) //NumberFormatException
                {
                    System.err.println("\nINVALID ENTRY! Select a double please!");
                    scanner.nextLine();
                    beklermisin();
                }
                catch(RuntimeException e)
                {
                    System.err.println(e.getMessage());
                    beklermisin();
                }
            }
        }

        return array;
    }
    
    public static int getSize()
    {
        cls();
        System.out.println("Objective 1");
        System.out.println("------------");
        System.out.println("-> In this objective, you need to create an array that contains double variables");
        System.out.println("-> The program would provide you the following information about your array");
        System.out.println("-> Median, Arithmetic mean, Geometric mean, and Harmonic mean\n");
        System.out.println("IMPORTANT NOTES");
        System.out.println("----------------");
        System.out.println("*  The median of even-length array is calculated by taking the average of the middle two elements\n");
        System.out.println("*  The values that are '<= 0' are ignored while calculating the geometric mean and harmonic mean of the array\n\n\n");
        
        System.out.print("Please enter your array's size between 1-10: ");

        String ans = scanner.nextLine();
        while (!isValidEntry(ans, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"))
        {
            cls();
            System.err.println("INVALID ENTRY!!");
            System.out.print("Please enter your array's size between 1-10: ");
            ans = scanner.nextLine();
        }
        return strToInt(ans);
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
        int count = 0;   // positive number counter
        for (double d : arr)
        {
            // if there are any elements equal to zero, ignores them
            if (d <= 0.0)
                continue;

            count++;
            geoMean *= d;
        }

        if (count == 0)
            throw new IllegalArgumentException("Cannot calculate geometric mean without any positive number inside the array");

        return Math.pow(geoMean, 1.0/(double)count);
    }


    // This method takes and array and its size as input, returns the harmonic mean of the array by using recursive harmonicSummation method in the summation process
    // With an array of size n, the formula of the harmonic mean is: n / [(1/a1) + (1/a2) + ... + (1/an)]
    // O(n) time complexity and O(n) space complexity. n=size of the array
    public static double harmonicMean(double arr[], int size)
    {
        // count how many numbers are greater than 0 (valid for harmonic mean calculation)
        int count = 0;
        for(double d: arr)
        {
            if (d > 0)
                count++;
        }
        if (count == 0)
            throw new IllegalArgumentException("Cannot calculate harmonic mean without any positive number inside the array");
        return (double)size / harmonicSummation(arr, size-1);
    }

    // This method is a recursive approach for harmonic summation step of the harmonic mean calculation
    // Takes an array and an index as input and calculates the harmonic summation recursively until it reaches the first element of the array.
    public static double harmonicSummation(double arr[], int index)
    {
        if (index == 0)
            return 1.0 / arr[index];
        
        // If the current value is <= 0, ignore it. If valid, continue normally
        double sum = (arr[index] <= 0) ? 0.0 : 1.0/arr[index];
        
        return sum + harmonicSummation(arr, index-1);
    }
     //the method that is able to change between interfaces and operations
     public static void interfaceChange(String Objective, String Operation)
     {
        
         if(loopAsk())
         {
             loadingPage();
             Objective1();
         }
         else
         {
             returnHomePage();
         }
     }
 
     //set of objectives
     public static void objectiveChosen(String Objective)
     {
         switch (Objective)
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
                     scanner.close();
                     exitPage();
                     return;
             }
     }
 
     //checks if there is any overflow or underflow
     //since double type doesn't throw ArithmethicException, we have to check every possible overflowable value with isInfinite
     //Underflow value is generally 0.0 so we use that condition to detect underflow
     public static void overUnderFlow(double value)
     {
         if(Double.isInfinite(value))
         {
             System.out.println("Overflow occurred in element multiplication! Try with different values.");
             interfaceChange("1", null);
         }
         else if(value == 0.0)
         {
             System.out.println("Underflow occurred in element multiplication! Try with different values.");
             interfaceChange("1", null);
         }
     }
}