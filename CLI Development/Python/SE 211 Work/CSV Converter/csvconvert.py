#!/usr/bin/env/python3
# Mohamed Mohamed
# 1/26/2020
# Platform: Windows 10 Professional
# Python 3.7
# csvcon.py: assists in simulates a CSV manager (csvmenu.py), possesses the various functions for CSV text files that csvmenu.py derives from, including appending data, and reading data.
def csvcon(file): #In charge of "converting" the file through changing the separators.
    f1 = open(file, 'r')
    f2 = open("new" + file, 'w')
    for line in f1: #For every ",", replace it with "|"
        f2.write(line.replace(',', '|'))
    f1.close()
    f2.close()

def csvprint(file): #Prints the file's contents into the CLI
    f1 = open(file, "r")
    print(f1.read())
    
def csvreplace(file, ogword, newword): #Replace the selected contents with new contents which are determined in the main application.
    f1 = open(file, "r")
    contents = f1.read()
    contents = contents.replace(ogword, newword)
    f1.close()
    f1 = open(file, "w")
    f1.write(contents) #Print the file with new file.
    f1.close()
    
def csvappend(file, newcon): #Add contents into the selected file.
    f1 = open(file, "r")
    contents = f1.read()
    print(contents) #Prints the file's contents so that the user can refer to the data.
    f1.close()
    f1 = open(file, "a")
    f1.write(newcon)
    f1.close()
    
 