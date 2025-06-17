def square_digits(num):
    result = ''
    for digit in str(num):
        squared = int(digit) ** 2
        result += str(squared)
    return int(result)