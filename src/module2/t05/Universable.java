package module2.t05;

import java.util.List;

/**
 * thanks eserdk for idea
 * Created by alterG on 15.05.2017.
 */
public interface Universable {

    Student getBestStudent(Subject sub);
    List<Mark> getStudentMarks (Student stud, Subject sub);
    List<Student> getTop10 (Subject sub);

    void addStudent (Student stud);
    void removeStudent(Student stud);
}
