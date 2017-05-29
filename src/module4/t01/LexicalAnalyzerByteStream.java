package module4.t01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Условие:
 * Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова
 * языка Java это код содержит. Выведите эти слова и их количество в другой файл. Используйте
 * только байтовые потоки ввода-вывода.
 * Created by alterG on 25.05.2017.
 */
public class LexicalAnalyzerByteStream {
    private static final String pathToKeywords = "keywordsjava.txt";
    private static final File inputFile = getResourceAsFile("Main.java");
    private static final File outputFile = getOutputFile("out.txt");

    public static final void main(String[] args) throws IOException {
        checkFiles(inputFile, outputFile);
        Set<String> javaKeyWordsSet = getJavaKeywordsSetFormFile(pathToKeywords);

        // Read file with java code
        FileInputStream inputFileStream = new FileInputStream(inputFile);
        byte[] inputBuffer = new byte[(int) inputFile.length()];
        inputFileStream.read(inputBuffer);
        inputFileStream.close();
        String[] words = (new String(inputBuffer).split("[^a-zA-Z]+")); // Get only words

        // Fill map with java keywords
        Map<String, Integer> inputFileKeywordsMap = new HashMap<>();
        for (String word : words) {
            if (javaKeyWordsSet.contains(word)) {
                inputFileKeywordsMap.merge(word, 1, Integer::sum);
            }
        }

        // Get sorted array of map's entry
        Entry[] result = getEntryArray(inputFileKeywordsMap);

        // Write result in a file
        FileOutputStream outputFileStream = new FileOutputStream(outputFile);
        StringBuilder outputString = new StringBuilder("Количество ключевых слов в файле "+inputFile.getName()+"\n");
        for (Entry entry : result) {
            outputString.append(entry.toString()+"\n");
        }
        outputFileStream.write(outputString.toString().getBytes());
        outputFileStream.close();
        System.out.println(String.format("Анализ ключевых слов в файле %s успешно записан в %s", inputFile.getName(), outputFile.getName()));
    }

    public static Set<String> getJavaKeywordsSetFormFile(String path) throws IOException {

        String result = readByteFile(path);
        Set<String> set = new HashSet<>();
        String[] keyWords = result.split("[,\\s]+");
        set.addAll(Arrays.asList(keyWords));
        return set;
    }

    private static String readByteFile(String path) throws IOException {
        final File javaKeywordsFile = getResourceAsFile(path);
        FileInputStream in = new FileInputStream(javaKeywordsFile);
        byte[] inputArray = new byte[(int) javaKeywordsFile.length()];
        in.read(inputArray);
        in.close();
        return new String(inputArray);
    }


    public static Entry[] getEntryArray (Map<String, Integer> map) {
        Entry[] result = new Entry[map.size()];
        int i = 0;
        for (String key : map.keySet() ) {
            result[i++] = new Entry(key, map.get(key));
        }
        Arrays.sort(result, Comparator.reverseOrder());  //descending order
        return result;
    }

    /*
    Need to be in subdirectory of package instead of root directory
     */
    private static File getOutputFile(String path) {
        Class<LexicalAnalyzerByteStream> cl = LexicalAnalyzerByteStream.class;
        String pathname = ".\\src\\" + cl.getPackage().getName().replaceAll("\\.", "\\\\") + "\\" + path;
        return new File(pathname);
    }

    private static File getResourceAsFile(String path) {
        Class<LexicalAnalyzerByteStream> cl = LexicalAnalyzerByteStream.class;
        return new File(cl.getResource(path).getFile());
    }

    /*
    Function is used as example of correct error describing
    There is no reason to use it here
     */
    private static void printUsage() {
        System.out.println(String.format("File (variable = pathToKeywords) consists java keywords."));
    }

    /*
    There is no reason to use it
    */
    private static final void checkFiles(File inputFile, File outputFile) {
        if (!inputFile.canRead()) {
            throw new IllegalArgumentException("Can't read file " + inputFile);
        }
        if (outputFile.exists() && !outputFile.canWrite()) {
            throw new IllegalArgumentException("Can't write file " + outputFile);
        }
    }
}
