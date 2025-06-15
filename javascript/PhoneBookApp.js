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

