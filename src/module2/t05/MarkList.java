package module2.t05;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alterG on 12.07.2017.
 */
public class MarkList<T extends Number> {
    private Map<Student, T> markList;

    public MarkList() {
        markList = new HashMap<>();
    }

    public void addStudent(Student student) {
        if (!markList.containsKey(student)) {
            markList.put(student, null);
        }
    }

    public void addStudent(Group studentsGroup) {
        for (Student student : studentsGroup.getStudentSet()) {
            if (!markList.containsKey(student)) {
                markList.put(student, null);
            }
        }
    }

    public void setMark(Student student, T mark) {
        if (markList.containsKey(student)) {
            markList.put(student, mark);
        }
    }

    public T getStudentMark(Student student) {
        return markList.get(student);
    }
}
