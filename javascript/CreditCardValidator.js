const prompt = require('prompt-sync')();

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