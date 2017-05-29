package module4.t03;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * Условие:
 * Дан файл, содержащий буквы текст на кириллице. Кодировка файла utf-8. Прочитайте
 * информацию из файла и перепишите ее в файл в кодировкой utf-16.
 * Created by alterG on 29.05.2017.
 */
public class CharsetCoder {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Неправильный ввод аргументов.");
            usage();
            return;
        }
        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);
        checkFiles(inputFile, outputFile);
        Charset inputCharset = StandardCharsets.UTF_8;
        Charset outputCharset = StandardCharsets.UTF_16;
        recodeToCharset(inputFile, inputCharset, outputFile, outputCharset);
        System.out.println(String.format("Файл %s успешно перекодирован в UTF-16 (%s)", inputFile, outputFile));
    }

    public static void recodeToCharset(File inputFile, Charset inputCharset, File outputFile, Charset outputCharset) throws IOException {
        String inputFileContent = readFile(inputFile, inputCharset);
        writeFile(inputFileContent, outputFile, outputCharset);
    }

    private static void usage() {
        System.out.println("Формат ввода java inputfile outputfile.");
    }

    private static void checkFiles(File inputFile, File outputFile) {
        if (!inputFile.canRead()) {
            throw new IllegalArgumentException("Can't read file " + inputFile);
        }
        if (outputFile.exists() && !outputFile.canWrite()) {
            throw new IllegalArgumentException("Can't write in a file " + outputFile);
        }
    }

    private static String readFile(File inputFile, Charset inputCharset) throws IOException {
        String result = new String(Files.readAllBytes(inputFile.toPath()), inputCharset);
        return result;
    }

    private static void writeFile(String content, File outputFile, Charset outputCharset) throws IOException {
        Files.write(outputFile.toPath(), content.getBytes(outputCharset));
    }
}
