package module3.t02;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Условие:
 * Разработать приложение, позволяющее по выбору пользователя использовать русский
 * или английский язык, для отображения информации.  Приложение должно представлять собой
 * перечень вопросов под номерами (на английском или русском соответственно). Выбрав номер
 * вопроса пользователь может узнать ответ на него.
 * Created by alterG on 25.05.2017.
 */
public class Main {
    private final static int questionCount = 5;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Input number:\n1. English\n2. Russian");
        int choice;
        do {
            choice = scan.nextInt();
        } while (choice != 1 && choice != 2);
        Locale locale;
        if (choice == 1) {
            locale = Locale.forLanguageTag("en");
        }
        else {
            locale = Locale.forLanguageTag("ru");
        }
            printQuestions(locale);
        while (true) {
            choice = scan.nextInt();
            printAnswer(choice, locale);
        }

    }

    private static void printQuestions(Locale locale) {

        ResourceBundle bundle = getResourceBundle(locale);
        int i = 1;
        for (String key : bundle.keySet()) {
            if (key.contains("question")) {         // excluding unnecessary values (cause we storage questions and answers in one file)
                System.out.println(i + ". " + bundle.getString(key));
                i++;
            }
        }
        System.out.println(bundle.getString("tipQuestion"));
    }

    private static void printAnswer(int questionNumber, Locale locale) {
        ResourceBundle bundle = getResourceBundle(locale);
        if (questionNumber < 1 || questionNumber >= questionCount) {
            System.out.println(bundle.getString("inputWarning"));
            return;
        }
        String answerKey = "answer" + questionNumber;
        System.out.println(bundle.getString("tipAnswer")+"("+questionNumber+"): "+bundle.getString(answerKey));

    }

    private static ResourceBundle getResourceBundle(Locale locale) {
        Class<Main> cl = Main.class;
        String path = cl.getPackage().getName() + ".questions";
        return ResourceBundle.getBundle(path, locale);
    }
}
