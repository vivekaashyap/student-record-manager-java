import java.util.Scanner;

public class Main {
// 
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter CGPA: ");
                    double cgpa = sc.nextDouble();

                    Student student =
                            new Student(id, name, age, course, cgpa);

                    manager.addStudent(student);

                    break;

                case 2:

                    manager.viewStudents();

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    Student found =
                            manager.searchStudent(searchId);

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Student ID: ");
                    int updateId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("New Age: ");
                    int newAge = sc.nextInt();

                    sc.nextLine();

                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();

                    System.out.print("New CGPA: ");
                    double newCgpa = sc.nextDouble();

                    manager.updateStudent(
                            updateId,
                            newName,
                            newAge,
                            newCourse,
                            newCgpa
                    );

                    break;

                case 5:

                    System.out.print("Enter Student ID: ");
                    int deleteId = sc.nextInt();

                    manager.deleteStudent(deleteId);

                    break;

                case 6:

                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice.");
            }
        }
    }
}