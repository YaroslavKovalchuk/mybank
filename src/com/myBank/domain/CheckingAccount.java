/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myBank.domain;

/**
 *
 * @author koval
 */
public class CheckingAccount extends Account {

    private double overdraftAmount;

    public CheckingAccount(double initBalance, double overdraftAmount) {
        this.balance=initBalance;
        this.overdraftAmount=overdraftAmount;
    }

    public CheckingAccount(double initBalance) {
        this(initBalance, 0);
    }

    
    public boolean withdraw(double amt) throws OverdraftException{
        if(amt<=balance+overdraftAmount){
            balance=balance-amt;
            return true;
        }
        throw new OverdraftException(amt-balance-overdraftAmount, "Error! Insufficient funds");
    }

    public double getOverdraftAmount() {
        return overdraftAmount;
    }
    
    
}
