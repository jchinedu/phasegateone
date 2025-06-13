def calculate_totals(scores):
    totals = []
    for student_scores in scores:
        totals.append(sum(student_scores))
    return totals
def calculate_averages(totals, number_of_subjects):
    return [total / number_of_subjects for total in totals]
def check_position(totals):
    ranks = []
    for i in range(len(totals)):
        rank = 1
        for j in range(len(totals)):
            if totals[j] > totals[i]:
                rank += 1
        ranks.append(rank)
    return ranks
def display_table(scores, totals, averages, positions):
    number_of_students = len(scores)
    number_of_subjects = len(scores[0]) if number_of_students > 0 else 0
    line_length = int(39 + (number_of_subjects * (number_of_subjects) * 1.5))
    print("=" * line_length)
    print(f"{'Student':<8}", end="")
    for j in range(number_of_subjects):
        print(f"Sub{j + 1:<8}", end="")
    print(f"{'Total':<8}{'Average':<8}{'Position':<8}")
    print("=" * line_length)
    for i in range(number_of_students):
        print(f"{i+1:<8}", end="")
        for j in range(number_of_subjects):
            print(f"{scores[i][j]:<8}", end="")
        print(f"{totals[i]:<8}{averages[i]:<8.2f}{positions[i]:<8}")
    for _ in range(2):
        print("=" * line_length)
def subject_summary(scores, pass_mark):
    number_of_students = len(scores)
    number_of_subjects = len(scores[0]) if number_of_students > 0 else 0
    for i in range(number_of_subjects):
        total = 0
        passes = 0
        failures = 0
        highest_score = scores[0][i]
        lowest_score = scores[0][i]
        highest_student = 1
        lowest_student = 1

        for student in range(number_of_students):
            score = scores[student][i]
            total += score
            if score >= pass_mark:
                passes += 1
            else:
                failures += 1
            if score > highest_score:
                highest_score = score
                highest_student = student + 1
            if score < lowest_score:
                lowest_score = score
                lowest_student = student + 1
        average = total / number_of_students

        print("SUBJECT SUMMARY")
        print(f"Subject {i + 1}")
        print(f"  Highest Scoring student is : Student {highest_student} scoring {highest_score}")
        print(f"  Lowest Scoring student is : Student {lowest_student} scoring {lowest_score}")
        print(f"  Total Score is : {total}")
        print(f"  Average Score is: {average:.2f}")
        print(f"  Number of Passes: {passes}")
        print(f"  Number of Fails: {failures}")
def find_hardest_subject(scores, pass_mark):
    number_of_subjects = len(scores[0])
    number_of_students = len(scores)
    max_failures = -1
    hardest_subject = -1

    for k in range(number_of_subjects):
        failures = 0
        for student in range(number_of_students):
            if scores[student][k] < pass_mark:
                failures += 1
        if failures > max_failures:
            max_failures = failures
            hardest_subject = k
    return hardest_subject, max_failures
def find_easiest_subject(scores, pass_mark):
    number_of_subjects = len(scores[0])
    number_of_students = len(scores)
    max_passes = -1
    easiest_subject = -1

    for i in range(number_of_subjects):
        passes = 0
        for student in range(number_of_students):
            if scores[student][i] >= pass_mark:
                passes += 1
        if passes > max_passes:
            max_passes = passes
            easiest_subject = i
    return easiest_subject, max_passes
