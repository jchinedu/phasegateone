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

console.log("Subtotal: " + subtotal);
console.log("Discount (" + discountPercent + "%): " + discountAmount);
console.log("VAT @7.5%: " + vat);
console.log("Total Due: " + totalDue);
console.log();

function handlePayment(totalDue) {
  while (true) {
    console.log("Select payment method:");
    console.log("1. Cash");
    console.log("2. Card");
    console.log("3. Mobile Money");
    let paymentChoice = Number(prompt("Enter your choice: "));
    if (![1, 2, 3].includes(paymentChoice)) {
      console.log("Invalid payment method. Try again.");
      continue;
    }
    switch (paymentChoice) {
      case 1:
        let amountPaid = Number(prompt("Enter amount paid: "));
        while (isNaN(amountPaid) || amountPaid < totalDue) {
          amountPaid = Number(prompt("Insufficient amount. Enter at least " + totalDue + ": "));
        }
        let change = amountPaid - totalDue;
        console.log("Change: " + change);
        return amountPaid;
      case 2:
        let cardNumber = prompt("Enter card number: ");
        console.log("Payment of " + totalDue + " processed via card ending with " + cardNumber);
        return totalDue;
      case 3:
        let mmRef = prompt("Enter mobile money reference: ");
        console.log("Payment of " + totalDue + " processed with reference " + mmRef);
        return totalDue;
    }
  }
}














