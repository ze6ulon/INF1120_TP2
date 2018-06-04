/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf1120_tp2;

import java.util.ArrayList;

/**
 *
 * @author MoZZyPeace - V1
 */
class piFeBaResult {

    private int number;   
    private String pattern;
    private String compareResult;

    public piFeBaResult() {
        this.number = 1;
        this.pattern = "";
        this.compareResult = "";
    }
   
    public piFeBaResult(int number, String pattern, String compareResult) {
        this.number = number;
        this.pattern = pattern;
        this.compareResult = compareResult;
    }

    public int getNumber() {
        return number;
    }

    public String getPattern() {
        return pattern;
    }

    public String getCompareResult() {
        return compareResult;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setCompareResult(String compareResult) {
        this.compareResult = compareResult;
    }

    public void afficherResult(){
        System.out.format("%9d. |%10s |%10s%n", number, pattern, compareResult);
    }
    
    @Override
    public String toString() {
        return "piFeBaResult{" + "number=" + number + ", pattern=" + pattern + ", compareResult=" + compareResult + '}';
    }

    
    
    

}
