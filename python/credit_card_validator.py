def valid_length(card_number):
	if len(card_number) != 16:
		return False
	for ch in card_number:
		if not ch.isdigit():