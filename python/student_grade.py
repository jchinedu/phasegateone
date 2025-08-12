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
def main():
   while True:
        try:
            number_of_students = int(input("How many students do you have: "))
        except ValueError:
            print("That was not a number. Please enter a whole number.")
            continue

        if number_of_students <= 0:
            print("Number of students must be positive.")
            continue
        else:
            break

   while True:
        try:
            number_of_subjects = int(input("How many subjects do they offer: "))
        except ValueError:
            print("That was not a number. Please enter a whole number.")
            continue

        if number_of_subjects <= 0:
            print("Number of subjects must be positive.")
            continue
        else:
            break
   scores = []
   for i in range(number_of_students):
        print(f"Enter scores for Student {i + 1}")
        student_scores = []
        for j in range(number_of_subjects):
            while True:
                score = int(input(f"Enter score for Subject {j + 1}: "))
                if 0 <= score <= 100:
                    break
                print("Invalid score, must be between 0-100.")
            print("Saving >>>>>>>>>>>>>>>")
            print("Saved successfully")
            student_scores.append(score)
        scores.append(student_scores)
   totals = calculate_totals(scores)
   averages = calculate_averages(totals, number_of_subjects)
   positions = check_position(totals)

   pass_mark = int(input("Enter pass mark: "))

 
   option = None
   while option != 0:
        print("\n=== MENU ===")
        print("1. Display Student Table")
        print("2. Display Subject Summary")
        print("3. Display Class Summary")
        print("0. Exit")

        try:
            option = int(input("Choose an option: "))
        except ValueError:
            print("Please enter a valid option.")
            continue

        if option == 1:
            display_table(scores, totals, averages, positions)
        elif option == 2:
            subject_summary(scores, pass_mark)
            print("===========================================================")
        elif option == 3:
            class_summary(scores, pass_mark)
        elif option == 0:
            print("Exiting..")
        else:
            print("Invalid option. Try again.")

main()

