package module2.t05.try2;

/**
 * Created by alterG on 12.07.2017.
 */
public class Main {
    public static void main(String[] args) {
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
        company.printStudentInfo(student1);
    }
}
