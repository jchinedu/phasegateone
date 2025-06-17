const prompt = require('prompt-sync')();

contacts = []

function addcontact(){
    first = prompt("Enter first name: ")
    last = prompt("Enter last name: ")
    phone = prompt("Enter phone number: ")
    contacts.append({"first_name": first, "last_name": last, "phone_number": phone})
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
