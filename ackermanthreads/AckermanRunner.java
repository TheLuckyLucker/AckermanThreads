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
public class AckermanRunner implements Runnable{

    private AckermanNumbers numbers;
    
    public AckermanRunner(AckermanNumbers A){
        this.numbers = A;
    }
    
    @Override
    public void run() {
        numbers.calculate(numbers.getM(), numbers.getN());
    }
    
}
