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
    contact.add(new String[]{fname, name, number});
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


