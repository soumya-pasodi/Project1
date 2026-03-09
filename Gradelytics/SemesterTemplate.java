 import java.io.Serializable;
import java.util.ArrayList;

public class SemesterTemplate implements Serializable {

    private int semesterNumber;
    private ArrayList<SubjectTemplate> subjects = new ArrayList<>();

    public SemesterTemplate(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void addSubjectTemplate(SubjectTemplate subject) {
        subjects.add(subject);
    }

    public ArrayList<SubjectTemplate> getSubjects() {
        return subjects;
    }
}