def calculate_totals(scores):
    totals = []
    for student_scores in scores:
        totals.append(sum(student_scores))
    return totals
def calculate_averages(totals, number_of_subjects):
    return [total / number_of_subjects for total in totals]