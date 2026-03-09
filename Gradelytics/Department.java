 import java.io.Serializable;
import java.util.ArrayList;

public class Department implements Serializable {

    private String departmentName;
    private ArrayList<SemesterTemplate> semesters = new ArrayList<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void addSemesterTemplate(SemesterTemplate semester) {
        semesters.add(semester);
    }

    public ArrayList<SemesterTemplate> getSemesters() {
        return semesters;
    }
}