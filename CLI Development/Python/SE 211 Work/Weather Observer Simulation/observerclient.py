# Mohamed Mohamed
# 3/10/2020
# Platform: Windows 10 Professional
# Python 3.7
# observerclient.py: Serves as the client code for observerclass.py
from observerclass import *

object_array = [inta, a, b, c, d, e] #Just the instances of all classes.
def MenuOpp():
    print("Welcome to the Weather message application!")
    print("Here are an example of different classes of messages being notified:\n")
    inta.attach(a) #Using the attach method to add all instances of *Service objects.
    inta.attach(b)
    inta.attach(c)
    inta.attach(d)
    inta.attach(e)
    inta.notify(50, 51, "Class is canceled due to the weather.") #Based on the parameters, notify() will be called.
    print("\nHere are an example of different classes of messages being notified after some have been removed from service:\n")
    inta.detach(a) #Using the detach method to remove some instances of *Service objects.
    inta.detach(b)
    inta.detach(c)
    inta.notify(50, 51, "Class is canceled due to the weather.")
MenuOpp()