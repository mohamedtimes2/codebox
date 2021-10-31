package com.surveytest.abstractedInputOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*; //My edit!
import java.util.Arrays; // My edit!
import java.util.regex.Pattern;

public class InputHelper {
    // If file is null, read from System.in
    public static String readStr(String file) {
        BufferedReader in = null;
        String line = "-1";
        try{
            if(file == null)
                in = new BufferedReader(new InputStreamReader(System.in)); //Mohamed's case: Reads the input
            else
                in = new BufferedReader(new FileReader(file));
            line = in.readLine();
            // Verify the input exists
            while(line == null || line.length() == 0 || line.trim().isEmpty()){
                Out.getInstance().say("Please enter a valid string.");
                line = in.readLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return line;
    }

    // If file is null, read from System.in
    public static int readInt(String file) {
        BufferedReader in = null;
        String line = "-1"; //Mohamed: What's this? Answer: just there so you don't instantiate!
        try{
            if(file == null)
                in = new BufferedReader(new InputStreamReader(System.in));
            else
                in = new BufferedReader(new FileReader(file));
            line = in.readLine();
            while(line == null || line.length() == 0 || !isInt(line)) { //Mohamed's case: We edit this for each version for out
                Out.getInstance().say("Please enter a valid number!");
                line = in.readLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return Integer.parseInt(line);
    }

    // If file is null, read from System.in
    public static double readDouble(String file) {
        BufferedReader in = null;
        String line = "-1";
        try{
            if(file == null)
                in = new BufferedReader(new InputStreamReader(System.in));
            else
                in = new BufferedReader(new FileReader(file));
            line = in.readLine();
            while(line == null || line.length() == 0 || !isDouble(line)) {
                Out.getInstance().say("Please enter a valid double!");
                line = in.readLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return Double.parseDouble(line);
    }


    public static String readFile(String file) {
        BufferedReader in = null;
        String line = "-1";
        File fileline = null;
        File directoryPath = new File(".");
        //List of all files and directories
        File filesList[] = directoryPath.listFiles();
        System.out.println(filesList[0]);
        System.out.println("List of files and directories in the specified directory:");
        for(File filesin : filesList) {
            System.out.println("File name: "+ filesin.getName());
        }
        try{
            if(file == null)
                in = new BufferedReader(new InputStreamReader(System.in)); //Mohamed's case: Reads the input
            else
                in = new BufferedReader(new FileReader(file));
            line = in.readLine();
            fileline = new File("." + File.separator + "test" + File.separator + line); //https://www.geeksforgeeks.org/file-exists-method-in-java-with-examples/
            // Verify the input exists
            while(line == null || line.length() == 0 || !fileline.exists()){
                Out.getInstance().say("Please enter valid input of at least 1 char"); //Why is this not working?
                System.out.println("Yo!");
                line = in.readLine();
                fileline = new File("." + File.separator + "test" + File.separator + line);
                Out.getInstance().say("Please enter valid input of at least 1 char");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return line;
    }

    //Mohamed's comments: An derivation of readStr that I implemented, which only takes in "Yes" and "No" as valid input otherwise it loops!
    public static String readOption(String file) {
        BufferedReader in = null;
        String line = "-1";
        try{
            if(file == null)
                in = new BufferedReader(new InputStreamReader(System.in)); //Mohamed's case: Reads the input
            else
                in = new BufferedReader(new FileReader(file));
            line = in.readLine();
            // Verify the input exists
            while((!line.equals("No") && (!line.equals("Yes")))) {
                Out.getInstance().say("Please enter \"Yes\" or \"No\".");
                line = in.readLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return line;
    }




    // Returns true if the input can be parsed to an int, else false
    private static boolean isInt(String num) {
        try {
            int p = Integer.parseInt(num);
            if (p > 0) { //Mohamed's comment: Added condition to check if num is less than 0
                return true;
            }
            return false;
        }
        catch(Exception e){
            return false;
        }
    }

    // Returns true if the input can be parsed to a double, else false
    private static boolean isDouble(String num) {
        try {
            Double.parseDouble(num);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
