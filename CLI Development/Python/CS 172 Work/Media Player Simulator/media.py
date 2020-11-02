class Media(): #Basic Media class (Parent)
    def __init__(self, meditype, name, rating):
        self.__meditype = meditype
        self.__name = name
        self.__rating = rating
    def __str__(self): # Overrides the print statement of Media objects.
        return "File: "+ self.__meditype + "\n" + "Name: "+ self.__name + "\n" + "Rating: " + self.__rating + "\n"
    
    def getName(self): #A getter method that retrieves the media file's name for other methods and classes.
        return self.__name
    
    def getMeditype(self):
        return self.__meditype #A getter method that retrieves the media file's media format for other methods and classes.

class Movie(Media): #The movie class (Child)
    def __init__(self, meditype, name, rating, director, running_time):
        super().__init__(meditype, name, rating) #Inherits the attributes from the parent class, Media.
        self.__director = director
        self.__running_time = running_time
    def __str__(self): #Overrides the print statement for any Movie objects.
        return super().__str__() + "Director: " + self.__director + "\n" + "Running Time (Minutes): " + self.__running_time + "\n"
    def play(self): #A play method, exclusive to the Movie objects that show a return statement of the object being played.
        return self.getName() + "," + " playing now"

class Song(Media): #The song class (Child)
    def __init__(self, meditype, name, rating, artist, album):
        super().__init__(meditype, name, rating)
        self.__artist = artist
        self.__album = album
    def __str__(self):
        return super().__str__() + "Artist: " + self.__artist + "\n" + "Album: " + self.__album + "\n"
    def play(self):
        return self.getName() + " " + "by" + " " + self.__artist + "," + " playing now"

class Picture(Media): #The picture class (Child)
    def __init__(self, meditype, name, rating, resolution):
        super().__init__(meditype, name, rating)
        self.__resolution = resolution
    def __str__(self):
        return super().__str__() + "Resolution: " + self.__resolution + "\n"
    def show(self): #A method that displays the object when selected to be shown.
        return "Showing " + "\"" + self.getName() + "." + self.getMeditype() + "\""

#The objects of the movie, song, and picture.
moviefile1 = Movie("mov","Avengers: Endgame", str(99), "Russo Brothers", "180")
moviefile2 = Movie("mp4", "Avengers: Age of Ultron", str(90), "Joss Whedon", "150")
moviefile3 = Movie("avi", "Avengers: Infinity War", str(95), "Russo Brothers", "170")
moviefile4 = Movie("wmv", "The Avengers", str(92), "Joss Whedon", "160")

songfile1 = Song("mp3", "Vandanturf Town", str(85), "Go Ichinose", "Pokémon Ruby & Pokémon Sapphire: Super Music Collection")
songfile2 = Song("wav", "Route 29", str(77), "Junichi Masuda", "Pokémon HeartGold & Pokémon SoulSilver: Super Music Collection")
songfile3 = Song("ogg", "Deoxys Appears", str(90), "Go Ichinose", "Pokémon FireRed & Pokémon LeafGreen: Super Music Collection")
songfile4 = Song("midi", "Battle! (Wild Pokémon)", "95", "Junichi Masuda", "Pokémon X & Pokémon Y: Super Music Collection")

picfile1 = Picture("jpeg", "A New Dawn", str(77), "900 dpi")
picfile2 = Picture("png", "True Blue", str(85), "1000 dpi")
picfile3 = Picture("bmp", "The Braveheart's Triumphant Return", str(95), "9000 dpi")
picfile4 = Picture("gif", "Dragon Soul", str(88), "500 dpi")

#These functions are to condense the code for the script and displays all of the files in the respective class.
def dispAll():
    print(moviefile1), print(moviefile2), print(moviefile3), print(moviefile4), print(songfile1), print(songfile2), print(songfile3), print(songfile4), print(picfile1), print(picfile2), print(picfile3), print(picfile4)
def dispMovies():
    print(moviefile1), print(moviefile2), print(moviefile3), print(moviefile4)
def dispSongs():
    print(songfile1), print(songfile2), print(songfile3), print(songfile4)
def dispPics():
    print(picfile1), print(picfile2), print(picfile3), print(picfile4)