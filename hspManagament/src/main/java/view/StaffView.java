package view;


import java.util.List;
import java.util.Scanner;

import model.Staff;

public class StaffView {
    private Scanner scanner = new Scanner(System.in);

    public Staff getStaffDetails() {
        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter Role:");
        String role = scanner.nextLine();

        System.out.println("Enter Phone:");
        String phone = scanner.nextLine();

        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        return new Staff(firstName, lastName, role, phone, email);
    }

    public void displayStaffList(List<Staff> staffList) {
        System.out.println("\n--- Staff List ---");
        for (Staff staff : staffList) {
            System.out.printf("ID: %d, Name: %s %s, Role: %s, Phone: %s, Email: %s\n",
                    staff.getStaffId(), staff.getFirstName(), staff.getLastName(), staff.getRole(), staff.getPhone(), staff.getEmail());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
