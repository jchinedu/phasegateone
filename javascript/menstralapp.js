const prompt = require('prompt-sync')();

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
  const responses = [
    "Nice! Shoutout to Semicolon Africa.",
    "Learning is power!",
    "We're happy your circle shared us!",
    "Glad you searched and found us!",
    "TikTok knows everything!",
    "Thanks for watching and joining.",
    "Shoutout to the influencers out there!",
    "Great to know professionals recommend us.",
    "Thank you for discovering Semi Flow."
  ];

  if (sourceChoice >= 1 && sourceChoice <= 9) {
    console.log(responses[sourceChoice - 1]);
  } else {
    console.log("Thanks for joining us!");
  }

  const dobInput = prompt("\nWhen were you born? (YYYY-MM-DD): ");
  const dob = new Date(dobInput);
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
  const startDate = new Date(dateInput);

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


console.log(main());
