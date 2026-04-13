contacts = []
try:
    with open("contacts.txt", "r") as f:
        print(f.read())
except:
    print("no contacts yet!")
while True:
    print("1. add contact")
    print("2. view all contacts")
    print("3. search contact")
    print("4. delete contact")
    print("5. exit")
    a=input("enter u choice: ")
    if a=="1":
        name=input("enter the name: ")
        number=input("enter the number: ")
        contacts.append({"name": name,"phone number":number})
        with open("contacts.txt","w") as f:
            for contact in contacts:
                 f.write(f"name: {contact['name']},phone number: {contact['phone number']}")
        print("\n")
    elif a=="2":
        print(contacts,"\n")
    elif a=="3":
        search = input("enter the name: ")
        found = False
        for contact in contacts:
             if contact["name"] == search:
                print(f"name: {contact['name']}")
                print(f"phone: {contact['phone number']}")
                found = True
        if found == False:
           print("contact not found")
        print("\n")
    elif a=="4":
        delete=input("enter the name: ")
        found=False
        for contact in contacts:
            if contact["name"]==delete:
                contacts.remove(contact)
                found=True
                print("contact deleted")
                break
        if found==False:
            print("contact not found")
        print("\n")
    elif a=="5":
        print("goodbye")
        break
