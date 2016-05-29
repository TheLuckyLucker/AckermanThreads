/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ackermanthreads;

/**
 *
 * @author Conny
 */
public class AckermanNumbers {
    private int ackerman;
    
    public AckermanNumbers(int m, int n){
        this.ackerman = calculate(m,n);
    }
    
    private int calculate(int m, int n){
        if(m == 0){
            return n + 1;
        }
        else if(m > 0 && n == 0){
            return calculate(m-1, 1);
        }
        else if(m > 0 && n > 0){
            return calculate(m-1, calculate(m, n-1));
        }
        return 0;
    }
    
    public int getAckerman(){
        return this.ackerman;
    }
}