public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String city;

    public Student(String firstName, String lastName, int age, String cty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = cty;
    }

    public String getCity() {
        return city;
    }

    public Student setCity(String city) {
        this.city = city;
        return this;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.", this.firstName, this.lastName, this.age);
    }
}
