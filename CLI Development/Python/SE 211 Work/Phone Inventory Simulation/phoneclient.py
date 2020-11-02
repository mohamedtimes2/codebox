# Mohamed Mohamed
# 3/7/2020
# Platform: Windows 10 Professional
# Python 3.7
# phoneclass.py: The client program for phoneclass.py. 
from phoneclass import * #Imports everything from phoneclass.py
import sys #Imports the sys module.

object_array = [a, b, c, d] #All instances in phoneclass.py

def MenuOpp():
    print("Welcome to AlphaMobile Inc. Phone Inventory program.")
    print("1) See phones created in the Singapore factory.")
    print("2) See phones created in the NY Factory.")
    menuinp = input("Select the number that corresponds with the task you want: ")
    if menuinp == "1": #List all Phone instances created with SinPhoneFactory's methods.
        print("Singapore Phones\n")
        print(c.getPhoneDetails() + "\n")
        print(d.getPhoneDetails())
        sys.exit(0)
    elif menuinp == "2": #List all Phone instances created with NYPhoneFactory's methods.
        print("NY Phones\n")
        print(a.getPhoneDetails() + "\n")
        print(b.getPhoneDetails())
        sys.exit(0)
    else:
        sys.exit(1)
MenuOpp()