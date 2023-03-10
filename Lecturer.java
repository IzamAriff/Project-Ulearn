import java.util.Scanner;

public class Lecturer extends Person {
    
    private Office office;
    private ArrayList<Session> session;
    
   
    public void setName(Name name) {
        this.name = name;
    }
    public Name getName(){
        return name;
    }

    public void setOfficeAddr(String officeAddr) {
        this.officeAddr = officeAddr;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void createLecturer() {
        System.out.println("----------Lecturer's Details----------");
        Lecturer lec = new Lecturer();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name of lecturer: ");
        Name name = lec.getName();
        setName(name);

        System.out.print("Office room: ");
        String officeAddr = scanner.next();
        setOfficeAddr(officeAddr);

        System.out.print("Office number: ");
        String officeNum = scanner.next();
        setOfficeNum(officeNum);

        System.out.print("Lecturer's phone number: ");
        String phoneNum = scanner.next();
        setPhoneNum(phoneNum);

        System.out.print("Lecturer's email: ");
        String email = scanner.next();
        setEmail(email);

        scanner.close();

        System.out.println("Lecturer's details created successfully.");

    }

    public void displayLecturer() {
        System.out.println("Name: " + this.name);
        System.out.println("Office room: " + this.officeAddr);
        System.out.println("office number: " + this.officeNum);
        System.out.println("Phone number: " + this.phoneNum);
        System.out.println("Email: " + this.email);
    }

    public static void main(String[] args) {
        Lecturer lecturer = new Lecturer();
        lecturer.createLecturer();
        lecturer.displayLecturer();
    }
}
