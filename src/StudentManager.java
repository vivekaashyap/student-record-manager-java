
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public void saveToFile() {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("students.txt"))) {

            for (Student s : students) {

                writer.write(
                        s.getId() + ","
                        + s.getName() + ","
                        + s.getAge() + ","
                        + s.getCourse() + ","
                        + s.getCgpa());

                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public void loadFromFile() {

        try (BufferedReader reader = new BufferedReader(
                new FileReader("students.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);

                String name = parts[1];

                int age = Integer.parseInt(parts[2]);

                String course = parts[3];

                double cgpa = Double.parseDouble(parts[4]);

                Student student = new Student(
                        id,
                        name,
                        age,
                        course,
                        cgpa);

                students.add(student);
            }

        } catch (IOException e) {

            System.out.println(
                    "No saved data found.");
        }
    }

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
