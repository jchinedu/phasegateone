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