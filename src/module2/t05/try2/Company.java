package module2.t05.try2;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by alterG on 12.07.2017.
 */
public class Company {
    private String name;
    private Map<Integer, Group> groups;

    // subject contains map of groups (key is group id)
    private Map<Subject, Set<Group>> groupsBySubjectList;


    public void addStudentToGroup(int groupId, Student student) {
        groups.get(groupId).addStudent(student);
    }

    public void addGroupToSubject(Subject subject, int groupId) {
        Group group = groups.get(groupId);
        Set<Group> subjectGroupSet = groupsBySubjectList.get(subject);
        subjectGroupSet.add(group);
    }

    public void createGroup(int groupId) {
        Group group = new Group(groupId);
        groups.put(groupId, group);
    }

    public void addSubject(Subject subject) {
        if (groupsBySubjectList.containsKey(subject)) return;
        groupsBySubjectList.put(subject, new HashSet<Group>());
    }
}
