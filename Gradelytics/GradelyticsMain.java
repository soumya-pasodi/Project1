  import java.util.*;

public class GradelyticsMain {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println(ConsoleColors.CYAN + "\n--- Gradelytics Menu ---" + ConsoleColors.RESET);
            System.out.println("1. Add Student");
            System.out.println("2. Display Class Topper");
            System.out.println("3. Subject Failure Analytics");
            System.out.println("4. Export CSV");
            System.out.println("5. Export PDF");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("USN: ");
                    String usn = sc.nextLine();
                    Student student = new Student(name, usn);

                    Semester sem = new Semester();
                    System.out.print("How many subjects? ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Subject Name: ");
                        String subName = sc.nextLine();

                        System.out.print("Type (1-Theory / 2-Lab): ");
                        int typeChoice = sc.nextInt();
                        sc.nextLine();
                        SubjectType type = (typeChoice == 1) ? SubjectType.THEORY : SubjectType.LAB;

                        Subject s = new Subject(subName, type);
                        System.out.print("Internal Marks: ");
                        s.setInternalMarks(sc.nextInt());
                        sc.nextLine();
                        sem.addSubject(s);

                        // Auto Lab Creation
                        if (type == SubjectType.THEORY) {
                            System.out.print("Does this subject have Lab? (yes/no): ");
                            String resp = sc.nextLine();
                            if (resp.equalsIgnoreCase("yes")) {
                                Subject lab = new Subject(subName + " Lab", SubjectType.LAB);
                                System.out.print("Internal Marks for Lab: ");
                                lab.setInternalMarks(sc.nextInt());
                                sc.nextLine();
                                sem.addSubject(lab);
                                System.out.println("Lab auto-created!");
                            }
                        }
                    }

                    student.addSemester(sem);
                    service.addStudent(student);
                    break;

                case 2: service.displayClassTopper(); break;
                case 3: service.subjectFailureAnalytics(); break;
                case 4: service.exportToCSV("Gradelytics_Report.csv"); break;
                case 5: service.exportToPDF("Gradelytics_Report.pdf"); break;
                case 6: System.out.println("Exiting..."); System.exit(0);
            }
        }
    }
}