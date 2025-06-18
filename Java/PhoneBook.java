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


