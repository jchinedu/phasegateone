const prompt = require("prompt-sync")();
console.log("Welcome to SemiColon Stores Checkout System!");
let customerName = prompt("Enter customer name: ");
let productNames = [];
let quantities = [];
let unitPrices = [];
while (true) {
	let product = prompt("Enter product name (or 'done' to finish): ");
  if (product.toLowerCase() === "done") break;




