 import java.util.*;

public class Student {
    private String name;
    private String usn;
    private List<Semester> semesters = new ArrayList<>();

    public Student(String name, String usn) {
        this.name = name;
        this.usn = usn;
    }

    public String getName() { return name; }
    public String getUsn() { return usn; }
    public List<Semester> getSemesters() { return semesters; }
    public void addSemester(Semester sem) { semesters.add(sem); }

    public double calculateOverallPercentage() {
        double sum = 0;
        int count = 0;
        for (Semester sem : semesters) {
            for (Subject s : sem.getSubjects()) {
                sum += s.getInternalMarks();
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }

    // Performance Insights
    public void performanceInsights() {
        Subject strongest = null;
        Subject weakest = null;

        for (Semester sem : semesters) {
            for (Subject s : sem.getSubjects()) {
                if (strongest == null || s.getInternalMarks() > strongest.getInternalMarks())
                    strongest = s;
                if (weakest == null || s.getInternalMarks() < weakest.getInternalMarks())
                    weakest = s;
            }
        }

        System.out.println(ConsoleColors.CYAN + "\n--- Performance Insight ---" + ConsoleColors.RESET);
        if (strongest != null)
            System.out.println(ConsoleColors.GREEN + "Strongest: " + strongest.getName() + ConsoleColors.RESET);
        if (weakest != null)
            System.out.println(ConsoleColors.RED + "Weakest: " + weakest.getName() + ConsoleColors.RESET);
    }
}