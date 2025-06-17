const prompt = require('prompt-sync')();

contacts = []

function addContact(){
    first = prompt("Enter first name: ")
    last = prompt("Enter last name: ")
    phone = prompt("Enter phone number: ")
    contacts.push({"first_name": first, "last_name": last, "phone_number": phone})
    console.log("Contact added.")
}

function removeContact() {
    let phone = prompt("Enter phone number to remove:");
    let updatedContacts = [];

    for (let i = 0; i < contacts.length; i++) {
        if (contacts[i].phone_number !== phone) {
            updatedContacts.push(contacts[i]);
        }
    }

    contacts = updatedContacts;
    console.log("Contact removed.");
}
function findContactByPhone() {
    let phone = prompt("Enter phone number to find:");
    let contact = null;

    for (let i = 0; i < contacts.length; i++) {
        if (contacts[i].phone_number === phone) {
            contact = contacts[i];
            break;
        }
    }

    if (contact) {
        console.log("Found:", contact.first_name, contact.last_name);
    } else {
        console.log("Contact not found.");
    }
}
function findContactByFirstName() {
    let first = prompt("Enter first name to find:");
    let contact = null;

    for (let i = 0; i < contacts.length; i++) {
        if (contacts[i].first_name === first) {
            contact = contacts[i];
            break;
        }
    }

    if (contact) {
        console.log("Found:", contact.first_name, contact.last_name);
    } else {
        console.log("Contact not found.");
    }
}
function findContactByLastName() {
    let last = prompt("Enter last name to find:");
    let contact = null;

    for (let i = 0; i < contacts.length; i++) {
        if (contacts[i].last_name === last) {
            contact = contacts[i];
            break;
        }
    }

    if (contact) {
        console.log("Found:", contact.first_name, contact.last_name);
    } else {
        console.log("Contact not found.");
    }
}
function editContact() {
    let phone = prompt("Enter phone number to edit:");
    let contact = null;

    for (let i = 0; i < contacts.length; i++) {
        if (contacts[i].phone_number === phone) {
            contact = contacts[i];
            break;
        }
    }

    if (contact) {
        contact.first_name = prompt("Enter new first name:");
        contact.last_name = prompt("Enter new last name:");
        contact.phone_number = prompt("Enter new phone number:");
        console.log("Contact updated.");
    } else {
        console.log("Contact not found.");
    }
}
function menu() {
    while (true) {
        console.log("\nPhone Book");
        console.log("1. Add Contact");
        console.log("2. Remove Contact");
        console.log("3. Find by Phone");
        console.log("4. Find by First Name");
        console.log("5. Find by Last Name");
        console.log("6. Edit Contact");
        console.log("7. Exit");

        const choice = prompt("Choose option: ");

        switch (choice) {
            case "1":
                addContact();
                break;
            case "2":
                removeContact();
                break;
            case "3":
                findContactByPhone();
                break;
            case "4":
                findContactByFirstName();
                break;
            case "5":
                findContactByLastName();
                break;
            case "6":
                editContact();
                break;
            case "7":
                console.log("Goodbye!");
                return;
            default:
                console.log("Invalid option.");
        }
    }
}

menu();

