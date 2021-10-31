// ===============================
// AUTHOR: Mohamed Mohamed
// PURPOSE: In charge of the code for the Question superclass that other classes inherit from.
// ===============================
package com.surveytest;
import com.surveytest.abstractedInputOutput.In;
import java.util.ArrayList;
import java.io.*;

public abstract class Question implements Serializable { //The abstract class that deals with the universal behavior of all Question subclasses.
    protected String questionPrompt;
    protected Response userAnswer = new Response();
    private static final long serialVersionUID = 1L;

    public Question() {
        System.out.println("What is the prompt?"); //Asks for the prompt of all Question subclasses.
        String quespromptinput = In.getInstance().readStr();
        this.questionPrompt = quespromptinput;
    }

    public ArrayList<String> getUserAnswer() {
        return this.userAnswer.getResponses();
    }

    public Response getUserAnswerObj() {return this.userAnswer;}

    public String getQuestionPrompt() {
        return this.questionPrompt;
    }

    public void setQuestionPrompt(String newQuestionPrompt) {
        this.questionPrompt = newQuestionPrompt;
    }

    //Will be implemented by Question subclasses.
    public abstract void setUserAnswer();

    public abstract void modify();

    public abstract void display();

    public abstract void create();

    public abstract Response setCorrectAnswer();
}

