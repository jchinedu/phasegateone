import unittest
from datetime import datetime
import semi_colon_store_check_out 

class Test_semi_colon_store_check_out(unittest.TestCase):
   
	def test_valid_input(self):
	 semi_colon_store_check_out.get_valid_int(10)
	

	def test_the_header_function(self):
	  semi_colon_store_check_out.print_header()
	
	def test_the_handle_payment_function_exist(self):
	  semi_colon_store_check_out.handle_payment(100)