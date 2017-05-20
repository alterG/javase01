package sandbox.Static.StaticMethodInInterface;

/**
 * Created by alterG on 19.05.2017.
 */
public interface InterfaceWithStatic {

    default void print(String str) {
        if (!isNull(str)) {
            System.out.println("Default метод интерфейса "+this.getClass().getSimpleName()+" Строка: " +str);
        }
    }

    /**
     * static method cant be overridden
     * @param str
     * @return true if string is empty method or null
     */
    static boolean isNull(String str) {
        System.out.println("Проверка строки на null методом интерфейса.");
        return str == null ? true : "".equals(str) ? true : false;
    }
}
