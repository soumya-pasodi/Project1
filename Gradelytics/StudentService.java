 import java.util.*;
import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) { students.add(s); }

    // Class Topper
    public void displayClassTopper() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        Student topper = students.get(0);
        for (Student s : students) {
            if (s.calculateOverallPercentage() > topper.calculateOverallPercentage())
                topper = s;
        }

        System.out.println(ConsoleColors.CYAN + "\n🏆 CLASS TOPPER 🏆" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "Name: " + topper.getName() + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "USN: " + topper.getUsn() + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "Percentage: " + topper.calculateOverallPercentage() + ConsoleColors.RESET);
    }

    // Subject Failure Analytics
    public void subjectFailureAnalytics() {
        Map<String, Integer> failureCount = new HashMap<>();

        for (Student s : students) {
            for (Semester sem : s.getSemesters()) {
                for (Subject sub : sem.getSubjects()) {
                    if (!sub.isPassed())
                        failureCount.put(sub.getName(), failureCount.getOrDefault(sub.getName(), 0) + 1);
                }
            }
        }

        System.out.println(ConsoleColors.CYAN + "\n--- Failure Analytics ---" + ConsoleColors.RESET);
        for (String sub : failureCount.keySet()) {
            System.out.println(ConsoleColors.RED + sub + " → Failures: " + failureCount.get(sub) + ConsoleColors.RESET);
        }
    }

    // CSV Export
    public void exportToCSV(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        fw.append("Name,USN,Percentage\n");
        for (Student s : students)
            fw.append(s.getName() + "," + s.getUsn() + "," + s.calculateOverallPercentage() + "\n");
        fw.flush();
        fw.close();
        System.out.println("CSV Report Generated: " + fileName);
    }

    // PDF Export
    public void exportToPDF(String fileName) throws Exception {
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(fileName));
        doc.open();
        doc.add(new Paragraph("Gradelytics Class Report\n\n"));
        for (Student s : students)
            doc.add(new Paragraph(s.getName() + " | USN: " + s.getUsn() + " | %" + s.calculateOverallPercentage()));
        doc.close();
        System.out.println("PDF Report Generated: " + fileName);
    }
}