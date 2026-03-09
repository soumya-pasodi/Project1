 public class ScholarshipStudent extends Student {

    public ScholarshipStudent(String usn, String name,
                              String password, Department department) {
        super(usn, name, password, department);
    }

    @Override
    public void calculateOverallGrade() {

        double percentage =
                calculateOverallPercentage() + 5;

        if (percentage > 100)
            percentage = 100;

        overallPercentage = percentage;

        if (percentage >= 90)
            grade = 'A';
        else if (percentage >= 75)
            grade = 'B';
        else if (percentage >= 60)
            grade = 'C';
        else
            grade = 'F';
    }
}