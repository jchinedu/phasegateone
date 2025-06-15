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
def find_contact_by_phone():
    phone = input("Enter phone number to find: ")
    for contact in contacts:
        if contact["phone_number"] == phone:
            print("Found:", contact["first_name"], contact["last_name"])
            return
    print("Contact not found.")
def find_contact_by_first_name():
    first = input("Enter first name to find: ")
    for contact in contacts:
        if contact["first_name"] == first:
            print("Found:", ccontact["first_name"], contact["last_name"])
            return
    print("Contact not found.")
def find_contact_by_last_name():
    last = input("Enter last name to find: ")
    for c in contacts:
        if contact["last_name"] == last:
            print("Found:", contact["first_name"], contact["last_name"])
            return
    print("Contact not found.")
def edit_contact():
    phone = input("Enter phone number to edit: ")
    for contact in contacts:
        if contact["phone_number"] == phone:
            contact["first_name"] = input("Enter new first name: ")
            contact["last_name"] = input("Enter new last name: ")
            contact["phone_number"] = input("Enter new phone number: ")
            print("Contact updated.")
            return
    print("Contact not found.")


