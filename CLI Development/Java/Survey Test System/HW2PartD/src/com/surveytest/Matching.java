// ===============================
// AUTHOR: Mohamed Mohamed
// PURPOSE: In charge of the code for the Matching questions.
// ===============================
package com.surveytest;
import com.surveytest.abstractedInputOutput.In;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.io.*;

public class Matching extends Question implements Serializable {
    protected ArrayList choices = new ArrayList<String>(); //Will store the left column of choices.
    protected ArrayList choices2 = new ArrayList<String>(); //Will store the right column of choices.
    protected ArrayList choiceLetters = new ArrayList<String>(); //Will store the letter choices for the left column
    protected ArrayList choiceNumbers = new ArrayList<String>(); //Will store the number choices for the right column
    protected int numofCho; //The number of choices for each matching question.
    protected int numofRes; //The number of responses for each matching question.

    public void create() { //Extension of constructor, handles numbers of choices, and responses
        System.out.println("Enter the number of choices for both columns for your matching question!");
        int numofchoiceInput = In.getInstance().readInt();
        this.numofCho = numofchoiceInput;
        System.out.println("Enter the number of responses for both columns for your matching question!");
        int numofresponseInput = In.getInstance().readInt();
        this.numofRes = numofresponseInput;
        for (int i = 65; i <= (65 + (this.numofCho - 1)); i++) { //https://stackoverflow.com/questions/2047228/auto-increment-alphabet-in-java
            choiceLetters.add(String.valueOf((char)i)); //Populates choiceLetters according to numofCho's value with string values of letters
        }
        for (int i = 0; i < this.numofCho; i++) {
            choiceNumbers.add(String.valueOf(i + 1)); //Populates choiceNumbers according to numofCho's value with string values of numbers
        }
        for (int i = 0; i < this.numofCho; i++) { //Based of numofCho, user will input their choices for the left column
            System.out.println("Enter choice " + choiceLetters.get(i) + ":");
            String choiceInput = In.getInstance().readStr();
            this.choices.add(choiceInput);
        }
        for (int i = 0; i < this.numofCho; i++) { //Based of numofCho, user will input their choices for the right column
            System.out.println("Enter choice #" + (i + 1));
            String choiceInput = In.getInstance().readStr();
            this.choices2.add(choiceInput);
        }
    }

    public void display() {
        System.out.println(this.questionPrompt +  " Please input your answer in the form of \"A 1\".");
        for (int i = 0; i < this.numofCho; i++) {
            System.out.printf( "%-15s %1s %n", this.choiceLetters.get(i) + ") " + this.choices.get(i), this.choiceNumbers.get(i) + ") " + this.choices2.get(i)); //https://www.homeandlearn.co.uk/java/java_formatted_strings.html
        }
    }
    //Display the left column of choices solely.
    public void displayleft() {
        for (int i = 0; i < this.numofCho; i++) {
            System.out.println(this.choiceLetters.get(i) + ") " + this.choices.get(i));
        }
    }
    //Display the right column of choices solely.
    public void displayright() {
        for (int i = 0; i < this.numofCho; i++) {
            System.out.println(this.choiceNumbers.get(i) + ") " + this.choices2.get(i));
        }
    }
    //Handles the modification of Matching questions, including prompt, left and right column.
    public void modify() {
        System.out.println("Do you wish modify the prompt? Please enter \"Yes\" or \"No\".");
        String confirmInput = In.getInstance().readOption();
        if (confirmInput.equals("Yes")) { //If user inputs "Yes", then user will be displayed current prompt and can input new prompt.
            System.out.println("Current Prompt: " + this.questionPrompt);
            System.out.println("Enter a new prompt: ");
            String confirmProInput = In.getInstance().readStr();
            this.questionPrompt = confirmProInput;
        }

        System.out.println("Do you wish modify the left column? Please enter \"Yes\" or \"No\".");
        String confirmleftInput = In.getInstance().readOption();
        if (confirmleftInput.equals("Yes")) { //If user inputs "Yes", then user will be displayed current left column and can choose choice to modify.
            System.out.println("Which choice do you want to change from the left column? Pick a letter:");
            this.displayleft();
            String letterinputchoice = In.getInstance().readStr();
            while(!this.choiceLetters.contains(letterinputchoice)) { //Checks if the input is a element within choiceLetters as a form of error handling, if not loop.
                System.out.println("Not a valid choice to modify!");
                letterinputchoice = In.getInstance().readStr();
            }
            System.out.println("Enter your new choice: ");
            String newchoice = In.getInstance().readStr();
            this.choices.set(this.choiceLetters.indexOf(letterinputchoice), newchoice); //Uses the index of the choice selected, and modifies the choice array to the user input.
            this.displayleft();
        }

        System.out.println("Do you wish modify the right column? Please enter \"Yes\" or \"No\".");
        String confirmrightInput = In.getInstance().readOption();
        if (confirmrightInput.equals("Yes")) { //If user inputs "Yes", then user will be displayed current right column and can choose choice to modify.
            System.out.println("Which choice do you want to change from the right column? Pick a number:");
            this.displayright();
            int numberinputchoice = In.getInstance().readInt();
            while(!this.choiceNumbers.contains(String.valueOf(numberinputchoice))) { //Checks if the input is a element within choiceNumbers as a form of error handling, if not loop.
                System.out.println("Not a valid choice to modify!");
                numberinputchoice = In.getInstance().readInt();
            }
            System.out.println("Enter your new choice: ");
            String newchoice2 = In.getInstance().readStr();
            this.choices2.set(this.choiceNumbers.indexOf(String.valueOf(numberinputchoice)), newchoice2); //Uses the index of the choice selected, and modifies the choice2 array to the user input.
            this.displayright();
        }
    }
    //Derived mainly from the StudentRepo
    public void setUserAnswer() {
        for (int i = 0; i < this.numofRes; i++) { //Repeats for the number of responses requested by creator.
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = "-1";
            try{
                System.out.println("Input your answer with the format \"A 1\": ");
                line = in.readLine();
                // Error handling, if line is null, empty, was previously inputted, or does not fulfill "isMatching", loop.
                while(line == null || line.length() == 0 || this.userAnswer.getResponses().contains(line) || !isMatching(line)){
                    System.out.println("Invalid input!");
                    System.out.println("Input your answer with the format \"A 1\": ");
                    line = in.readLine();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
            this.userAnswer.setResponses(line); //Once input is acceptable, set the response to the class attribute "userAnswer".

        }

    }

    public Response setCorrectAnswer() {
        Response correctAnswer = new Response();
        for (int i = 0; i < this.numofRes; i++) { //Repeats for the number of responses requested by creator.
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = "-1";
            try{
                System.out.println("Input the correct answer with the format \"A 1\": ");
                line = in.readLine();
                // Error handling, if line is null, empty, was previously inputted, or does not fulfill "isMatching", loop.
                while(line == null || line.length() == 0 || correctAnswer.getResponses().contains(line) || !isMatching(line)){
                    System.out.println("Invalid input!");
                    System.out.println("Input the correct answer with the format \"A 1\": ");
                    line = in.readLine();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
            correctAnswer.setResponses(line); //Once input is acceptable, set the response to the class attribute "userAnswer".
        }
        return correctAnswer;
    }

    // Checks line in setUserAnswer if it is acceptable as an answer, uses a regex to control valid format: "A 1".
    //Checks if the letter and number selected are vaild choices by referring to choiceLetters and choiceNumbers's contents, and returns a boolean.
    private boolean isMatching(String line) {
        String regex = "[A-Z]\\s\\d";
        Pattern pattern = Pattern.compile(regex);
        String[] parts = line.split(" ");
        if (line.matches(regex) && this.choiceLetters.contains(parts[0]) && this.choiceNumbers.contains(parts[1])) {
            return true;
        }
        return false;
    }


}
