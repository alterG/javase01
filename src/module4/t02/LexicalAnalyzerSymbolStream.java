package module4.t02;

import module4.t01.LexicalAnalyzerByteStream;

import module4.t01.Entry;
import java.io.*;
import java.util.*;

/**
 * Условие:
 * Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова
 * языка Java это код содержит. Выведите эти слова и их количество в другой файл. Используйте
 * только символьные потоки ввода-вывода.
 * Created by alterG on 29.05.2017.
 */
public class LexicalAnalyzerSymbolStream {
    private static final String pathToKeywords = "keywordsjava.txt";
    private static final File inputFile = getResourceAsFile("Main.java");
    private static final File outputFile = getOutputFile("out.txt");

    public static void main(String[] args) throws IOException {
        checkFiles(inputFile, outputFile);
        Set<String> javaKeyWordsSet = getJavaKeywordsSetFormFile(pathToKeywords);

        // Read file with java code
        BufferedReader inputFileStream = new BufferedReader(new FileReader(inputFile));
        StringBuilder inputBuffer = new StringBuilder();
        while (inputFileStream.ready()) {
            inputBuffer.append(inputFileStream.readLine());
        }
        inputFileStream.close();
        String[] words = inputBuffer.toString().split("[^a-zA-Z]+"); // Get only words

        // Fill map with java keywords
        Map<String, Integer> inputFileKeywordsMap = new HashMap<>();
        for (String word : words) {
            if (javaKeyWordsSet.contains(word)) {
                inputFileKeywordsMap.merge(word, 1, Integer::sum);
            }
        }
        System.out.println(inputFileKeywordsMap);

        // Get sorted array of map's entry
        Entry[] result =  LexicalAnalyzerByteStream.getEntryArray(inputFileKeywordsMap);

        // Write result in a file
        BufferedWriter outputFileStream = new BufferedWriter(new FileWriter(outputFile));
        StringBuilder outputString = new StringBuilder("Количество ключевых слов в файле "+inputFile.getName()+"\n");
        for (Entry entry : result) {
            outputString.append(entry.toString()+"\n");
        }
        outputFileStream.write(outputString.toString());
        outputFileStream.close();
        System.out.println(String.format("Анализ ключевых слов в файле %s успешно записан в %s", inputFile.getName(), outputFile.getName()));

    }

    public static Set<String> getJavaKeywordsSetFormFile(String path) throws IOException {

        String result = readSymbolFile(path);
        Set<String> set = new HashSet<>();
        String[] keyWords = result.split("[,\\s]+");
        set.addAll(Arrays.asList(keyWords));
        return set;
    }

    private static String readSymbolFile(String path) throws IOException {
        final File javaKeywordsFile = getResourceAsFile(path);
        FileReader in = new FileReader(javaKeywordsFile);
        char[] bufferArray = new char[(int)javaKeywordsFile.length()];
        while (in.ready()) {
            in.read(bufferArray);
        }
        String result = new String(bufferArray);
        in.close();
        return result;
    }


    private static File getOutputFile(String path) {
        Class<LexicalAnalyzerSymbolStream> cl = LexicalAnalyzerSymbolStream.class;
        String pathname = ".\\src\\" + cl.getPackage().getName().replaceAll("\\.", "\\\\") + "\\" + path;
        return new File(pathname);
    }

    private static File getResourceAsFile(String path) {
        Class<LexicalAnalyzerSymbolStream> cl = LexicalAnalyzerSymbolStream.class;
        return new File(cl.getResource(path).getFile());
    }

    private static final void checkFiles(File inputFile, File outputFile) {
        if (!inputFile.canRead()) {
            throw new IllegalArgumentException("Can't read file " + inputFile);
        }
        if (outputFile.exists() && !outputFile.canWrite()) {
            throw new IllegalArgumentException("Can't write file " + outputFile);
        }
    }
}

