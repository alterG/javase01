package module2.t05.try2;

/**
 * Created by alterG on 12.07.2017.
 */
public enum Subject {
    MATH("Math", true),
    BIOLOGY("Biology", true),
    PHILOSOPHY("Philosophy", false);

    private String name;
    private boolean isInteger;

    public boolean isInteger() {
        return isInteger;
    }

    public String getName() {
        return name;
    }

    private Subject(String name, boolean isInteger) {
        this.name = name;
        this.isInteger = isInteger;
    }

    public static Subject getType(Subject name) {
        for (Subject subject : Subject.values()) {
            if (subject.name.equals(name)) {
                return subject;
            }
        }
        return null;
    }
}
