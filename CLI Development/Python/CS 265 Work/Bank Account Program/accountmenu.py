#!/usr/bin/env pytho n3
# Mohamed Mohamed
# 11/19/2019
# Platform: Windows 10 Professional
# Python 3.7
# accountmenu.py: simulates a account database, which logs in user input into log files that can accessed through the program.
import sys
print("Welcome to the account manager")

def menuOpp():
    file = open("sample.txt", "a") # Opens a list of files that will serve as log files that stores user data.
    filescan = open("sample.txt", "r")
    regexfile = open("regexhis.txt", "w")
    regexscan = open("regexhis.txt", "r")
    hisfile = open("his.txt", "w+")
    hisscan = open("his.txt", "r")
    acc_det = filescan.readlines()
    acc_hisdet = regexscan.readlines()
    acc_hisdetx = hisscan.readlines()
    print("i) Account info") # Various options in the main menu.
    print("h) History")
    print("t) Insert transaction")
    print("?) Exit")
    maininp = input("Select the character according to the option you selected => ")
    
    if maininp == "i": # Opens up various options depending on user input for maininp.
        print("Info")
        print("---------")
        acc_linum = 0
        for line in acc_det:
            acc_linum += 1
            x = line.split(":")
            print(acc_linum, ")", x[1], x[0]) # Formats the amount of options according the amount of lines in the log file: sample.txt
        infoinp = input("Enter choice (input the number choice for the account's info) => ")
        unparinfo = acc_det[int(infoinp) - 1] # Takes infoinp's value and uses it to find the line that corresponds with the line number in sample.txt
        infoparse = unparinfo.split(":")
        print("account #:", infoparse[0])
        print("name:", infoparse[1])
        print("balance:", infoparse[4])
        print("------------------------")
        info_tomain = input("To go back the main menu, type ""yes"" or to exit, input any other key => ") #Returns you to the main menu or exit out of the program.
        if info_tomain == "yes":
            menuOpp()
        else:
            sys.exit(0)
    elif maininp == "h":
        print("History")
        print("-------")
        acc_linum =  0
        for line in acc_det:
            acc_linum += 1
            x = line.split(":")
            print(acc_linum, ")", x[1], x[0])
        hisinp = input("Please input the account # to see its history => ")
        for line in acc_det:
            if hisinp in line: #Scans the log file to find certain account details.
                regexfile.write(line) #Write the scanned lines to an external file.
                parsehis = line.split(":")
                hisfile.write(parsehis[2] + " ")
                hisfile.write(parsehis[3] + " ")
                hisfile.write(parsehis[4])
        hisfile.close()
        print("History (W = withdraw, D = deposit)")
        print("------------------------")
        for line in hisscan: #Prints the account details from the external file.
            print(line)
        print("------------------------")
        info_tomain = input("To go back the main menu, type ""yes"" or to exit, input any other key => ")
        if info_tomain == "yes":
            menuOpp()
        else:
            sys.exit(0)
    elif maininp == "t":
        acc_numinp = input("Input account number => ") #A sequence of details needed to input account info
        acc_nameinp = input("Input account holder name => ")
        acc_datinp = input("Input date => ")
        acc_wdinp = input("Deposit (D) or Withdrawal(W)? => ")
        acc_moninp = input("Input the amount of money => ")
        file.write(acc_numinp + ":" + acc_nameinp + ":" + acc_datinp + ":" + acc_wdinp + ":" + acc_moninp + "\n") #Writes the input into sample.txt in the requested format.
        file.close()
        menuOpp() #Goes back to main menu.
    elif maininp == "?":
        print("Exiting.")
        sys.exit(0)
    else: #Quits the program if input is invalid.
        print("You have inputted a invalid character.")
        print("Exitting")
        sys.exit(0)

menuOpp() #Starts the Program