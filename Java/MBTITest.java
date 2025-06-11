public class MBTITest{
	
	static String[][] questions = {
		{"Expend energy, enjoy groups", "Conserve energy, enjoy one-on-one"},
		{"Interpret literally", "Look for meaning and possibilities"},
                {"Logical, thinking, questioning", "Empathetic, feeling, accommodating"},
	        {"Organized, orderly", "Flexible, adaptable"},
		{"More outgoing, think out loud", "More reserved, think to yourself"},
		{"Practical, realistic, frank", "Tactful, kind, encouraging"},
	        {"Candid, straightforward, frank", "Tactful, kind, encouraging"},
	        {"Plan, schedule", "Unplanned, spontaneous"},
	        {"Seek many tasks, public activities", "Seek private, solitary activities"},
	        {"Standard, usual, convention", "Different, novel, unique"},
	        {"Firm, tend to criticize, hold the line", "Gentle, tend to appreciate, conciliate"},
	        {"Regulated, structured", "Easy-going, live and let live"},
	        {"External, communicative, express yourself", "Internal, reticent, keep to yourself"},
	        {"Focus on here-and-now", "Look to the future, big picture"},
	        {"Tough-minded, just", "Tender-hearted, merciful"},
	        {"Preparation, plan ahead", "Go with the flow, adapt as you go"},
	        {"Active, initiate", "Reflective, deliberate"},
	        {"Facts, things, what is", "Ideas, dreams, what could be, philosophical"},
	        {"Matter of fact, issue-oriented", "Sensitive, people-oriented, compassionate"},
	{"Control, govern", "Latitude, freedom"}
    };
	static char[] traitForA = {
		'E', 'S', 'T', 'J', 'E', 'S', 'T', 'J', 'E', 'S',
		'T', 'J', 'E', 'S', 'T', 'J', 'E', 'S', 'T', 'J'
    };
	static char[] traitForB = {
        'I', 'N', 'F', 'P', 'I', 'N', 'F', 'P', 'I', 'N',
        'F', 'P', 'I', 'N', 'F', 'P', 'I', 'N', 'F', 'P'
    };
	public static String processAnswers(String answers) {
        if (answers.length() != questions.length) {
	throw new IllegalArgumentException("Answers length must be " + questions.length);
        }
	int[] counts = new int[8];
	for (int i = 0; i < questions.length; i++) {
            char answer = Character.toUpperCase(answers.charAt(i));
            if (answer != 'A' && answer != 'B') {
                throw new IllegalArgumentException("Invalid answer at position " + (i+1) + ". Only A or B allowed.");
            }
            updateTraitCount(answer, i, counts);
        }
	return determineMBTIType(counts);
    }
	private static void updateTraitCount(char answer, int questionIndex, int[] counts) {
        char trait = (answer == 'A') ? traitForA[questionIndex] : traitForB[questionIndex];
        switch (trait) {
            case 'E' -> counts[0]++;
            case 'I' -> counts[1]++;
            case 'S' -> counts[2]++;
            case 'N' -> counts[3]++;
            case 'T' -> counts[4]++;
            case 'F' -> counts[5]++;
            case 'J' -> counts[6]++;
            case 'P' -> counts[7]++;
        }
    }
	private static String determineMBTIType(int[] counts) {
        char first = counts[0] >= counts[1] ? 'E' : 'I';
        char second = counts[2] >= counts[3] ? 'S' : 'N';
        char third = counts[4] >= counts[5] ? 'T' : 'F';
        char fourth = counts[6] >= counts[7] ? 'J' : 'P';
        return "" + first + second + third + fourth;
    }
	public static void displayPersonalityDescription(String type) {
        switch (type) {
            case "INTJ" -> System.out.println("The Architect: Strategic and imaginative thinkers.");
            case "INTP" -> System.out.println("The Thinker: Innovative and curious.");
            case "ENTJ" -> System.out.println("The Commander: Bold, imaginative leaders.");
            case "ENTP" -> System.out.println("The Debater: Clever and intellectual.");
            case "INFJ" -> System.out.println("The Advocate: Quiet, insightful idealists.");
            case "INFP" -> System.out.println("The Mediator: Gentle, empathetic dreamers.");
            case "ENFJ" -> System.out.println("The Protagonist: Charismatic and inspiring.");
            case "ENFP" -> System.out.println("The Campaigner: Energetic, free-spirited.");
            case "ISTJ" -> System.out.println("The Logistician: Responsible and honest.");
            case "ISFJ" -> System.out.println("The Defender: Protective and warm.");
	 case "ESTJ" -> System.out.println("The Executive: Organized and confident.");
            case "ESFJ" -> System.out.println("The Consul: Caring and social.");
            case "ISTP" -> System.out.println("The Virtuoso: Bold and efficient.");
            case "ISFP" -> System.out.println("The Adventurer: Creative and spontaneous.");
            case "ESTP" -> System.out.println("The Entrepreneur: Energetic problem-solver.");
            case "ESFP" -> System.out.println("The Entertainer: Fun-loving and enthusiastic.");
            default -> System.out.println("No description available for this personality type.");
        }
    }
}












