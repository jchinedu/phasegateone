QUESTIONS = [
	("Expend energy, enjoy groups", "Conserve energy, enjoy one-on-one"),
	("Interpret literally", "Look for meaning and possibilities"),
	("Logical, thinking, questioning", "Empathetic, feeling, accommodating"),
	("Organized, orderly", "Flexible, adaptable"),
	("More outgoing, think out loud", "More reserved, think to yourself"),
	("Practical, realistic, frank", "Tactful, kind, encouraging"),
	("Candid, straightforward, frank", "Tactful, kind, encouraging"),
	("Plan, schedule", "Unplanned, spontaneous"),
	("Seek many tasks, public activities", "Seek private, solitary activities"),
	("Standard, usual, convention", "Different, novel, unique"),
	("Firm, tend to criticize, hold the line", "Gentle, tend to appreciate, conciliate"),
	("Regulated, structured", "Easy-going, live and let live"),
	("External, communicative, express yourself", "Internal, reticent, keep to yourself"),
	("Focus on here-and-now", "Look to the future, big picture"),
	("Tough-minded, just", "Tender-hearted, merciful"),
	("Preparation, plan ahead", "Go with the flow, adapt as you go"),
	("Active, initiate", "Reflective, deliberate"),
	("Facts, things, what is", "Ideas, dreams, what could be, philosophical"),
	("Matter of fact, issue-oriented", "Sensitive, people-oriented, compassionate"),
	("Control, govern", "Latitude, freedom")
]

TRAITS = [
	('E', 'I'), ('S', 'N'), ('T', 'F'), ('J', 'P'),
        ('E', 'I'), ('S', 'N'), ('T', 'F'), ('J', 'P'),
	('E', 'I'), ('S', 'N'), ('T', 'F'), ('J', 'P'),
        ('E', 'I'), ('S', 'N'), ('T', 'F'), ('J', 'P'),
        ('E', 'I'), ('S', 'N'), ('T', 'F'), ('J', 'P')
]

def process_answers(answers):
    if len(answers) != len(QUESTIONS):
        raise ValueError("Answers must be exactly 20 characters long.")

    counts = {'E': 0, 'I': 0, 'S': 0, 'N': 0, 'T': 0, 'F': 0, 'J': 0, 'P': 0}

    for i, ch in enumerate(answers.upper()):
        if ch not in ('A', 'B'):
            raise ValueError("Invalid answer at position {}: {}".format(i + 1, ch))

        trait = TRAITS[i][0] if ch == 'A' else TRAITS[i][1]
        counts[trait] += 1
    result = ""
    result += 'E' if counts['E'] >= counts['I'] else 'I'
    result += 'S' if counts['S'] >= counts['N'] else 'N'
    result += 'T' if counts['T'] >= counts['F'] else 'F'
    result += 'J' if counts['J'] >= counts['P'] else 'P'

    return result
def describe_INTJ():
    return "The Architect: Strategic and imaginative thinkers."

def describe_INTP():
    return "The Thinker: Innovative and curious."

def describe_ENTJ():
    return "The Commander: Bold, imaginative leaders."

def describe_ENTP():
    return "The Debater: Clever and intellectual."

def describe_INFJ():
    return "The Advocate: Quiet, insightful idealists."

def describe_INFP():
    return "The Mediator: Gentle, empathetic dreamers."

def describe_ENFJ():
    return "The Protagonist: Charismatic and inspiring."

def describe_ENFP():
    return "The Campaigner: Energetic, free-spirited."

def describe_ISTJ():
    return "The Logistician: Responsible and honest."

def describe_ISFJ():
    return "The Defender: Protective and warm."

def describe_ESTJ():
    return "The Executive: Organized and confident."

def describe_ESFJ():
    return "The Consul: Caring and social."

def describe_ISTP():
    return "The Virtuoso: Bold and efficient."

def describe_ISFP():
    return "The Adventurer: Creative and spontaneous."

def describe_ESTP():
    return "The Entrepreneur: Energetic problem-solver."

def describe_ESFP():
    return "The Entertainer: Fun-loving and enthusiastic."

def describe_default():
    return "No description available."
def get_description(personality_type):
    if personality_type == "INTJ":
        return describe_INTJ()
    elif personality_type == "INTP":
        return describe_INTP()
    elif personality_type == "ENTJ":
        return describe_ENTJ()
    elif personality_type == "ENTP":
        return describe_ENTP()
    elif personality_type == "INFJ":
        return describe_INFJ()
    elif personality_type == "INFP":
        return describe_INFP()
    elif personality_type == "ENFJ":
        return describe_ENFJ()
    elif personality_type == "ENFP":
        return describe_ENFP()
    elif personality_type == "ISTJ":
        return describe_ISTJ()
    elif personality_type == "ISFJ":
        return describe_ISFJ()
    elif personality_type == "ESTJ":
        return describe_ESTJ()
    elif personality_type == "ESFJ":
        return describe_ESFJ()
    elif personality_type == "ISTP":
        return describe_ISTP()
    elif personality_type == "ISFP":
        return describe_ISFP()
    elif personality_type == "ESTP":
        return describe_ESTP()
    elif personality_type == "ESFP":
        return describe_ESFP()
    else:
        return describe_default()
