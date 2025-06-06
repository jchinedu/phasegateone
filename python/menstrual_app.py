from datetime import datetime, timedelta

def is_valid_date(day, month, year):
    try:
        datetime(year, month, day)
        return True
    except ValueError:
        return False
def add_days(day, month, year, days_to_add):
    date = datetime(year, month, day) + timedelta(days=days_to_add)
    return date.day, date.month, date.year
def is_leap_year(year):
    return year % 4 == 0 and (year % 100 != 0 or year % 400 == 0)