contacts = []

def add_contact():
    first = input("Enter first name: ")
    last = input("Enter last name: ")
    phone = input("Enter phone number: ")
    contacts.append({"first_name": first, "last_name": last, "phone_number": phone})
    print("Contact added.")

def remove_contact():
    phone = input("Enter phone number to remove: ")
    global contacts
    contacts = [contact for contact in contacts if contact["phone_number"] != phone]
    print("Contact removed.")

