package com.lpreda.boxing.api;

import com.lpreda.boxing.exception.ApplicationException;
import com.lpreda.boxing.starter.BoxingSolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lrpre
 */
@RestController
public class BoxingAnswer {
    
    @RequestMapping(value="/rest/boxing/{labelOpt}/{fruitOpt}", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<Object> BoxingSolver(@PathVariable final String fruitOpt,@PathVariable final String labelOpt){
        BoxingSolver bxSolver = new BoxingSolver();
        Object ret;
        try {
            ret = bxSolver.correctAnswer(fruitOpt, labelOpt);
        } catch (ApplicationException ex) {
           return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
    
    @RequestMapping(value="/rest/boxing/", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<Object> Helper(){
        StringBuilder sel = new StringBuilder("For labelOpt : send 1 for label Orange, 2 for Apple or 3 for Apple & Orange ");
        sel.append("For fuitOpt : send 1 for Orange or 2 for Apple");
        
        return new ResponseEntity<>(sel, HttpStatus.OK);
    }
}
