package task4;

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(final String[] args) {

        final int row1, col1, row2, col2;
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows in first matrix: ");
        row1 = scanner.nextInt();

        System.out.print("Enter number of columns in first matrix: ");
        col1 = scanner.nextInt();

        System.out.print("Enter number of rows in second matrix: ");
        row2 = scanner.nextInt();

        System.out.print("Enter number of columns in second matrix: ");
        col2 = scanner.nextInt();

        // !!!
        if (col1 != row2) {
            System.out.println("Multiplication is not possible");
            return;
        }

        final int a[][] = new int[row1][col1];
        final int b[][] = new int[row2][col2];
        final int c[][] = new int[row1][col2];

        // Input the values of matrices
        System.out.println("\nEnter values for matrix A : ");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++)
                a[i][j] = scanner.nextInt();
        }
        System.out.println("\nEnter values for matrix B : ");
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++)
                b[i][j] = scanner.nextInt();
        }

        // Matrix multiplication
        System.out.println("\nMatrix multiplication is : ");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                // Initialize the element C(i,j) with zero
                c[i][j] = 0;

                // Dot product calculation
                for (int k = 0; k < col1; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}

