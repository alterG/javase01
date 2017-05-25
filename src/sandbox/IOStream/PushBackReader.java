package sandbox.IOStream;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * Example of PushbackReader
 * Created by alterG on 25.05.2017.
 */
public class PushBackReader {
    public static void main(String[] args) throws IOException {
        String s = "if (a == 4) a = 0\n";
        char[] buf = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);
        CharArrayReader ca = new CharArrayReader(buf);
        PushbackReader reader = new PushbackReader(ca);
        for (int i = 0; i < buf.length; i++) {
            char k = (char) reader.read();
            switch (k) {
                case '=':
                    if ((k = (char) reader.read()) == '=') System.out.print(".eq.");
                    else {
                        System.out.print("<-");
                        reader.unread(k);
                    }
                    break;
                default:
                    System.out.print(k);
            }
        }

    }
}
