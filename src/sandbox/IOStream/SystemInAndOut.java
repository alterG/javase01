package sandbox.IOStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Example of stream redirection
 * Created by alterG on 25.05.2017.
 */
public class SystemInAndOut {
    public static void main(String[] args) throws IOException {
        OutputStream out = System.out;
        out.write(104);     //ASCII 'h'
        out.flush();
        out.write('\n');
        byte[] b = new byte[5];
        InputStream in = System.in;
        in.read();
        System.out.write(b);
        System.out.write('\n');
        System.out.flush();
        InputStream in2 = System.in;
        System.out.println(in2.available());
        byte[] b2 = new byte[in2.available()];
        for (int i = 0; i < b2.length; i++) {
            b2[i] = (byte) in2.read();
        }
        System.out.println(b2[0]+" "+b[1]);
        System.out.flush();
    }
}
