# Mohamed Mohamed
# 3/7/2020
# Platform: Windows 10 Professional
# Python 3.7
# observerclass.py: Can construct messages class for SMS, Phone, and Email. Store them in an array and calls notify class.
from abc import ABC, abstractmethod

class ServiceNotifier(ABC): #Abstract class for Decision Engine.
    def __init__(self):
        self.observer = []
        
    def attach(self, obj):
        pass
    
    def detach(self,obj):
        pass
            
    def notify(self, message):
        pass
        
class DecisionEngine(ServiceNotifier): #Concrete class of Service Notifier.
    def __init__(self):
        self.observer = [] #Array that stores the instances of message classes. 
        
    def attach(self, obj): #Adds a Service instance to self.observer.
        if not (obj in self.observer):
            self.observer.append(obj)
    
    def detach(self,obj): #Remove a Service instance to self.observer.
        if (obj in self.observer):
            self.observer.remove(obj)
            
    def notify(self, windspeed, humidity, message): #Dependent on the condition set, each instance in self.observer calls its "update" method
        if windspeed + humidity > 100:
            for obj in self.observer:
                obj.update(message)
        
class Service(ABC): #Abstract class for all *Service class.
    def update(self):
        pass

class EmailService(Service):
    def __init__(self, student): #Constructor for student's name.
        self.student = student
    def update(self, message): #The output method that notifies the user.
        print("Email Message to " + self.student + ": " + message)

class PhoneService(Service):
    def __init__(self, student):
        self.student = student
    def update(self, message):
        print("Phone Message to " + self.student + ": " + message)


class SmsService(Service):
    def __init__(self, student):
        self.student = student
    def update(self, message):
        print("SMS Message to " + self.student + ": " + message)


inta = DecisionEngine() #Instance that holds all *Service instances.
a = EmailService("Jack") #Instances of various *Service classes.
b = PhoneService("Jack")
c = SmsService("Jack")
d = SmsService("Sam")
e = EmailService("Grant")