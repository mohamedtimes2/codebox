from abc import ABC, abstractmethod #Imports the abstract class methods and properties methods.
#!/usr/bin/python3
# Mohamed Mohamed
# 2/17/2020
# Platform: Windows 10 Professional
# Python 3.7
# compuclass.py: Simulates the UML diagram structure of the Abstract Factory methodology for the "computer store" problem.

class ComputerPartsFactory(ABC): #Simulates the interface for both the concrete Advanced/StandardPartsFactory class. 
    def createMonitor(self):
        pass
    def createKeyboard(self):
        pass
    def createCPU(self):
        pass
# Both the Advanced and Standard CPFs will returns instances of their respective category's computer components.
class AdvancedComputerPartsFactory(ComputerPartsFactory):
    def createMonitor(self, name, cost, res): 
        return AdvancedMonitor(name, cost, res)
    def createKeyboard(self, name, cost, typeswt):
        return AdvancedKeyboard(name, cost, typeswt)
    def createCPU(self, name, cost):
        return AdvancedCPU(name, cost)

class StandardComputerPartsFactory(ComputerPartsFactory):
    def createMonitor(self, name, cost, res):
        return StandardMonitor(name, cost, res)
    def createKeyboard(self, name, cost, typeswt):
        return StandardKeyboard(name, cost, typeswt)
    def createCPU(self, name, cost):
        return StandardCPU(name, cost)
# The three instances below provide the methods for both the Standard and Advanced concrete classes.
class CPU(ABC):
    def getName(self):
        pass
    def getCost(self):
        pass

class Monitor(ABC):
    def getName(self):
        pass
    def getCost(self):
        pass
    def getRes(self):
        pass
    
class Keyboard(ABC):
    def getName(self):
        pass
    def getCost(self):
        pass
    def getTypeswt(self):
        pass
#-------------------------------------------------------------------------    
class AdvancedCPU(CPU):
    def __init__(self, name, cost): #Attributes are cost and name (Same in Standard CPU).
        self.__name = name
        self.__cost = cost
        
    def getName(self):
        return self.__name
    
    def getCost(self):
        return self.__cost
    
class AdvancedMonitor(Monitor):
    def __init__(self, name, cost, res): #Attributes are name, cost, and resolution (Same in Standard Monitor).
        self.__name = name
        self.__cost = cost
        self.__res = res
        
    def getName(self):
        return self.__name
    
    def getCost(self):
        return self.__cost
    
    def getRes(self):
        return self.__res

class AdvancedKeyboard(Keyboard):
    def __init__(self, name, cost, typeswt): #Attributes are name, cost, and switch type (Same in Standard Keyboard).
        self.__name = name
        self.__cost = cost
        self.__typeswt = typeswt
        
    def getName(self):
        return self.__name
    
    def getCost(self):
        return self.__cost
    
    def getTypeswt(self):
        return self.__typeswt
        
class StandardCPU(CPU):
    def __init__(self, name, cost):
        self.__name = name
        self.__cost = cost
        
    def getName(self):
        return self.__name
    
    def getCost(self):
        return self.__cost
    
class StandardMonitor(Monitor):
    def __init__(self, name, cost, res):
        self.__name = name
        self.__cost = cost
        self.__res = res
        
    def getName(self):
        return self.__name
    
    def getCost(self):
        return self.__cost
    
    def getRes(self):
        return self.__res

class StandardKeyboard(Keyboard):
    def __init__(self, name, cost, typeswt):
        self.__name = name
        self.__cost = cost
        self.__typeswt = typeswt
        
    def getName(self):
        return self.__name
    
    def getCost(self):
        return self.__cost
    
    def getTypeswt(self):
        return self.__typeswt
#---------------------------------------------------------------------------------

class Computer():
    def __init__(self, monitor, keyboard, cpu): #Attributes include monitor, keyboard, and cpu.
        self.__monitor = monitor
        self.__keyboard = keyboard
        self.__cpu = cpu
        
    def getCPUName(self):
        return self.__cpu.getName() #Returns the cpu attribute using the Standard/Advanced CPU's class method.
    
    def getKeyboardName(self):
        return self.__keyboard.getName() #Returns the keyboard attribute using the Standard/Advanced CPU's class method.
    
    def getMonitorName(self):
        return self.__monitor.getName() #Returns the monitor attribute using the Standard/Advanced CPU's class method.

s1 = StandardComputerPartsFactory().createMonitor("720p Monitor", "$100", "1280 x 720") #Returns a Standard Monitor instance w/ attributes.
s2 = StandardComputerPartsFactory().createKeyboard("Basic Keyboard", "$50", "Standard Switches") #Returns a Standard Keyboard instance w/ attributes.
s3 = StandardComputerPartsFactory().createCPU("Standard Ryzen", "$100") #Returns a Standard CPU instance w/ attributes.
a1 = AdvancedComputerPartsFactory().createMonitor("4K Monitor", "$4000", "2000 x 1000") #Returns a Advanced Monitor instance w/ attributes.
a2 = AdvancedComputerPartsFactory().createKeyboard("Advanced Keyboard", "$100", "Cherry MX") #Returns a Advanced Keyboard instance w/ attributes.
a3 = StandardComputerPartsFactory().createCPU("Intel Core i9", "$900") #Returns a Advanced CPU instance w/ attributes.
stancomp = Computer(s1, s2, s3) #The Computer instance is constructed using the instances of the other components, similar to an actual computer.
advacomp = Computer(a1, a2, a3)

