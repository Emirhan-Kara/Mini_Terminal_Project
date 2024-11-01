import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * The class for the project 1
 * Group-17
 * This class contains array statical information, matrix operations, encryption/decryption, and a tic-tac-toe game 
 * @author Emirhan, Hayrunnisa, Murat, Mohammad Zaid, Metehan
 */
public class Group17
{
    private static final Scanner scanner = new Scanner(System.in);      // scanner for the whole program
    private static double[][] Objective2Product;                        // matrix that is used to store the product matrix from the operations
    private static String rememberProduct = "N";                        // Indicates whether the product matrix should be used ("Y" for yes, "N" for no)
    
    /**
     * Main fucntion that represents the main menu
     * Directs the user into the relevant methods
     * @author Emirhan, Hayrunnisa, Murat, Zaid, Metehan
     */
    public static void main(String[] args)
    {
        String selection;
        cls();
        printHello();
        beklermisin();
        greetingPage();
        // this while loop takes an valid input between A-E and calls the relevent object
        // The loop represents the main menu
        while (true)
        {
            cls();
            printHello();
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
                    Objective2();
                    break;
                case "C":
                    Objective3();
                    break;
                case "D":
                    Objective4();
                    break;
                case "E":
                    exitPage();
                    scanner.close();
                    return;
            }
        }
    }
    //  MAIN METHODS FOR HOMEPAGE
    /**
     * Prints "WELCOME G17" with ascii art
     * @author Emirhan, Hayrunnisa
     */
    public static void printHello()
    {
        String[] part1 = {
            "____    __    ____  _______  __        ______   ______   .___  ___.  _______      _______ __   ______",
            "\\   \\  /  \\  /   / |   ____||  |      /      | /  __  \\  |   \\/   | |   ____|    /  _____/_ | |____  |",
            " \\   \\/    \\/   /  |  |__   |  |     |  ,----'|  |  |  | |  \\  /  | |  |__      |  |  __  | |     / / ",
            "  \\            /   |   __|  |  |     |  |     |  |  |  | |  |\\/|  | |   __|     |  | |_ | | |    / /  ",
            "   \\    /\\    /    |  |____ |  `----.|  `----.|  `--'  | |  |  |  | |  |____    |  |__| | | |   / /   ",
            "    \\__/  \\__/     |_______||_______| \\______| \\______/  |__|  |__| |_______|    \\______| |_|  /_/    ",
            "                                                                                                       "
        };
        for (String line : part1) System.out.println(line);
        System.out.println("\n\n\n");
    }
    /**
     * Prints the names with ascii art
     * @author Emirhan, Hayrunnisa
     */
    public static void greetingPage()
    {
        String[] part2 = {
            " _______ .___  ___.  __  .______       __    __       ___      .__   __.     __  ___      ___      .______          ___           ___ __      ___",
            "|   ____||   \\/   | |  | |   _  \\     |  |  |  |     /   \\     |  \\ |  |    |  |/  /     /   \\     |   _  \\        /   \\         /  /|  |     \\  \\ ",
            "|  |__   |  \\  /  | |  | |  |_)  |    |  |__|  |    /  ^  \\    |   \\|  |    |  '  /     /  ^  \\    |  |_)  |      /  ^  \\       |  | |  |      |  |",
            "|   __|  |  |\\/|  | |  | |      /     |   __   |   /  /_\\  \\   |  . `  |    |    <     /  /_\\  \\   |      /      /  /_\\  \\      |  | |  |      |  |",
            "|  |____ |  |  |  | |  | |  |\\  \\----.|  |  |  |  /  _____  \\  |  |\\   |    |  .  \\   /  _____  \\  |  |\\  \\----./  _____  \\     |  | |  `----. |  |",
            "|_______||__|  |__| |__| | _| `._____||__|  |__| /__/     \\__\\ |__| \\__|    |__|\\__\\ /__/     \\__\\ | _| `._____/__/     \\__\\    |  | |_______| |  |",
            "                                                                                                                                 \\__\\         /__/  "
        };
    
        String[] part3 = {
            " __    __       ___   ____    ____ .______       __    __  .__   __. .__   __.  __       _______.     ___           ______     ___   ____    ____  _______       ___      .______",
            "|  |  |  |     /   \\  \\   \\  /   / |   _  \\     |  |  |  | |  \\ |  | |  \\ |  | |  |     /       |    /   \\         /      |   /   \\  \\   \\  /   / |       \\     /   \\     |   _  \\ ",
            "|  |__|  |    /  ^  \\  \\   \\/   /  |  |_)  |    |  |  |  | |   \\|  | |   \\|  | |  |    |   (----`   /  ^  \\       |  ,----'  /  ^  \\  \\   \\/   /  |  .--.  |   /  ^  \\    |  |_)  | ",
            "|   __   |   /  /_\\  \\  \\_    _/   |      /     |  |  |  | |  . `  | |  . `  | |  |     \\   \\      /  /_\\  \\      |  |      /  /_\\  \\  \\      /   |  |  |  |  /  /_\\  \\   |      /  ",
            "|  |  |  |  /  _____  \\   |  |     |  |\\  \\----.|  `--'  | |  |\\   | |  |\\   | |  | .----)   |    /  _____  \\     |  `----./  _____  \\  \\    /    |  '--'  | /  _____  \\  |  |\\  \\----.",
            "|__|  |__| /__/     \\__\\  |__|     | _| `._____| \\______/  |__| \\__| |__| \\__| |__| |_______/    /__/     \\__\\     \\______/__/     \\__\\  \\__/     |_______/ /__/     \\__\\ | _| `._____|",
            "                                                                                                                                        "
        };
    
        String[] part4 = {
            ".___  ___.   ______    __    __       ___      .___  ___. .___  ___.      ___       _______      ________      ___       __   _______ ",
            "|   \\/   |  /  __  \\  |  |  |  |     /   \\     |   \\/   | |   \\/   |     /   \\     |       \\    |       /     /   \\     |  | |       \\ ",
            "|  \\  /  | |  |  |  | |  |__|  |    /  ^  \\    |  \\  /  | |  \\  /  |    /  ^  \\    |  .--.  |   `---/  /     /  ^  \\    |  | |  .--.  | ",
            "|  |\\/|  | |  |  |  | |   __   |   /  /_\\  \\   |  |\\/|  | |  |\\/|  |   /  /_\\  \\   |  |  |  |      /  /     /  /_\\  \\   |  | |  |  |  | ",
            "|  |  |  | |  `--'  | |  |  |  |  /  _____  \\  |  |  |  | |  |  |  |  /  _____  \\  |  '--'  |     /  /----./  _____  \\  |  | |  '--'  | ",
            "|__|  |__|  \\______/  |__|  |__| /__/     \\__\\ |__|  |__| |__|  |__| /__/     \\__\\ |_______/     /________/__/     \\__\\ |__| |_______/ ",
            "                                                                                                                                        "
        };
    
        String[] part5 = {
            ".___  ___.  __    __  .______          ___   .___________.        ___       __       __  ___      ___      .______   .___________.    ___      .__   __. ",
            "|   \\/   | |  |  |  | |   _  \\        /   \\  |           |       /   \\     |  |     |  |/  /     /   \\     |   _  \\  |           |   /   \\     |  \\ |  | ",
            "|  \\  /  | |  |  |  | |  |_)  |      /  ^  \\ `---|  |----`      /  ^  \\    |  |     |  '  /     /  ^  \\    |  |_)  | `---|  |----`  /  ^  \\    |   \\|  | ",
            "|  |\\/|  | |  |  |  | |      /      /  /_\\  \\    |  |          /  /_\\  \\   |  |     |    <     /  /_\\  \\   |   ___/      |  |      /  /_\\  \\   |  . `  | ",
            "|  |  |  | |  `--'  | |  |\\  \\----./  _____  \\   |  |         /  _____  \\  |  `----.|  .  \\   /  _____  \\  |  |          |  |     /  _____  \\  |  |\\   | ",
            "|__|  |__|  \\______/  | _| `._____/__/     \\__\\  |__|        /__/     \\__\\ |_______||__|\\__\\ /__/     \\__\\ | _|          |__|    /__/     \\__\\ |__| \\__| ",
            "                                                                                                                                         "
        };
    
        String[] part6 = {
            ".___  ___.  _______ .___________. _______  __    __       ___      .__   __.     __  ___  __   __       __    ______  __       __ ",
            "|   \\/   | |   ____||           ||   ____||  |  |  |     /   \\     |  \\ |  |    |  |/  / |  | |  |     |  |  /      ||  |     |  | ",
            "|  \\  /  | |  |__   `---|  |----`|  |__   |  |__|  |    /  ^  \\    |   \\|  |    |  '  /  |  | |  |     |  | |  ,----'|  |     |  | ",
            "|  |\\/|  | |   __|      |  |     |   __|  |   __   |   /  /_\\  \\   |  . `  |    |    <   |  | |  |     |  | |  |     |  |     |  | ",
            "|  |  |  | |  |____     |  |     |  |____ |  |  |  |  /  _____  \\  |  |\\   |    |  .  \\  |  | |  `----.|  | |  `----.|  `----.|  | ",
            "|__|  |__| |_______|    |__|     |_______||__|  |__| /__/     \\__\\ |__| \\__|    |__|\\__\\ |__| |_______||__|  \\______||_______||__| ",
            "                                                                                                                                         "
        };
    
        // Print each part
        for (String line : part2) System.out.println(line);
        beklermisin();
        for (String line : part3) System.out.println(line);
        beklermisin();
        for (String line : part4) System.out.println(line);
        beklermisin();
        for (String line : part5) System.out.println(line);
        beklermisin();
        for (String line : part6) System.out.println(line);
        beklermisin();
    }
    /**
     * Prints the options in the main menu
     * @author Emirhan, Hayrunnisa
     */
    public static void printOptions()
    {
        System.out.println("        A)   Statistical Information about an array\n");
        System.out.println("        B)   Matrix Operations\n");
        System.out.println("        C)   Text Encryption/Decryption\n");
        System.out.println("        D)   Tic-tac-toe HotSeat\n");
        System.out.println("        E)   EXIT\n\n\n");
        System.out.print("        Please select an option from the list above(A-E)): ");
    }
    /**
     * Prints the options in the objective 3
     * @author Hayrunnisa
     */
    public static void printCrypOptions()
    {
        System.out.println("        A)   Encryption\n");
        System.out.println("        B)   Decryption\n");
        System.out.println("        C)   Return to the Main Menu\n");
        System.out.print("        Please select an option from the list above(A-C)): ");
    }
    /**
     * Control the string ans, with the strings ...Check
     * If there is a match, returns true
     * @author Emirhan, Hayrunnisa
     * @param ans the string to be controlled
     * @param Check variable-length argument list, it contains valid answers
     * @return if valid returns true, else return false 
     */
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
    /**
     * Method for clearing the terminal
     * @author Emirhan
     */
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
    /**
     * Method that waits 1 second, then clears screen.
     * @author Hayrunnisa
     */
    public static void beklermisin()
    {
        // 1 saniye bekle, sonra ekranı temizle
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interruption cut: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        cls();
    }
    /**
     * Animation used for returning homepage
     * @author Emirhan
     */
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
    /**
     * Animation used for interface changes
     * @author Emirhan
     */
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
    /**
     * Animation used for terminating the program
     * @author Emirhan
     */
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

    /**
     * Method that asks for either re-doing the operation or going back
     * @author Emirhan, Hayrunnisa
     * @return returns true if the user wants to re-do the operation
     */
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


    // -------------------------------------------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------------------------------------------
    // -------------------------------------------    METHODS FOR THE OBJECTIVE 1    -------------------------------------------
    // -------------------------------------------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------------------------------------------

    /**
     * OBJECTIVE 1 MAIN METHOD
     * Calls the relevent methods for objective 1 and ask the user if they want to re-do the operation or go back
     * @author Emirhan, Hayrunnisa
     */
    public static void Objective1()
    {
        cls();
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
    
    /**
     * This method calls all the operation methods for objective 1 
     * @param arr to be used in the operations
     */
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

    /**
     * This method creates a valid double array with the constrains
     * For non-positive elements, the program warns the user as:
     * The value will be ignored in harmonic and geometric mean calculations.
     * And then ask if the user wants to change it or continue
     * @author Emirhan
     * @throws RuntimeException if the user enters a number that is not in the determined range
     * @throws IllegalArgumentException if the user enters a non-positive number. Because it will be ignored in harmonic and geometric mean calculations.
     * @return array, an double array
     */
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
    
    /**
     * This methods prints the objetive information, and takes an integer between 1-10
     * @author Emirhan, Hayrunnisa
     * @return an integer between 1-10 to represent the array size
     */
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
        return Integer.parseInt(ans);
    }
    
    /**
     * This methods takes an array as input and prints it
     * @author Emirhan, Hayrunnisa
     * @param arr array to be printed
     */
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

    /**
     * This method takes an array and its size as input, returns the median of the array
     * The array is first sorted, then the mean is selected based on the size of the array
     * O(logn) space complexity and O(n logn) time complexity. n=number of elements in the array
     * @author Emirhan, Hayrunnisa
     * @param arr array to be used for the operation
     * @param size size of the array
     * @return a double value, median of the array
     */
    public static double median(double arr[], int size)
    {
        Arrays.sort(arr);
        // if the array size is even, take the average of the middle two value
        if (size % 2 == 0)
        {
            double midTwo = 0.0;
            try
            {
                midTwo = secureSum(arr[size/2], arr[(size/2) - 1]);
            }
            catch (ArithmeticException e)
            {   
                System.err.println(e.getMessage() + "While calculating median");
                System.out.println("The median is set to '0.0'\n\n");
                midTwo = 0.0;
            }
            
            return midTwo / 2.0;
        }
            return arr[size/2];
    }

    /**
     * This method takes an array and its size as input, returns the arithmetic mean (average) of the array
     * With an array of size n, the formula of the arithmetic mean is: (a1 + a2 + ... + an) / n
     * O(n) time complexity. n=size of the array
     * @author Emirhan, Hayrunnisa
     * @param arr array to be used in the operation
     * @param size size of the array
     * @return a double value, arithmetic mean of the array
     */
    // 
    public static double arithmeticMean(double arr[], int size)
    {
        double aritMean = 0;
        for (double i : arr)
        {
            try
            {
                aritMean = secureSum(aritMean, i);
            }
            catch (ArithmeticException e)
            {
                System.err.println(e.getMessage() + "\nArithmetic mean is set to 0.0 !!\n\n");
                return 0.0;
            }
        }
        return aritMean / (double)size;
    }

    /**
     * This method takes an array and its size as input, returns the geometric mean of the array.
     * With an array of size n, the formula of the geometric mean is: pow((a1 * a2 * ... * an), 1/n)
     * O(n) time complexity. n=size of the array
     * @author Emirhan
     * @param arr array to be used in the operation
     * @param size size of the array
     * @throws IllegalArgumentException when there is no positive number in the array
     * @return a double value, geometric mean of the array
     */
    
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
            try
            {
                geoMean = secureMultiply(geoMean, d);
            }
            catch (ArithmeticException e)
            {
                System.err.println(e.getMessage() + "\nGeometric mean is set to 0.0 !!\n\n");
                return 0.0;
            }
        }

        if (count == 0)
            throw new IllegalArgumentException("Cannot calculate geometric mean without any positive number inside the array");

        return Math.pow(geoMean, 1.0/(double)count);
    }


    /**
     * This method takes and array and its size as input, returns the harmonic mean of the array by using recursive harmonicSummation method in the summation process
     * With an array of size n, the formula of the harmonic mean is: n / [(1/a1) + (1/a2) + ... + (1/an)]
     * O(n) time complexity and O(n) space complexity. n=size of the array
     * @author Emirhan
     * @param arr array to be used in the operation
     * @param size size of the array
     * @throws IllegalArgumentException when there is no positive number in the array
     * @return a double value, harmonic mean of the array
     */
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
        
        double harmonicSum; 
        try
        {
            harmonicSum = harmonicSummation(arr, size-1);
        }
        catch (ArithmeticException e)
        {
            System.err.println(e.getMessage() + "\nHarmonic mean is set to 0.0 !!\n\n");
            return 0.0;
        }

        return (double)count / harmonicSum;
    }

    /**
     * This method is a recursive approach for harmonic summation step of the harmonic mean calculation
     * Takes an array and an index as input and calculates the harmonic summation recursively until it reaches the first element of the array.
     * @author Emirhan
     * @param arr array to be used in the operation
     * @param index index that limits the array size for the recursive call
     * @throws ArithmeticException when there is an overflow during the summation
     * @return a double value, total harmonic summation of the array
     */
    public static double harmonicSummation(double arr[], int index)
    {
         // Base case
        if (index < 0)
            return 0.0;

        // Ignore zeros
        if (arr[index] <= 0)
            return harmonicSummation(arr, index-1); // Skip this element

        
        double sum = 1.0 / arr[index];
        double recursiveSum = harmonicSummation(arr, index - 1);
        double totalSum;
        try
        {
            totalSum = secureSum(sum, recursiveSum);
        }
        catch (ArithmeticException e)
        {
            throw new ArithmeticException(e.getMessage());
        }
        
        return totalSum;
    }
     
    /**
     * This methods takes two double values and sum them and returns the result
     * Checks the overflow/underflow during summation and if any, throws an exception
     * If the result is 0 but neither of the values is zero, it is underflow
     * If the result is infinite, it is overflow
     * @author Emirhan
     * @param a first double value
     * @param b second double value
     * @return the result of a + b if there is no exception
     * @throws ArithmeticException if overflow or underflow is detected
     */
    public static double secureSum(double a, double b)
    {
    double result = a + b;

    if (Double.isInfinite(result))
        throw new ArithmeticException("OVERFLOW DETECED !!!\n");
    else if (result == 0.0 && Math.abs(a) != Math.abs(b))
        throw new ArithmeticException("UNDERFLOW DETECED !!!\n");

    return result;
    }


    // -------------------------------------------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------------------------------------------
    // -------------------------------------------    METHODS FOR THE OBJECTIVE 2    -------------------------------------------
    // -------------------------------------------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------------------------------------------


    /**
     * OBJECTIVE 2 MAIN METHOD
     * @author Emirhan, Hayrunnisa, Murat
     * Contains information about the objective and main menu of the objective 2 UI
     * Directs the user to corresponding methods according to their input
    */ 
    public static void Objective2()
    {
        cls();
        System.out.println("Objective 2");
        System.out.println("------------");
        System.out.println("-> In this objective, you can perform the matrix operations listed below\n");
        printMatrixOptions();
        String input = scanner.nextLine();
        while (!isValidEntry(input, "1","2","3","4","5"))
        {
            cls();
            System.err.println("\n\n        INVALID ENTRY!!");
            printMatrixOptions();
            input = scanner.nextLine();
        }

        switch (input)
        {
            case "1":
                Obj2Case1();
                break;
            case "2":
                Obj2Case2();
                break;
            case "3":
                Obj2Case3();
                break;
            case "4":
                Obj2Case4();
                break;
            case "5":
                returnHomePage();
        }
    }

    /**
     * This method prints the options and the notes for Objective 2 
     * @author Emirhan, Hayrunnisa, Murat 
     * Contains information about the objective and main menu of the objective 2 UI
     * Directs the user to corresponding methods according to their input
    */
    public static void printMatrixOptions()
    {
        System.out.println("IMPORTANT NOTES");
        System.out.println("----------------");
        System.out.println("*  Option 2 (Inverse) requires a square matrix.\n");
        System.out.println("*  Option 3 (Matrix multiplication): The second matrix's row size will match the first matrix's column size automatically for compatibility.\n");
        System.out.println("*  Option 4 (Element-wise matrix multiplication): Both matrices must have same dimensions for compatibility.\n\n\n\n");
        System.out.println("        1)   Transpose of a matrix\n");
        System.out.println("        2)   Inverse of a matrix\n");
        System.out.println("        3)   Matrix multiplication\n");
        System.out.println("        4)   Element-wise matrix multiplication\n");
        System.out.println("        5)   EXIT TO HOMEPAGE\n\n\n");
        System.out.print("        Please select an option from the list above(1-5)): ");
    }
    
    /**  Main method for Objective2_Case1 (Matrix transpose)
     * Displays the transpose of the matrix and asks the user if they want to re-do the objective or go back to main menu for Objective 2
     * @author Emirhan, Hayrunnisa, Murat
    */
    public static void Obj2Case1()
    {
        int row;
        int col;
        double[][] matrix;

        //if user wanted to use the Product object, assign and do the calculation automatically
        if(rememberProduct.equals("Y"))
        {
            matrix = Objective2Product;
            row = matrix.length;
            col = matrix[0].length;
        }
        else
        {

        row = takeInputOfRowAndColumn("number of ROWS");
        col = takeInputOfRowAndColumn("number of COLUMNS");

        matrix = new double[row][col];

        fillMatrix(matrix, row, col);

        }
        cls();
        double[][] transpose = returnTranspose(matrix);
        Objective2Product = transpose;
        printMatrix(matrix, row, col, "Your Matrix:");
        printMatrix(transpose, transpose.length, transpose[0].length, "Transpose of Your Matrix:");

        isUseProduct();
        cls();
        if (loopAsk())
        {
            loadingPage();
            Obj2Case1();
        }
        else
        {
            loadingPage();
            Objective2();
        }
    }
    
    /**
     * This method prevents the repetitive process of asking for a fixed range value. It loops until the user selects a valid number between 1-5
     * @author Emirhan, Hayrunnisa, Murat
     * @param s is the message for different input taking scenarios (for flexiblity)
     * @return an integer between 1-5
    */
    public static int takeInputOfRowAndColumn(String s)
    {
        cls();
        System.out.printf("\nEnter a value for %s (between 1-5): ", s);
        String val = scanner.nextLine();
        while (!isValidEntry(val, "1","2","3","4","5"))
        {
            cls();
            System.err.println("        INVALID ENTRY!!");
            System.out.printf("\nEnter a value for %s (between 1-5): ", s);
            val = scanner.nextLine();
        }
        return Integer.parseInt(val);
    }
    
    /**
     * This method takes a matrix with its dimensions as input.
     * Iterates each element and changes them with the valid user input,
     * ensuring that the input is a valid double and within specified limits.
     * @author Emirhan, Hayrunnisa, Murat
     * @param mat is being filled by valid double values from user input
     * @param row row size of matrix
     * @param col column size of matrix
     * @throws RuntimeException if the entered number is not-finite (overflow for double) or has more than 8 digits before the decimal point
     * @throws InputMismatchException if the user enters a non-double value  
     */
    public static void fillMatrix(double[][] mat, int row, int col)
    {
        cls();

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                boolean flag = true;
                while(flag)
                {
                    try
                    {
                        cls();
                        printMatrix(mat, row, col,"~ CURRENT MATRIX ~" );
                        System.out.printf("Please enter a number for ROW: %d  and COLUMN: %d\n\n", i+1, j+1);
                        System.out.print("Enter a double (max 8 digits before the decimal): ");
                        double val = scanner.nextDouble();
                        scanner.nextLine(); 
                         /**  java automatically sets the number as +/- infinity if it over/underflows. 
                          * So we check if the number is finite or not
                          * also we check if the number has more than 8 digits before the decimal part.*/
                        if(!Double.isFinite(val) || Math.abs(val) >= Math.pow(10, 8))
                        {
                            throw new RuntimeException("!NUMBER IS NOT IN THE RANGE!");
                        }
                        mat[i][j] = val;
                        flag = false;
                    }
                    catch(InputMismatchException e) //NumberFormatException
                    {
                        cls();
                        System.err.println("\n\nINVALID ENTRY! Select a double please.\n");
                        beklermisin();
                        scanner.nextLine();
                    }
                    catch(RuntimeException e)
                    {
                        System.err.println(e.getMessage());
                        beklermisin();
                    }
                }
            }
        }
    }
    
    /**  
     * This methods takes a matrix and its dimensions as input and prints it. Input string is for the flexibility of the method.
     * @author Emirhan, Hayrunnisa, Murat
     * @param mat is printed in this method
     * @param row size of matrix
     * @param col size of matrix
     * @param message is to use the method in various situations
    */
    public static void printMatrix(double[][] mat, int row, int col, String message)
    {
        System.out.printf("\n\n%s\n", message);
        System.out.println("=".repeat((col * 20)+3));
    
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                System.out.printf("%15.3f ", mat[i][j]); // 7 spaces wide and 2 decimal places
            }
            System.out.println();
        }
    
        System.out.println("=".repeat((col * 20)+3) + "\n\n"); // Bottom divider line
    }  
    
    /** 
     * This method takes a matrix as input, returns the transpose of that matrix
     * O(n) space complexity and O(n) time complexity. n=number of elements in the matrix
     * @author Emirhan, Hayrunnisa, Murat
     * @param mat is the matrix to be used for transpose operation
     * @return the transpose of the input matrix
    */ 
    public static double[][] returnTranspose(double mat[][])
    {
        int row = mat.length;
        int col = mat[0].length;

        double transposeMat[][] = new double[col][row];

        for (int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
                transposeMat[j][i] = mat[i][j];
        }

        return transposeMat;
    }


    /**
     * Main method for Objective2_Case2 (Inverse matrix)
     * Creates a square matrix and controls the determinant of that to be able to perform the task
     * Displays the inverse of the matrix and asks the user if they want to re-do the objective or go back to main menu for Objective 2
     * @author Emirhan, Hayrunnisa, Murat
    */
    public static void Obj2Case2()
    {
        int row;
        double[][] matrix; 
        
        if(rememberProduct.equals("Y"))
        {
            //if the matrix isn't square by using another product, return and dont use that product
            if(Objective2Product.length != Objective2Product[0].length)
            {
                cls();
                System.out.println("This product is not valid for inverse operation!");
                rememberProduct = "N";
                beklermisin();
                Obj2Case2();
                return;
            }
            matrix = Objective2Product;
            row = matrix.length;
        }
        else
        {
            row = takeInputOfRowAndColumn("both number of ROWS and COLUMNS");
        
            matrix = new double[row][row];

            fillMatrix(matrix, row, row);
        }
        
        cls();
        printMatrix(matrix, row, row, "Your Matrix:");

        double determinant = determinant(matrix);
        if (determinant == 0.0)
            System.err.println("\n\nSingular matrices (determinant = 0) does not have an inverse!!\n");
        
        else if (matrix.length == 1)
        {
            printMatrix(matrix, row, row, "Inverse of Your Matrix:");
            Objective2Product = matrix;
        }
        else
        {
            double[][] inverse = inverseMatrix(matrix, determinant);
            Objective2Product = inverse;
            printMatrix(inverse, inverse.length, inverse[0].length, "Inverse of Your Matrix:");
        }
            
        isUseProduct();
        cls();
        if (loopAsk())
        {
            loadingPage();
            Obj2Case2();
        }
        else
        {
            loadingPage();
            Objective2();
        }
    }
    
    /** 
     * This method takes a matrix and its determinant as input;
     * calculates the cofactor matrix, adjoint matrix and then returns the inverse of the matrix
     * O(n+r) space complexity and O(n^2) time complexity. n=number of elements in the matrix, r=row size of the matrix
     * @author Emirhan, Hayrunnisa, Murat
     * @param mat the matrix to be inverted
     * @param determinant to multiply the adjoint matrix with 1/determinant
     * @return inverse of the input matrix
    */ 
    public static double[][] inverseMatrix(double[][] mat, double determinant)
    {
        /**  create the adjoint matrix by taking the transpose of the cofactor matrix*/
        double[][] cofactorMatrix = cofactorMatrix(mat);
        double[][] adjointMatrix = returnTranspose(cofactorMatrix);
        
        /**  use the formula to derive the inverse of the matrix (Inverse Matrix = Adjoint Matrix . 1/determinant)*/
        matrixMultWithConstant(adjointMatrix, 1.0 / determinant);
        
        /**  create a reference just for clean coding, its not copy*/
        double[][] inverseMatrix = adjointMatrix;
        return inverseMatrix;
    }

    /**
     * Calculates the determinant of the square rxr matrix recursively
     * Returns the base cases directly without recursion (1x1 and 2x2 matrices)
     * O(r) space complexity and O(n) time complexity where r=row number and n=number of elements in matrix(r^2)
     * @author Emirhan, Hayrunnisa, Murat
     * @param mat the matrix whose determinant will be calculated
     * @throws ArithmeticException if overflow or underflow is detected. Sets the determinant as 0 and returns
     * @return a double value, determinant
    */ 
    public static double determinant(double[][] mat)
    {
        /**  base cases for 1x1 and 2x2 matrices*/
        int n = mat.length;
        if (n == 1)
            return mat[0][0];
        else if (n == 2)
            return mat[0][0]*mat[1][1] - mat[0][1]*mat[1][0];

        double ans = 0;

        /** iterate through each element in the first row*/
        for (int i = 0; i < n; i++)
        { 
            /** Create a submatrix called "newMat" by excluding the current element's row and column
            // "newMat" will have dimensions (n-1)x(n-1) */
            double newMat[][] = new double[n-1][n-1];
            int colCount = 0;

            // skip the first row and start from the second one
            for (int row = 1; row < n; row++)
            {
                for (int col = 0; col < n; col++)
                {
                    if (col != i) // ignore the current element's column
                        newMat[row-1][colCount++] = mat[row][col];
                }
                colCount = 0;
            }
            /**determinant calculation formula.*/
            try
            {
                ans += secureMultiply((Math.pow(-1, i) * mat[0][i]), determinant(newMat));
            }
            catch (ArithmeticException e)
            {
                System.err.println(e.getMessage() + "While calculating the determinant\n\n");
                System.out.println("The determinant is set as '0.0'\n\nReturning....\n");
                beklermisin();
                return 0.0;
            }
        }
        return ans;
    }
    
    /** 
     * This method takes a matrix as input, creates sub-matrices for each element of the original matrix,
     * calculate the minors (determinant of the submatrix) for each sub-matrices and returns a cofactor matrix accordingly
     * O(n+r) space complexity and O(n^2) time complexity. n=number of elements in the matrix, r=row size of the matrix
     * @author Emirhan, Hayrunnisa, Murat
     * @param mat the matrix whose cofactor matrix will be derived
     * @return cofactorMat, cofactor matrix of the input matrix
    */ 
    public static double[][] cofactorMatrix(double mat[][])
    {
        int row = mat.length;
        int col = mat[0].length;
        double cofactorMat[][] = new double[row][col];

        // Iterate through each element of the matrix to calculate cofactors
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                // create the submatrix by ignoring i-th row and j-th column
                double subMatrix[][] = ignore_ithRow_jthColumn(mat, i, j);
                
                // Calculate the minor (determinant of the submatrix)
                double det = determinant(subMatrix);

                // Determine the sign for the cofactor
                cofactorMat[i][j] = Math.pow(-1, i+j) * det;
            }
        }
    
        return cofactorMat;
    }
    
    /** 
     * This method takes a matrix and two indeces as input,
     * returns a new matrix that doesn't contain the i-th row and j-th column of the original matrix
     * O(n) space complexity, O(n) time complexity. n=number of elements in the matrix
     * @author Emirhan, Hayrunnisa, Murat
     * @param mat is to hold the matrix in memory
     * @param i index of the ignored row
     * @param j index of the ignored column
     * @return newMat, a new matrix without the i-th row and j-th column of the input matrix
    */ 
    public static double[][] ignore_ithRow_jthColumn(double mat[][], int i, int j)
    {
        int row = mat.length;
        int col = mat[0].length;
        double newMat[][] = new double[row-1][col-1];

        int rowIdx = 0;
        for (int a = 0; a < row; a++)
        {
            int colIdx = 0;
            if (a == i)
                continue;
            for (int b = 0; b < col; b++)
            {
                if (b == j)
                    continue;
                newMat[rowIdx][colIdx++] = mat[a][b];
            }
            rowIdx++;
            colIdx = 0;
        }

        return newMat;
    }
    
    /**
     * This method takes a matrix and constant as input, modifes the matrix such that each element is multiplied with the constant
     * O(1) space complexity and O(n) time complexity. n=number of elements in the matrix
     * @author Emirhan, Hayrunnisa, Murat
     * @param mat the matrix to be modifed
     * @param x is the constant to be multiplied with each element of the matrix
     * @throws ArithmeticException if overflow or underflow is detected. Handles the exception such that it sets the value to 0.0
     */
    public static void matrixMultWithConstant(double mat[][], double x)
    {
        int row = mat.length;
        int col = mat[0].length;
        if (row == 0 || col == 0)
            return;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                try
                {
                    mat[i][j] = secureMultiply(mat[i][j], x);
                }
                catch (ArithmeticException e)
                {
                    System.err.println(e.getMessage() + "While multiplying elements at [" + i + "][" + j + "] with the constant\n\n");
                    System.out.println("The value is set to '0.0'\n\n");
                    mat[i][j] = 0.0;
                    beklermisin();
                }
            }
        }
    }

    /**
     * Main method for Objective2_Case3 (Matrix multiplication)
     * Creates and fills two matrices suitable for the operation
     * Displays the multiplication of two matrices and asks the user if they want to re-do the objective or go back to main menu for Objective 2
     * @author Emirhan, Hayrunnisa, Murat
    */
    public static void Obj2Case3()
    {
        int row1, col1;
        double mat1[][];

        if(rememberProduct.equals("Y"))
        {
            mat1 = Objective2Product;
            row1 = mat1.length;
            col1 = mat1[0].length;
        }
        else
        {

        row1 = takeInputOfRowAndColumn("number of ROWS for the first matrix");
        col1 = takeInputOfRowAndColumn("number of COLUMNS for the first matrix");
        mat1 = new double[row1][col1];
        fillMatrix(mat1, row1, col1);

        }
        cls();

        System.out.printf("Number of ROWS for the second matrix is set as %d to perform the task!!\n\n", col1);
        try
        {
            for(int i = 0; i < 4; i++)
            {
                System.out.println(".");
                Thread.sleep(750);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Error on pause!!");
        }
        cls();

        int row2 = col1;
        int col2 = takeInputOfRowAndColumn("number of COLUMNS for the second matrix");
        double mat2[][] = new double[row2][col2];
        fillMatrix(mat2, row2, col2);
        cls();


        printMatrix(mat1, row1, col1, "Your FIRST MATRIX:");
        printMatrix(mat2, row2, col2, "Your SECOND MATRIX");

        double multMat[][] = matrixMult(mat1, mat2);
        Objective2Product = multMat;
        printMatrix(multMat, multMat.length, multMat[0].length, "Multiplication of two matrices above:");

        isUseProduct();
        cls();
        if (loopAsk())
        {
            loadingPage();
            Obj2Case3();
        }
        else
        {
            loadingPage();
            Objective2();
        }
    }
    
    /**  
     * This methods takes two matrices as input, returns another matrix that is the product of the mat1 x mat2 multiplication
     * O(n) space complexity and O(nr) time complexity. n=number of elements in answer matrix and r=number of rows in the first matrix
     * @author Emirhan, Hayrunnisa, Murat
     * @param mat1 the first matrix
     * @param mat2 the second matrix 
     * @throws ArithmeticException if overflow or underflow is detected. Handles the exception such that it sets the value to 0.0
     * @return result, the product matrix from the mat1 x mat 2 multiplication
     * that is the dot product of the two matrices (matrix multiplication)
    */
    public static double[][] matrixMult(double mat1[][], double mat2[][])
    {
        int row1 = mat1.length;

        int row2 = mat2.length;
        int col2 = mat2[0].length;

        int row_new = row1;
        int col_new = col2;
        double result[][] = new double[row_new][col_new];

        /**  i is the row index for the new matrix
        * j is the column index for the new matrix
        * k is the index/counter for how many multiplication that must be summed to fill one spot in the new matrix
        */
        for(int i = 0; i < row_new; i++)
        {
            for(int j = 0; j < col_new; j++)
            {
                for(int k = 0; k < row2; k++)
                {
                    try
                    {
                        result[i][j] += secureMultiply(mat1[i][k], mat2[k][j]);
                    }
                    catch (ArithmeticException e)
                    {
                        System.err.println(e.getMessage() + "While multiplying elements at mat1[" + i + "][" + k + "] and mat2[" + k + "][" + j + "]\n\n");
                        System.out.println("The value is set to '0.0'\n\n");
                        result[i][j] = 0.0;
                        beklermisin();
                    }
                    
                }
            }
        }
        return result;
    }

    /**  
     * Main method for Objective2_Case4 (Element-wise multiplication)
     * Creates and fills 2 matrices with same dimensions
     * Displays the element-wise multiplication matrix and ask the user if they want to re-do the objective 
     * or go back to main menu for Objective 2
     * @author Emirhan, Hayrunnisa, Murat
    */
    public static void Obj2Case4()
    {
        int row, col;
        double mat1[][];
        if(rememberProduct.equals("Y"))
        {
            row = Objective2Product.length;
            col = Objective2Product[0].length;
            mat1 = Objective2Product;
        }
        else
        {
            row = takeInputOfRowAndColumn("number of ROWS for both matrices");
            col = takeInputOfRowAndColumn("number of COLUMNS for both matrices");
            mat1 = new double[row][col];
            cls();
            System.out.println("You will fill the FIRST MATRIX!");
            beklermisin();
            fillMatrix(mat1, row, col);
        }

        double mat2[][] = new double[row][col];

        cls();
        System.out.println("You will fill the SECOND MATRIX!");
        beklermisin();
        fillMatrix(mat2, row, col);
        cls();

        double mult[][] = elementwiseMult(mat1, mat2);
        Objective2Product = mult;
        printMatrix(mat1, row, col, "Your FIRST MATRIX:");
        printMatrix(mat2, row, col, "Your SECOND MATRIX:");
        printMatrix(mult, row, col, "Element-wise multiplication of the two matrices above:");

        isUseProduct();
        cls();
        if (loopAsk())
        {
            loadingPage();
            Obj2Case4();
        }
        else
        {
            loadingPage();
            Objective2();
        }
    }

    /**
     * This method takes two matrices as input, returns another matrix that contains the element-wise multiplication result
     * O(n) space complexity and O(n) time complexity. n=number of elements in one matrix
     * @author Emirhan, Hayrunnisa, Murat
     * @param mat1 the first matrix
     * @param mat2 the second matrix  
     * @return mult, a new matrix with the element-wise multiplication results
     * @throws ArithmeticException if overflow or underflow is detected. Handles the exception such that the overflowed/underflowed value is set to default (0.0)
     * */
    public static double[][] elementwiseMult(double mat1[][], double mat2[][])
    {
        int row = mat1.length;
        int col = mat1[0].length;
        double mult[][] = new double[row][col];

        for(int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                try
                {
                    mult[i][j] = secureMultiply(mat1[i][j], mat2[i][j]);
                }
                catch (ArithmeticException e)
                {
                    System.err.println(e.getMessage() + "While multiplying elements at [" + i + "][" + j + "]\n\n");
                    System.out.println("The value is set to '0.0'\n\n");
                    mult[i][j] = 0.0;
                    beklermisin();
                }
            }
        }

        return mult;
    }
    /**
     * This methods takes two double values and multiplies them and returns the result
     * Checks the overflow/underflow during multiplication and if any, throws an exception
     * If the result is 0 but neither of the values is zero, it is underflow
     * If the result is infinite, it is overflow
     * @author Emirhan, Hayrunnisa, Murat
     * @param a first double value
     * @param b second double value
     * @return the result of a * b if there is no exception
     * @throws ArithmeticException if overflow or underflow is detected
     */
    public static double secureMultiply(double a, double b)
    {
        double result = a * b;
        
        if (Double.isInfinite(result))
            throw new ArithmeticException("OVERFLOW DETECED !!!\n");
        else if (result == 0.0 && a != 0.0 && b != 0.0)
            throw new ArithmeticException("UNDERFLOW DETECED !!!\n");

        return result;
    }
    /**
     * This method is used to eleminate repetitive opearion
     * After a matrix operation is done, it asks user to if they want to do another operation with the result matrix of the operation they have done
     * @author Emirhan, Hayrunnisa, Murat 
     */
    public static void isUseProduct()
    {
        if(Objective2Product == null)
        {
            System.out.println("There is no recorded product!");
            beklermisin();
        }
        System.out.println("\nWould you like to use the product of this operation in a new operation?\n");
        System.out.println("Your choice(Y/N): ");
        rememberProduct = scanner.nextLine();
        rememberProduct = rememberProduct.toUpperCase();
        while(!isValidEntry(rememberProduct, "Y","N", "y", "n"))
        {
            cls();
            System.out.println("INVALID ENTRY!");
            System.out.println("\nWould you like to use the product of this operation in a new operation?\n");
            System.out.println("Your choice(Y/N): ");
            rememberProduct = scanner.nextLine();
        }
    }




    // -------------------------------------------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------------------------------------------
    // -------------------------------------------    METHODS FOR THE OBJECTIVE 3    -------------------------------------------
    // -------------------------------------------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------------------------------------------




    /**
     * Prints options for encryption/decryption and ables user to select an option
     * @author Hayrunnisa, Zaid
     */
    public static void Objective3()
    {
        String selection;
        cls();
        while(true)
        {
            printCrypOptions();
            selection = scanner.nextLine();
            selection = selection.toUpperCase();
            while (!isValidEntry(selection, "A","B","C"))
            {
                cls();
                System.err.println("\n\n        INVALID ENTRY!!");
                printCrypOptions();
                selection = scanner.nextLine();
                selection = selection.toUpperCase();
            }
            cls();
            switch (selection)
            {
                case "A":
                    Encryption(1);
                    break;
                case "B":
                    Encryption(-1);
                    break;
                case "C":
                    returnHomePage();
                    return;
            }  
        }
    }
    /**
     * Main method for encryption and decryption.
     * @author Hayrunnisa, zaid
     * @param x , by multiplying -1 it decides if it is enc or dec x = dec , x -1 enc
     * if the input is empty, invalid try 
     * it throws exception.
     * 
     * Negative key:
     * -Cannot be smaller than -26, to make them positive method adds 26 after taking modulo. then again it takes modulo so that it can go further from the original letter
     * strings are stabile so that we create a char "che" then assigned every char in the string to che in the for loop.
     * !!newarr hold the new message
     * !! char Aa holds the place in the ascii table for 'a' or 'A',
     * (THE DISTANCE OF THE ORIGINAL LETTER TO FIRST LETTER  + THE RAW KEY) %  26 gives the exact point from the first letter
     * so that dont forget the add first letter Aa
     * 
     */
    public static void Encryption(int x)
    {
        String victim; // The message
        int key = 0;
        boolean isValid = false;
        do
        {
            System.out.print("\n        Please enter your message: ");
            victim = scanner.nextLine();
            cls();
        } while ( victim.equals("") || victim.equals(" "));

        do {
            try {
                
                System.out.print("\nPlease enter the key[-26,26]: ");
                key = scanner.nextInt();
                scanner.nextLine();  // Buffer temizleme
                cls();
                if(key < 27 && key > -27)
                {
                    isValid = true;
                }else{
                    cls();
                    System.out.println("Not In The Range!");
                }
            } catch (InputMismatchException e) {
                cls();
                System.out.println("Invalid input. Please enter an **INTEGER**.");
                scanner.nextLine();  // Scanner cleans non-integer input
            }
        } while (!isValid);

        // Multiply by x, to decide if the request is encryption or decryption
        key = key * x;

        // Managing negative keys by modulo and adding 26
        if (key < 0) {
            key = (key % 26 + 26) % 26; // now, they are positive
            // positivie keys are already correct
        }

        // string to char array
        char[] newarr = new char[victim.length()];

        //Process of encryption/decryption
        for (int i = 0; i < victim.length(); i++)
        {
            char che = victim.charAt(i);
            if (Character.isLetter(che))  
            {
                char Aa = Character.isLowerCase(che) ? 'a' : 'A';  // Decides whether the starting point should be lowercase or uppercase
                newarr[i] = (char) ((che - Aa + key) % 26 + Aa);   // addition of the key to the distance to starting point is actually the purified key, getting mod 26 shows how many steps you need to take from the beginning
            }
            else
            {
                newarr[i] = che;  // non-alphabetic, remains
            }
        }
        // Char array to string, then print the message
        String result = new String(newarr);
        if (x == 1) {
            System.out.println("\n             Encrypted Message:\n");
        } else {
            System.out.println("\n             Decrypted Message:\n");
        }
        System.out.printf("\n             %s", result);
        System.out.print("\n\n        To return back press a button:\n");
        scanner.nextLine();
        cls();
        return;
    }






    // -------------------------------------------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------------------------------------------
    // -------------------------------------------    METHODS FOR THE OBJECTIVE 4    -------------------------------------------
    // -------------------------------------------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------------------------------------------




    /**
     *        Simulates an ascii art entrance for the game
     * @author Hayrunnisa
     */
    public static void Objective4()
    {
        cls();
        welcometoxox();
        startxox();
        return;
    }
    /**
     * Animation
     * @author Hayrunnisa
     */
    public static void welcometoxox() {
        String[] lines = {
                "                                                                                          ",
                "                        --                /,                                              ",
                "                        vt                fI                           .\"       ^'        ",
                "                       `c<                |>                           .it^   '}{.        ",
                "                       ,c,                1<                             ._(^>j\"          ",
                "                       ;c`                )+                               -cv`           ",
                "                       ic`                \\-                             ^t+.^j?.         ",
                "                       <c`                j?                           .}{'    >n`        ",
                "                       >c\"                n]               .            .       .         ",
                "       '-]]]]]?][}{1)(|xcxfjjrrrrxxxxrrrrrcuft/\\|(1{}}[]?+>\"                               ",
                "                       ;c\"                c}                                               ",
                "                       :c\"                z}                             .I}][)l          ",
                "                       ,c\"               .z}                            \"r^   ._/         ",
                "                       \"c,               .z{                           'c^      rl        ",
                "                       ^c,               .z{                           ,c.     .u:        ",
                "                       `c,               .z{                           'n+.   '\\<         ",
                "                       `c,               .z{                            .;}}}{<`          ",
                "                      .`cI...............`z(''''''....                                     ",
                "       .,I>+?[{11))))((\\cr((||||\\\\////ttcuffffjjjrrxxxrt}^                               ",
                "                       .zl                v{                            .'.   .'.         ",
                "                       .z>                n}                           [uxn\\^}uxn\\.       ",
                "                       .z+                f}                          'c///jcx///v,       ",
                "                        z[                (}                           {n///j///rf.       ",
                "                        c(                ]1                            .>xjn]'          ",
                "                        c{                >|                             .;'             ",
                "                        u>                ,x                                               ",
                "                        t^                'v                                               ",
                "                                                                                          "
        };
        /**
         * print ascıı art line by line 10 ms for each line
         * 
         * @throws if an exception occurs during execution
         */
        for (String satir : lines) {
            System.out.println(satir);
            try {
                Thread.sleep(10); // Her satır arasında 0.01 saniye bekle
            } catch (InterruptedException e) {
                System.out.println("Interruption cut: " + e.getMessage());
                Thread.currentThread().interrupt(); // İş parçacığının kesildiğini bildirir
            }
        }
        beklermisin();
        cls();
    }

    /**
     * Animation to print out who is next
     * @author Hayrunnisa
     * @param choice -> is the person who is the next
     *               represents the user next and remains 1.2 sec
     */
    public static void printNext(char choice) {
        if ('O' == choice) {
            System.out.println(" ________   __    __   ______        __      _        ____    ");
            System.out.println("(___  ___)  ) )  ( (  (   __ \\      /  \\    / )      / __ \\   ");
            System.out.println("    ) )    ( (    ) )  ) (__) )    / /\\ \\  / /      / /  \\ \\  ");
            System.out.println("   ( (      ) )  ( (  (    __/     ) ) ) ) ) )     ( ()  () ) ");
            System.out.println("    ) )    ( (    ) )  ) \\ \\  _   ( ( ( ( ( (      ( ()  () ) ");
            System.out.println("   ( (      ) \\__/ (  ( ( \\ \\_))  / /  \\ \\/ /       \\ \\__/ /  ");
            System.out.println("   /__\\     \\______/   )_) \\__/  (_/    \\__/         \\____/   ");
            System.out.println("                                                              ");
        }
        if ('X' == choice) {
            System.out.println(" ________   __    __   ______        __      _      __     __  ");
            System.out.println("(___  ___)  ) )  ( (  (   __ \\      /  \\    / )    (_ \\   / _) ");
            System.out.println("    ) )    ( (    ) )  ) (__) )    / /\\ \\  / /       \\ \\_/ /   ");
            System.out.println("   ( (      ) )  ( (  (    __/     ) ) ) ) ) )        \\   /    ");
            System.out.println("    ) )    ( (    ) )  ) \\ \\  _   ( ( ( ( ( (         / _ \\    ");
            System.out.println("   ( (      ) \\__/ (  ( ( \\ \\_))  / /  \\ \\/ /       _/ / \\ \\_  ");
            System.out.println("   /__\\     \\______/   )_) \\__/  (_/    \\__/       (__/   \\__) ");
            System.out.println("                                                                ");
        }
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            System.out.println("Interruption cut: " + e.getMessage());
            Thread.currentThread().interrupt(); // İş parçacığının kesildiğini bildirir
        }
        cls();
    }

    
    /*public static void startxox() {
        char paper[][] = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
        char turn = 'X';
        short counter = 0;
        int row, col;
        boolean isValid;
        boolean flag = true;
        short invalidcounter = 0;
        while (flag) {
            printNext(turn);
            isValid = false;
            do {
                try {
                    printPaper(paper);
                    System.out.printf("\nYou can type 9 to return to main menu!]\n", invalidcounter);
                    System.out.println();
                    System.out.printf("\nPlease select a row %c [1,3]: ", turn);
                    row = scanner.nextInt();
                    scanner.nextLine();
                    if(row == 9)
                    {
                        returnHomePage();
                        return;
                    }
                    row -= 1;
                    System.out.printf("\nPlease select a column %c [1,3]: ", turn);
                    col = scanner.nextInt();
                    scanner.nextLine();
                    if(col == 9)
                    {
                        returnHomePage();
                        return;
                    }
                    col -= 1;
                    cls();
                    if (row < 3 && row > -1 && col < 3 && col > -1 && paper[row][col] == ' ') {
                        cls();
                        isValid = true;
                        paper[row][col] = turn;
                        counter++;
                        if (counter > 4 && Over(paper, turn)) {
                            flag = false; // GAME OVER
                            System.out.printf(
                                    "                     %c WON IN %d TURNS                                                 \n\n",
                                    turn, counter);
                            System.out.println(
                                    " __        ___                                  _                       ");
                            System.out.println(
                                    " \\ \\      / (_)_ __  _ __   ___ _ __  __      _(_)_ __  _ __   ___ _ __ ");
                            System.out.println(
                                    "  \\ \\ /\\ / /| | '_ \\| '_ \\ / _ \\ '__| \\ \\ /\\ / / | '_ \\| '_ \\ / _ \\ '__|");
                            System.out.println(
                                    "   \\ V  V / | | | | | | | |  __/ |     \\ V  V /| | | | | | | |  __/ |   ");
                            System.out.println(
                                    "    \\_/\\_/  |_|_| |_|_| |_|\\___|_|      \\_/\\_/ |_|_| |_|_| |_|\\___|_|   ");
                            System.out
                                    .println("  ___| |__ (_) ___| | _____ _ __     __| (_)_ __  _ __   ___ _ __      ");
                            System.out.println(
                                    " / __| '_ \\| |/ __| |/ / _ \\ '_ \\   / _` | | '_ \\| '_ \\ / _ \\ '__|     ");
                            System.out
                                    .println("| (__| | | | | (__|   <  __/ | | | | (_| | | | | | | | |  __/ |        ");
                            System.out.println(
                                    " \\___|_| |_|_|\\___|_|\\_\\___|_| |_|  \\__,_|_|_| |_|_| |_|\\___|_|         \n");
                        } else if (counter == 9 && !Over(paper, turn)) {
                            System.out.printf("The Game is Tie!\n\n");
                            flag = false; // GAME OVER
                        }
                        printPaper(paper);
                        turn = (turn == 'X') ? 'O' : 'X';
                    } else
                        System.out.print("\n 🚫 You Can't Choose This Block 🚫 \n");
                } catch (InputMismatchException e) {
                    scanner.nextLine(); // Scanner cleans non-integer input
                    cls();
                    invalidcounter++;
                    if (invalidcounter == 3) {
                        flag = false;
                    }
                    System.out.println(" ⛔️ Invalid input. You should use a valid **INTEGER** ⛔️");

                }
                if(!flag)
                    isValid = true;

            } while (!isValid);

        }
        System.out.println("\nPLAY AGAIN [0]");
        System.out.println("\nRETURN MAIN MENU [1]");
        try {
            int exit;
            exit = scanner.nextInt();
            if (exit == 0) {
                cls();
                startxox();
            } else {
                returnHomePage();
                return;
            }
        } catch (Exception e) {
            cls();
            System.out.println("\n INVALID ENTRY");
            returnHomePage();
            return;
        }

    }
    */
    
    /**
     * Main method for XOX game
     * @author Hayrunnisa, Zaid
     *         XOX STARTS
     *         starts with an empty board
     *         prints the board on terminal each time
     *         X starts
     *         if the turn number smaller then 4 it does not check if there is a
     *         winner or not
     *         About selecting a block:
     *         they cannot choose a block that does not exist or full
     *         Flag: follows the progress of the game.
     *         Counter: total of the turns.
     *         isValid: indicates input
     */
    public static void startxox() {
        char paper[][] = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
        char turn = 'X';
        short counter = 0;
        int row, col;
        boolean isValid;
        boolean flag = true;
        short invalidcounter = 0;
        while (flag) {
            printNext(turn);
            isValid = false;
            do {
                try {
                    printPaper(paper);
                    System.out.printf("\n[After 3 non-integer entry, game will be over! [%d] ]\n", invalidcounter);
                    System.out.println();
                    System.out.printf("\nPlease select a row %c [0,2]: ", turn);
                    row = scanner.nextInt();
                    System.out.printf("\nPlease select a column %c [0,2]: ", turn);
                    col = scanner.nextInt();
                    scanner.nextLine(); // Buffer temizleme
                    cls();
                    if (row < 3 && row > -1 && col < 3 && col > -1 && paper[row][col] == ' ') {
                        cls();
                        isValid = true;
                        paper[row][col] = turn;
                        counter++;
                        if (counter > 4 && Over(paper, turn)) {
                            flag = false; // GAME OVER
                            System.out.printf(
                                    "                     %c WON IN %d TURNS                                                 \n\n",
                                    turn, counter);
                            System.out.println(
                                    " __        ___                                  _                       ");
                            System.out.println(
                                    " \\ \\      / (_)_ __  _ __   ___ _ __  __      _(_)_ __  _ __   ___ _ __ ");
                            System.out.println(
                                    "  \\ \\ /\\ / /| | '_ \\| '_ \\ / _ \\ '__| \\ \\ /\\ / / | '_ \\| '_ \\ / _ \\ '__|");
                            System.out.println(
                                    "   \\ V  V / | | | | | | | |  __/ |     \\ V  V /| | | | | | | |  __/ |   ");
                            System.out.println(
                                    "    \\_/\\_/  |_|_| |_|_| |_|\\___|_|      \\_/\\_/ |_|_| |_|_| |_|\\___|_|   ");
                            System.out
                                    .println("  ___| |__ (_) ___| | _____ _ __     __| (_)_ __  _ __   ___ _ __      ");
                            System.out.println(
                                    " / __| '_ \\| |/ __| |/ / _ \\ '_ \\   / _` | | '_ \\| '_ \\ / _ \\ '__|     ");
                            System.out
                                    .println("| (__| | | | | (__|   <  __/ | | | | (_| | | | | | | | |  __/ |        ");
                            System.out.println(
                                    " \\___|_| |_|_|\\___|_|\\_\\___|_| |_|  \\__,_|_|_| |_|_| |_|\\___|_|         \n");
                        } else if (counter == 9 && !Over(paper, turn)) {
                            System.out.printf("The Game is Tie!\n\n");
                            flag = false; // GAME OVER
                        }
                        printPaper(paper);
                        turn = (turn == 'X') ? 'O' : 'X';
                    } else
                        System.out.print("\n 🚫 You Can't Choose This Block 🚫 \n");
                } catch (InputMismatchException e) {
                    scanner.nextLine(); // Scanner cleans non-integer input
                    cls();
                    invalidcounter++;
                    if (invalidcounter == 3) {
                        flag = false;
                    }
                    System.out.println(" ⛔️ Invalid input. You should use a valid **INTEGER** ⛔️");

                }
                if(!flag)
                    isValid = true;

            } while (!isValid);

        }
        System.out.println("\nPLAY AGAIN [0]");
        System.out.println("\nRETURN MAIN MENU [1]");
        try {
            int exit;
            exit = scanner.nextInt();
            if (exit == 0) {
                cls();
                scanner.nextLine();
                startxox();
            } else {
                returnHomePage();
                scanner.nextLine();
                return;
            }
        } catch (Exception e) {
            cls();
            System.out.println("\n INVALID ENTRY");
            returnHomePage();
            return;
        }

    }

    /**
     * To control if the game is over or not
     * @author Hayrunnisa , Zaid
     * @param paper , current board
     * @param turn  , indicates who's turn
     * @return if it is a winning situation return true
     *         checks the moves
     */
    public static boolean Over(char paper[][], char turn) {
        // cross control
        if (paper[0][0] == turn && paper[1][1] == turn && paper[2][2] == turn)
            return true;
        if (paper[0][2] == turn && paper[1][1] == turn && paper[2][0] == turn)
            return true;
        for (short i = 0; i < 3; i++) {
            if (paper[0][i] == turn && paper[1][i] == turn && paper[2][i] == turn)
                return true;
            if (paper[i][0] == turn && paper[i][1] == turn && paper[i][2] == turn)
                return true;
        }
        return false;
    }

    /**
     * Prints the board
     * @author Zaid, Hayrunnisa
     * @param paper, the board
     */
    public static void printPaper(char paper[][]) {
        System.out.print("\nTic-Tac-Toe Board:\n\n");
        for (short i = 0; i < 3; i++) {
            for (short j = 0; j < 3; j++) {
                System.out.print(paper[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            if (i < 2) {
                System.out.println();
                System.out.println("---------");
            }
        }
        System.out.println();
    }
}
