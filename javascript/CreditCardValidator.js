const prompt = require('prompt-sync')();

function ValidLength(cardNumber) {
  if (cardNumber.length !== 16) {
    return false;
  }