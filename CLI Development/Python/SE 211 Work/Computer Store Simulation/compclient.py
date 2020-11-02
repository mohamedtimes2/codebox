#!/usr/bin/env/python3
# Mohamed Mohamed
# 2/20/2020
# Platform: Windows 10 Professional
# Python 3.7
# compuclass.py: Simulates the client script for the "computer store" problem.
from compuclass import * #Imports everything from the compuclass.py file.
import sys #Imported to get the exit method as a form of error handling.

object_array = [s1, s2, s3, stancomp, a1, a2, a3, advacomp] #The list of objects created in the compuclass.py file.

def MenuOpp(): #The menu of the client UI.
    print("Welcome to the computer inventory client application.")
    print("1) Display all standard computers.")
    print("2) Display all advanced computers.")
    print("3) Display all standard computer parts.")
    print("4) Display all advanced computer parts.")
    menuinp = input("Select the number that corresponds to the option you want: ")
    if menuinp == "1": #Prints all the Standard Computer Sets.
        print("Standard Computers")
        print("-------------------")
        print("Standard Computer #1:")
        print("Processor: " + stancomp.getCPUName()) #Uses the Computer class's name method to get the attribute's value.
        print("Monitor: " + stancomp.getMonitorName())
        print("Keyboard: " + stancomp.getKeyboardName())
        MenuOpp()
    elif menuinp == "2": #Prints all the Advanced Computer Sets.
        print("Advanced Computers")
        print("-------------------")
        print("Processor: " + advacomp.getCPUName()) #Uses the Computer class's name method to get the attribute's value.
        print("Monitor: " + advacomp.getMonitorName())
        print("Keyboard: " + advacomp.getKeyboardName())
        MenuOpp()
    elif menuinp == "3": #Print all the Standard Computer Parts.
        print("Standard Computer Parts")
        print("-------------")
        print("Processor #1:")
        print("Name: " + s3.getName()) # Uses the  Standard CPU class's getName() method to get the name attribute's value.
        print("Cost: " + s3.getCost() + "\n")
        print("Keyboard #1:")
        print("Name: " + s2.getName())
        print("Cost: " + s2.getCost())
        print("Switches: " + s2.getTypeswt() + "\n")
        print("Monitor #1:")
        print("Name: " + s1.getName())
        print("Cost: " + s1.getCost())
        print("Resolution: " + s1.getRes() + "\n")
        MenuOpp()
    elif menuinp == "4": #Print all the Advanced Computer Parts.
        print("Advanced Computer Parts")
        print("------------------------")
        print("Processor #1:")
        print("Name: " + a3.getName()) # Uses the  Standard CPU class's getName() method to get the name attribute's value.
        print("Cost: " + a3.getCost() + "\n")
        print("Keyboard #1:")
        print("Name: " + a2.getName())
        print("Cost: " + a2.getCost())
        print("Switches: " + a2.getTypeswt() + "\n")
        print("Monitor #1:")
        print("Name: " + a1.getName())
        print("Cost: " + a1.getCost())
        print("Resolution: " + a1.getRes() + "\n")
        MenuOpp()
    else:
        print("Inputted a invalid value. Exitting.")
        sys.exit()
        
    
MenuOpp()
