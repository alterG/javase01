package module2.t05.try2;

import java.io.IOException;

/**
 * Created by alterG on 12.07.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Company company = new Company("Epam systems");
        company.addSubjectToCompany(Subject.MATH);

        Student student1 = new Student("Oleg");
        Student student2 = new Student("Nekit");
        Student student3 = new Student("Pavel");

        company.createGroup(1);
        company.addStudentToGroup(1, student1);
        company.addStudentToGroup(1, student2);
        company.printSubjectInfo();
        company.printGroupInfo(1);
        company.addStudentToGroup(1, student3);
        company.printGroupInfo(1);
        company.addGroupToSubject(1, Subject.MATH);
        company.printStudentInfo(student1);
        company.setMark(Subject.MATH, student1, 4);
        company.printStudentInfo(student1);
        company.setMark(Subject.MATH, student1, 3.4);
        company.printStudentInfo(student1);
        company.addSubjectToCompany(Subject.PHILOSOPHY);
        company.addGroupToSubject(1, Subject.PHILOSOPHY);
        company.printGroupInfo(1);

    }
}
