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
                    Objective2();
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
    public static void Objective2()
    {
        cls();
        Scanner scanB = new Scanner(System.in);
        System.out.println("Objective 2");
        System.out.println("------------");
        System.out.println("-> In this objective, you can perform the matrix operations listed below\n");
        printMatrixOptions();
        String input = scanB.nextLine();
        while (!isValidEntry(input, "1","2","3","4","5"))
        {
            cls();
            System.err.println("\n\n        INVALID ENTRY!!");
            printMatrixOptions();
            input = scanB.nextLine();
        }

        switch (input)
        {
            case "1":
                transposeMatrix();
                break;
            case "2":
                inverseMatrix();
                break;
            case "3":
                multiplicationMatrix();
                break;
            case "4":
                elementMultiplication();
                break;
            case "5":
                returnHomePage();
        }
    }
    public static void printMatrixOptions()
    {
        System.out.println("IMPORTANT NOTES");
        System.out.println("----------------");
        System.out.println("*  Option 2 (Inverse) requires a square matrix.\n");
        System.out.println("*  Option 3 (Matrix Multiplication): The second matrix's row size will match the first matrix's column size automatically for compatibility.\n\n\n\n");
        System.out.println("        1)   Transpose of a matrix\n");
        System.out.println("        2)   Inverse of a matrix\n");
        System.out.println("        3)   Matrix Multiplication\n");
        System.out.println("        4)   Element-wise multiplication\n");
        System.out.println("        5)   EXIT TO HOMEPAGE\n\n\n");
        System.out.print("        Please select an option from the list above(1-5)): ");
    }
    
    public static void transposeMatrix()
    {
        int row = takeInputOfRowAndColumn("number of ROWS");
        int col = takeInputOfRowAndColumn("number of COLUMNS");

        double[][] matrix = new double[row][col];

        fillMatrix(matrix, row, col);
        cls();
        printMatrix(matrix, row, col);
        printTranspose(matrix, row, col);
        if (loopAsk())
        {
            loadingPage();
            transposeMatrix();
        }
        else
        {
            loadingPage();
            Objective2();
        }
    }
    public static int takeInputOfRowAndColumn(String s)
    {
        cls();
        Scanner scan = new Scanner(System.in);
        System.out.printf("\nEnter a value for %s (between 1-5): ", s);
        String val = scan.nextLine();
        while (!isValidEntry(val, "1","2","3","4","5"))
        {
            cls();
            System.err.println("        INVALID ENTRY!!");
            System.out.printf("\nEnter a value for %s (between 1-5): ", s);
            val = scan.nextLine();
        }
        return strToInt(val);
    }
    public static void fillMatrix(double[][] mat, int row, int col)
    {
        cls();
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                cls();
                System.out.printf("Please enter a number for ROW: %d  and COLUMN: %d\n\n", i+1, j+1);
                System.out.print("Your value (data type is double): ");
                String val = input.nextLine();
                while (val.isEmpty() || !isValidDouble(val)) 
                {
                    cls();
                    System.err.println("\n\nINVALID ENTRY!!\n");
                    System.out.printf("Please enter a number for ROW: %d  and COLUMN: %d\n\n", i+1, j+1);
                    System.out.print("Your value (data type is double): ");
                    val = input.nextLine();
                }
                mat[i][j] = Double.parseDouble(val);
            }
        }
    }
    public static void printMatrix(double[][] mat, int row, int col)
    {
        System.out.printf("\n\nYour %d x %d Matrix:\n", row, col);
        System.out.println("=".repeat((col * 8)+3));
    
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                System.out.printf("%7.2f ", mat[i][j]); // 7 spaces wide and 2 decimal places
            }
            System.out.println();
        }
    
        System.out.println("=".repeat((col * 8)+3) + "\n"); // Bottom divider line
    }  
    public static void printTranspose(double[][] mat, int row, int col)
    {
        System.out.printf("\n\nTranspose of Your %d x %d Matrix:\n", row, col);
        System.out.println("=".repeat((row * 8)+3));

        for (int i = 0; i < col; i++)
        {
            for (int j = 0; j < row; j++)
            {
                System.out.printf("%7.2f ", mat[j][i]); // 7 spaces wide and 2 decimal places
            }
            System.out.println();
        }
    
        System.out.println("=".repeat((row * 8)+3) + "\n");
    }
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


    public static void inverseMatrix()
    {
        int row = takeInputOfRowAndColumn("both number of ROWS and COLUMNS");
        
        double matrix[][] = new double[row][row];

        fillMatrix(matrix, row, row);
        cls();
        printMatrix(matrix, row, row);
        printInverse(matrix);

        if (loopAsk())
        {
            loadingPage();
            inverseMatrix();
        }
        else
        {
            loadingPage();
            Objective2();
        }
    }
    public static void printInverse(double[][] mat)
    {
        double determinant = determinant(mat);
        
        if (determinant == 0.0)
        {
            System.err.println("\n\nSingular matrices (determinant = 0) does not have an inverse!!\n");
        }
        else if (mat.length == 1)
        {
            System.out.printf("\n\nInverse of Your %d x %d Matrix:\n", mat.length, mat[0].length);
            System.out.println("=".repeat((mat.length * 8)+3));
            System.out.printf("%7.2f \n", mat[0][0]);
            System.out.println("=".repeat((mat.length * 8)+3) + "\n");
        }
        else
        {
            // create the adjoint matrix by taking the transpose of the cofactor matrix
            double[][] cofactorMatrix = cofactorMatrix(mat);
            double[][] adjointMatrix = returnTranspose(cofactorMatrix);
            
            // use the formula to derive the inverse of the matrix (Inverse Matrix = Adjoint Matrix . 1/determinant)
            matrixMultWithConstant(adjointMatrix, 1.0 / determinant);
            
            // print the inverse matrix
            System.out.printf("\n\nInverse of Your %d x %d Matrix:\n", mat.length, mat[0].length);
            System.out.println("=".repeat((adjointMatrix.length * 8)+3));

            for (int i = 0; i < adjointMatrix.length; i++)
            {
                for (int j = 0; j < adjointMatrix[0].length; j++)
                {
                    System.out.printf("%7.2f ", adjointMatrix[i][j]); // 7 spaces wide and 2 decimal places
                }
                System.out.println();
            }
        
            System.out.println("=".repeat((adjointMatrix.length * 8)+3) + "\n");
        }
    }



    // Calculates the determinant of the square rxr matrix recursively
    // O(r) space complexity and O(n) time complexity where r=row number and n=number of elements in matrix(r^2)
    public static double determinant(double[][] mat)
    {
        // base cases for 1x1 and 2x2 matrices
        int n = mat.length;
        if (n == 1)
            return mat[0][0];
        else if (n == 2)
            return mat[0][0]*mat[1][1] - mat[0][1]*mat[1][0];

        double ans = 0;

        // iterate through each element in the first row
        for (int i = 0; i < n; i++)
        { 
            // Create a submatrix called "newMat" by excluding the current element's row and column
            // "newMat" will have dimensions (n-1)x(n-1)
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
            // determinant calculation formula. In the recurisve call, the skipRow index is 0 because newMat has new dimensions and it must start from 0
            ans += Math.pow(-1, i)*mat[0][i]*determinant(newMat);
        }
        return ans;
    }

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

    public static void matrixMultWithConstant(double mat[][], double x)
    {
        int row = mat.length;
        int col = mat[0].length;
        
        if (row == 0 || col == 0)
        {
            //System.out.print("Please enter a matrix that is not null");
            return;
        }

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                mat[i][j] *= x;
            }
        }
    }
    
    public static void multiplicationMatrix()
    {
        
        //Enter the first matrix row1, col1
        int row1 = takeInputOfRowAndColumn("Number of ROWS: ");
        int col1 = takeInputOfRowAndColumn("Number of COLUMNS: ");
        
        //initialize double Mat1[row1][col1];
        double[][] Mat1 = new double[row1][col1];
        
        //accept values to the matrix:
        fillMatrix(Mat1, row1, col1);

        //cls();
        //Enter the second object Mat2[row2][col2]
        int row2 = takeInputOfRowAndColumn("Number of ROWS: ");
        int col2 = takeInputOfRowAndColumn("Number of COLUMNS: ");

        double[][] Mat2 = new double[row2][col2];

        fillMatrix(Mat2, row2, col2);
        //!!!!This part is skipped
        //cls();
            //if constant: matrixMultWithConstant(multMat)
        
        if(isNotValidMult(col1, row2))
        {
            
            /*if(row2 == 1 && col2 == 1)//Matrix . constant
            {
                //not printing the output
                matrixMultWithConstant(Mat1, Mat2[0][0]);
                printMatrices(Mat1, row1, col1);
                
            }*/
            //Matrix . Matrix
            double[][] resultant = multiplyMat(Mat1, row1, col1, Mat2, row2, col2);
            System.out.println("Result of Matrix Multiplication: ");
            printMatrices(resultant, resultant.length, resultant[0].length);
            
            /* to matrix interface
            if(loopAsk())
                {
                    loadingPage();
                    transposeMatrix();
                }
                else
                {
                    loadingPage();
                    Objective2();
                }*/
        }
        else{
            System.out.println("The two matrices aren't multiplicable! Enter different sized matrices.");
            //Return to matrix interface
        }
            
    }
    public static double[][] multiplyMat(double[][] Mat1, int row1, int col1, double[][] Mat2, int row2, int col2)
    {

        //assign the result matrix, we can refrain from passing row, col variables by using .length utility
        double[][] result = new double[row1][col2];

        for(int i = 0; i < row1; i++)
        {
            for(int j = 0; j < col2; j++)
            {
                for(int k = 0; k < row2; k++)
                {
                    result[i][j] += Mat1[i][k] * Mat2[k][j];
                }
            }
        }
        return result;
    }
    public static void printMatrices(double[][] mat, int row, int col)
    {
        System.out.println("=".repeat((col * 8)+3));
    
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                System.out.printf("%7.2f ", mat[i][j]); // 7 spaces wide and 2 decimal places
            }
            System.out.println();
        }
    
        System.out.println("=".repeat((col * 8)+3) + "\n"); // Bottom divider line
        
    }
    public static boolean isNotValidMult(int col1, int row2)
    {
        if(row2 != col1)
        {
            System.out.println("\nMultiplication is not possible, you can try by switching places of matrices");
            return false;
        }

        return true;
    }
    public static void elementMultiplication()
    {
       double[][] Mat1 = InitializeMatrix();
       double[][] Mat2 = Mat1;

       int row = Mat1.length;
       int col = Mat1[0].length;

        fillMatrix(Mat1, row, col);

        fillMatrix(Mat2, row, col);

        double[][] result = new double[row][col];
    
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; i < col; j++)
            {
                result[i][j] = Mat1[i][j] * Mat2[i][j];
            }
        }

        printMatrices(result, row, col);
        //Flow control goes here..

    }
    public static double[][] InitializeMatrix()
    {  
        int row = takeInputOfRowAndColumn("ROWS");
        int col = takeInputOfRowAndColumn("COLS");
        double [][] Mat = new double[row][col];
        return Mat;
    }
    
}
