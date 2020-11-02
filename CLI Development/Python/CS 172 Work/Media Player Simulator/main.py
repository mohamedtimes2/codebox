from media import *
import sys
print("Welcome to Mohamed Mohamed's media player\n")
media_files = [moviefile1, moviefile2, moviefile3, moviefile4, songfile1, songfile2, songfile3, songfile4, picfile1, picfile2, picfile3, picfile4]

def menuOpp(): #Displays the overall main menu.
    print("(Main Menu)")
    print("1) Display all media files")
    print("2) Display all movie files")
    print("3) Display all song files")
    print("4) Display all picture files\n")
    maininp = input("Input the number according to the command you desire: ")


    if maininp == "1": #The following if-elif for maininp determine the menu display once the user makes a choice.
        def mainOpp(): #These functions are called depending with the value of maininp.
            print("\n")
            print("------------------------------------------")
            print("All media files:\n")
            dispAll()
            mediainp = input("What is the name of the file do you want to play/show?: ")
            if mediainp == "Avengers: Endgame":
                print(moviefile1.play())
            elif mediainp == "Avengers: Age of Ultron":
                print(moviefile2.play())       
            elif mediainp == "Avengers: Infinity War":
                print(moviefile3.play())           
            elif mediainp == "The Avengers":
                print(moviefile4.play())
            elif mediainp == "Vandanturf Town":
                print(songfile1.play())
            elif mediainp == "Route 29":
                print(songfile2.play())
            elif mediainp == "Deoxys Appears":
                print(songfile3.play())
            elif mediainp == "Battle! (Wild Pokemon!)":
                print(songfile4.play())
            elif mediainp == "A New Dawn":
                print(picfile1.show())
            elif mediainp == "True Blue":
                print(picfile2.show())       
            elif mediainp == "The Braveheart's Triumphant Return":
                print(picfile3.show())           
            elif mediainp == "Dragon Soul":
                print(picfile4.show())
            else:
                print("Doesn't exist.")
            mediaexit = input("Exit the application <type Exit> or go to main menu <type Return>: ")
            if mediaexit == "Exit": #These two if statements change the functionality of the exit input
                sys.exit(0)
            if mediaexit == "Return":
                print("\n")
                menuOpp() #When the user types "Return" in the last input it restarts the function again.
        mainOpp() #This calls the function on start-up.
    
    elif maininp == "2":
        def movieOpp():
            print("\n")
            print("------------------------------------------")
            print("All movies files:\n")
            dispMovies()
            movieinp = input("What is the name of the movie do you want to play?: ")
            if movieinp == "Avengers: Endgame":
                print(moviefile1.play())
            elif movieinp == "Avengers: Age of Ultron":
                print(moviefile2.play())       
            elif movieinp == "Avengers: Infinity War":
                print(moviefile3.play())           
            elif movieinp == "The Avengers":
                print(moviefile4.play())
            else:
                print("Doesn't exist.")
            movieexit = input("Exit the application <type Exit> or go to main menu <type Return>: ")
            if movieexit == "Exit":
                sys.exit(0)
            if movieexit == "Return":
                print("\n")
                menuOpp()
        movieOpp()
                
    elif maininp == "3":
        def songOpp():
            print("\n")
            print("------------------------------------------")
            print("All songs:\n")
            dispSongs()
            songinp = input("What is the name of the song do you want to play?: ")
            if songinp == "Vandanturf Town":
                print(songfile1.play())
            elif songinp == "Route 29":
                print(songfile2.play())
            elif songinp == "Deoxys Appears":
                print(songfile3.play())
            elif songinp == "Battle! (Wild Pokemon!)":
                print(songfile4.play())
            else:
                print("Doesn't exist.")
            songexit = input("Exit the application <type Exit> or go to main menu <type Return>: ")
            if songexit == "Exit":
                sys.exit(0)
            if songexit == "Return":
                print("\n")
                menuOpp()
        songOpp()
    
    elif maininp == "4":
        def picOpp():
            print("\n")
            print("------------------------------------------")
            print("All picture files:\n")
            dispPics()
            picinp = input("What is the name of the picture do you want to display?: ")
            if picinp == "A New Dawn":
                print(picfile1.show())
            elif picinp == "True Blue":
                print(picfile2.show())       
            elif picinp == "The Braveheart's Triumphant Return":
                print(picfile3.show())           
            elif picinp == "Dragon Soul":
                print(picfile4.show())
            else:
                print("Doesn't exist.")
            picexit = input("Exit the application <type Exit> or go to main menu <type Return>: ")
            if picexit == "Exit":
                sys.exit(0)
            if picexit == "Return":
                print("\n")
                menuOpp()
        picOpp()          
    else:
        print("The command doesn't exist. Exiting.")
        sys.exit(0)
menuOpp()
