package com.lpreda.boxing.starter;

import com.lpreda.boxing.exception.ApplicationException;
import com.lpreda.boxing.helpers.CLReaderUtil;
import com.lpreda.boxing.lists.FruitList;

/**
 * In Command Like, as for the Fruit taken from Box
 *
 * @author lrpre
 */
public class AskForTheFruit {

    public String getFruit(final String labelOpt) throws ApplicationException {
        System.out.println("You only can choose a box and get one fruit, what fruit did you get ?");
        String labelChoosen = FruitList.labelList.get(labelOpt);
        //Lambda For Each
        FruitList.fruitList.forEach((k, x) -> {
            if (!x.equals(labelChoosen)) {
                System.out.println(k + ")" + x + " ?");
            }
        });
        String fruitOpt = null;
        while (fruitOpt == null) {
            fruitOpt = CLReaderUtil.readConsole();
            if (!FruitList.fruitList.containsKey(fruitOpt)) {
                fruitOpt = null;
                System.out.println("Invalid Option : Get a new option ");
            }
        }
        return fruitOpt;

    }
}
