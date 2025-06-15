const prompt = require('prompt-sync')();

const questions = [
  ["Expend energy, enjoy groups", "Conserve energy, enjoy one-on-one"],
  ["Interpret literally", "Look for meaning and possibilities"],
  ["Logical, thinking, questioning", "Empathetic, feeling, accommodating"],
  ["Organized, orderly", "Flexible, adaptable"],
  ["More outgoing, think out loud", "More reserved, think to yourself"],
  ["Practical, realistic, frank", "Tactful, kind, encouraging"],
  ["Candid, straightforward, frank", "Tactful, kind, encouraging"],
  ["Plan, schedule", "Unplanned, spontaneous"],
  ["Seek many tasks, public activities", "Seek private, solitary activities"],
  ["Standard, usual, convention", "Different, novel, unique"],
  ["Firm, tend to criticize, hold the line", "Gentle, tend to appreciate, conciliate"],
  ["Regulated, structured", "Easy-going, live and let live"],
  ["External, communicative, express yourself", "Internal, reticent, keep to yourself"],
  ["Focus on here-and-now", "Look to the future, big picture"],
  ["Tough-minded, just", "Tender-hearted, merciful"],
  ["Preparation, plan ahead", "Go with the flow, adapt as you go"],
  ["Active, initiate", "Reflective, deliberate"],
  ["Facts, things, what is", "Ideas, dreams, what could be, philosophical"],
  ["Matter of fact, issue-oriented", "Sensitive, people-oriented, compassionate"],
  ["Control, govern", "Latitude, freedom"]
];

const traits = [
  ['E', 'I'], ['S', 'N'], ['T', 'F'], ['J', 'P'],
  ['E', 'I'], ['S', 'N'], ['T', 'F'], ['J', 'P'],
  ['E', 'I'], ['S', 'N'], ['T', 'F'], ['J', 'P'],
  ['E', 'I'], ['S', 'N'], ['T', 'F'], ['J', 'P'],
  ['E', 'I'], ['S', 'N'], ['T', 'F'], ['J', 'P']
];

function processAnswers(answerString) {
  const counts = { E: 0, I: 0, S: 0, N: 0, T: 0, F: 0, J: 0, P: 0 };

  for (let i = 0; i < answerString.length; i++) {
    const choice = answerString[i];
    const trait = choice === 'A' ? traits[i][0] : traits[i][1];
    counts[trait]++;
  }

  const type = [
    counts['E'] >= counts['I'] ? 'E' : 'I',
    counts['S'] >= counts['N'] ? 'S' : 'N',
    counts['T'] >= counts['F'] ? 'T' : 'F',
    counts['J'] >= counts['P'] ? 'J' : 'P'
  ].join('');

  return type;
}

function getDescription(type) {
  if (type === "INTJ") return "The Architect: Strategic and imaginative thinkers.";
  if (type === "INTP") return "The Thinker: Innovative and curious.";
  if (type === "ENTJ") return "The Commander: Bold, imaginative leaders.";
  if (type === "ENTP") return "The Debater: Clever and intellectual.";
  if (type === "INFJ") return "The Advocate: Quiet, insightful idealists.";
  if (type === "INFP") return "The Mediator: Gentle, empathetic dreamers.";
  if (type === "ENFJ") return "The Protagonist: Charismatic and inspiring.";
  if (type === "ENFP") return "The Campaigner: Energetic, free-spirited.";
  if (type === "ISTJ") return "The Logistician: Responsible and honest.";
  if (type === "ISFJ") return "The Defender: Protective and warm.";
  if (type === "ESTJ") return "The Executive: Organized and confident.";
  if (type === "ESFJ") return "The Consul: Caring and social.";
  if (type === "ISTP") return "The Virtuoso: Bold and efficient.";
  if (type === "ISFP") return "The Adventurer: Creative and spontaneous.";
  if (type === "ESTP") return "The Entrepreneur: Energetic problem-solver.";
  if (type === "ESFP") return "The Entertainer: Fun-loving and enthusiastic.";
  return "No description available.";
}

function runTest() {
  console.log("Welcome to the MBTI Test!");
  console.log("You will be asked 20 questions. Respond with A or B.\n");

  let answers = "";

  for (let i = 0; i < questions.length; i++) {
    const [a, b] = questions[i];
    while (true) {
      console.log(`Q${i + 1}:`);
      console.log(`A: ${a}`);
      console.log(`B: ${b}`);
      const response = prompt("Your answer (A/B): ").toUpperCase().trim();

      if (response === 'A' || response === 'B') {
        answers += response;
        console.log();
        break;
      } else {
        console.log("Invalid input. Please enter 'A' or 'B'.\n");
      }
    }
  }

  const type = processAnswers(answers);
  const description = getDescription(type);
  console.log("\nYour MBTI personality type is:", type);
  console.log(description);
}

runTest();
