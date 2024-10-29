import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;

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
                    cls();
                    welcometoxox();
                    startxox();
                    break;
                case "E":
                    input.close();
                    exitPage();
                    return;
            }
        }
    }

    /**
     * GREETING PAGE
     * NO PARAMETERS
     * @author Emirhan Hayrunnisa
     * 
     */

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
    /**
     * @author Emirhan
     * Shows options of applivation
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
     * @author Hayrunnisa
     * @param NO PARAMETER
     * Visualization of sections for C
     */
    public static void printCrypOptions()
    {
        System.out.println("        A)   Encryption\n");
        System.out.println("        B)   Decryption\n");
        System.out.println("        C)   Return to the Main Menu\n");
        System.out.print("        Please select an option from the list above(A-C)): ");
    }
    /**
     * @author Emirhan Hayrunnisa 
     * @param ans
     * @param Check
     * @return true/false according to correctness of the input 
     * Method takes options and input as parameter 
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
     * @author Emirhan
     * Cleans terminal
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
     * @author Emirhan
     * Clear screen, simulate a return to home, displays a " . " in every 500 ms
     * @throw if interrupted, it catches an default exception
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
     * @author Emirhan
     * logic same as the previous one string is differ
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
    // ----------------------------------------------------------------------------------------
    /**
     * @author Hayrunnisa
     * Simulates an ascıı art entrance for the game
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
         * @throws if an exception occurs during execution
         */
        for (String satır : lines) {
            System.out.println(satır);
            try {
                Thread.sleep(10);  // Her satır arasında 0.01 saniye bekle
            } catch (InterruptedException e) {
                System.out.println("Interruption cut: " + e.getMessage());
                Thread.currentThread().interrupt();  // İş parçacığının kesildiğini bildirir
            }
        }
        beklermisin();
    }
    /**
     * @author Hayrunnisa
     * To give an significant visualizement to user in the some part of program
     * it waits for 1 sec
     */
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
    /**
     * @author Hayrunnisa
     * @param choice -> is the person who is the next 
     * represents the user next and remains 1.2 sec
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
        if('X' == choice) {
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
            Thread.currentThread().interrupt();  // İş parçacığının kesildiğini bildirir
        }
        cls();
    }
    /**
     * @author Hayrunnisa, Zaid
     * XOX STARTS
     * starts with an empty board
     * prints the board on terminal each time
     * X starts
     * if the turn number smaller then 4 it does not check if there is a winner or not
     * About selecting a block:
     * they cannot choose a block that does not exist or full
     * Flag: follows the progress of the game. 
     * Counter: total of the turns.
     * isValid: indicates input
     * 
     * 
     */
    public static void startxox()
    {
        Scanner input = new Scanner(System.in);
        char paper[][] = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        char turn = 'X';
        short counter = 0;
        int row, col;
        boolean isValid = false;
        boolean flag = true;
        while(flag)
        {
            printNext(turn);
            printPaper(paper);
            do {
                try 
                {
                    System.out.println();
                    System.out.printf("\nPlease select a row %c [0,2]: ",turn);
                    row = input.nextInt();
                    System.out.print("\nPlease select a column [0,2]: ");
                    col = input.nextInt();
                    input.nextLine();  // Buffer temizleme
                    cls();
                    if(row < 3 && row > -1 && col < 3 && col > -1 && paper[row][col] == ' ')
                    {
                        cls();
                        isValid = true;
                        paper[row][col] = turn;
                        counter ++;
                        if(counter > 4 && Over(paper, turn))
                        {
                            flag = false; // GAME OVER
                            System.out.printf("                     %c WON IN %d TURNS                                                 \n\n",turn,counter);
                            System.out.println(" __        ___                                  _                       ");
                            System.out.println(" \\ \\      / (_)_ __  _ __   ___ _ __  __      _(_)_ __  _ __   ___ _ __ ");
                            System.out.println("  \\ \\ /\\ / /| | '_ \\| '_ \\ / _ \\ '__| \\ \\ /\\ / / | '_ \\| '_ \\ / _ \\ '__|");
                            System.out.println("   \\ V  V / | | | | | | | |  __/ |     \\ V  V /| | | | | | | |  __/ |   ");
                            System.out.println("    \\_/\\_/  |_|_| |_|_| |_|\\___|_|      \\_/\\_/ |_|_| |_|_| |_|\\___|_|   ");
                            System.out.println("  ___| |__ (_) ___| | _____ _ __     __| (_)_ __  _ __   ___ _ __      ");
                            System.out.println(" / __| '_ \\| |/ __| |/ / _ \\ '_ \\   / _` | | '_ \\| '_ \\ / _ \\ '__|     ");                                System.out.println("| (__| | | | | (__|   <  __/ | | | | (_| | | | | | | | |  __/ |        ");
                            System.out.println(" \\___|_| |_|_|\\___|_|\\_\\___|_| |_|  \\__,_|_|_| |_|_| |_|\\___|_|         \n");     
                        }
                        else if(counter == 9 && !Over(paper,turn))
                        {
                            System.out.printf("\n DRAW!\n");
                            flag = false; // GAME OVER
                        }
                        
                        printPaper(paper);
                        turn = ( turn == 'X') ? 'O' : 'X';   
                    }
                    else System.out.print("\nYou Can't Choose This Block\n");
                } catch (InputMismatchException e) {
                    cls();
                    System.out.println("Invalid input. Please enter an valid **INTEGER**.");
                    input.nextLine();  // Scanner cleans non-integer input
                }
            } while (!isValid);

            if(!flag)
            {
                System.out.println();
                System.out.println("\n PLAY AGAIN [0]");
                System.out.println("\n RETURN MAIN MENU [1]");
                try {
                    int exit;
                    exit = input.nextInt();
                    if(exit == 0)
                    {
                        cls();
                        startxox();
                    }
                    else{
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
        }

           
    }
    /**
     * @author Hayrunnisa , Zaid
     * @param paper , current board
     * @param turn , indicates who's turn
     * @return if it is a winning situation return true
     * checks the moves
     */
    public static boolean Over(char paper[][], char turn)
    {
        //cross control
        if (paper[0][0] == turn && paper[1][1] == turn && paper[2][2] == turn)
            return true;
        if (paper[0][2] == turn && paper[1][1] == turn && paper[2][0] == turn)
            return true;
        for(short i = 0; i<3; i++)
        {
            if(paper[0][i] == turn && paper[1][i] == turn && paper[2][i] == turn)
                return true;
            if(paper[i][0] == turn && paper[i][1] == turn && paper[i][2] == turn)
                return true;
        }            
        return false;
    }
    /**
     * @author Zaid, Hayrunnisa
     * Prints the board
     * @param paper, the board
     */
    public static void printPaper(char paper[][])
    {
        for(short i = 0; i<3; i++)
        {
            for(short j = 0; j<3; j++)
            {
                System.out.print(paper[i][j]);
                if(j<2)
                {
                    System.out.print(" | ");
                }
            }
            if(i<2)
                {
                    System.out.println();
                    System.out.println("---------");
                } 
        }
        System.out.println();
    }
}
