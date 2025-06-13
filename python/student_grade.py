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
