def calculate_totals(scores):
    totals = []
    for student_scores in scores:
        totals.append(sum(student_scores))
    return totals