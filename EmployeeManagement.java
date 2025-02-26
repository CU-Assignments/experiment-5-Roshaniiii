import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name, designation;
    double salary;

    Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    static final String FILE_NAME = "employees.dat";

    static void addEmployee() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME, true))) {
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            String name = scanner.next();
            String designation = scanner.next();
            double salary = scanner.nextDouble();
            out.writeObject(new Employee(id, name, designation, salary));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void displayEmployees() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            while (true) System.out.println((Employee) in.readObject());
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();
            if (choice == 1) addEmployee();
            else if (choice == 2) displayEmployees();
            else break;
        }
    }
}
