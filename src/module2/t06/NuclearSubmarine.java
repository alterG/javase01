package module2.t06;
import module2.t07.*;

/**
 * Created by alterG on 10.05.2017.
 */
@NuclearToJavadoc(material = "iron")
public class NuclearSubmarine {
    private boolean isWork;
    private NuclearSubmarineEngine engine;

    public NuclearSubmarine() {
        engine = new NuclearSubmarineEngine();
        isWork = true;
        System.out.println("Атомная лодка готова к работе.");
    }

    class NuclearSubmarineEngine {
        boolean isWork;

        public NuclearSubmarineEngine() {
            this.isWork = true;
            System.out.println("Двигатель атомной лодки запущен.");
        }
    }
}
