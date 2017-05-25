package sandbox.IOStream;

import java.io.*;
import java.util.Arrays;

/**
 * InputStream (IS): ByteArrayIS, FileIS, ObjectIS, DataIS, FilterIS, BufferedIS, SequenceIS, PipedIS
 * OutputStream is the same
 * Reader (R): CharArrayR, InputStreamR (adapter), FileR, BufferedR, PipedR, StringR
 * Writer is the same
 *
 * For working with memory: ByteArrayIS/CharArrayR, StringR
 * For pipe: PipedIS, PipedR
 * For files: FileR, FileIS
 * For serialization: ObjectIS
 *
 * Note: always close streams!
 * Created by alterG on 25.05.2017.
 */
public class ByteStreams {
    public static void main(String[] args) throws IOException {
//        ByteArrayInputStream str = new ByteArrayInputStream(new byte[]{1,3,5,6});
//        System.out.println(str.markSupported());
//        int[] s = new int[4];
//        s[0] = str.read();
//        int readlimit = 100;
//        str.mark(readlimit);
//        s[1] = str.read();
//        str.reset();
//        s[2] = str.read();
//        System.out.println(Arrays.toString(s));         // output: 1 3 3
//        byte[] a = new byte[5];
//        str.read(a,1,2);
//        System.out.println(Arrays.toString(a));
//        str.close();
//
//        int[] output = new int[10];
//        ByteArrayOutputStream out = new ByteArrayOutputStream(10);
//        out.write(a, 1, 2);
//        byte[] b = out.toByteArray();
//        out.close();
//        System.out.println(Arrays.toString(b));

//        PipedInputStream pipe1 = new PipedInputStream();
//        PipedOutputStream pipe2 = new PipedOutputStream();
//        pipe1.connect(pipe2);
//        for (int i = 0; i < 20; i++) {
//            pipe2.write(i);
//        }
//        int willRead = pipe1.available();
//        int[] toRead = new int [willRead];
//        for (int i = 0; i < willRead; i++) {
//            toRead[i] = pipe1.read();
//            System.out.println(toRead[i]);
//        }

        ByteArrayInputStream i1 = new ByteArrayInputStream(new byte[]{3,4,5,6});
        ByteArrayInputStream i2 = new ByteArrayInputStream(new byte[]{13,14,15,16});
        SequenceInputStream s = new SequenceInputStream(i1, i2);
        ByteArrayOutputStream o1 = new ByteArrayOutputStream(20);
        int readByte = s.read();
        while (readByte != -1) {
            o1.write(readByte);
            readByte = s.read();
        }
        o1.flush();
        System.out.println(Arrays.toString(o1.toByteArray()));

    }
}
