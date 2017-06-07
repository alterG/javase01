package sandbox.IOStream.testconsole;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Example how to test console output
 * <p>
 * Created by alterG on 25.05.2017.
 */
public class ConsoleTest {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream console = System.out;       // we must save System.out
        System.setOut(ps);
        System.out.println("Print to out");
        System.out.println("Second print");
        String result = stream.toString();
        ps.close();
        stream.close();
        System.setOut(console);                 // return stream of console
        System.out.println(result);
    }
}
