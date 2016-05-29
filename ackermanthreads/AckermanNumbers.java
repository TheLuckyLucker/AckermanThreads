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
public class AckermanNumbers{
    private int ackerman;
    private int m,n;
    private boolean canceled;
    
    public AckermanNumbers(int m, int n){
        this.m = m;
        this.n = n;
        canceled = false;
    }
    
    public int calculate(int m, int n){
        if(m == 0){
            this.ackerman = n + 1;
            return n + 1;
        }
        else if(m > 0 && n == 0){
            return calculate(m-1, 1);
        }
        else if(m > 0 && n > 0){
            return calculate(m-1, calculate(m, n-1));
        }
        this.ackerman = 0 ;
        return 0;
    }
    
    public int getAckerman(){
        return this.ackerman;
    }
    
    public int getN(){
        return this.n;
    }
    
    public int getM(){
        return this.m;
    }
    
    public void setCanceled(boolean value){
        this.canceled = value;
    }
    
    public boolean getCanceled(){
        return this.canceled;
    }
}
