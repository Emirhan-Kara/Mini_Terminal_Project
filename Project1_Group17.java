import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        cls();
        String selection;
        Scanner input = new Scanner(System.in);
        while (true) {
            cls();
            greetingPage();
            printOptions();
            selection = input.nextLine();
            selection = selection.toUpperCase();
            while (!isValidEntry(selection, "A", "B", "C", "D", "E")) {
                cls();
                System.err.println("\n\n        INVALID ENTRY!!");
                printOptions();
                selection = input.nextLine();
                selection = selection.toUpperCase();
            }

            switch (selection) {
                case "A":
                    break;
                case "B":
                    break;
                case "C":
                    break;
                case "D":
                    playTicTacToe(); // Call the Tic-Tac-Toe game method
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
        System.out.println("         _       _         _                                   ");
        System.out.println("        ( )  _  ( )       (_ )                                 ");
        System.out.println("        | | ( ) | |   __   | |    ___    _     ___ ___     __  ");
        System.out.println("        | | | | | | /'__`\\ | |  /'___) /'_`\\ /' _ ` _ `\\ /'__`\\ ");
        System.out.println("        | (_/ \\_) |(  ___/ | | ( (___ ( (_) )| ( ) ( ) |(  ___/ ");
        System.out.println("        `\\_______/'`\\____)(___)`\\____)`\\___/'(_) (_) (_)`\\____) \n\n");
    }

    public static void printOptions() {
        System.out.println("        A)   Statistical Information about an array\n");
        System.out.println("        B)   Matrix Operations\n");
        System.out.println("        C)   Text Encryption/Decryption\n");
        System.out.println("        D)   Tic-tac-toe HotSeat\n");
        System.out.println("        E)   EXIT\n\n\n");
        System.out.print("        Please select an option from the list above(A-E)): ");
    }

    public static boolean isValidEntry(String ans, String... Check) {
        for (String c : Check) {
            if (c.equals(ans))
                return true;
        }
        return false;
    }

    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows")) // For Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else // For Linux and MacOS
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.err.println("Error on cls!!!!");
        }
    }

    public static void exitPage() {
        cls();
        System.out.println("Exiting from the program");
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(".");
                Thread.sleep(500);
            }
            System.out.println("\n\nEXIT! SEE YOU NEXT TIME\n");
        } catch (InterruptedException e) {
            System.out.println("Error! Returning Now");
        }
    }

    // Tic-Tac-Toe Game Logic
    public static void playTicTacToe() {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
    
        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        int moves = 0; // Track the number of moves for checking tie
    
        while (!gameOver  ) { // Continue till game over or all moves are made
            printBoard(board);
            System.out.print("\n Player " + player + " enter row and column (0, 1, or 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            System.out.println();
    
            // Check for valid row and column input
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid position. Please enter row and column between 0 and 2.");
                continue;
            }
    
            if (board[row][col] == ' ') {
                board[row][col] = player; // place the element
                moves++; // increment moves
                gameOver = haveWon(board, player);
                
                // Debugging statements to track the game's state
                System.out.println("Current moves: " + moves);
                System.out.println("Game over status: " + gameOver);
                
                if (gameOver) {
                    printBoard(board);
                    System.out.println("Player " + player + " has won!");
                } else if (moves == 9) {
                    printBoard(board);
                    System.out.println("The game is a tie!");
                } else {
                    player = (player == 'X') ? 'O' : 'X'; // Switch player
                }
            } else {
                System.out.println("Invalid move. Try again!");
            }
        }
    }
    
    public static boolean haveWon(char[][] board, char player) {
        // Check the rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
    
        // Check for columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
    
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
    
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
    
    public static void printBoard(char[][] board) {
        System.out.print("\nTic-Tac-Toe !\n\n");
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}    