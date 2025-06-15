import unittest
import student_grade

class TestStudentGrades(unittest.TestCase):

    def test_calculate_totals(self):
        self.assertEqual(
            student_grade.calculate_totals([[90, 80, 70], [60, 50, 40], [100, 90, 80]]),
            [240, 150, 270]
        )

    def test_calculate_averages(self):
        self.assertEqual(
            student_grade.calculate_averages([240, 150, 270], 3),
            [80.0, 50.0, 90.0]
        )

    def test_check_position(self):
        self.assertEqual(
            student_grade.check_position([240, 150, 270]),
            [2, 3, 1]
        )
