package module2.t05.try2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        boolean isGroupExist = (group == null);
        if (isGroupExist) {
            group.addStudent(student);
            updateMarkList(groupId, student);
        }
    }

    public void addGroupToSubject(Subject subject, int groupId) {
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
                System.out.println(subject.getName() + "не допускает вещественных оценок.");
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
