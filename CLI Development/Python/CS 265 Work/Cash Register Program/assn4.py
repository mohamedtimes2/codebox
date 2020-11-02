#!/usr/bin/python3
import sys
if sys.argv[1] == "init": #If init is first arg.
    def regStart():
        if len(sys.argv) == 8: #Sets number of parameters to set up register.
            f = open("register.txt", "w+") #Store register state.
            for i in sys.argv[4:]:
                f.write(i + "\n")
            f.close()
            salescount = open("salesdetails.txt", "w+") #Represents the sales count.
            salescount.write("0")
            f.close()
        else:
            sys.exit(1)
    regStart()
elif sys.argv[1] == "purchase":
    def Purc():
        ogarray = []
        with open("register.txt", "r") as f: #Stores register state in a list to use in calculations.
            ogarray = [line.strip() for line in f]
        regsarray = []
        for i in ogarray:
            regsarray.append(int(i))
        midarray = []
        for i in sys.argv[4:]: #Gets the money being paid and stores it.
            midarray.append(int(i))
        finalarray = []
        for i in range(0, len(regsarray)):
            finalarray.append(regsarray[i] + midarray[i]) #Adds the register state and money through a list.
        money_dev = (int(sys.argv[4]) * 1) + (int(sys.argv[5]) * 5) + (int(sys.argv[6]) * 10) + (int(sys.argv[7]) * 20) #Total money given by customer as a numerical total.
        twenty_array = [0,0] #Stores the max amount of each bill can calculate the difference of the money given and price.
        tens_array = [0,0]
        fives_array = [0,0]
        ones_array = [0,0]
        if int(sys.argv[2]) < money_dev: #If price is less than money given.
            x = open("salesdetails.txt", "a") #Stores the sale in a text file for future reference.
            x.write(sys.argv[2] + "\n")
            x.close()
            money_diff = money_dev - int(sys.argv[2]) #Calculates the difference between the given money and price.
            for i in range(finalarray[3]): #Calculates the number of times a bill and its multiplier can reach the difference of money a.k.a change.
                if twenty_array[0] + 20 <= money_diff:
                    x = twenty_array[0] + 20
                    y = twenty_array[1] + 1
                    twenty_array[0] = x
                    twenty_array[1] = y
            money_diff = money_diff - twenty_array[0] #Subtracts the remaining money owned by number of twenty dollar bills that can almost cover up the change needed.
            for i in range(finalarray[2]):
                if tens_array[0] + 10 <= money_diff:
                    x = tens_array[0] + 10
                    y = tens_array[1] + 1
                    tens_array[0] = x
                    tens_array[1] = y
            money_diff = money_diff - tens_array[0]
            for i in range(finalarray[1]):
                if fives_array[0] + 5 <= money_diff:
                    x = fives_array[0] + 5
                    y = fives_array[1] + 1
                    fives_array[0] = x
                    fives_array[1] = y
            money_diff = money_diff - fives_array[0]
            for i in range(finalarray[0]):
                if ones_array[0] + 1 <= money_diff:
                    x = ones_array[0] + 1
                    y = ones_array[1] + 1
                    ones_array[0] = x
                    ones_array[1] = y
            money_diff = money_diff - ones_array[0]
            moneydiffarray = []
            moneydiffarray.append(ones_array[1])
            moneydiffarray.append(fives_array[1])
            moneydiffarray.append(tens_array[1])
            moneydiffarray.append(twenty_array[1])
            print(moneydiffarray[0], moneydiffarray[1], moneydiffarray[2], moneydiffarray[3]) #Prints change.
            newregs = []
            for i in range(0, len(regsarray)):
                newregs.append(finalarray[i] - moneydiffarray[i]) #Gives back the change and removes that change from the register.
            f = open("register.txt", "w+") #Adds it to the register.
            for i in newregs:
                f.write(str(i) + "\n")
            f.close()
            sys.exit(0)
        elif int(sys.argv[2]) == money_dev:
            x = open("salesdetails.txt", "a") #Stores the sale in a text file for future reference.
            x.write(sys.argv[2] + "\n")
            x.close()
            print(0, 0, 0, 0) #Prints out money returned in this case, zero.
            pur_money = []
            for i in sys.argv[4:]:
                pur_money.append(int(i)) #Takes the given money and puts into a DS.
            ogarray = []
            with open("register.txt", "r") as f:
                ogarray = [line.strip() for line in f]
            regarray = []
            for i in ogarray:
                regarray.append(int(i))
            newregs2 = []
            for i in range(0, len(regarray)):
                newregs2.append(regarray[i] + pur_money[i]) #Adds the register state with the money given.
            f = open("register.txt", "w+")
            for i in newregs2: #Gives new register state.
                f.write(str(i) + "\n")
            f.close()
            sys.exit(0)
        else:
            sys.exit(2)
    Purc()
elif sys.argv[1] == "change": #If change is first arg.
    def Change():
        money_giv = []
        for i in sys.argv[2:6]: #Takes money given as a list.
            money_giv.append(int(i))
        money_rec = []
        for i in sys.argv[7:11]:
            money_rec.append(int(i))
        money_givtot = (money_giv[0] * 1) + (money_giv[1] * 5) + (money_giv[2] * 10) + (money_giv[3] * 20) # Gives total of money offered
        money_rectot = (money_rec[0] * 1) + (money_rec[1] * 5) + (money_rec[2] * 10) + (money_rec[3] * 20) #Gives total of money, received.
        ogarray = []
        with open("register.txt", "r") as f:
            ogarray = [int(line.strip()) for line in f]
        newregsinit = []
        newregsfin = []
        if money_givtot == money_rectot:
            for i in range(0, len(ogarray)): #Adds the money given to the register state.
                newregsinit.append(ogarray[i] + money_giv[i])
            for i in range(0, len(newregsinit)): #Subtracts money (the change) and gives to the customer.
                newregsfin.append(newregsinit[i] - money_rec[i])
            def check(listch, val): #Checks to see if the difference between sub and adding in register state is not negative (illegal)
                for x in listch:
                    if val >= x:
                        return False
                return True
            if (check(newregsfin,0)): #If true, print and update the register state.
                print(money_rec[0], money_rec[1], money_rec[2], money_rec[3])
                f = open("register.txt", "w+")
                for i in newregsfin:
                    f.write(str(i) + "\n")
                f.close()
                sys.exit(0)
            else: #If not exit
                sys.exit(3)
        else:
            sys.exit(2)
    Change()
elif sys.argv[1] == "report":
    def report(): 
        purchtotarray = []
        registotarray = []
        with open("salesdetails.txt", "r") as f: #Takes sales.
            purchtotarray = [int(line.strip()) for line in f]
        with open("register.txt", "r") as f: #Takes register.
            registotarray = [int(line.strip()) for line in f]
        total = 0
        for i in range(0, len(purchtotarray)): #Finds the total amount of sales.
            total = total + purchtotarray[i]
        total_money = (registotarray[0] * 1) + (registotarray[1] * 5) + (registotarray[2] * 10) + (registotarray[3] * 20) #Finds all money in register.
        print(total, ":", total_money, "=", registotarray[0], registotarray[1],registotarray[2], registotarray[3]) #Prints all details.
    report()
    sys.exit(0)