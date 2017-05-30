package com.lpreda.boxing.helpers;

import com.lpreda.boxing.exception.ApplicationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Command Line reader
 *
 */ 
public class CLReaderUtil {
 
    private static final BufferedReader bfReader;
    static {
        bfReader = new BufferedReader(new InputStreamReader(System.in));
    }
    
    /**
     * Read input from console
     * 
     * @return String
     * @throws ApplicationException
     */
    public static String readConsole() throws ApplicationException {
        try {
            return bfReader.readLine();
        } catch (IOException ioE) {
            throw new ApplicationException("Could not open console : " + ioE.getMessage());
        }
    }

}
