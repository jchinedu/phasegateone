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
function checkPosition(totals) {
  const ranks = [];
  for (let i = 0; i < totals.length; i++) {
    let rank = 1;
    for (let j = 0; j < totals.length; j++) {
      if (totals[j] > totals[i]) {
        rank++;
      }
    }
    ranks.push(rank);
  }
  return ranks;
}
function displayTable(scores, totals, averages, positions) {
  const numberOfStudents = scores.length;
  const numberOfSubjects = scores[0].length;
  const lineLength = 39 + numberOfSubjects * numberOfSubjects * 1.5;
console.log("=".repeat(lineLength));
  process.stdout.write("Student  ");
  for (let j = 0; j < numberOfSubjects; j++) {
    process.stdout.write(`Sub${j + 1}   `);
  }
process.stdout.write("Total   Average Position\n");
  console.log("=".repeat(lineLength));
