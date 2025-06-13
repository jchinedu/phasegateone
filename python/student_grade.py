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