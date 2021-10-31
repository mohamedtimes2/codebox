Survey (HW2 - Part B) implemented by Mohamed Mohamed
Student ID: 14310542

This is an implementation of the Survey assignment for SE310. The source files consist of my own code, and also depends on modules from the StudentRepo, such as Utils and abstractInputOutput to
minimize redundant error handling. All files within the modules used have been saved for integrity, and are written by Sean Grimes. As for any modifications of code within those modules that I
depended on, please look at the InputHelper.java file in abstractInputOutput to see some added functionality I implemented. Survey.java features some code that I derive from the Utils folder to fit
functionality. Comments and headers have been added in areas to reduce confusion. No major errors have been discovered aside from the ones I did found from stress testing. I hope you don't find any. 
All source files are present in the Survey folder in the same directory as this README file. PLEASE DO NOT DELETE THE SURVEYS FOLDER. SERIALIZATION AND DESERIALIZATION IS 
DEPENDENT ON THE EXISTENCE OF THAT FOLDER.

The Main.java file has what you need, calling the Survey.surveyMenu() static method will start the program.


Test (HW2 - Part D) implemented by Mohamed Mohamed
Student ID: 14310542
This is an implementation of the Test part of the HW2 assignment for SE310. The source files consist of my own code, and also depends on modules from the StudentRepo, such as Utils and 
abstractInputOutput to minimize redundant error handling. All files within the modules used have been saved for integrity, and are written by Sean Grimes. As for any modifications of code 
within those modules that I depended on, please look at the InputHelper.java file in abstractInputOutput to see some added functionality I implemented. Test.java features some code that I 
derive from the Utils folder to fit functionality. Additional comments have been added to explain confusing logic/code. No major errors have been discovered aside from the ones I did found 
from stress testing, and ones reported from HW2 Part B have been fixed, please do not try to find any. All sample files in relation to the Test taking functionality are in the Test folder in the same
directory as this README, with some responses added. PLEASE DO NOT DELETE THE TESTS FOLDER. SERIALIZATION AND DESERIALIZATION IS DEPENDENT ON THE EXISTENCE 
OF THAT FOLDER.

Tabulation might be a bit different, in the case of its presentation. Tabulation was programmed with the concept of each set of responses will be tabulated, so [A,D] is different from [A,B] for a question
that asks for two responses, and will appear as two different answers entirely to a question. This was the expected result according to Sean Grimes. Tabulation consists of a tabulation section, that 
details each different answer given for a question and the frequency it was shown, and the responses, which are all the answers given in the response files.
In cases, there will be errors that state "You don't have a survey or test". THIS IS INTENTIONAL, AND THE CORRECT FUNCTIONALITY WAS IMPLEMENTED. This is me reducing the amount of
code reuse, which isn't worth it for a single if condition.

The Main.java has been configured to display a Main Menu, that will display two menus, being the surveyMenu and the TestMenu.
