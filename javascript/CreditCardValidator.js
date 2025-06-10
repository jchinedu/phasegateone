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