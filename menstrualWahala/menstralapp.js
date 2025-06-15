const prompt = require('prompt-sync')();

function randomInt(min, max) {
  return Math.floor(Math.random() * (max - min)) + min;
}

function main() {
  console.log("==================================");
  console.log("   Welcome to Semi Flow Tracker   ");
  console.log("==================================");

  while (true) {
    console.log("\nAre you using Semi Flow for yourself?");
    console.log("1. Yes");
    console.log("2. No, I have a partner");
    console.log("0. Exit");

    const mainChoice = Number(prompt("Enter your choice: "));

    if (mainChoice === 1) {
      handlePersonalUse();
    } else if (mainChoice === 2) {
      console.log("Partner tracking isn’t available yet.");
    } else if (mainChoice === 0) {
      console.log("Thank you for using Semi Flow. Goodbye!");
      break;
    } else {
      console.log("Invalid input. Please enter 1, 2, or 0.");
    }
  }
}

function handlePersonalUse() {
  const sources = [
    "Semicolon Africa",
    "Personal learning",
    "Friends or family",
    "Google Play or Google Search",
    "TikTok",
    "YouTube",
    "Influencer or Celebrity",
    "Medical professional",
    "Others"
  ];

  console.log("\nHow did you find out about Semi Flow?");
  sources.forEach((s, i) => console.log(`${i + 1}. ${s}`));

  const sourceChoice = Number(prompt("Enter your choice (1 to 9): "));
  if (sourceChoice >= 1 && sourceChoice <= sources.length) {
    console.log(`Thanks! You selected: ${sources[sourceChoice - 1]}`);
  } else {
    console.log("Thanks for joining us!");
  }

  const dobInput = prompt("\nWhen were you born? (YYYY-MM-DD): ");
  const [year, month, day] = dobInput.split("-").map(Number);
  const dob = new Date(year, month - 1, day);
  if (isNaN(dob.getTime())) {
    console.log("Invalid date format. Use YYYY-MM-DD.");
    return;
  }

  const age = calculateAge(dob);
  if (age < 13) {
    console.log("Sorry, Semi Flow is for users aged 13 and above.");
    return;
  }

  console.log("\nAre you pregnant?");
  console.log("1. No, but I want to be");
  console.log("2. No, I am here to understand my body better");
  console.log("3. Yes, I am");

  const pregChoice = Number(prompt("Enter your choice: "));
  if (pregChoice === 1) {
    console.log("We’re here to support your journey.");
  } else if (pregChoice === 2) {
    console.log("Awesome! Let's help you understand your body better.");
    getMenstrualCycleInput();
  } else if (pregChoice === 3) {
    console.log("Congratulations! Pregnancy support features coming soon.");
  } else {
    console.log("Thanks for sharing!");
  }
}

function calculateAge(dob) {
  const today = new Date();
  let age = today.getFullYear() - dob.getFullYear();
  const m = today.getMonth() - dob.getMonth();
  if (m < 0 || (m === 0 && today.getDate() < dob.getDate())) {
    age--;
  }
  return age;
}

function getMenstrualCycleInput() {
  const name = prompt("What is your name? ");
  const dateInput = prompt("Enter the first day of your last menstrual cycle (YYYY-MM-DD): ");
  const [year, month, day] = dateInput.split("-").map(Number);
  const startDate = new Date(year, month - 1, day);

  if (isNaN(startDate.getTime())) {
    console.log("Invalid date, kindly enter the correct date in YYYY-MM-DD format.");
    return;
  }

  console.log(`\nHello ${name}, your last menstrual cycle started on ${formatDate(startDate)}.\n`);
  printPeriodFlowDates(startDate);
  printOvulationPeriod(startDate);
  printNextPeriodDate(startDate);
  printSafePeriod(startDate);
}

function printPeriodFlowDates(startDate) {
  console.log("Your Period flow dates (5 Days):");
  for (let i = 0; i < 5; i++) {
    console.log(`Day ${i + 1}: ${formatDate(addDays(startDate, i))}`);
  }
  console.log();
}

function printOvulationPeriod(startDate) {
  console.log("Ovulation Period:");
  console.log(`Start: ${formatDate(addDays(startDate, 12))}`);
  console.log(`End:   ${formatDate(addDays(startDate, 16))}\n`);
}

function printNextPeriodDate(startDate) {
  const nextPeriod = addDays(startDate, 28 + randomInt(0, 3));
  console.log("Your Next Period Prediction:");
  console.log(`Predicted Date: ${formatDate(nextPeriod)}\n`);
}

function printSafePeriod(startDate) {
  console.log("Safe Period Dates:\nBefore fertile window:");
  for (let i = 0; i < 12; i++) {
    console.log(formatDate(addDays(startDate, i)));
  }

  console.log("\nAfter fertile window:");
  for (let i = 19; i < 29; i++) {
    console.log(formatDate(addDays(startDate, i)));
  }
  console.log();
}

function addDays(date, days) {
  const newDate = new Date(date);
  newDate.setDate(newDate.getDate() + days);
  return newDate;
}

function formatDate(date) {
  return date.toISOString().split("T")[0];
}

main();
