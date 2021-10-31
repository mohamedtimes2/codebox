package com.surveytest;

import com.surveytest.utils.Input;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        boolean loop = true;
        while (loop == true) {
            System.out.println("Main Menu");
            System.out.println("---------------------------------------");
            System.out.println("1) Survey");
            System.out.println("2) Test");
            System.out.println("3) Exit");
            System.out.println("Please select a choice:");
            int menuinput = Input.readIntInRange(1, 3);
            if (menuinput == 1) {
                Survey.surveyMenu();
            } else if (menuinput == 2) {
                Test.testMenu();
            } else if (menuinput == 3) {
                loop = false;
            }
        }
    }
}
