public class Student {
    public String name;
    public String studentID;
    public String address;
    public String email;


    public Student(String name, String studentID, String address, String email) {
        this.name = name;
        this.studentID = studentID;
        this.address = address;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Full Name: " + name + "\nStudent ID: " + studentID + "\nAddress: " + address + "\nEmail: " + email;
    }
}
