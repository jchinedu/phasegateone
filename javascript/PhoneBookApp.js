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
	let phoneNumber = prompt("Enter phone number to remove: ");
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
  let phoneNumber = prompt("Enter phone number to find: ");
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
function findContactByFirstName() {
  const firstName = prompt("Enter first name to find: ");
  let found = false;

  for (let i = 0; i < contacts.length; i++) {
    if (contacts[i].firstName === firstName) {
      console.log("Found contact: " + contacts[i].firstName + " " + contacts[i].lastName);
      found = true;
      break;
    }
  }

  if (!found) {
    console.log("Contact not found.");
  }
}  
function findContactByLastName() {
  const lastName = prompt("Enter last name to find: ");
  let found = false;

  for (let i = 0; i < contacts.length; i++) {
    if (contacts[i].lastName === lastName) {
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
  console.log("4. Find Contact by First Name");
  console.log("5. Find Contact by Last Name");
  console.log("6. Edit Contact");
  console.log("7. Exit");

  const choice = prompt("Choose an option: ");

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
      console.log("Exiting Phone Book App.");
      return;
    default:
      console.log("Invalid choice. Try again.");
  }

  menu();
}

menu();
