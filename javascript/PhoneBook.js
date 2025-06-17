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
