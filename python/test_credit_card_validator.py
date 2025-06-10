import unittest
from credit_card_validator import valid_length, card_type, check

class TestCreditCardValidator(unittest.TestCase):
	def test_valid_length(self):
        	self.assertTrue(valid_length("1234567890123456"))
	        self.assertFalse(valid_length("123456789012345"))
