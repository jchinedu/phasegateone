import unittest
import mbtitest

class TestMBTIFunctions(unittest.TestCase):


	def test_process_answers_valid(self):
        	answers = "A" * 20
        	personality = mbtitest.process_answers(answers)
        	self.assertEqual(personality, "ESTJ")
