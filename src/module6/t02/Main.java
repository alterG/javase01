package module6.t02;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by alterG on 15.06.2017.
 */
public class Main {
    private static final File propertyFile = new File("resources/module3/t02/questions_en.properties");

    public static void main(String[] args) {
        PropertyManager pm = new PropertyManager();
        try {
            pm.loadFromFile(propertyFile);
        } catch (IOException e) {
            System.out.println("Не удалось загрузить файл.");
            System.exit(0);
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите ключ: ");
            String answer = scanner.nextLine();
            if ("exit".equals(answer)) break;
            try {
                System.out.println("Key = " + answer + "\tValue = " + pm.getValue(answer));
            } catch (IllegalArgumentException e) {
                System.out.println("Значения по данному ключу не существует");
            }
        }

    }
}
