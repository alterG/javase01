package sandbox.IOStream;

import java.io.*;

/**
 * New methods: ready, write(String), skip
 * Created by alterG on 25.05.2017.
 */
public class CharStreams {
    public static void main(String[] args) throws IOException {

//        String example = "abcdefghikl";
//        char[] a = new char[example.length()];
//        example.getChars(0, example.length(), a, 0);
//        CharArrayReader reader1 = new CharArrayReader(a);
//        CharArrayReader reader2 = new CharArrayReader(a, 0,4);
//        int k;
//        while ((k=reader1.read()) != -1) {
//            reader1.skip(1);
//            System.out.println((char)k);
//        }
//        while (reader2.ready()) {
//            System.out.println((char)reader2.read());
//        }

//        Using adapter for write text as bytes
//        String path ="";
//        Writer writer = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(path)));


        BufferedReader reader3 = new BufferedReader(getResource("PushBackReader"));
        String s;
        while ((s = reader3.readLine()) != null) {
            System.out.println(s);
        }
        reader3.close();
    }

    private static InputStreamReader getResource(String path) {
        Class<CharStreams> cl = CharStreams.class;
        return new InputStreamReader (cl.getResourceAsStream(path));
    }
}
