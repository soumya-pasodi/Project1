 import java.io.Serializable;

public class SubjectTemplate implements Serializable {

    private String subjectName;
    private SubjectType type;

    public SubjectTemplate(String subjectName, SubjectType type) {
        this.subjectName = subjectName;
        this.type = type;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public SubjectType getType() {
        return type;
    }
}