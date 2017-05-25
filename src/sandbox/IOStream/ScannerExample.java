package sandbox.IOStream;

import java.util.Locale;
import java.util.Scanner;

/**
 * Scanner can be created from classes implement Readable / ReadableByteChannel
 * Such as: File, InputStream, String, Readable, ReadableByteChannel
 * Note: dont forget to invoke scanner.close() to free his resources
 * Created by alterG on 25.05.2017.
 */
public class ScannerExample {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        example of scanner reading
//        1. boolean hasNext() or hasNextType()
//        2. Type nextType() or String next()
//        while (scan.hasNextInt()) {
//            int n = scan.nextInt();
//            System.out.println(scan.next());
//            System.out.println(scan.nextLine());
//        }
        scan.close();
        Scanner scan2 = new Scanner("1.3; 2,7 ; 4;3");
        scan2.useDelimiter("\\s*;\\s*");
//        in Russia float if divided by ',', in USA - '.'
        scan2.useLocale(Locale.US);
        double sum = 0;
        while(scan2.hasNext()) {
            if (scan2.hasNextDouble()) {
                sum+=scan2.nextDouble();
            } else {
                System.out.println(scan2.next());
            }
        }
        System.out.println("Double sum is "+sum);

//      Methods findInLine(pattern, range) and skip(pattern)
        String example = "Name: Joe Age: 28 ID: 77";
        Scanner scan3 = new Scanner(example);
//        get pattern and move mark after it
//        also exist skip(String pattern) to move mark (if no matches it throw NoSuchElementException)
        scan3.findInLine("Age");
        if (scan3.hasNext()) {
            System.out.println(scan3.next());
        } else {
            System.out.println("Error!");
        }
    }


}
