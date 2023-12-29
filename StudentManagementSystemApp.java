import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student
{
    private String name;
    private int rollNumber;
    private String grade;
    public Student(String name, int rollNumber, String grade)
    {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getRollNumber()
    {
        return rollNumber;
    }
    public void setRollNumber(int rollNumber)
    {
        this.rollNumber = rollNumber;
    }
    public String getGrade()
    {
        return grade;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
    }
    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade='" + grade + '\'' +
                '}';
    }
}
class StudentManagementSystem
{
    private List<Student> students;
    public StudentManagementSystem()
    {
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student)
    {
        students.add(student);
    }
    public void removeStudent(int rollNumber)
    {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }
    public Student searchStudent(int rollNumber)
    {
        for (Student student : students)
        {
            if (student.getRollNumber() == rollNumber)
            {
                return student;
            }
        }
        return null;
    }
    public void displayAllStudents()
    {
        for (Student student : students)
        {
            System.out.println(student);
        }
    }
}
public class StudentManagementSystemApp
{
    public static void main(String[] args)
    {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    Student newStudent = createStudentFromUserInput(scanner);
                    system.addStudent(newStudent);
                    break;
                case 2:
                    System.out.print("Enter the roll number of the student to remove: ");
                    int rollToRemove = scanner.nextInt();
                    system.removeStudent(rollToRemove);
                    break;
                case 3:
                    System.out.print("Enter the roll number of the student to search: ");
                    int rollToSearch = scanner.nextInt();
                    Student foundStudent = system.searchStudent(rollToSearch);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    system.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
    private static Student createStudentFromUserInput(Scanner scanner)
    {
        System.out.print("Enter student name: ");
        String name = scanner.next();

        System.out.print("Enter student roll number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter student grade: ");
        String grade = scanner.next();

        return new Student(name, rollNumber, grade);
    }
}
