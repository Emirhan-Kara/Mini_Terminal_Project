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
    public static void greetingPage() {
        String[] part1 = {
            "____    __    ____  _______  __        ______   ______   .___  ___.  _______      _______ __   ______",
            "\\   \\  /  \\  /   / |   ____||  |      /      | /  __  \\  |   \\/   | |   ____|    /  _____/_ | |____  |",
            " \\   \\/    \\/   /  |  |__   |  |     |  ,----'|  |  |  | |  \\  /  | |  |__      |  |  __  | |     / / ",
            "  \\            /   |   __|  |  |     |  |     |  |  |  | |  |\\/|  | |   __|     |  | |_ | | |    / /  ",
            "   \\    /\\    /    |  |____ |  `----.|  `----.|  `--'  | |  |  |  | |  |____    |  |__| | | |   / /   ",
            "    \\__/  \\__/     |_______||_______| \\______| \\______/  |__|  |__| |_______|    \\______| |_|  /_/    ",
            "                                                                                                       "
        };
    
        String[] part2 = {
            " _______ .___  ___.  __  .______       __    __       ___      .__   __.     __  ___      ___      .______          ___           ___ __      ___",
            "|   ____||   \\/   | |  | |   _  \\     |  |  |  |     /   \\     |  \\ |  |    |  |/  /     /   \\     |   _  \\        /   \\         /  /|  |     \\  \\ ",
            "|  |__   |  \\  /  | |  | |  |_)  |    |  |__|  |    /  ^  \\    |   \\|  |    |  '  /     /  ^  \\    |  |_)  |      /  ^  \\       |  | |  |      |  |",
            "|   __|  |  |\\/|  | |  | |      /     |   __   |   /  /_\\  \\   |  . `  |    |    <     /  /_\\  \\   |      /      /  /_\\  \\      |  | |  |      |  |",
            "|  |____ |  |  |  | |  | |  |\\  \\----.|  |  |  |  /  _____  \\  |  |\\   |    |  .  \\   /  _____  \\  |  |\\  \\----./  _____  \\     |  | |  `----. |  |",
            "|_______||__|  |__| |__| | _| `._____||__|  |__| /__/     \\__\\ |__| \\__|    |__|\\__\\ /__/     \\__\\ | _| `._____/__/     \\__\\    |  | |_______| |  |",
            "                                                                                                                               \\__\\         /__/  "
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
        for (String line : part1) System.out.println(line);
        beklermisin();
        for (String line : part2) System.out.println(line);
        beklermisin();
        for (String line : part3) System.out.println(line);
        beklermisin();
        for (String line : part4) System.out.println(line);
        beklermisin();
        for (String line : part5) System.out.println(line);
        beklermisin();
        for (String line : part6) System.out.println(line);
        cls();
        for (String line : part1) System.out.println(line);
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
}
