import java.io.*;
import java.util.ArrayList;

public class DataStorage {

    private static final String FILE_NAME = "students.dat";

    public static void saveStudents(ArrayList<Student> students) {
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(students);
            oos.close();
            System.out.println("Data Saved Successfully.");
        } catch (IOException e) {
            System.out.println("Error Saving Data.");
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Student> loadStudents() {
        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(FILE_NAME));
            ArrayList<Student> students =
                    (ArrayList<Student>) ois.readObject();
            ois.close();
            return students;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}