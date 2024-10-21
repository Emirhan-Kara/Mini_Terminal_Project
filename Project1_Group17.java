import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class Project1_Group17
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
                    break;
                case "B":
                    break;
                case "C":
                    Cryption();
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
    public static void Cryption()
    {
        
        String selection;
        Scanner input = new Scanner(System.in);
        cls();
        while(true)
        {
            printCrypOptions();
            selection = input.nextLine();
            selection = selection.toUpperCase();
            while (!isValidEntry(selection, "A","B","C"))
            {
                cls();
                System.err.println("\n\n        INVALID ENTRY!!");
                printCrypOptions();
                selection = input.nextLine();
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
    public static void Encryption(int x)
    {
        String victim; // The message
        int key; 
        Scanner input = new Scanner(System.in);
        do
        {
            System.out.print("\n        Please enter your message: ");
            victim = input.nextLine();
            System.out.print("\n        Please enter the key[-26,26]: ");
            key = input.nextInt();
            input.nextLine();

        } while ((key < -26 || key > 26) || victim.equals(""));
        // Multiply by x, to decide if the request is encryption or decryption
        key = key * x;
        // Managing negative keys by modulo and adding 26
        if (key < 0) {
            key = (key % 26 + 26) % 26; // now, they are positive
            key = key % 26;  // positivie keys are already correct
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
                newarr[i] = che;  // nonalphabetic, remains
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
        input.nextLine();
        cls();
        return;
    }
    // ----------------------------------------------------------------------------------------

}
