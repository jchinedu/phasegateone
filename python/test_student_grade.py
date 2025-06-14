import unittest

import student_grade

class TestStudentGrades(unittest.TestCase):

	def test_calculate_totals(self):
        	expected = [245, 155, 100]
        	self.assertEqual(student_grade.calculate_totals(self.scores), expected)