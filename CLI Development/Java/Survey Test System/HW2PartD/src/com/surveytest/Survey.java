// ===============================
// AUTHOR: Mohamed Mohamed
// PURPOSE: In charge of the code for the Survey interface and bring all the Question subclasses together.
// ===============================
package com.surveytest;
import com.surveytest.utils.Input;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Survey implements Serializable {
    protected String name; //The name of the survey.
    protected String responsename = ""; //The name of the survey response file.
    protected ArrayList<Question> questions = new ArrayList<Question>(); //Container for all questions.
    private static final long serialVersionUID = 1L;

    //Constructor derives from StudentRepo
    public Survey() {
        System.out.println("What will be the name of your file? Please enter an non-whitespace string with no special characters or a number as the first character.");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "-1";
        try {
            line = in.readLine();
            // Loops if input is empty, null, or does not fulfill the requirements of isValidFileName.
            while (line == null || line.length() == 0 || !isValidFileName(line)) {
                System.out.println("Invalid input!");
                System.out.println("What will be the name of your file? Please enter an non-whitespace string with no special characters or a number as the first character.");
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.name = line;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Question getQuestion(int index) {
        return this.questions.get(index);
    }

    public ArrayList getQuestions() {
        return this.questions;
    }
    //A if-else block that loops until a certain input breaks the loop.
    public void createQuestions() {
        boolean loop = true;
        while (loop == true) {
            if(this.questions.size() == 0) {
                System.out.println("You need have at least one question created for your survey!");
                System.out.println("---------------------------------------------");
            }
            System.out.println("1) Add a new T/F question");
            System.out.println("2) Add a new multiple-choice question");
            System.out.println("3) Add a new short answer question");
            System.out.println("4) Add a new essay question");
            System.out.println("5) Add a new date question");
            System.out.println("6) Add a new matching question");
            System.out.println("7) Return to previous menu");
            System.out.println("Please select a choice: ");
            int createinput = Input.readIntInRange(1, 7); //Allows for inputs that within the range of parameters. See utils.Input for details.
            if (createinput == 1) {
                Question tfquestion = new TrueFalse();
                this.questions.add(tfquestion);
            } else if (createinput == 2) {
                Question mcquestion = new MultipleChoice();
                mcquestion.create();
                this.questions.add(mcquestion);
            } else if (createinput == 3) {
                Question saquestion = new ShortAnswer();
                saquestion.create();
                this.questions.add(saquestion);
            } else if (createinput == 4) {
                Question equestion = new Essay();
                equestion.create();
                this.questions.add(equestion);
            } else if (createinput == 5) {
                Question dquestion = new Date();
                dquestion.create();
                this.questions.add(dquestion);
            } else if (createinput == 6) {
                Question mquestion = new Matching();
                mquestion.create();
                this.questions.add(mquestion);
            } else {
                if (this.questions.size() == 0) { //A nested if-else, that states that if there are no questions, continue loop, otherwise end loop.
                    loop = true;
                } else {
                    loop = false;
                }
            }
        }
    }
    //Loops through each question in this.question, and calls the display method for each question.
    public void display() {
        System.out.println("Displayed Survey: " + this.name);
        System.out.println("------------------------------------------------------ ");
        for (int i = 0; i < this.questions.size(); i++) {
            Question p = (Question) this.questions.get(i);
            p.display();
            System.out.println("");
        }
    }
    //Loops through each question in this.question, and calls the display method and setUserAnswer for each question.
    public void take() {
        System.out.println("Taking: " + this.name);
        System.out.println("------------------------------------------------------ ");
        for (int i = 0; i < this.questions.size(); i++) {
            Question p = (Question) this.questions.get(i);
            p.display();
            System.out.println("");
            p.setUserAnswer();
        }
        System.out.println("What will be the name of your responses file? Please enter an non-whitespace string with no special characters or a number as the first character."); //Input for responsename.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "-1";
        try {
            line = in.readLine();
            // Loops if input is empty, null, or does not fulfill the requirements of isValidFileName.
            while (line == null || line.length() == 0 || !isValidFileName(line)) {
                System.out.println("Invalid input!");
                System.out.println("What will be the name of your responses file? Please enter an non-whitespace string with no special characters or a number as the first character.");
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.responsename = line; //Sets the responsename as the input.
    }
    //Allows for the modification of any question in the survey.
    public void modify() {
        System.out.println("Modifying Survey: " + this.name);
        System.out.println("------------------------------------------------------ ");
        int i;
        for (i = 0; i < this.questions.size(); i++) { //Loops through each question to display it.
            Question p = (Question) this.questions.get(i);
            System.out.println(String.valueOf(i) + ".");
            p.display();
            System.out.println("");
        }
        System.out.println("Please the number that corresponds to the question you wish to modify: ");
        int modifyinput = Input.readIntInRange(0, this.questions.size() - 1); //Input for number of question you wish to edit.
        Question chosenques = (Question) this.questions.get(modifyinput);
        chosenques.modify();
        //After survey has been edited, all responses will be invalid and must be deleted, thus check if directory of responses exist and deleted if it does.
        File modifieddir = new File("." + File.separator + "Surveys" + File.separator + this.name + File.separator);
        if (modifieddir.isDirectory()) {
            deleteDirectory(modifieddir);
        }
    }


    public static String serialize(Survey sur) {
        String path = "";
        if (sur.responsename.equals("")) {
            /* If responsename is an empty string, we treated the Survey object as a survey and serialize it in the Surveys subdirectory and create
            subdirectory for the responses related to the survey, otherwise
            * treat it as a response and save the responses folder. */
            path = "." + File.separator + "Surveys" + File.separator + sur.name + ".ser";
            createDirectory("." + File.separator + "Surveys" + File.separator + sur.name + File.separator);
        } else {
            path = "." + File.separator + "Surveys" + File.separator + sur.name + File.separator + sur.responsename + ".ser";
            createDirectory("." + File.separator + "Surveys" + File.separator + sur.name + File.separator);
        }
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(sur);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(2);
        } finally {
            try {
                if (fos != null)
                    fos.close();
                if (oos != null)
                    oos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Saved path: " + path); //Print path for convenience.
        return path;
    }


    public static Survey deserialize(String path){
        Survey deserializedObject = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            deserializedObject = (Survey) ois.readObject(); //Returns the object as type Object, thus we need to explicitly cast it to Survey.
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
            System.exit(2);
        }
        finally{
            try{
                if(ois != null)
                    ois.close();
                if(fis != null)
                    fis.close();
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return deserializedObject; //Returns the object we want.
    }


    //Ripped from the StudentRepo w/ original comments as well.
    protected static boolean createDirectory(String directoryPath) { // because static and since we are in the scope of the class when don't need to explain what class we look to (line 41).
        File dir = new File(directoryPath);
        // Nothing exists here, create the directory and all parent directories
        if (!dir.exists())
            return dir.mkdirs();

        // Something exists at the supplied path, see if it's a directory. If it is,
        // return true. If it's not, it's something else so return false.
        return dir.isDirectory();
    }

    boolean deleteDirectory(File directoryToBeDeleted) { //Source: https://www.baeldung.com/java-delete-directory
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file); //Recursively deleted any visited directories and files as Java can only delete empty directories.
            }
        }
        return directoryToBeDeleted.delete();
    }

    //Derived from the StudentRepo
    public static String listAndPickFileFromDir(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory())
            throw new IllegalStateException(dirPath + " is invalid");

        File[] files = dir.listFiles(File::isFile);
        if (files == null || files.length == 0) {
            System.out.println("There are no surveys or tests!"); //Mohamed's comment: An alteration here that I made that handles the case of someone loading while no surveys were made.
            return "Need to make surveys/tests!";
            //throw new IllegalStateException(dirPath + " is empty"); //Mohamed's comment: The original exception thrown in the StudentRepo.
        }

        System.out.println("Please enter number of file to load: ");
        for (int i = 0; i < files.length; ++i) {
            if (files[i].isFile())
                // Adding 1 to avoid 0-indexed UI. getName to chop off full path.
                System.out.println((i + 1) + ") " + files[i].getName());
        }

        // Get a valid integer between 1 and number of files
        int fileSelection = Input.readIntInRange(1, files.length);

        // Remember to subtract 1 to get back to 0-indexed value
        return files[fileSelection - 1].getAbsolutePath();
    }

    //Derived from the StudentRepo
    public static String listAndPickFileFromDirStealth(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory())
            throw new IllegalStateException(dirPath + " is invalid");

        File[] files = dir.listFiles(File::isFile);
        if (files == null || files.length == 0) {
            return "Need to make surveys/tests!";
            //throw new IllegalStateException(dirPath + " is empty"); //Mohamed's comment: The original exception thrown in the StudentRepo.
        }

        System.out.println("Please enter the number of the file to load: ");
        for (int i = 0; i < files.length; ++i) {
            if (files[i].isFile())
                // Adding 1 to avoid 0-indexed UI. getName to chop off full path.
                System.out.println((i + 1) + ") " + files[i].getName());
        }

        // Get a valid integer between 1 and number of files
        int fileSelection = Input.readIntInRange(1, files.length);

        // Remember to subtract 1 to get back to 0-indexed value
        return files[fileSelection - 1].getAbsolutePath();
    }


    //Derived from the StudentRepo
    public static String listAndPickDirStealth(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory())
            throw new IllegalStateException(dirPath + " is invalid");

        File[] files = dir.listFiles(File::isDirectory);
        if (files == null || files.length == 0) {
            return "Need to make surveys/tests!";
            //throw new IllegalStateException(dirPath + " is empty"); //Mohamed's comment: The original exception thrown in the StudentRepo.
        }

        System.out.println("Please enter the number of the file you wish to pick: ");
        for (int i = 0; i < files.length; ++i) {
            if (files[i].isDirectory())
                // Adding 1 to avoid 0-indexed UI. getName to chop off full path.
                System.out.println((i + 1) + ") " + files[i].getName());
        }

        // Get a valid integer between 1 and number of files
        int fileSelection = Input.readIntInRange(1, files.length);

        // Remember to subtract 1 to get back to 0-indexed value
        return files[fileSelection - 1].getAbsolutePath();
    }




    //Derived from the StudentRepo
    public static String listAndPickDir(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory())
            throw new IllegalStateException(dirPath + " is invalid");

        File[] files = dir.listFiles(File::isDirectory);
        if (files == null || files.length == 0) {
            System.out.println("There are no surveys or tests!"); //Mohamed's comment: An alteration here that I made that handles the case of someone loading while no surveys were made.
            return "Need to make surveys/tests!";
            //throw new IllegalStateException(dirPath + " is empty"); //Mohamed's comment: The original exception thrown in the StudentRepo.
        }

        System.out.println("Please enter number of file to load: ");
        for (int i = 0; i < files.length; ++i) {
            if (files[i].isDirectory())
                // Adding 1 to avoid 0-indexed UI. getName to chop off full path.
                System.out.println((i + 1) + ") " + files[i].getName());
        }

        // Get a valid integer between 1 and number of files
        int fileSelection = Input.readIntInRange(1, files.length);

        // Remember to subtract 1 to get back to 0-indexed value
        return files[fileSelection - 1].getAbsolutePath();
    }


    //Derived from the StudentRepo
    public static List<String> getAllFilePathsInDir(String path){
        List<String> paths = new ArrayList<>();
        File[] files = new File(path).listFiles();
        if(files == null || files.length == 0)
            return new ArrayList<String>();
        for(File f : files){
            if(f.isFile())
                paths.add(f.getAbsolutePath());
        }
        return paths; //Mohamed's comment: Just removed the sorted part of the return value, not really needed.
    }





    protected boolean isValidFileName(String line) {
        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        char charArray[] = line.toCharArray(); //Line from: https://www.tutorialspoint.com/how-do-we-find-out-if-first-character-of-a-string-is-a-number-in-java#:~:text=The%20charAt()%20method%20of,character%20as%20array%5B0%5D.
        if (line.matches(regex) && !Character.isDigit(charArray[0])) { //Regex from: https://howtodoinjava.com/java/regex/regex-alphanumeric-characters/
            return true;
        }
        return false;
    }



    public static void tabulate() {
        String testroot = Survey.listAndPickDirStealth("." + File.separator + "Surveys" + File.separator); //We pick a directory, associated with a Survey.
        if (testroot != "Need to make surveys/tests!") { //If the test directory has folders.
            List<String> loadedpaths = Survey.getAllFilePathsInDir(testroot); //Go into the selected folder and get all the paths in that folder.
            if (loadedpaths.isEmpty() == false) { //If the folder is not empty.
                ArrayList<Survey> loadedSurveys = new ArrayList<Survey>();
                ArrayList<HashMap<ArrayList<String>, Integer>> hashmaps = new ArrayList<HashMap<ArrayList<String>, Integer>>();
                ArrayList<ArrayList<ArrayList<String>>> responses = new ArrayList<ArrayList<ArrayList<String>>>();
                //Deserializes all the loaded paths and put them into loadedSurveys (I know, not the best name for a variable).
                for (String i: loadedpaths) {
                    Survey deser = Survey.deserialize(i);
                    loadedSurveys.add(deser);
                }
                //Iterating through all the questions using the first loaded Survey in loadedSurveys.
                for (int i = 0; i < loadedSurveys.get(0).questions.size(); i++) {
                    HashMap<ArrayList<String>, Integer> map = new HashMap<ArrayList<String>, Integer>(); //Making a Map to gather the responses and frequency of them.
                    //We loop over the whole loadedSurveys arrayList to get access to the responses for all loaded objects.
                    for (int j = 0; j < loadedSurveys.size(); j++) {
                        if (map.containsKey(loadedSurveys.get(j).questions.get(i).getUserAnswer())) { //If the Map contains the answer as a key...
                            int count = map.get(loadedSurveys.get(j).questions.get(i).getUserAnswer()); //Take the value of that answer
                            map.put(loadedSurveys.get(j).questions.get(i).getUserAnswer(), count + 1); //And override the answer, which is a key, and add one to its value.
                        } else {
                            map.put(loadedSurveys.get(j).questions.get(i).getUserAnswer(), 1); //Otherwise, just add the new response as a key, and give it the value 1.
                        }
                    }
                    ArrayList<ArrayList<String>> response = new ArrayList<>(); //Stores the response of the survey from each question.
                    for (int j = 0; j < loadedSurveys.size(); j++) {
                        response.add(loadedSurveys.get(j).questions.get(i).getUserAnswer()); //Adds the response for the survey.
                    }
                    hashmaps.add(map); //Adds "map" to the ArrayList hashmaps.
                    responses.add(response); //Adds "response" to the responses ArrayList.
                }
                //Loops through the hashmaps, responses, and questions ArrayList to display the data.
                System.out.println("Tabulation Data");
                System.out.println("--------------------------------------");
                for (int i = 0; i < hashmaps.size(); i++) {
                    loadedSurveys.get(0).questions.get(i).display();
                    System.out.println("Tabulation: ");
                    hashmaps.get(i).forEach((k,v) -> System.out.println("Answer: "+ k + ", Frequency: " + v)); //https://www.javatpoint.com/how-to-iterate-map-in-java
                    System.out.println("Responses: ");
                    responses.get(i).forEach((k) -> System.out.println(k)); //Inspired by the code seen in: https://www.javatpoint.com/how-to-iterate-map-in-java
                    System.out.println(" ");
                }

            } else {
                System.out.println("There are no response files!");
            }
        } else {
            System.out.println("There are no survey folders created!");
        }
    }




    //The survey menu, which consists of a loop that handles a if-else hierarchy of functionality, depending on the user's option!
    public static void surveyMenu() {
        Survey loadedSurvey = null; //Is the container of the loaded Survey that the user will loaded in the menu.
        boolean loop = true;
        while (loop == true) {
            if (Objects.isNull(loadedSurvey)) { // Objects.isNull() will check if loaded Survey is of null value, to execute alternate behavior.
                System.out.println("A survey is not loaded yet.");
            } else {
                System.out.println("Loaded Survey: " + loadedSurvey.getName());
            }
            System.out.println("--------------------------------------");
            System.out.println("1) Create a new Survey");
            System.out.println("2) Display an existing Survey");
            System.out.println("3) Load an existing Survey");
            System.out.println("4) Save the current Survey");
            System.out.println("5) Take the current Survey");
            System.out.println("6) Modifying the current Survey");
            System.out.println("7) Tabulating a Survey");
            System.out.println("8) Return to previous menu");
            System.out.println("Please select a choice: ");
            int menuinput = Input.readIntInRange(1, 8);
            if (menuinput == 1) {
                Survey newsur = new Survey();
                newsur.createQuestions();
                loadedSurvey = newsur; //The created survey will become the "loaded" survey by default!
            }
            else if (menuinput == 2) {
                if (Objects.isNull(loadedSurvey)) {
                    System.out.println("You need to have a loaded survey!");
                }
                else {
                    loadedSurvey.display();
                }
            }
            else if (menuinput == 3) {
                String loadpath = Survey.listAndPickFileFromDir("." + File.separator + "Surveys" + File.separator);
                if (loadpath != "Need to make surveys/tests!") {
                    loadedSurvey = Survey.deserialize(loadpath); //Using deserialize to load Survey from file system.
                }
            }
            else if (menuinput == 4) {
                if (Objects.isNull(loadedSurvey)) {
                    System.out.println("You need to have a loaded survey or have created a survey!");
                }
                else {
                    Survey.serialize(loadedSurvey);
                }
            }
            else if (menuinput == 5) {
                if (Objects.isNull(loadedSurvey)) {
                    System.out.println("You need to have a loaded survey or have created a survey!");
                }
                else {
                    File checkFile = new File("." + File.separator + "Surveys" + File.separator + loadedSurvey.name + ".ser");
                    if (checkFile.exists()) { //This checks the event that the user creates a survey, but has not saved it to create the responses directory for the survey.
                        loadedSurvey.take();
                        Survey.serialize(loadedSurvey);
                        loadedSurvey = null; //Sets the loaded survey to null, as we are done taking it.
                    } else {
                        System.out.println("You must have saved your survey before taking it, first!");
                    }
                }
            }
            else if (menuinput == 6) {
                if (Objects.isNull(loadedSurvey)) {
                    System.out.println("You need to have a loaded survey or have created a survey!");
                }
                else {
                    loadedSurvey.modify();
                }
            }
            else if (menuinput == 7) {
                Survey.tabulate();
            }
            else if (menuinput == 8) {
                loop = false; //The terminator of the loop for the menu.
            }
        }
    }


}
