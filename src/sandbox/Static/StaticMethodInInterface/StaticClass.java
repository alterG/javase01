package sandbox.Static.StaticMethodInInterface;

/**
 * Created by alterG on 19.05.2017.
 */
public class StaticClass implements InterfaceWithStatic {
    public static void main(String[] args) throws Exception{
        String s ="";
        StaticClass staticClass = new StaticClass();
        System.out.println(staticClass.isNull(s));          // call class method
        System.out.println(InterfaceWithStatic.isNull(s));  // call interface method
    }

    /**
     * Method of StaticClass, it doesn't override Interface method (cause scope of static methods is their interface)
     * @param str
     * @return true if String is null (not empty)
     */
//    @Override  - compile error cause InterfaceWithStatic.isNull() is static method
    public boolean isNull(String str) {
        System.out.println("Проверка строки на null.");
        return str == null ? true : false;
    }
}
