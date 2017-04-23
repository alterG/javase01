package t03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by alterG on 23.04.2017.
 */


public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double leftBorder, rightBorder, step;
        while (true) {
            try {
                System.out.print("Type left border = ");
                leftBorder = Double.parseDouble(reader.readLine());
                System.out.print("Type right border = ");
                rightBorder = Double.parseDouble(reader.readLine());
                System.out.print("Type step = ");
                step = Double.parseDouble(reader.readLine());
                System.out.printf("Function: 2*tg(x)-3 from [%f;%f] step is %f\n", leftBorder, rightBorder, step);
                break;
            } catch (Exception e) {
                System.out.println("Please type numbers.");
            }
        }
        printTable(leftBorder, rightBorder, step);
    }

    /**
     * print table with values of function 2*tg(x)-3
     */
    private static void printTable(double leftBorder, double rightBorder, double step) {
        System.out.printf("|----------------------|\n" +
                          "|     x    |     y     |\n" +
                          "|----------------------|\n");
        for (double h = leftBorder; h <= rightBorder; h+=step) {
            System.out.printf("| %5f | % 5f |\n|----------------------|\n", h, 2*Math.tan(h)-3);
        }
    }

}
