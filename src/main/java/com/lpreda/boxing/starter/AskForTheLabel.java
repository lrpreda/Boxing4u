package com.lpreda.boxing.starter;

import com.lpreda.boxing.exception.ApplicationException;
import com.lpreda.boxing.helpers.CLReaderUtil;
import com.lpreda.boxing.lists.FruitList;

/**
 * From command line ask for the label
 *
 * @author lrpre
 */
public class AskForTheLabel {

    public String getLabelInput() throws ApplicationException {
        System.out.println("What box is your choice ? ");

        FruitList.labelList.forEach((k, x)
                -> System.out.println("Box " + k + " labeled >> " + x + " ?")
        );

        String labelOpt = null;
        while (labelOpt == null) {
            labelOpt = CLReaderUtil.readConsole();
            if (!FruitList.labelList.containsKey(labelOpt)) {
                labelOpt = null;
                System.out.println("Invalid option : Get a new one ");
            }
        }
        return labelOpt;
    }
}
