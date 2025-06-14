const prompt = require("prompt-sync")();
function calculateTotals(scores) {
  let totals = [];

  for (let i = 0; i < scores.length; i++) {
    let total = 0;

    for (let j = 0; j < scores[i].length; j++) {
      total += scores[i][j];
    }

    totals.push(total);
  }

  return totals;
}
function calculateAverages(totals, numberOfSubjects) {
  let averages = [];
  for (let i = 0; i < totals.length; i++) {
    averages.push(totals[i] / numberOfSubjects);
  }
  return averages;
}
