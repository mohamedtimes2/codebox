// ===============================
// AUTHOR: Mohamed Mohamed
// PURPOSE: In charge of the code for the Essay question.
// ===============================
package com.surveytest;
import com.surveytest.abstractedInputOutput.In;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class Essay extends Question implements Serializable {
    protected int numofRes; //Sets number of responses
    private static final long serialVersionUID = 1L;

    public Essay() {
        super();
    }

    public void create() { //Extended constructor that handles the user's input for numofRes.
        System.out.println("Enter the number of responses for your essay question.");
        int numofresponseInput = In.getInstance().readInt();
        this.numofRes = numofresponseInput;
    }


    //Mainly derived from StudentRepo
    public void setUserAnswer() {
        for (int i = 0; i < this.numofRes; i++) { //Repeats for the number of responses requested by creator.
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = "-1";
            try{
                System.out.println("Input your essay answer: ");
                line = in.readLine();
                //Error handling, if input is empty, null, or only consists of whitespace, loop and prompt a new response.
                while(line == null || line.length() == 0 || !(line.trim().length() > 0)) { //https://stackoverflow.com/questions/3247067/how-do-i-check-that-a-java-string-is-not-all-whitespaces
                    System.out.println("Invalid input!");
                    System.out.println("Input your essay answer: ");
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
                System.out.println("Input the correct answer for the essay question: ");
                line = in.readLine();
                //Error handling, if input is empty, null, or only consists of whitespace, loop and prompt a new response.
                while(line == null || line.length() == 0 || !(line.trim().length() > 0)) { //https://stackoverflow.com/questions/3247067/how-do-i-check-that-a-java-string-is-not-all-whitespaces
                    System.out.println("Invalid input!");
                    System.out.println("Input the correct answer for the essay question: ");
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

    public void modify() {
        System.out.println("Do you wish modify the prompt? Please enter \"Yes\" or \"No\".");
        String confirmInput = In.getInstance().readOption(); //Will only expect inputs "Yes" or "No", see InputHelper.java in AbstractInputOutput.
        if (confirmInput.equals("Yes")) { //If user inputs "Yes", current prompt will be displayed and user input for new prompt will be set.
            System.out.println("Current Prompt: " + this.questionPrompt);
            System.out.println("Enter a new prompt: ");
            String confirmProInput = In.getInstance().readStr();
            this.questionPrompt = confirmProInput;
        }
    }

    public void display() {
        System.out.println(this.questionPrompt +  " Please input a valid response.");
    }
}
