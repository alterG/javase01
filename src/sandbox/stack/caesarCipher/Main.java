package sandbox.stack.caesarCipher;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by alterG on 25.05.2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        int OFFSET = 3;
        File pathIn = new File("");
        File pathOut = new File("");
        if (args.length == 3 && "-d".equals(args[0])) {
            OFFSET=-OFFSET;
            pathIn = new File(args[1]);
            pathOut = new File(args[2]);
        } else if (args.length == 2) {
            pathIn = new File(args[0]);
            pathOut = new File(args[1]);
        } else {
            System.out.println("Неверный формат запуска. Требуется: java [-d] inputfile outputfile.");
            System.exit(0);
        }
        System.out.println(pathIn);
        System.out.println(pathOut);
//        Недостаток в том, что весь файл считывается полностью, а не построчно. А он может быть большим. Лучше обрабатывать по строкам или байтам.
        String s = new String(Files.readAllBytes(Paths.get(pathIn.toString())), StandardCharsets.UTF_8);
        FileWriter writer = new FileWriter(pathOut);
        writer.write(encrypt(s, OFFSET));
        writer.close();
    }

    public static String encrypt(String source, int offset) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            output.append((char) (source.charAt(i) + offset));
        }
        return output.toString();
    }

    private static InputStreamReader getResource(String path) {
        Class<Main> cl = Main.class;
        return new InputStreamReader(cl.getResourceAsStream(path));
    }
}
