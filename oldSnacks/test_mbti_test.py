import unittest
import mbtitest

class TestMBTIFunctions(unittest.TestCase):


	def test_process_answers_valid(self):
        	answers = "A" * 20
        	personality = mbtitest.process_answers(answers)
        	self.assertEqual(personality, "ESTJ")
	def test_process_answers_invalid_length(self):
        	with self.assertRaises(ValueError):
            		mbtitest.process_answers("A" * 19)
	def test_get_description_known_types(self):
        	self.assertIn("Architect", mbtitest.get_description("INTJ"))
        	self.assertIn("Thinker", mbtitest.get_description("INTP"))
        	self.assertIn("Commander", mbtitest.get_description("ENTJ"))
        	self.assertIn("Debater", mbtitest.get_description("ENTP"))
        	self.assertIn("Advocate", mbtitest.get_description("INFJ"))
        	self.assertIn("Mediator", mbtitest.get_description("INFP"))
