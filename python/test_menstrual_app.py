import unittest
from datetime import datetime
import menstrual_app
from menstrual_app import is_valid_date, add_days, is_leap_year

class TestMenstrualCycle(unittest.TestCase):

    def test_valid_date(self):
        self.assertTrue(is_valid_date(15, 6, 2025))
        self.assertFalse(is_valid_date(31, 2, 2025))

    def test_leap_year(self):
        self.assertTrue(is_leap_year(2024))
        self.assertFalse(is_leap_year(2023))
