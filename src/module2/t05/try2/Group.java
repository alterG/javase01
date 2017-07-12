package module2.t05.try2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by alterG on 12.07.2017.
 */
public class Group {
    private Set<Student> studentList;
    private int id;


    public Group(int groupId) {
        id = groupId;
        studentList = new HashSet<Student>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public Set<Student> getStudentSet() {
        return studentList;
    }

    public int getId() {
        return id;
    }
}
