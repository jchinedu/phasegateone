import unittest
from credit_card_validator import valid_length, card_type, check

class TestCreditCardValidator(unittest.TestCase):
	def test_valid_length(self):
        	self.assertTrue(valid_length("1234567890123456"))
	        self.assertFalse(valid_length("123456789012345"))
	def test_card_type(self):
        	self.assertEqual(card_type("4111111111111111"), "VISA")
        	self.assertEqual(card_type("5111111111111111"), "MasterCard")
        	self.assertEqual(card_type("371111111111111"), "American Express")
       		self.assertEqual(card_type("6011111111111111"), "Discover")
        	self.assertEqual(card_type("8011111111111111"), "Invalid")
	def test_check_valid(self):
        	self.assertTrue(check("4111111111111111"))
	def test_check_invalid(self):
        	self.assertFalse(check("4539682995824396"))
