 import java.util.*;

public class Semester {
    private List<Subject> subjects = new ArrayList<>();

    public void addSubject(Subject s) {
        subjects.add(s);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}