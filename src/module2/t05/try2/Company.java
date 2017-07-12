package module2.t05.try2;

import java.util.*;

/**
 * Created by alterG on 12.07.2017.
 */
public class Company {
    private String name;

    public Company(String name) {
        this.name = name;
        companyGroups = new HashMap<>();
        companySubjects = new HashSet<>();
        subjectGroupSetMap = new HashMap<>();
        subjectMarkListMap = new HashMap<>();
    }

    private Map<Integer, Group> companyGroups;
    private Set<Subject> companySubjects;
    private Map<Subject, Set<Group>> subjectGroupSetMap;
    private Map<Subject, MarkList> subjectMarkListMap;

    public void addStudentToGroup(int groupId, Student student) {
        Group group = companyGroups.get(groupId);
        boolean isGroupExist = !(group == null);
        if (isGroupExist) {
            group.addStudent(student);
            updateMarkList(groupId, student);
        }
    }

    public void addGroupToSubject(int groupId, Subject subject) {
        Group group = companyGroups.get(groupId);
        boolean isGroupAndSubjectExist = !(group == null || !companySubjects.contains(subject));
        if (isGroupAndSubjectExist) {
            Set<Group> subjectGroupSet = subjectGroupSetMap.get(subject);
            subjectGroupSet.add(group);
            updateMarkList(subject, group);
        }
    }

    public void createGroup(int groupId) {
        boolean isGroupExist = companyGroups.containsKey(groupId);
        if (!isGroupExist) {
            Group group = new Group(groupId);
            companyGroups.put(groupId, group);
        }
    }

    public void addSubjectToCompany(Subject subject) {
        boolean subjectIsExist = companySubjects.contains(subject);
        if (!subjectIsExist) {
            companySubjects.add(subject);
            subjectGroupSetMap.put(subject, new HashSet<Group>());
            if (subject.isInteger()) {
                subjectMarkListMap.put(subject, new MarkList<Integer>());
            } else {
                subjectMarkListMap.put(subject, new MarkList<Float>());
            }
        }
    }

    public void setMark(Subject subject, Student student, double mark) {
        int roundedMark = (int) Math.round(mark);
        boolean isMarkInteger = Math.abs(mark - roundedMark) < 10e-4;
        if (subject.isInteger()) {
            if (!isMarkInteger) {
                System.out.println(subject.getName() + " не допускает вещественных оценок.");
                return;
            } else {
                MarkList<Integer> markList = subjectMarkListMap.get(subject);
                markList.setMark(student, roundedMark);
            }
        } else {
            MarkList<Double> markList = subjectMarkListMap.get(subject);
            markList.setMark(student, mark);
        }
    }

    public void printGroupInfo(int groupId) {
        Group group = companyGroups.get(groupId);
        Set<Student> studentSet = group.getStudentSet();
        System.out.print("Group #" + groupId + ":\n");
        int number = 1;
        for (Student student : studentSet) {
            System.out.print(number++ + ". ");
            printStudentInfo(student);
        }
    }

    public void printSubjectInfo() {

        StringBuilder res = new StringBuilder();
        res.append("Subjects:\n");
        int number = 1;
        for (Subject subject : companySubjects) {
            res.append(number++ + ". " + subject.getName() + "\n");
        }
        System.out.print(res);
    }

    public void printStudentInfo(Student student) {
        Set<Integer> studentGroupIds = getGroupsByStudent(student);
        Set<Subject> studentSubjects = getSubjectsByGroup(studentGroupIds);
        StringBuilder res = new StringBuilder();

        res.append("Student " + student.name + ":\n" +
                "\tgroup ids:");
        if (studentGroupIds.isEmpty()) {
            res.append(" none");
        } else {
            for (int id : studentGroupIds) {
                res.append(" " + id + ",");
            }
            res.delete(res.length() - 1, res.length()); // delete last character
        }
        res.append(".\n\tsubjects:");
        if (studentSubjects.isEmpty()) {
            res.append(" none.\n");
        } else {
            res.append("\n");
            for (Subject subject : studentSubjects) {
                Number mark = subjectMarkListMap.get(subject).getStudentMark(student);
                res.append(String.format("\t\t%s, mark is %s.\n", subject.getName(), mark == null ? "absent" : mark));
            }
        }
        System.out.print(res);
    }

    // return set with all subject contains this group
    private Set<Subject> getSubjectsByGroup(int groupId) {
        Set<Subject> resultSet = new HashSet<>();
        for (Subject subject : companySubjects) {
            for (Group group : subjectGroupSetMap.get(subject)) {
                if (group.getId() == groupId) {
                    resultSet.add(subject);
                }
            }
        }
        return resultSet;
    }

    // return set with all subject contains these groups
    private Set<Subject> getSubjectsByGroup(Collection<Integer> ids) {
        Set<Subject> resultSet = new HashSet<>();
        for (int id : ids) {
            Set<Subject> groupSubjects = getSubjectsByGroup(id);
            resultSet.addAll(groupSubjects);
        }
        return resultSet;
    }

    // return set with all group ids contains this student
    private Set<Integer> getGroupsByStudent(Student student) {
        Set<Integer> resultSet = new HashSet<>();
        for (Subject subject : companySubjects) {
            for (Group group : subjectGroupSetMap.get(subject)) {
                if (group.contains(student)) {
                    resultSet.add(group.getId());
                }
            }
        }
        return resultSet;
    }

    // add student to markList if subject contains this group
    private void updateMarkList(int groupId, Student student) {
        for (Subject subject : getSubjectsByGroup(groupId)) {
            subjectMarkListMap.get(subject).addStudent(student);
        }
    }

    // add student from group to markList subject
    private void updateMarkList(Subject subject, Group group) {
        MarkList subjectMarkList = subjectMarkListMap.get(subject);
        subjectMarkList.addStudent(group);
    }

}
