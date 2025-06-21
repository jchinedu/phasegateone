import java.util.Scanner;
import java.util.ArrayList;
public class PhoneBook {
static ArrayList<String[]> contacts = new ArrayList<>();
Scanner input = new Scanner(System.in);

public static void addContact(){

System.out.print("Enter first name: ");
	String Fname = input.nextLine();
    System.out.print("Enter last name: ");
    String name = input.nextLine();
	System.out.print("Enter your phone number: ");
    String number = input.nextLine();
    contact.add(new String[]{Fname, name, number});
    System.out.print("Contact added.");
}
public static void removeContact() {
    System.out.print("Enter phone number to remove: ");
    String phone = input.nextLine();

    ArrayList<String[]> updatedContacts = new ArrayList<>();
    boolean removed = false;

    for (int i = 0; i < contacts.size(); i++) {
        String[] contact = contacts.get(i);
        if (!contact[2].equals(phone)) {
            updatedContacts.add(contact);
        } else {
            removed = true;
        }
    }

    contacts = updatedContacts;

    if (removed) {
        System.out.println("Contact removed.");
    } else {
        System.out.println("Contact not found.");
    }
}
public static void findContactByPhone() {
    System.out.print("Enter phone number to find: ");
    String phone = input.nextLine();

    String[] found = null;
    for (int i = 0; i < contacts.size(); i++) {
        String[] contact = contacts.get(i);
        if (contact[2].equals(phone)) {
            found = contact;
            break;
        }
    }

    if (found != null) {
        System.out.println("Found: " + found[0] + " " + found[1]);
    } else {
        System.out.println("Contact not found.");
    }
}
public static void findContactByFirstName() {
        System.out.print("Enter first name to find: ");
        String first = input.nextLine();

        String[] found = null;
        for (String[] contact : contacts) {
            if (contact[0].equals(first)) {
                found = contact;
                break;
            }
        }

        if (found != null) {
            System.out.println("Found: " + found[0] + " " + found[1]);
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void findContactByLastName() {
        System.out.print("Enter last name to find: ");
        String last = input.nextLine();

        String[] found = null;
        for (String[] contact : contacts) {
            if (contact[1].equals(last)) {
                found = contact;
                break;
            }
        }

        if (found != null) {
            System.out.println("Found: " + found[0] + " " + found[1]);
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void editContact() {
        System.out.print("Enter phone number to edit: ");
        String phone = input.nextLine();

        String[] found = null;
        for (String[] contact : contacts) {
            if (contact[2].equals(phone)) {
                found = contact;
                break;
            }
        }

        if (found != null) {
            System.out.print("Enter new first name: ");
            found[0] = input.nextLine();
            System.out.print("Enter new last name: ");
            found[1] = input.nextLine();
            System.out.print("Enter new phone number: ");
            found[2] = input.nextLine();

            System.out.println("Contact updated.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void menu() {
        while (true) {
            System.out.println("\nPhone Book");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Find by Phone");
            System.out.println("4. Find by First Name");
            System.out.println("5. Find by Last Name");
            System.out.println("6. Edit Contact");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            String choice = input.nextLine();

            switch (choice) {
                case "1": addContact(); break;
                case "2": removeContact(); break;
                case "3": findContactByPhone(); break;
                case "4": findContactByFirstName(); break;
                case "5": findContactByLastName(); break;
                case "6": editContact(); break;
                case "7": 
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}


