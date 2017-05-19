package sandbox.StringMethods;

import java.util.Arrays;

/**
 * demonstration how String methods work
 * Created by alterG on 19.05.2017.
 */
public class StringMethods {
    public static void main(String[] args) {
//        Delete spaces (also \n, \t) from start and end of line
        String a = "                " +
                "     so much spaces      ";
        System.out.println(a.trim());

//        Convert char array into string
        char[] bytes ={'a', 'b', 'c', 'd', 'e'};
        System.out.println(String.copyValueOf(bytes));

//        Substring
        String main = "There is some words";
        System.out.println(main.substring(9));

//        true if string (not part of it) is regular expression
        String b = "stop the agent 007 :)";
        System.out.println(b.matches("[\\w\\s]*\\d{3} :\\)"));

//        replace char to char, char sequence to char sequence, relevated (to regex) part to String
        String c = "Розовые зайцы глотают снег";
        System.out.println(c.replace("глотают","копают"));
        System.out.println(c.replaceFirst("о", "а"));
        System.out.println(c.replaceAll("\\b[а-я]{5}\\b", "розы"));

//       split string into array according to regex. \s+ - biggest sequence of whitespace separators
        String d = "Я ебашу     \t  пробелы   где \n  хочу";
        System.out.println(Arrays.toString(d.split("\\s+")));
    }

//      Output:
//      so much spaces
//      abcde
//      some words
//      true
//      Розовые зайцы копают снег
//      Разовые зайцы глотают снег
//      Розовые розы глотают снег
//      [Я, ебашу, пробелы, где, хочу]
}
