package module2.t05.try2;

/**
 * DTO that's why field is public
 * Created by alterG on 12.07.2017.
 */
public class Student {
    public String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public Student(String name) {
        this.name = name;
    }
}
