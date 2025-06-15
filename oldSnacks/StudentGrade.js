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
const average = total / numberOfStudents;

    console.log("SUBJECT SUMMARY");
    console.log(`Subject ${i + 1}`);
    console.log(
      `  Highest Scoring student is : Student ${highestStudent} scoring ${highestScore}`
    );
    console.log(
      `  Lowest Scoring student is : Student ${lowestStudent} scoring ${lowestScore}`
    );
    console.log(`  Total Score is : ${total}`);
    console.log(`  Average Score is: ${average.toFixed(2)}`);
    console.log(`  Number of Passes: ${passes}`);
    console.log(`  Number of Fails: ${failures}`);
  }
}
const numberOfStudents = parseInt(prompt("How many students do you have: "));
const numberOfSubjects = parseInt(prompt("How many subjects do they offer: "));

const scores = [];

for (let i = 0; i < numberOfStudents; i++) {
  console.log(`Enter scores for Student ${i + 1}`);
  const studentScores = [];
  for (let j = 0; j < numberOfSubjects; j++) {
    let score;
    do {
      score = parseInt(prompt(`Enter score for Subject ${j + 1}: `));
      if (score < 0 || score > 100) {
        console.log("Invalid score, must be between 0-100.");
      }
    } while (score < 0 || score > 100);
    studentScores.push(score);
    console.log("Saving >>>>>>>>>>>>>>>");
    console.log("Saved successfully");
  }
  scores.push(studentScores);
}

const totals = calculateTotals(scores);
const averages = calculateAverages(totals, numberOfSubjects);
const positions = checkPosition(totals);

const passMark = parseInt(prompt("Enter pass mark: "));

let option;
do {
  console.log("\n=== MENU ===");
  console.log("1. Display Student Table");
  console.log("2. Display Subject Summary");
  console.log("3. Display Class Summary");
  console.log("0. Exit");
  option = parseInt(prompt("Choose an option: "));

  switch (option) {
    case 1:
      displayTable(scores, totals, averages, positions);
      break;
    case 2:
      subjectSummary(scores, passMark);
      break;
    case 3:
    case 0:
      console.log("Exiting...");
      break;
    default:
      console.log("Invalid option. Try again.");
  }
} while (option !== 0);
