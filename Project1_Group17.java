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
            greetingPage();
            printOptions();
            selection = input.nextLine();
            while (!isValidEntry(selection))
            {
                cls();
                System.err.println("\n\n        INVALID ENTRY!!");
                printOptions();
                selection = input.nextLine();
            }
            
            switch (selection)
            {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
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
        System.out.println("        1)   Statistical Information about an array\n");
        System.out.println("        2)   Matrix Operations\n");
        System.out.println("        3)   Text Encryption/Decryption\n");
        System.out.println("        4)   Tic-tac-toe HotSeat\n");
        System.out.println("        5)   EXIT\n\n\n");
        System.out.print("        Please select an option from the list above(1-5): ");
    }
    public static boolean isValidEntry(String ans)
    {
        // .equals method must be used. Because when we use ==, it compares the their memory references
        if (ans.equals("1") || ans.equals("2") || ans.equals("3") || ans.equals("4") || ans.equals("5"))
            return true;
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
    // ----------------------------------------------------------------------------------------
}
