package com.lpreda.boxing.lists;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Fruit List
 * 
 * @author lrpre
 */
public class FruitList {

    public static final HashMap<String, String> fruitList = new HashMap<String, String>();
    public static final HashMap<String, String> labelList = new HashMap<String, String>();
    public static final Map<String, String> solverList = new HashMap<String, String>();
    
    static {
        //Fruit List
        fruitList.put("1", "Orange");
        fruitList.put("2", "Apple");
        
        //Label List
        labelList.put("1", "Orange");
        labelList.put("2", "Apple");
        labelList.put("3", "Apple & Orange");
        
        //Mapped Label to Fruit
        solverList.put("Orange", "1");
        solverList.put("Apple" , "2");
        solverList.put("Apple & Orange", "3");
    }
    
}
