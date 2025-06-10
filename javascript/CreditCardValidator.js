const prompt = require('prompt-sync')();

function AllDigits(number) {
  for (let i = 0; i < number.length; i++) {
    if (number[i] < '0' || number[i] > '9') {
      return false;
    }
  }
  return true;
}

function ValidLength(cardNumber) {
  if (cardNumber.length !== 16) {
    return false;
  }
for (let i = 0; i < cardNumber.length; i++) {
    let ch = cardNumber[i];
    if (ch < '0' || ch > '9') {
      return false;
    }
  }
  return true;
}
function CardType(cardNumber) {
  if (cardNumber.startsWith('4')) {
    return "VISA";
  } else if (cardNumber.startsWith('5')) {
    return "MasterCard";
  } else if (cardNumber.startsWith('37')) {
    return "American Express";
  } else if (cardNumber.startsWith('6')) {
    return "Discover";
  } else {
    return "invalid";
  }
}
function check(cardNumber) {
  let total = 0;
  let shouldDouble = false;

  for (let i = cardNumber.length - 1; i >= 0; i--) {
    let digit = parseInt(cardNumber[i]);
    if (shouldDouble) {
      digit *= 2;
    }
    total += digit;
    shouldDouble = !shouldDouble;
  }

  return total % 10 === 0;
}

do {
  cardNumber = prompt("Please enter your credit card number: ");
} while (!AllDigits(cardNumber));

console.log("Thanks! You entered:", cardNumber);
console.log(`\nCard Number: ${cardNumber}`);
console.log(`Card Type: ${CardType(cardNumber)}`);
console.log(`Number of Digits: ${cardNumber.length}`);
if (!ValidLength(cardNumber)) {
  console.log("Status: Invalid");
} else if (check(cardNumber)) {
  console.log("Status: Valid ");
} else {
  console.log("Status: Invalid");
}