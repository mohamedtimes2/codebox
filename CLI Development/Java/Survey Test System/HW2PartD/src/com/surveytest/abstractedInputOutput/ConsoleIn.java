package com.surveytest.abstractedInputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Please note this class is here as an example and the error checking is minimal.
 *
 * @author Sean Grimes, sean@seanpgrimes.com
 */
public class ConsoleIn extends In {
    // No public c'tor to fit the singleton requirements
    private ConsoleIn() {}
    // The instance that's returned in the getInstance() call
    private static ConsoleIn instance;

    // Return a ConsoleIn object in a threadsafe manner with lazy initialization
    public static ConsoleIn getInstance() { //M: Not sure what that means?
        if(instance == null){
            synchronized (ConsoleIn.class) {
                if(instance == null)
                    instance = new ConsoleIn();
            }
        }
        return instance;
    }

    // Read a string from the console
    public String readStr() { return InputHelper.readStr(null); } //Mohamed's case: Why is this null?

    // Read an int, keep asking for a valid one while it's invalid
    public int readInt() { return InputHelper.readInt(null); }

    // Read a valid double, keep asking while it's invalid
    public double readDouble() { return InputHelper.readDouble(null); }

    public String readFile() { return InputHelper.readFile(null);}

    public String readOption() { return InputHelper.readOption(null);}
}
