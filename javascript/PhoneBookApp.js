const prompt = require("prompt-sync")();

let contacts = [];

function addContact() {
  let firstName = prompt("Enter first name: ");
  let lastName = prompt("Enter last name: ");
  let phoneNumber = prompt("Enter phone number: ");
  contacts.push({ firstName: firstName, lastName: lastName, phoneNumber: phoneNumber });
  console.log("Contact added successfully.");
}
function removeContact() {
	let PhoneNumber = prompt("Enter phone number to remove: ");
	let newContacts = [];

	for(let i = 0; i < contacts.length; i++){
	   if(contacts[i].phoneNumber !== phoneNumber){
	      newContacts.push(contacts[i]);
	}
	}
	contacts = newContacts;
  console.log("Contact removed successfully.");
}
function findContactByPhone() {
  const phoneNumber = prompt("Enter phone number to find: ");
  let found = false;
for (let i = 0; i < contacts.length; i++) {
    if (contacts[i].phoneNumber === phoneNumber) {
      console.log("Found contact: " + contacts[i].firstName + " " + contacts[i].lastName);
      found = true;
      break;
    }
  }
if (!found) {
    console.log("Contact not found.");
  }
}
function findContactByName() {
  const name = prompt("Enter first or last name to find: ");
  let found = false;

  for (let i = 0; i < contacts.length; i++) {
    if (contacts[i].firstName === name || contacts[i].lastName === name) {
      console.log("Found contact: " + contacts[i].firstName + " " + contacts[i].lastName);
      found = true;
      break;
    }
  }

  if (!found) {
    console.log("Contact not found.");
  }
  }
function editContact() {
  const phoneNumber = prompt("Enter phone number of contact to edit: ");
  let found = false;

  for (let i = 0; i < contacts.length; i++) {
    if (contacts[i].phoneNumber === phoneNumber) {
      contacts[i].firstName = prompt("Enter new first name: ");
      contacts[i].lastName = prompt("Enter new last name: ");
      contacts[i].phoneNumber = prompt("Enter new phone number: ");
      console.log("Contact updated successfully.");
      found = true;
      break;
    }
  }
 if (!found) {
    console.log("Contact not found.");
  }
}
 
function menu() {
  console.log("\nPhone Book App");
  console.log("1. Add Contact");
  console.log("2. Remove Contact");
  console.log("3. Find Contact by Phone Number");
  console.log("4. Find Contact by Name");
  console.log("5. Edit Contact");
  console.log("6. Exit");


