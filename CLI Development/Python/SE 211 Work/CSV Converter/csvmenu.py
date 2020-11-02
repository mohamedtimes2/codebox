#!/usr/bin/env/python3
# Mohamed Mohamed
# 1/26/2020
# Platform: Windows 10 Professional
# Python 3.7
# csvmenu.py: simulates a CSV manager, deals in various functions for CSV text files, including appending data, and reading data.
import csvconvert #The library handling the various functionalities behind the
import sys #Used to exitting out of the program.
import os.path #In charge of determining the error handling of nonexistent files.

coninp = " "
def menuOpp(): #The main menu behind the program. The function is recursively called to simulate a unified main menu.
    print("Welcome to the CSV menu!")
    print("1) Convert a CSV formatted file.")
    print("2) Read a file.")
    print("3) Read a file and replacing a value.")
    print("4) Append content in a existing file.")
    maininp = input("Select the number for the task you want executed (press any other key to exit): ") # Main input that determines what function from the library will be performed.
    coninp = " "
    appinp = " "
    parsedcsvs = [] #Stores any CSV files for modification.
    
    if maininp == "1": #First option that changes the separator to make the file more readable.
        while coninp != "":
            coninp = input("What files do you want converted? (Press Enter at the next prompt to start execution: ")
            parsedcsvs.append(coninp) #Library function that changes the separator for the CSV.
        if len(parsedcsvs) < 1:
            sys.exit()
        parsedcsvs.pop()
        for file in parsedcsvs: #Check if file is in current directory.
            if os.path.isfile(file):
                csvconvert.csvcon(file)
            else:
                print("One of your files might not exist. Exiting.")
                menuOpp()
        print("Files have been converted successfully.")
        menuOpp()

    elif maininp == "2": #Reads the file.
        readinp = input("What file would you like to read?: ")
        if os.path.isfile(readinp):
            readfile = open(readinp, "r")
            print("\n")
            print("File read:")
            print("----------------------------------------------")
            csvconvert.csvprint(readinp) #Prints out the file's contents.
            menuOpp()
        else:
            print("File does not exist. Exiting.")
            menuOpp()
            
        menuOpp()
    
    elif maininp == "3": #Reads a file and replaces any input noted by the user.
        readinp = input("What file would you like to change?: ")
        if os.path.isfile(readinp):
            readfile = open(readinp, "r")
            print("\n")
            csvconvert.csvprint(readinp)
            ogwordinput = input("What value do you want to replace?: ")
            newwordinput = input("What value do you want to insert?: ")
            csvconvert.csvreplace(readinp, ogwordinput, newwordinput) #Function that replace old word with new word.
            print("\n")
            print("File")
            print("-----------------------------------------------")
            csvconvert.csvprint(readinp)
            menuOpp()
        else:
            print("File does not exist. Exitting.")
            menuOpp()
    elif maininp == "4": #Option that appends input 
        readinp = input("What file do you wish to append to?: ")
        if os.path.isfile(readinp):
            print("File selected:")
            print("-----------------------------------------------")
            csvconvert.csvprint(readinp)
            while appinp != "":
                appinp = input("What text do you wish to append onto the file (Press Enter to cease appending)?: ")
                csvconvert.csvappend(readinp, appinp + "\n") #Appends a row written by the user in the selected file.
                print("-----------------------------------------------")
                print("File has been modified.")
                print("-----------------------------------------------")
                csvconvert.csvprint(readinp)
            menuOpp()
        else:
            print("File does not exist. Exiting.")
            menuOpp()
    elif maininp == "Kobe Bryant": #The Mamba is still alive.
        print("R.I.P. The Black Mamba")
        sys.exit()
    else:
        print("Inputted an invalid option. Exiting.")
        sys.exit()
        
menuOpp()