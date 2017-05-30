package module4.t04;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Условие:
 * Дана коллекция фильмов, содержащая информацию об актерах, снимавшихся в главных
 * ролях (один актер мог сниматься и в нескольких фильмах). Необходимо написать приложение,
 * позволяющее при запуске восстанавливать коллекцию фильмов, позволять ее модифицировать,
 * а по завершении работы приложения – сохранять (в файл). Для восстановления/сохранения
 * коллекции использовать  сериализацию/десериализацию.
 * Created by alterG on 30.05.2017.
 */
public class Main {
    private static final File saveFile = getFile("save.txt");

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        StorageManager collection;
        if (saveFile.length() == 0) {
            collection = new StorageManager(StorageManager.getStandartKit(), "FilmsInMyHeart");
            System.out.println("Создана стандартная коллекция фильмов.");
        } else {
            collection = StorageManager.load(saveFile);
            System.out.println("Данные прочитаны с диска.");
        }
        System.out.println(collection);
//        collection.removeMovie(new Movie("The Wolf of Wall Street", new HashSet<Actor>(Arrays.asList(new Actor("Leonardo de Caprio")))));
//        collection.addMovie(new Movie("The Wolf of Wall Street", new HashSet<Actor>(Arrays.asList(new Actor("Leonardo de Caprio")))));
        StorageManager.save(collection, saveFile);
        System.out.println("Данные сохранены на диск.");
    }

    private static File getFile(String path) {
        Class<Main> cl = Main.class;
        File result = new File("target\\" + cl.getPackage().getName().replaceAll("\\.", "\\\\") + "\\" + path);
        return result;
    }

}
