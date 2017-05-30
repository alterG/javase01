package module5.t01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Условие:
 * Разработать приложение, позволяющее просматривать файлы и каталоги файловой
 * системы, а также создавать и удалять текстовые файлы. Для работы с текстовыми файлами
 * необходимо реализовать функциональность записи (дозаписи) в файл. Требуется определить
 * исключения для каждого слоя приложения и корректно их обработать.
 *
 * Notes:
 * Files and directories are united in File
 * Firstly, you should to realize class architecture and methods logic
 *
 * ToDo: generate documentation
 * Created by alterG on 30.05.2017.
 */
public class Main {
    private static File pwd;
    private static final Pattern firstArgument = Pattern.compile("^\\s*([a-zA-Z]+)");
    private static final Pattern secondArgument = Pattern.compile("\\s+([._\\w]+)");

    public static void main(String[] args) {
        pwd = new File("").getAbsoluteFile();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(pwd.getAbsolutePath() + "@user: ");
            String inputBuffer = scanner.nextLine();
            Matcher matcher = firstArgument.matcher(inputBuffer);
            if (!matcher.find()) {
                System.out.println("Unknown command.");
                continue;
            }
            String argument1 = matcher.group(1);
            int argument2Index;
            switch (argument1) {
                case "ls":
                    ls(pwd);
                    break;
                case "cd":
                    argument2Index = matcher.end(1);
                    try {
                        File fileToCd = getArgument2(inputBuffer, argument2Index, true);
                        cd(fileToCd);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "cat":
                    argument2Index = matcher.end(1);
                    try {
                        File fileToCat = getArgument2(inputBuffer, argument2Index, true);
                        cat(fileToCat);
                    } catch (IllegalArgumentException  | IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "touch":
                    argument2Index = matcher.end(1);
                    try {
                        File fileToCat = getArgument2(inputBuffer, argument2Index, false);
                        if (touch(fileToCat)) {
                            System.out.println("File is created.");
                        } else {
                            System.out.println("File can't be created.");
                        }
                    } catch (IOException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    System.out.println("Thank you for work.");
                    System.exit(0);
                    break;
                default:
                    System.out.println(argument1+" (def)");
            }

        }
    }

    /**
     * Parse 2nd argument
     * Note: method makes too much work
     * @param string to parse 2nd argument
     * @param start position index to parse
     * @return argument for command
     * @throws IllegalArgumentException if pwd doesn't contain parsed file (in 2nd argument) or
     * 2nd argument has wrong format
     */
    private static File getArgument2(String string, int start, boolean isExistValidation) throws IllegalArgumentException {
        Matcher matcher = secondArgument.matcher(string.substring(start));
        if (!matcher.find()) {
            throw new IllegalArgumentException("Wrong argument.");
        }
        if ("..".equals(matcher.group(1))) return pwd.getParentFile();

        File file = new File(pwd.getAbsolutePath());
        if (file.listFiles() == null) {
            throw new IllegalArgumentException(("Directory is empty."));
        } else {
            File parsedFile = new File(pwd.getAbsolutePath() + "\\" + matcher.group(1));
            if (isExistValidation) {
            Set<File> fileSet = new HashSet<>(Arrays.asList(file.listFiles()));
                if (fileSet.contains(parsedFile)) {
                    return parsedFile;
                } else {
                    throw new IllegalArgumentException("File not found.");
                }
            } else {
                return parsedFile;
            }
        }
    }

    private static boolean touch(File file) throws IOException {
        try {
            return file.createNewFile();
        } catch (IOException e) {
            throw new IOException("Can't create file.");
        }
    }

    /**
     * Print files in directory
     * @param file target directory
     */
    private static void ls(File file) {
        for (File x : file.listFiles()) {
            System.out.println(String.format("%s\t%s", x.isFile() ? "-" : "d", x.getName()));
        }
    }

    /**
     * Change pwd to given directory
     * @param file target directory
     */
    private static void cd(File file) throws IllegalArgumentException {
        if (!file.canRead() || !file.canExecute()) {
            throw new IllegalArgumentException("Access denied.");
        }
            pwd = file;
    }

    /**
     * Print content of file
     *
     * Here we can know reason of exception, that's why we throw exception
     * with it's reason after catching it
     * @param file to print it's content
     * @throws IOException with reason of it
     */
    private static void cat(File file) throws IOException {
        try {
            System.out.println(new String(Files.readAllBytes(file.toPath())));
        } catch (IOException e) {
            String errorMessage;
            if (file.isDirectory()) {
                errorMessage = "Can't read directory.";
            } else if (file.isFile() && !file.canRead()) {
                errorMessage ="Can't read file. Access error.";
            } else {
                errorMessage = "Can't read file. Unknown error.";
            }
            throw new IOException(errorMessage);
        }
    }
}
