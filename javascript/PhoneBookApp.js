const prompt = require("prompt-sync")();

let contacts = [];

function addContact() {
  let firstName = prompt("Enter first name: ");
  let lastName = prompt("Enter last name: ");
  let phoneNumber = prompt("Enter phone number: ");
  contacts.push({ firstName: firstName, lastName: lastName, phoneNumber: phoneNumber });
  console.log("Contact added successfully.");
}
