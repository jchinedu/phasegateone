import unittest
import phone_app

class TestPhoneBookApp(unittest.TestCase):
	def test_add_contact(self):
		phone_app.add_contact()
