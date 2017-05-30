package module5.t01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Files and directories are united in File
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
            String argument2;
            switch (argument1) {
                case "ls":
                    ls(pwd);
                    break;
//                case "cd":
//                    argument2Index = matcher.end(1);
//                    File fileToCd = getArgument2(inputBuffer, argument2Index);
//                    if ("..".equals(argument2)) {
//                        cd((pwd.getParentFile()));
//                    } else {
//                        cd(new File(pwd.getAbsolutePath() +"\\"+argument2));
//                    }
//                    break;
                case "cat":
                    argument2Index = matcher.end(1);
                    try {
                        File fileToCat = getArgument2(inputBuffer, argument2Index);
                        cat(fileToCat);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println(argument1+" (def)");
            }

        }
    }

    /**
     *
     * @param string
     * @param start
     * @return
     * @throws IllegalArgumentException if pwd doesn't contain parsed file (in 2nd argument) or
     * 2nd argument has wrong format
     */
    private static File getArgument2(String string, int start) throws IllegalArgumentException {
        Matcher matcher = secondArgument.matcher(string);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Wrong argument.");
        }
        File file = new File(pwd.getAbsolutePath());
        Set<File> fileSet = new HashSet<>(Arrays.asList(file.listFiles()));
        File parsedFile = new File(pwd.getAbsolutePath()+"\\"+matcher.group(1));
        if (fileSet.contains(parsedFile)) {
            return parsedFile;
        } else {
            throw new IllegalArgumentException("File not found.");
        }
    }

    private static void ls(File file) {
        for (File x : file.listFiles()) {
            System.out.println(String.format("%s\t%s", x.isFile() ? "-" : "d", x.getName()));
        }
    }

    private static void cd(File file) {
        if (file.exists() && file.canRead() && file.canExecute()) {
            pwd = file;
        } else {
            System.out.println("ACCESS DENIED.");
        }
    }

    /**
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
