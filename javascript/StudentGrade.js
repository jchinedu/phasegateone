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
for (let i = 0; i < numberOfStudents; i++) {
    process.stdout.write(`${i + 1}        `);
    for (let j = 0; j < numberOfSubjects; j++) {
      process.stdout.write(`${scores[i][j]}      `);
    }
process.stdout.write(
      `${totals[i]}      ${averages[i].toFixed(2)}   ${positions[i]}\n`
    );
  }
for (let k = 0; k < 2; k++) {
    console.log("=".repeat(lineLength));
  }
}
function subjectSummary(scores, passMark) {
  const numberOfStudents = scores.length;
  const numberOfSubjects = scores[0].length;
for (let i = 0; i < numberOfSubjects; i++) {
    let total = 0;
    let passes = 0;
    let failures = 0;
    let highestScore = scores[0][i];
    let lowestScore = scores[0][i];
    let highestStudent = 1;
    let lowestStudent = 1;

    for (let student = 0; student < numberOfStudents; student++) {
      const score = scores[student][i];
      total += score;

      if (score >= passMark) {
        passes++;
      } else {
        failures++;
      }

      if (score > highestScore) {
        highestScore = score;
        highestStudent = student + 1;
      }

      if (score < lowestScore) {
        lowestScore = score;
        lowestStudent = student + 1;
      }
    }
