package lab2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Create a Student Database with the following attributes:
 * - New Student constructor that takes name and SSN in the arguments
 * - Automatically create an email ID based on the name
 * - Set a private static ID
 * - Generate a user ID that is combination of Static ID, random 4-digit number between 1000 and 9000, and last 4 of SSN
 * - Methods: enroll(), pay(), checkBalance(), toString(), showCourses()
 * - Use encapsulation to set variables (phone, city, state)
 */

public class Student {

    private static int id = 1000;
    private static int coursePrice = 100;

    private String email;
    private String firstName;
    private String lastName;
    private String studentId;
    private int phone;
    private String city;
    private String state;
    private int balance = 200;

    private List<String> courses = new ArrayList<String>();

    public static void main(String[] args) {
        Student john = new Student("John", "Smith", 343543643);
        System.out.println(john);

        Student jennifer = new Student("Jennifer", "Johnson", 827304345);
        System.out.println(jennifer);
    }

    public Student(String firstName, String lastName, int ssn) {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("Firstname and lastname must be provided.");
        }

        if (Integer.toString(ssn).length() != 9) {
            System.out.print(ssn);
            throw new IllegalArgumentException("SSN must contain 9 characters.");
        }

        System.out.println("Creating student");

        id++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.generateStudentId(ssn);
        this.generateEmail();
    }

    private void generateStudentId(int ssn) {
        int rand = (new Random()).nextInt(8000) + 1000;
        String ssnStr = Integer.toString(ssn);
        String lastOfSsn = ssnStr.substring(ssnStr.length() - 4);
        this.studentId = Integer.toString(id) + rand + lastOfSsn;

        System.out.println("Student id: " + this.studentId);
    }

    private void generateEmail() {
        String name = this.firstName.trim().substring(0, 3) + this.lastName.trim().substring(0, 3);
        this.email = name.toLowerCase() + id +  "@example.com";

        System.out.println("Student email: " + this.email);
    }

    public void enroll(String course) {
        if (this.courses.contains(course)) {
            System.out.println("Student is already enrolled in course " + course);
            return;
        }

        try {
            this.pay(coursePrice);
        } catch (Exception e) {
            System.out.println("Could not pay for course course: " + e.getMessage());
            return;
        }

        this.courses.add(course);

        System.out.println("Successfully enrolled in course " + course);
    }

    public void pay(int n) throws Exception {
        if (this.balance < n) {
            throw new Exception("Insufficient funds.");
        }

        this.balance -= n;

        System.out.println("Payment: $" + n);
    }

    public void checkBalance() {
        System.out.println("Balance: $" + this.balance);
    }

    @Override
    public String toString() {
        return "Name: " + this.firstName + " " + this.lastName
                + ", id: " + this.studentId
                + ", email: " + this.email;
    }

    public void showCourses() {
        if (this.courses.isEmpty()) {
            System.out.println("The student is not enrolled in any courses.");
            return;
        }
        System.out.println("Student is enrolled in the following courses:");
        System.out.println(this.courses);
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
