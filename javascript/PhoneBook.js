const prompt = require('prompt-sync')();

contacts = []

function addcontact(){
    first = prompt("Enter first name: ")
    last = prompt("Enter last name: ")
    phone = prompt("Enter phone number: ")
    contacts.append({"first_name": first, "last_name": last, "phone_number": phone})
    console.log("Contact added.")
}

