package sandbox.StringMethods.Codepoint;

/**
 * Created by alterG on 20.05.2017.
 */
public class Codepoint {
    public static void main(String[] args) {

//        Create string from codepoints
        int[] A = {0xf402, 0x5301};
        String s = new String(A, 0, A.length);

//      String str = "russ";     getBytes().length = 4*2 (utf-16?)
//      String str = "engl";     getBytes().length = 4*1 (utf-8?)
        String str = "漢字汉字"; // getBytes().length = 4*3 (utf-32 + compressed string?)

        System.out.println("String: " + str);
        System.out.println("String length: " + str.length());
        System.out.println("String length in bytes: " + str.getBytes().length);
        System.out.println("String length in code points: " + str.codePointCount(0, str.length())); // equal number of chars

        for (int i = 0; i < str.codePointCount(0, str.length()); i++) {
            int index = str.offsetByCodePoints(0, i);  // position in string (index+offset) in code points (or chars)
            int code = str.codePointAt(index); // code point (number instead of char) at given index
            char symbol = (char) code; // char from given code point
            System.out.println(i+" symbol is code: "+Integer.toHexString(code)+" equal: "+symbol);
        }
      
    }
}
