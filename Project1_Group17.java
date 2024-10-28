import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

public class Project1_Group17 {
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

    // MAIN METHODS FOR HOMEPAGE
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

    public static void returnHomePage() {
        cls();
        System.out.println("Returning to homepage");
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(".");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Error! Returning Now");
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

        while (!gameOver) { // Continue until game over or all moves are made
            cls(); // Clear the console for the current player's turn
            printBoard(board);
            System.out.print("\nPlayer " + player + ", enter row and column (0, 1, or 2): ");

            int row = -1;
            int col = -1;
            // Input handling
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                scanner.next(); // Clear invalid input
                continue; // Skip to the next iteration
            }

            // Check for valid row and column input
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid position. Please enter row and column between 0 and 2.");
                continue;
            }

            if (board[row][col] == ' ') {
                board[row][col] = player; // Place the element
                moves++; // Increment moves
                gameOver = haveWon(board, player);

                if (gameOver) {
                    cls(); // Clear console to display final board
                    printBoard(board);
                    System.out.println("Player " + player + " has won!");
                    pause(2000); // Pause for 2 seconds to allow the player to see the result
                } else if (moves == 9) {
                    cls(); // Clear console to display final board
                    printBoard(board);
                    System.out.println("The game is a tie!");
                    pause(2000); // Pause for 2 seconds to allow the player to see the result
                } else {
                    player = (player == 'X') ? 'O' : 'X'; // Switch player
                }
            } else {
                System.out.println("Invalid move. Try again!");
            }
        }

        returnHomePage(); // Return to the main menu after the game ends
    }

    // Method to pause execution for a specified number of milliseconds
    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Error in pause: " + e.getMessage());
        }
    }

    public static boolean haveWon(char[][] board, char player) {
        // Check rows for a win
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // Check columns for a win
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Check diagonals for a win
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public static void printBoard(char[][] board) {
        System.out.print("\nTic-Tac-Toe Board:\n");
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
                if (col < 2) System.out.print(" | "); // Print separator
            }
            System.out.println();
            if (row < 2) System.out.println("---------"); // Print row separator
        }
    }
}
