public class Student {
    private String firstName;
    private String lastName;
    private double grade;

    public Student(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public double getGrade() {
        return grade;
    }

    public Student setGrade(double grade) {
        this.grade = grade;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f",this.firstName,this.lastName,this.grade);
    }
}
