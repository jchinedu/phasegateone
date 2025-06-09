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

def print_safe_period(start_day, start_month, start_year):
    before_start = add_days(start_day, start_month, start_year, 0)
    before_end = add_days(start_day, start_month, start_year, 11)
    after_start = add_days(start_day, start_month, start_year, 17)
    after_end = add_days(start_day, start_month, start_year, 28)
    print(f"Safe Period Before Fertile Window: {before_start[0]:02d}-{before_start[1]:02d}-{before_start[2]} to {before_end[0]:02d}-{before_end[1]:02d}-{before_end[2]}")
    print(f"Safe Period After Fertile Window: {after_start[0]:02d}-{after_start[1]:02d}-{after_start[2]} to {after_end[0]:02d}-{after_end[1]:02d}-{after_end[2]}")

def main():
    name = input("What is your name? ")
    print("Please enter the first day of your last menstrual cycle.")
    day = int(input("Day (1-31): "))
    month = int(input("Month (1-12): "))
    year = int(input("Year (e.g., 2025): "))

    if not is_valid_date(day, month, year):
        print("Invalid date entered. Please enter a valid date.")
        return

    print(f"\nHello {name}, your last menstrual cycle started on {day:02d}-{month:02d}-{year}.\n")
    print_period_flow_dates(day, month, year)
    print_ovulation_period(day, month, year)
    print_safe_period(day, month, year)


main()


# i was able to calculate for 2026, invalid year 
