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
	
    if payment_choice == 1:
        amount_paid = get_valid_float("Enter amount paid by customer: ")
        if amount_paid < total_due:
            print(f"Insufficient payment. Please pay at least: {total_due:.2f}")
            return handle_payment(total_due)
        else:
            change = amount_paid - total_due
            print(f"Change to give back: {change:.2f}")
            return amount_paid
    elif payment_choice == 2:
        card_number = input("Enter card number (simulate): ")
        print(f"Payment of {total_due:.2f} processed via card ending with {card_number[-4:]}")
        return total_due
    elif payment_choice == 3:
        mm_ref = input("Enter mobile money reference: ")
        print(f"Payment of {total_due:.2f} processed with reference {mm_ref}")
        return total_due
    else:
        print("Invalid payment method. Please try again.")
        return handle_payment(total_due)
def main():
    print("Welcome to SemiColon Stores Checkout System!")

    customer_name = input("Enter customer name: ")

    product_names = []
    quantities = []
    unit_prices = [] 
    while True:
        product = input("Enter product name (or 'done' to finish): ")
        if product.lower() == 'done':
            break

        price = get_valid_float("Enter unit price: ")
        qty = get_valid_int("Enter quantity purchased: ")
        product_names.append(product)
        unit_prices.append(price)
        quantities.append(qty)
    cashier_name = input("Enter cashier name: ")
    discount_response = input("Is there any discount for this customer? (yes/no): ").strip().lower()
    discount_percent = 0.0
    if discount_response == 'yes':
        discount_percent = get_valid_float("Enter discount percentage: ")
        if discount_percent < 0:
            discount_percent = 0
        elif discount_percent > 100:
            discount_percent = 100
    subtotal = sum(q * p for q, p in zip(quantities, unit_prices))
    discount_amount = subtotal * discount_percent / 100.0
    total_after_discount = subtotal - discount_amount
    vat = total_after_discount * 0.075
    total_due = total_after_discount + vat
    print_header()
    print(f"Customer: {customer_name}")
    print(f"Cashier: {cashier_name}")
    print("=================================================")
    print(f"{'ITEM':<15} {'QTY':>5} {'PRICE':>10} {'TOTAL(NGN)':>12}")
    print("-------------------------------------------------")
    
    for name, qty, price in zip(product_names, quantities, unit_prices):
        line_total = qty * price
        print(f"{name:<15} {qty:>5} {price:>10.2f} {line_total:>12.2f}")