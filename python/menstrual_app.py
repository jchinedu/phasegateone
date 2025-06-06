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
def print_period_flow_dates(start_day, start_month, start_year):
    print("Your Period flow dates (5 Days):")
    for i in range(5):
        day, month, year = add_days(start_day, start_month, start_year, i)
        print(f"Day {i+1}: {day:02d}-{month:02d}-{year}")
def print_ovulation_period(start_day, start_month, start_year):
    start = add_days(start_day, start_month, start_year, 12)
    end = add_days(start_day, start_month, start_year, 16)
    print(f"Ovulation Period: Start: {start[0]:02d}-{start[1]:02d}-{start[2]} End: {end[0]:02d}-{end[1]:02d}-{end[2]}")
