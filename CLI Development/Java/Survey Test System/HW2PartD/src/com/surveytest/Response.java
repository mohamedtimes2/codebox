// ===============================
// AUTHOR: Mohamed Mohamed
// PURPOSE: In charge of the code for the responses object aggregates from all Question subclasses.
// ===============================
package com.surveytest;
import java.util.ArrayList;
import java.io.*;
import java.util.Collection;
import java.util.Collections;

public class Response implements Serializable {

    public Response() {
    }

    ArrayList<String> responses = new ArrayList<String>(); //Contains the answers for all Question subclasses.
    private static final long serialVersionUID = 1L;


    public ArrayList getResponses() {
        Collections.sort(this.responses); //To sort responses that might be given in a different order.
        return this.responses;
    }

    public void setResponses(String input) {
        this.responses.add(input);
        Collections.sort(this.responses);
    } //Appends the argument to the class variable, responses.

    //Sets the rules for grading for test functionality.
    public static boolean compare (Response r1, Response r2) {
        //Both "copy" arrayList are created to retain the integrity of the original values.
        ArrayList<String> r1copy = new ArrayList<String>();
        ArrayList<String> r2copy = new ArrayList<String>();
        //Appends the data of the original Response objects to the empty ArrayLists.
        for (String response: r1.responses){
            r1copy.add(response);
        }
        for (String response: r2.responses){
            r2copy.add(response);
        }
        //To keep them standardize and allow for lenient grading for SAs. Sorts is required as arrays with different orders are not considered equal.
        r1copy.replaceAll(String::toLowerCase); //https://howtodoinjava.com/java/collections/arraylist/arraylist-replaceall-example/
        r2copy.replaceAll(String::toLowerCase);
        Collections.sort(r1copy);
        Collections.sort(r2copy);
        if (r1copy.equals(r2copy)) {
            return true;
        }
        return false;
    }

}
