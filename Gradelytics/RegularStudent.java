 public class RegularStudent extends Student {

    public RegularStudent(String usn, String name,
                          String password, Department department) {
        super(usn, name, password, department);
    }

    @Override
    public void calculateOverallGrade() {

        double percentage = calculateOverallPercentage();

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