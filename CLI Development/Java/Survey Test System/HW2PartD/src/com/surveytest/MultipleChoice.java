// ===============================
// AUTHOR: Mohamed Mohamed
// PURPOSE: In charge of the code for the MultipleChoice questions.
// ===============================
package com.surveytest;
import com.surveytest.abstractedInputOutput.In;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.*;

public class MultipleChoice extends Question implements Serializable {
    protected ArrayList choices = new ArrayList<String>(); //Contains choices for the question.
    protected int numofCho; //Is the number of choices when the MC is setup.
    protected int numofRes; //Contains the number of responses that the taker is given.
    protected ArrayList choiceLetters = new ArrayList<String>(); //Contains the letter choices for the question.
    private static final long serialVersionUID = 1L;

    public MultipleChoice() {
        super();
    }

    //Involves the creator declaring the values of the number of choices, responses, and the input of choices.
    public void create() {
        System.out.println("Enter the number of choices for your multiple-choice question.");
        int numofchoiceInput = In.getInstance().readInt();
        this.numofCho = numofchoiceInput;
        for (int i = 65; i <= (65 + (this.numofCho - 1)); i++) { //https://stackoverflow.com/questions/2047228/auto-increment-alphabet-in-java
            choiceLetters.add(String.valueOf((char)i)); //Populates choiceLetters according to the number of choices given.
        }
        System.out.println("Enter the number of responses for your multiple-choice question.");
        int numofresponseInput = In.getInstance().readInt(); //Sets the number of responses for the MC question.
        this.numofRes = numofresponseInput;
        System.out.println("Enter the choices for your multiple-choice question.");
        for (int i = 0; i < this.numofCho; i++) { //The population of the user's input for choices.
            System.out.println("Enter choice " + this.choiceLetters.get(i) + ":");
            String choiceInput = In.getInstance().readStr();
            this.choices.add(choiceInput);
        }
    }

    //Derived from StudentRepo
    public void setUserAnswer() {
        for (int i = 0; i < this.numofRes; i++) {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = "-1";
            try{
                System.out.println("Input your answer as an upper-case character: ");
                line = in.readLine();
                // If the input isn't full, already entered, or fits the criteria of isMultipleC, then loop!
                while(line == null || line.length() == 0 || this.userAnswer.getResponses().contains(line) || !(isMultipleC(line))) {
                    System.out.println("Invalid input!");
                    System.out.println("Input your answer as an upper-case character: ");
                    line = in.readLine();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
            this.userAnswer.setResponses(line); //Adds the user input as a response.
        }
    }

    public Response setCorrectAnswer() {
        Response correctanswer = new Response();
        for (int i = 0; i < this.numofRes; i++) {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = "-1";
            try{
                System.out.println("Input the correct answer as an upper-case character: ");
                line = in.readLine();
                // If the input isn't full, already entered, or fits the criteria of isMultipleC, then loop!
                while(line == null || line.length() == 0 || correctanswer.getResponses().contains(line) || !(isMultipleC(line))) {
                    System.out.println("Invalid input!");
                    System.out.println("Input the correct answer as an upper-case character: ");
                    line = in.readLine();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
            correctanswer.setResponses(line); //Adds the user input as a response.

        }
        return correctanswer;
    }

    //Modifies the prompt and choice.
    public void modify() {
        System.out.println("Do you wish modify the prompt? Please enter \"Yes\" or \"No\".");
        String confirmInput = In.getInstance().readOption();
        if (confirmInput.equals("Yes")) {
            System.out.println("Current Prompt: " + this.questionPrompt);
            System.out.println("Enter a new prompt: ");
            String confirmProInput = In.getInstance().readStr();
            this.questionPrompt = confirmProInput;
        }

        System.out.println("Do you wish modify the choices? Please enter \"Yes\" or \"No\".");
        String confirmchoices = In.getInstance().readOption(); //Takes only "Yes" and "No" as an answer.

        if (confirmchoices.equals("Yes")) {
            System.out.println("Which choice do you want to change?");
            this.displayChoices();
            String letterinputchoice = In.getInstance().readStr();
            while(!this.choiceLetters.contains(letterinputchoice)) { //A form of error handling, which checks the user input and if it is a valid choice.
                System.out.println("Not a valid choice to modify!");
                letterinputchoice = In.getInstance().readStr();
            }
            System.out.println("Enter your new choice: ");
            String newchoice = In.getInstance().readStr();
            this.choices.set(this.choiceLetters.indexOf(letterinputchoice), newchoice); //Uses the index of the choice selected, and modifies the "choices" array to the user input.
        }

    }

    public void display() {
        System.out.println(this.questionPrompt +  " Please pick an letter.");
        for (int i = 0; i < this.numofCho; i++) {
            System.out.println(this.choiceLetters.get(i) + ") " + this.choices.get(i) + " ");
        }
    }
    //Displays the choices only.
    public void displayChoices() {
        for (int i = 0; i < this.numofCho; i++) {
            System.out.println(this.choiceLetters.get(i) + ") " + this.choices.get(i) + " ");
        }
    }
    //An form of error handling, checks that the input is one character, and contained in choiceLetters, thus a valid choice and returns true.
    private boolean isMultipleC(String line) {
        if (line.length() == 1 && this.choiceLetters.contains(line)) {
            return true;
        }
        return false;
    }

}
