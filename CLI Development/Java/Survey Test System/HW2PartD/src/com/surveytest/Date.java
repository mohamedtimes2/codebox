// ===============================
// AUTHOR: Mohamed Mohamed
// PURPOSE: In charge of the code for the Date question.
// ===============================
package com.surveytest;
import com.surveytest.abstractedInputOutput.In;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class Date extends Question implements Serializable {
    protected int numofRes; //Handles number of responses for the question.
    private static final long serialVersionUID = 1L;

    public Date() {
        super();
    }

    public void create() { //Extended constructor that handles the user's input for numofRes.
        System.out.println("Enter the number of responses for your date question.");
        int numofresponseInput = In.getInstance().readInt();
        this.numofRes = numofresponseInput;
    }

    //Derived from StudentRepo
    public void setUserAnswer() {
        for (int i = 0; i < this.numofRes; i++) { //Repeats for the number of responses requested by creator.
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = "-1";
            try {
                System.out.println("Input your date answer: ");
                line = in.readLine();
                while (!isDate(line)) { //Verifies the input as a date format otherwise loops.
                    System.out.println("Invalid input!");
                    System.out.println("Input your date answer: ");
                    line = in.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.userAnswer.setResponses(line); //Sets the response to the user input.
        }
    }

    public Response setCorrectAnswer() {
        Response correctanswer = new Response();
        for (int i = 0; i < this.numofRes; i++) { //Repeats for the number of responses requested by creator.
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = "-1";
            try {
                System.out.println("Input your correct answer for the date question. Please input the valid date format (MM/DD/YYYY): ");
                line = in.readLine();
                while (!isDate(line)) { //Verifies the input as a date format otherwise loops.
                    System.out.println("Invalid input!");
                    System.out.println("Input your correct answer for the date question Please input the valid date format (MM/DD/YYYY): ");
                    line = in.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            correctanswer.setResponses(line); //Sets the response to the user input.
        }
        return correctanswer;

    }


    public void modify() {
        System.out.println("Do you wish modify the prompt? Please enter \"Yes\" or \"No\".");
        String confirmInput = In.getInstance().readOption(); //Will only expect inputs "Yes" or "No", see InputHelper.java in AbstractInputOutput.
        if (confirmInput.equals("Yes")) {
            System.out.println("Current Prompt: " + this.questionPrompt);
            System.out.println("Enter a new prompt: ");
            String confirmProInput = In.getInstance().readStr();
            this.questionPrompt = confirmProInput;
        }
    }
    public void display() {
        System.out.println(this.questionPrompt +  " Please input the valid date format (MM/DD/YYYY).");
    }
    // Compares input with a regex that looks for MM/DD/YYYY format. Regex source is below and credited.
    public boolean isDate(String line) {
        String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$"; //https://www.tutorialspoint.com/accepting-date-strings-mm-dd-yyyy-format-using-java-regex
        Pattern pattern = Pattern.compile(regex);
        if (line.matches(regex)) {
            return true;
        }
        return false;
    }

}

