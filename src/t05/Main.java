package t05;

/**
 * Created by alterG on 23.04.2017.
 */
public class Main {

    public static void main(String[] args) {
        char[][] matrix = getMatrix();
        printMatrix(matrix);
    }

    private static char[][] getMatrix() {
        char[][] matrix = new char[6][7];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 3 && j == 3) {
                    matrix[i][j] = 'O';
                } else if (i > 3 && (i == (j-1) || (i == (matrix[0].length-j-2))) ) {
                    matrix[i][j] = '1';
                } else if (j == 3) {
                    matrix[i][j] = 'Ʌ';
                } else if (i == 3) {
                    matrix[i][j] = 'M';
                } else if (i < 4 && (i == j || i == (matrix[0].length-j-1)) ) {
                    matrix[i][j] = '1';
                } else {
                    matrix[i][j] = '0';
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
