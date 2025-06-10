def valid_length(card_number):
	if len(card_number) != 16:
		return False
	for ch in card_number:
		if not ch.isdigit():
			return False
	return True
def card_type(card_number):
	if card_number.startswith("4"):
		return "VISA"
	elif card_number.startswith("5"):
		return "MasterCard"
	elif card_number.startswith("37"):
		return "American Express"
	elif card_number.startswith("6"):
		return "Discover"
	else:
		return "Invalid"
def check(card_number):
	total = 0
	double_digit = False
	for i in range(len(card_number) - 1, -1, -1):
		digit = int(card_number[i])
		if double_digit:
			digit *= 2
		total += digit
		double_digit = not double_digit
	return total % 10 == 0
def main():
	card_number = input("Hello, kindly enter card details to verify: ")
	print("Credit card type:", card_type(card_number))