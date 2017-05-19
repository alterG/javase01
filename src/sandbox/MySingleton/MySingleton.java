package sandbox.MySingleton;

/**
 * Десериализация создаст копию объекта и разрушит паттерн.
 * Singleton - устаревший паттерн, на смену ему пришли
 * Created by alterG on 19.05.2017.
 */
public class MySingleton {
    public static void main(String[] args) {
    }
    private static MySingleton instance;

    private MySingleton() {
        instance = new MySingleton();
    }

    public static MySingleton getInstance() {
        if (instance == null) instance =  new MySingleton();
        return instance;
    }
}
