from datetime import datetime

def get_valid_int(prompt):
    while True:
        try:
            return int(input(prompt))
        except ValueError:
            print("Invalid input. Enter a valid integer: ")
def get_valid_float(prompt):
    while True:
        try:
            return float(input(prompt))
        except ValueError:
            print("Invalid input. Enter a valid number: ")
def print_header():
    print("====================================================")
    print("SEMICOLON STORES")
    print("MAIN BRANCH")
    print("LOCATION: 312, HERBERT MACAULY WAY, SABO YABA, LAGOS.")
    print("Tel: +123 456 7890")
    print("Date:", datetime.now().strftime("%Y-%m-%d %H:%M:%S"))
def handle_payment(total_due):
    print("Select payment method:")
    print("1. Cash")
    print("2. Card")
    print("3. Mobile Money")
    payment_choice = get_valid_int("Enter your choice: ")