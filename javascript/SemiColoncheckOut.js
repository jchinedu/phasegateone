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
if (discountResponse.toLowerCase() === "yes") {
  discountPercent = Number(prompt("Enter discount percentage: "));
  if (isNaN(discountPercent) || discountPercent < 0) discountPercent = 0;
  if (discountPercent > 100) discountPercent = 100;
}
let subtotal = 0;
for (let i = 0; i < productNames.length; i++) {
  subtotal += quantities[i] * unitPrices[i];
}
let discountAmount = subtotal * discountPercent / 100;
let totalAfterDiscount = subtotal - discountAmount;
let vat = totalAfterDiscount * 0.075;
let totalDue = totalAfterDiscount + vat;
console.log("Customer: " + customerName);
console.log("Cashier: " + cashierName);
console.log("Items:");
for (let i = 0; i < productNames.length; i++) {
  let lineTotal = quantities[i] * unitPrices[i];
  console.log(productNames[i] + " - Qty: " + quantities[i] + ", Price: " + unitPrices[i] + ", Total: " + lineTotal);
}













