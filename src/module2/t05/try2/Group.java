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

    public boolean contains(Student student) {
        return studentList.contains(student);
    }

    public String getGroupInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Group #" + id + ":\n");
        int number = 1;
        for (Student student : studentList) {
            res.append(number++ + ". " + student.name + "\n");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (id != group.id) return false;
        return studentList != null ? studentList.equals(group.studentList) : group.studentList == null;
    }

    @Override
    public int hashCode() {
        int result = studentList != null ? studentList.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
}
