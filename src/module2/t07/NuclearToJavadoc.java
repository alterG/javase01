package module2.t07;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NuclearToJavadoc {
    String matterial();
    int century();
}