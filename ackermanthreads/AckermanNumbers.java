/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ackermanthreads;

import javafx.concurrent.Task;

/**
 *
 * @author Conny Blach, s4329872
 * @author Tiko Huizinga, s4460898
 */
public class AckermanNumbers {

    private int ackerman;
    private int m, n;
    private boolean canceled;       // This was used for task 2

    public AckermanNumbers(int m, int n) {
        this.m = m;
        this.n = n;
        canceled = false;
    }

    /**
     * Calculates the ackermannfunction for m and n
     * If the task.isCancelled(), the computation stops
     * @param m
     * @param n
     * @param t The task which is calculating the ackerman number
     * @return
     */
    public int calculate(int m, int n, Task<Integer> t) {
        if (t.isCancelled()) {
            System.out.println("canceled");
            this.ackerman = 0;
            return 0;
        } else if (m == 0) {
            this.ackerman = n + 1;
            return n + 1;
        } else if (m > 0 && n == 0) {
            return calculate(m - 1, 1, t);
        } else if (m > 0 && n > 0) {
            return calculate(m - 1, calculate(m, n - 1, t), t);
        }
        this.ackerman = 0;
        return 0;
    }

    /**
     * 
     * @return Ackerman number
     */
    public int getAckerman() {
        return this.ackerman;
    }

    /**
     * 
     * @return the input n
     */
    public int getN() {
        return this.n;
    }

    /**
     * 
     * @return the input m
     */
    public int getM() {
        return this.m;
    }

    /**
     * Set the canceled value to true. 
     * This was used for task 2
     * @param value 
     */
    public void setCanceled(boolean value) {
        this.canceled = value;
    }

    /**
     * This was used for task2
     * @return the boolean value of canceled
     */
    public boolean getCanceled() {
        return this.canceled;
    }
}
