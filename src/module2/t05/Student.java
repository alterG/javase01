package module2.t05;

import java.util.Random;

/**
 * Created by alterG on 15.05.2017.
 */
public class Student {
    private String name;
    private static int studentsNumber = 0;
    private static String[] availableNames = {
            "Александр",
            "Алексей",
            "Андрей",
            "Арсений",
            "Артем",
            "Владимир",
            "Владислав",
            "Глеб",
            "Даниил",
            "Дмитрий",
            "Егор",
            "Иван",
            "Илья",
            "Кирилл",
            "Максим",
            "Марк",
            "Матвей",
            "Михаил",
            "Никита",
            "Николай",
            "Роман",
            "Сергей",
            "Тимофей",
            "Федор",
            "Ярослав"
    };

    public Student() {
        int idName = new Random().nextInt(availableNames.length);
        this.name = availableNames[idName] + "_" + studentsNumber;
        studentsNumber++;
    }

    @Override
    public String toString() {
        return name;
    }
}

