 import java.io.*;
import java.util.ArrayList;

public class DepartmentService {

    private static final String FILE_NAME = "departments.dat";
    private ArrayList<Department> departments;

    public DepartmentService() {
        departments = loadDepartments();
    }

    public void addDepartment(Department department) {
        departments.add(department);
        saveDepartments();
    }

    public Department findDepartment(String name) {
        for (Department d : departments) {
            if (d.getDepartmentName().equalsIgnoreCase(name))
                return d;
        }
        return null;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    private void saveDepartments() {
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(departments);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error saving departments.");
        }
    }

    @SuppressWarnings("unchecked")
    private ArrayList<Department> loadDepartments() {
        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(FILE_NAME));
            ArrayList<Department> list =
                    (ArrayList<Department>) ois.readObject();
            ois.close();
            return list;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}