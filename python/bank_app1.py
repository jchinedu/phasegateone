accounts = []

def create_account(first_name, last_name, pin):
    account = [first_name, last_name, pin]
    accounts.append(account)
    return account

def close_account(account):
    if account in accounts:
        accounts.remove(account)
        print("Account closed successfully.")
    else:
        print("Account not found.")

def deposit(name, amount, balance):
 amount = float(amount)
 if amount <= 0:
        print("Deposit amount must be positive.")
        return None
 balance = balance + amount
 return balance
 
def withdraw(name, amount, balance, pin):
 if not any(acc[0] == name for acc in accounts):
   raise ValueError("Account not found.")
 if amount <= 0:
   raise ValueError("Withdrawal amount must be positive.")
 if balance < amount:
   raise ValueError("Insufficient funds.")
 balance = balance - amount
 return balance

def get_all_customers():
    return accounts
    
def find_customer(identifier, identifier1):
    for acc in accounts:
        if acc[0] == identifier or acc[1] == identifier1:
            return acc
    return None
