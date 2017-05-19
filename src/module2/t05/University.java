package module2.t05;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alterG on 15.05.2017.
 */
public class University implements Universable {
    private String name;
    private List<Student> subjects;

    public University(String name) {
        this.name = name;
        subjects = new ArrayList<>();

    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Student getBestStudent(Subject sub) {
        return null;
    }

    @Override
    public List<Mark> getStudentMarks(Student stud, Subject sub) {
        return null;
    }

    @Override
    public List<Student> getTop10(Subject sub) {
        return null;
    }

    @Override
    public void addStudent(Student stud) {

    }

    @Override
    public void removeStudent(Student stud) {

    }
}
