import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Project1_Group17
{
    private static final Scanner scanner = new Scanner(System.in);
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
            
            objectiveChosen(selection);
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
        // .equals() method must be used. Because when we use ==, it compares the their memory references
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
    // ----------------------------------------------------------------------------------------
    // METHODS FOR OPTION 3
    /**
     * @author Hayrunnisa, Zaid
     * Prints options for encryption/decryption and ables user to select an option
     */
    public static void Cryption()
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
     * @author hayrunnisa, zaid
     * @param x , by multiplying -1 it decides if it is enc or dec x = dec , x -1 enc
     * if the input is empty, invalid try
     * @throw choosing a key, while key is invalid it continues. If input is non-integer 
     * it throws exception.
     * 
     * Negative key:
     * -Cannot be smaller than -26, to make them positive method adds 26 after taking modulo. then again it takes modulo so that it can go further from the original letter
     * strings are stabile so that we create a char "che" then assigned every char in the string to che in the for loop.
     * !!newarr hold the new message
     * !! char Aa holds the place in the ascıı table for 'a' or 'A',
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
    //set of objectives
    public static void objectiveChosen(String Objective)
    {
        switch (Objective)
            {
                case "A":
                    break;
                case "B":
                    break;
                case "C":
                    Cryption();
                    break;
                case "D":
                    break;
                case "E":
                    scanner.close();
                    exitPage();
                    return;
            }
    }
    // ----------------------------------------------------------------------------------------
}
