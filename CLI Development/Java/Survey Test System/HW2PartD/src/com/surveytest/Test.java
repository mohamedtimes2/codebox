package com.surveytest;

import com.surveytest.abstractedInputOutput.In;
import com.surveytest.utils.Input;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Test extends Survey {
    private ArrayList<Response> correctanswers = new ArrayList<Response>(); //Container for all correct answers.
    private static final long serialVersionUID = 1L;

    public Test() {
        super();
    }

    //A if-else block that loops until a certain input breaks the loop.
    public void createQuestions() {
        boolean loop = true;
        while (loop == true) {
            if(this.questions.size() == 0) {
                System.out.println("You need have at least one question created for your test!");
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
                Response correctans = tfquestion.setCorrectAnswer();
                this.correctanswers.add(correctans); //Appending the return value of setCorrectAnswer to the correctanswers class variable.
            } else if (createinput == 2) {
                Question mcquestion = new MultipleChoice();
                mcquestion.create();
                this.questions.add(mcquestion);
                Response correctans = mcquestion.setCorrectAnswer();
                this.correctanswers.add(correctans);
            } else if (createinput == 3) {
                Question saquestion = new ShortAnswer();
                saquestion.create();
                this.questions.add(saquestion);
                Response correctans = saquestion.setCorrectAnswer();
                this.correctanswers.add(correctans);
            } else if (createinput == 4) {
                Question equestion = new Essay();
                equestion.create();
                this.questions.add(equestion);
                Response correctans = equestion.setCorrectAnswer();
                this.correctanswers.add(correctans);
            } else if (createinput == 5) {
                Question dquestion = new Date();
                dquestion.create();
                this.questions.add(dquestion);
                Response correctans = dquestion.setCorrectAnswer();
                this.correctanswers.add(correctans);
            } else if (createinput == 6) {
                Question mquestion = new Matching();
                mquestion.create();
                this.questions.add(mquestion);
                Response correctans = mquestion.setCorrectAnswer();
                this.correctanswers.add(correctans);
            } else {
                if (this.questions.size() == 0) { //A nested if-else, that states that if there are no questions, continue loop, otherwise end loop.
                    loop = true;
                } else {
                    loop = false;
                }
            }
        }
    }

    public void displayWithCorrectAnswers() {
        System.out.println("Displayed Survey: " + this.name);
        System.out.println("------------------------------------------------------ ");
        for (int i = 0; i < this.questions.size(); i++) {
            Question p = (Question) this.questions.get(i);
            p.display();
            System.out.println("");
            System.out.println("Correct Answers: " + this.correctanswers.get(i).getResponses()); //Getting the correct answers to display.
            System.out.println("");
        }
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
        System.out.println("Do you wish to modify the correct answer? Please enter \"Yes\" or \"No\".");
        String changecoransInput = In.getInstance().readOption();
        if (changecoransInput.equals("Yes")) {
            System.out.println("Current Correct Answer(s): " + this.correctanswers.get(modifyinput).getResponses());
            Response modifiedcoranswer = chosenques.setCorrectAnswer();
            this.correctanswers.set(modifyinput, modifiedcoranswer);
        }
        //After test has been edited, all responses will be invalid and must be deleted, thus check if directory of responses exist and deleted if it does.
        File modifieddir = new File("." + File.separator + "Tests" + File.separator + this.name + File.separator);
        if (modifieddir.isDirectory()) {
            deleteDirectory(modifieddir);
        }
    }


    public static String serialize(Test test) {
        String path = "";
        if (test.responsename.equals("")) {
            /* If responsename is an empty string, we treated the Test object as a survey and serialize it in the Tests subdirectory and create
            subdirectory for the responses related to the test, otherwise
            * treat it as a response and save the responses folder. */
            path = "." + File.separator + "Tests" + File.separator + test.name + ".ser";
            createDirectory("." + File.separator + "Tests" + File.separator + test.name + File.separator);
        } else {
            path = "." + File.separator + "Tests" + File.separator + test.name + File.separator + test.responsename + ".ser";
            createDirectory("." + File.separator + "Tests" + File.separator + test.name + File.separator);
        }
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(test);
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

    public static Test deserialize(String path){
        Test deserializedObject = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            deserializedObject = (Test) ois.readObject(); //Returns the object as type Object, thus we need to explicitly cast it to Survey.
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
        return deserializedObject; //Returns the object we want. Ask about this!
    }



    public static void tabulate() {
        String testroot = Survey.listAndPickDirStealth("." + File.separator + "Tests" + File.separator); //We pick a directory, associated with a Test.
        if (testroot != "Need to make surveys/tests!") { //If the test directory has folders.
            List<String> loadedpaths = Survey.getAllFilePathsInDir(testroot); //Go into the selected folder and get all the paths in that folder.
            if (loadedpaths.isEmpty() == false) { //If the folder is not empty.
                ArrayList<Test> loadedSurveys = new ArrayList<Test>();
                ArrayList<HashMap<ArrayList<String>, Integer>> hashmaps = new ArrayList<HashMap<ArrayList<String>, Integer>>();
                ArrayList<ArrayList<ArrayList<String>>> responses = new ArrayList<ArrayList<ArrayList<String>>>();
                //Deserializes all the loaded paths and put them into loadedSurveys (I know, not the best name for a variable).
                for (String i: loadedpaths) {
                    Test deser = Test.deserialize(i);
                    loadedSurveys.add(deser);
                }
                //Iterating through all the questions using the first loaded Test in loadedSurveys.
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
                    ArrayList<ArrayList<String>> response = new ArrayList<>(); //Stores the response of the test from each question.
                    for (int j = 0; j < loadedSurveys.size(); j++) {
                        response.add(loadedSurveys.get(j).questions.get(i).getUserAnswer()); //Adds the response for the test.
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
            System.out.println("There are no test folders created!");
        }
    }



    public static void grade() {
        String testroot = Survey.listAndPickDirStealth("." + File.separator + "Tests" + File.separator); //We pick a directory, associated with a Test.
        if (testroot != "Need to make surveys/tests!") {
            String testresselect = Survey.listAndPickFileFromDirStealth(testroot); //Go into the selected folder and get a path in that folder.
            if (testresselect != "Need to make surveys/tests!") {
                Test loadedTest = Test.deserialize(testresselect); //We deserialize using the path we return from testresselect.
                ArrayList<Boolean> answersheet = new ArrayList<Boolean>(); //Container for all questions.
                for (int i = 0; i < loadedTest.questions.size(); i++) {
                    //As long as the question that encounter is not a Essay, use Response.compare to check if the answer is correct or not, and add the result to answersheet.
                    if ((loadedTest.questions.get(i) instanceof ShortAnswer) == true || (loadedTest.questions.get(i) instanceof MultipleChoice) == true || (loadedTest.questions.get(i) instanceof TrueFalse) == true || (loadedTest.questions.get(i) instanceof Matching) == true || (loadedTest.questions.get(i) instanceof Date) == true) {
                        boolean result = Response.compare(loadedTest.questions.get(i).getUserAnswerObj(), loadedTest.correctanswers.get(i));
                        answersheet.add(result);
                    }
                }
                double numofcorres = Collections.frequency(answersheet, true); //Shows the number of correct responses out of the autogradable questions.
                double gradecalc = (numofcorres / (double) answersheet.size()) * 100; //Shows the grade based on autogradable questions only.
                double gradecalc2 = (answersheet.size() / (double) loadedTest.questions.size()) * 100; //Shows the number of points that can be graded.
                int diffinquestions = loadedTest.questions.size() - answersheet.size(); //Get the number of essay questions.
                //Fixing a case, where an individual could make a Test with one Essay question, and nothing else.
                if (Double.isNaN(gradecalc) == true) {
                    System.out.println("You received 0.0 on the test. The test was worth 100.0 points, but only " + gradecalc2  + " of those points could be auto graded because there was " + diffinquestions  + " essay question(s).");
                } else {
                    System.out.println("You received " +  gradecalc  + " on the test. The test was worth 100.0 points, but only " + gradecalc2  + " of those points could be auto graded because there was " + diffinquestions  + " essay question(s).");
                }
            } else {
                System.out.println("There are no response files!");
            }
        } else {
            System.out.println("There are no test folders created!");
        }
    }


    public static void testMenu() {
        Test loadedTest = null; //Is the container of the loaded Test that the user will loaded in the menu.
        boolean loop = true;
        while (loop == true) {
            if (Objects.isNull(loadedTest)) { // Objects.isNull() will check if loaded Survey is of null value, to execute alternate behavior.
                System.out.println("A test is not loaded yet.");
            } else {
                System.out.println("Loaded Test: " + loadedTest.getName());
            }
            System.out.println("--------------------------------------");
            System.out.println("1) Create a new Test");
            System.out.println("2) Display an existing Test without correct answers");
            System.out.println("3) Display an existing Test with correct answers");
            System.out.println("4) Load an existing Test");
            System.out.println("5) Save the current Test");
            System.out.println("6) Take the current Test");
            System.out.println("7) Modifying the current Test");
            System.out.println("8) Tabulate a Test");
            System.out.println("9) Grade a Test");
            System.out.println("10) Return to the previous menu");
            System.out.println("Please select a choice: ");
            int menuinput = Input.readIntInRange(1, 10);
            if (menuinput == 1) {
                Test newtest = new Test();
                newtest.createQuestions();
                loadedTest = newtest; //The created test will become the "loaded" test by default!
            }
            else if (menuinput == 2) {
                if (Objects.isNull(loadedTest)) {
                    System.out.println("You need to have a loaded test!");
                }
                else {
                    loadedTest.display();
                }
            }
            else if (menuinput == 3) {
                if (Objects.isNull(loadedTest)) {
                    System.out.println("You need to have a loaded test!");
                }
                else {
                    loadedTest.displayWithCorrectAnswers();
                }
            }
            else if (menuinput == 4) {
                String loadpath = Test.listAndPickFileFromDir("." + File.separator + "Tests" + File.separator);
                if (loadpath != "Need to make surveys/tests!") {
                    loadedTest = Test.deserialize(loadpath); //Using deserialize to load Test from file system.
                }
            }
            else if (menuinput == 5) {
                if (Objects.isNull(loadedTest)) {
                    System.out.println("You need to have a loaded test or have created a test!");
                }
                else {
                    Test.serialize(loadedTest);
                }
            }
            else if (menuinput == 6) {
                if (Objects.isNull(loadedTest)) {
                    System.out.println("You need to have a loaded test or have created a test!");
                }
                else {
                    File checkFile = new File("." + File.separator + "Tests" + File.separator + loadedTest.name + ".ser");
                    if (checkFile.exists()) { //This checks the event that the user creates a test, but has not saved it to create the responses directory for the test.
                        loadedTest.take();
                        Test.serialize(loadedTest);
                        loadedTest = null; //Sets the loaded test to null, as we are done taking it.
                    } else {
                        System.out.println("You must have saved your test before taking it, first!");
                    }
                }
            }
            else if (menuinput == 7) {
                if (Objects.isNull(loadedTest)) {
                    System.out.println("You need to have a loaded test or have created a test!");
                }
                else {
                    loadedTest.modify();
                }
            }
            else if (menuinput == 8) {
                Test.tabulate();
            }
            else if (menuinput == 9) {
                Test.grade();
            }
            else if (menuinput == 10) {
                loop = false; //The terminator of the loop for the menu.
            }
        }
    }


}
