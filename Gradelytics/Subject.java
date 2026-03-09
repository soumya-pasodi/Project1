 public class Subject {
    private String name;
    private SubjectType type;
    private int internalMarks;
    private int totalMarks = 100;

    public Subject(String name, SubjectType type) {
        this.name = name;
        this.type = type;
        this.internalMarks = 0;
    }

    public String getName() { return name; }
    public SubjectType getType() { return type; }
    public int getInternalMarks() { return internalMarks; }
    public void setInternalMarks(int marks) { this.internalMarks = marks; }
    public boolean isPassed() { return internalMarks >= 40; }
}