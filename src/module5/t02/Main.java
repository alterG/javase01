package module5.t02;

import module5.t01.FileSystemExplorer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by alterG on 31.05.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File propertyFile = FileSystemExplorer.runExplorer();
        String relativeFilePath = PropertiesManager.getRelativePath(propertyFile.getAbsolutePath());
        PropertiesManager manager = new PropertiesManager(relativeFilePath);
        System.out.println(String.format("File %s is read.", propertyFile));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter key to get value from property file.");
            String key = scanner.nextLine();
            if ("exit".equals(key)) {
                System.exit(0);
            }
            try {
                String result = manager.getValue(key);
                System.out.println(String.format("Value = %s\t(Key is %s)", result, key));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
