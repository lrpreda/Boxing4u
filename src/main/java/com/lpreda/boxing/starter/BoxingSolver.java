package com.lpreda.boxing.starter;

import com.lpreda.boxing.exception.ApplicationException;
import com.lpreda.boxing.lists.FruitList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class for Boxing Solver
 * It will receive prompt in the commandLine for the user
 * choose a box and select what was taken from this box
 *  
 * @author lrpre
 */
public class BoxingSolver {
    
    /**
     * Main Method
     * 
     * @param args 
     */
    public static void main(String args[]) {
        BoxingSolver bSolver = new BoxingSolver();
        bSolver.StartToSolve();
    }

    /**
     * Start the commandLine instruction for get the parameters
     *
     */
    public void StartToSolve() {
        try {
            //Instruction
            System.out.println("There are three boxes, one contains only apples, one contains only oranges, and one contains both apples and oranges");
            System.out.println("All the boxes are labeled incorrectly !!");

            final String labelOpt = new AskForTheLabel().getLabelInput();
            final String fruitOpt = new AskForTheFruit().getFruit(labelOpt);

            HashMap correctLabel = correctAnswer(fruitOpt, labelOpt);

            System.out.println("Lets correct the labels >> ");
            System.out.println("For Box 1 put the label : " + correctLabel.get("1"));
            System.out.println("For Box 2 put the label : " + correctLabel.get("2"));
            System.out.println("For Box 3 put the label : " + correctLabel.get("3"));

        } catch (ApplicationException ex) {
            Logger.getLogger(BoxingSolver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method used to solve the box problem
     *
     * @param fruitOpt
     * @param labelOpt
     * @return HashMap
     * @throws ApplicationException
     *
     */
    public HashMap<String, String> correctAnswer(final String fruitOpt, final String labelOpt) throws ApplicationException  {
        if (!FruitList.labelList.containsKey(labelOpt) || !FruitList.fruitList.containsKey(fruitOpt))
            throw new ApplicationException("Invalid Parameters");
        
        HashMap<String, String> correctLabel = new HashMap<>();

        //get label for the fruit
        correctLabel.put(labelOpt, FruitList.fruitList.get(fruitOpt));
        //Save the oldValue to be moved 
        final String oldValueForThatOption = FruitList.labelList.get(labelOpt);
        switch (labelOpt) {
            case "1":
                correctLabel.put("2", FruitList.labelList.get("3"));
                correctLabel.put("3", oldValueForThatOption);
                break;
            case "2":
                correctLabel.put("1", FruitList.labelList.get("3"));
                correctLabel.put("3", oldValueForThatOption);
                break;
            case "3":
                //Check what fruit was taken from the box
                //If 2 replace 1 with the replaced value
                if ("2".equals(FruitList.solverList.get(FruitList.fruitList.get(fruitOpt)))) {
                    correctLabel.put("1", oldValueForThatOption);
                    correctLabel.put("2", FruitList.labelList.get("1"));
                } else {
                    correctLabel.put("1", FruitList.labelList.get("2"));
                    correctLabel.put("2", oldValueForThatOption);
                }
                break;
        }
        return correctLabel;
    }
}
