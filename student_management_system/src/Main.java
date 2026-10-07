import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        StudentManage manager = new StudentManage();

        while(true){

            int chosenNum = manager.displayOptions(userInput);
            userInput.nextLine();

            switch(chosenNum){

                case 1:
                    manager.add(userInput);
                    break;

                case 2:
                    manager.searchStudent(userInput);
                    break;

                case 3:
                    manager.update(userInput);
                    break;

                case 4:
                    manager.delete(userInput);
                    break;

                case 5:
                    manager.displayAllStudents();
                    break;

                case 6:
                    System.out.println("Exiting");
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
