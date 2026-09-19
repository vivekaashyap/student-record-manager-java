
import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {

        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    public Student searchStudent(int id) {

        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    public void deleteStudent(int id) {

        Student student = searchStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);
        System.out.println("Student deleted successfully.");
    }

    public void updateStudent(int id,
            String name,
            int age,
            String course,
            double cgpa) {

        Student student = searchStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        student.setCgpa(cgpa);

        System.out.println("Student updated successfully.");
    }
}
