package module2.t05.try2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alterG on 12.07.2017.
 */
public class Group {
    private List<Student> studentList;
    private int id;


    public Group(int groupId) {
        id = groupId;
        studentList = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }
}
