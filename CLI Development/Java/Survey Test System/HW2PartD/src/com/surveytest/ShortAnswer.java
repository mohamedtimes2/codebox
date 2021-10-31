// ===============================
// AUTHOR: Mohamed Mohamed
// PURPOSE: In charge of the code for the Short Answer questions.
// ===============================
package com.surveytest;
import com.surveytest.abstractedInputOutput.In;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class ShortAnswer extends Essay implements Serializable {
    private int characterlimit; //Declares the character limit of the answer.
    private static final long serialVersionUID = 1L;

    public ShortAnswer() {
        super();
    }
    //Extension of constructor, which handling the number of responses and character limit being declared.
    public void create() {
        System.out.println("Enter the number of responses for your short answer question: ");
        int numofresponseInput = In.getInstance().readInt();
        this.numofRes = numofresponseInput;
        System.out.println("Enter the character limit for user (this includes spaces): ");
        int charresInput = In.getInstance().readInt();
        this.characterlimit = charresInput;

    }
    //Derived from the Student Repo
    public void setUserAnswer() {
        for (int i = 0; i < this.numofRes; i++) {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = "-1";
            try{
                System.out.println("Input your short answer response: ");
                line = in.readLine();
                // Error handling, as long as the input is null, empty, or greater than the character limit, loop.
                while(line == null || line.length() == 0 || !(line.length() <= this.characterlimit)){
                    System.out.println("Invalid input!");
                    System.out.println("Input your short answer response: ");
                    line = in.readLine();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
            this.userAnswer.setResponses(line); //Sets the input as the response.

        }
    }

    public Response setCorrectAnswer() {
        Response correctanswer = new Response();
        for (int i = 0; i < this.numofRes; i++) {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = "-1";
            try{
                System.out.println("Input the correct answer for the short answer question: ");
                line = in.readLine();
                // Error handling, as long as the input is null, empty, or greater than the character limit, loop.
                while(line == null || line.length() == 0 || !(line.length() <= this.characterlimit)){
                    System.out.println("Invalid input!");
                    System.out.println("Input the correct answer for the short answer question: ");
                    line = in.readLine();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
            correctanswer.setResponses(line); //Sets the input as the response.
        }
        return correctanswer;

    }
    //Just allows the user to modify the prompt class attribute.
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

    public void display() {
        System.out.println(this.questionPrompt +  " Please input a valid short answer response.");
    }

}
