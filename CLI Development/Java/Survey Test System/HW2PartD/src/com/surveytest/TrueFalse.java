// ===============================
// AUTHOR: Mohamed Mohamed
// PURPOSE: In charge of the code for the True and False questions.
// ===============================
package com.surveytest;
import com.surveytest.abstractedInputOutput.In;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrueFalse extends MultipleChoice implements Serializable {
    private static final long serialVersionUID = 1L;

    public TrueFalse() {
        super();
    }

    public void create() {
    }

    public void display() {
        System.out.println(this.questionPrompt +  " Please input \"True\" or \"False\".");
    }

    //Basic modify methods, allow one to modify the prompt or not.
    public void modify() {
        System.out.println("Do you wish modify the prompt? Please enter \"Yes\" or \"No\".");
        String confirmInput = In.getInstance().readOption();
        if (confirmInput.equals("Yes")) {
            System.out.println("Current Prompt: " + this.questionPrompt);
            System.out.println("Enter a new prompt: ");
            String confirmProInput = In.getInstance().readStr();
            this.questionPrompt = confirmProInput;
        }
    }

    public void setUserAnswer() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "-1";
        try{
            System.out.println("Input your answer as \"True\" or \"False\": ");
            line = in.readLine();
            // Will loop if user does not input True or False.
            while((!line.equals("True") && (!line.equals("False")))){
                System.out.println("Invalid input!");
                System.out.println("Input your answer as \"True\" or \"False\": ");
                line = in.readLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        this.userAnswer.setResponses(line); //Appends the input to the Response object that the TrueFalse class aggregates.
    }

    public Response setCorrectAnswer() {
        Response correctanswer = new Response();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "-1";
        try{
            System.out.println("Input the correct answer as \"True\" or \"False\": ");
            line = in.readLine();
            // Will loop if user does not input True or False.
            while((!line.equals("True") && (!line.equals("False")))){
                System.out.println("Invalid input!");
                System.out.println("Input the correct answer as \"True\" or \"False\": ");
                line = in.readLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        correctanswer.setResponses(line); //Appends the input to the Response object that the TrueFalse class aggregates.
        return correctanswer;

    }

}
