const prompt = require("prompt-sync")();
console.log("Welcome to SemiColon Stores Checkout System!");
let customerName = prompt("Enter customer name: ");
let productNames = [];
let quantities = [];
let unitPrices = [];
while (true) {
	let product = prompt("Enter product name (or 'done' to finish): ");
  if (product.toLowerCase() === "done") break;
	let price = Number(prompt("Enter unit price: "));
  while (isNaN(price)) {
    price = Number(prompt("Invalid input. Enter a valid number: "));
  }
	let qty = Number(prompt("Enter quantity purchased: "));
  while (isNaN(qty) || !Number.isInteger(qty)) {
    qty = Number(prompt("Invalid input. Enter a valid integer: "));
  }
  productNames.push(product);
  unitPrices.push(price);
  quantities.push(qty);
}
let cashierName = prompt("Enter cashier name: ");
let discountPercent = 0;
let discountResponse = prompt("Is there any discount for this customer? (yes/no): ");










