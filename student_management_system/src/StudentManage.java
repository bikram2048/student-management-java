import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StudentManage {
    private ArrayList<Student> addStudent = new ArrayList();
    private HashMap<String, Student> s = new HashMap();


    int chosenNum;

    public int displayOptions(Scanner userInput) {

        String[] arrNum = {
                "1. Add student",
                "2. Search Student By ID",
                "3. Update Student",
                "4. Delete Student",
                "5. View Students",
                "6. Exit"
        };

        for(String option : arrNum) {
            System.out.println(option);
        }

        System.out.println("Choose an option:");
        return userInput.nextInt();
    }

    public static String capitalize(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toUpperCase()
                + text.substring(1).toLowerCase();
    }

    public void add(Scanner userInput) {
        String student_id;
        String firstName;
        String lastName;
        String studentAddress;
        String studentEmail;

        System.out.println("PLease enter your student ID:");
        student_id = userInput.nextLine();

        while (s.containsKey(student_id)) {
            System.out.println("Student ID already exists.");
            System.out.println("Please enter a different student ID:");
            student_id = userInput.nextLine();
        }

            System.out.println("PLease enter your first name");
            firstName = capitalize(userInput.nextLine());

            System.out.println("Please enter your last name");
            lastName = capitalize(userInput.nextLine());

            System.out.println("Please enter your address");
            studentAddress = userInput.nextLine();

            System.out.println("Please enter your email");
            studentEmail = userInput.nextLine();

            Student students = new Student(firstName + " " + lastName, student_id, studentAddress, studentEmail);

            addStudent.add(students);
            s.put(student_id, students);
            System.out.println("Student details added successfully");
        }

    public void searchStudent(Scanner userInput) {
        System.out.println("Enter a student ID to search: ");
        String searchID = userInput.nextLine();

        Student foundStudent = s.get(searchID);

        if (foundStudent != null) {
            System.out.println("The searched student details is: \n" + foundStudent);
        } else {
            System.out.println("Student not found");
        }
    }
    public void update(Scanner userInput) {
        System.out.println("Please enter your student ID to update details:");
        String updateDetails = userInput.nextLine();

        Student details = s.get(updateDetails);

        if (details != null) {
            System.out.println("Current details: ");
            System.out.println(details);

            System.out.println("\nWhat would you like to update?");

            String[] options = {"1. Name", "2. Address", "3. Email"};
            for (int i = 0; i < options.length; i++) {
                System.out.println(options[i]);
            }

            System.out.println("Please select from the options:");
            int updateChoice = userInput.nextInt();
            userInput.nextLine();

            if (updateChoice == 1) {
                System.out.println("Enter new first name:");
                String updatedFirstName = capitalize(userInput.nextLine());

                System.out.println("Enter new last name:");
                String updatedLastName = capitalize(userInput.nextLine());

                details.name = updatedFirstName + " " + updatedLastName;
            } else if (updateChoice == 2) {
                System.out.println("Enter new address:");
                details.address = userInput.nextLine();
            } else if (updateChoice == 3) {
                System.out.println("Enter new email:");
                details.email = userInput.nextLine();
            }
            System.out.println("Student updated successfully!");
            System.out.println(details);
        } else {
            System.out.println("Student not found.");
        }
    }
    public void delete(Scanner userInput) {
        System.out.println("Enter Student ID to delete:");
        String deleteID = userInput.nextLine();

        Student deleted = s.remove(deleteID);

        if (deleted != null) {
            addStudent.remove(deleted);
            System.out.println("Student deleted successfully");
        } else {
            System.out.println("Student not found");
        }
    }
    public void displayAllStudents() {
        if (addStudent.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("\n===== ALL STUDENTS =====");
            for (Student student : addStudent) {
                System.out.println(student);
                System.out.println();
            }
        }
    }
}
