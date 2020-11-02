# Mohamed Mohamed
# 3/1/2020
# Platform: Windows 10 Professional
# Python 3.7
# phoneclass.py: Can construct phone objects with model names dependent on the factory in which the phone was created.
from abc import ABC, abstractmethod

class PhoneFactory(ABC): #The interface of both NY and Singapore phone factories
    def assemble(self):
        pass
    def label(self):
        pass
    def setPrice(self):
        pass

class NYPhoneFactory(PhoneFactory): #The origin in where the phone objects are created.
    def assemble(self, camera, processor, memory): #Returns a Specs instance.
        return Specs(camera, processor, memory)
    def Smart5label(self, label = "Smart5"): #Returns a specs instance, where its default value is "Smart5".
        return Label(label)
    def Smart6label(self, label = "Smart6"):
        return Label(label)
    def setPrice(self, price): #Returns a set price instance.
        return Price(price)

class SinPhoneFactory(PhoneFactory):
    def assemble(self, camera, processor, memory):
        return Specs(camera, processor, memory)
    def Smart4label(self, label = "Smart4"):
        return Label(label)
    def Smart5label(self, label = "Smart5"):
        return Label(label)
    def setPrice(self, price):
        return Price(price)

class Specs(): #Class represents attributes such as camera, processor, and memory sizes
    def __init__(self, camera, processor, memory):
        self.__camera = camera
        self.__processor = processor
        self.__memory = memory
    def getCam(self): #Getters for each attribute.
        return self.__camera
    def getProc(self):
        return self.__processor
    def getMem(self):
        return self.__memory

class Label(): #Gives the model name for each Phone object.
    def __init__(self, label):
        self.__label = label
    def getLab(self):
        return self.__label

class Price(): #Gives the price for each Phone Object.
    def __init__(self, price):
        self.__price = price
    def getPrice(self):
        return self.__price

class Phone(): #The parent class that combines the previous classes to make Phone instances.
    def __init__(self, specs, label, price):
        self.__specs = specs
        self.__label = label
        self.__price = price
    def getPhoneDetails(self): #Getter that also formats the details of the Phone instance.
        return "Model: " + self.__label.getLab() + "\n" + "Camera: " + self.__specs.getCam() + "\n" + "Processor: " + self.__specs.getProc() + "\n" + "Memory: " + self.__specs.getMem() + "\n" + "Price: " + self.__price.getPrice() 

a1 = NYPhoneFactory().assemble("12 MP", "3GHz Processor", "64GB") #Uses the assemble method for the NY Factory.
a2 = NYPhoneFactory().Smart5label() #Labels the phone object as Smart5
a3 = NYPhoneFactory().setPrice("$400") #Sets the price of the Phone object.
a = Phone(a1, a2, a3) #The literal Phone object.

b1 = NYPhoneFactory().assemble("15 MP", "4GHz Processor", "64GB")
b2 = NYPhoneFactory().Smart6label()
b3 = NYPhoneFactory().setPrice("$550")
b = Phone(b1, b2, b3)

c1 = SinPhoneFactory().assemble("8 MP", "2GHz Processor", "32GB")
c2 = SinPhoneFactory().Smart4label()
c3 = SinPhoneFactory().setPrice("$200")
c = Phone(c1, c2, c3)

d1 = SinPhoneFactory().assemble("12 MP", "3GHz Processor", "128GB")
d2 = SinPhoneFactory().Smart5label()
d3 = SinPhoneFactory().setPrice("$500")
d = Phone(a1, a2, a3)