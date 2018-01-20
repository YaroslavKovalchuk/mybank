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
public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(double initBalance, double interestRate) {
        this.balance =initBalance;
        this.interestRate=interestRate;
    }
    
    public void addInterestRate()
    {
        this.balance=this.balance*(1+interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }

}
