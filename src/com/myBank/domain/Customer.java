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
import java.util.ArrayList;

public class Customer {

    private ArrayList<Account> accounts;

    private String firstName;
    private String lastName;

    public int getNumOfAccounts() {
        return numOfAccounts;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private int customerNumber;

    private static int customerNumberBase = 1000;

    private int numOfAccounts;

    public Customer(String firstName, String lastName) {
        accounts = new ArrayList<>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerNumber = customerNumberBase++;
        this.numOfAccounts = 0;
    }

    public Account getAccount(int accNo) {
        if (accNo < accounts.size() && numOfAccounts != 0) {
            return accounts.get(accNo);
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "Customer :" + "fullName=" + lastName + ", "+firstName+", customerNumber=" + customerNumber + ", numOfAccounts=" + numOfAccounts;
        for (int i = 0; i < this.numOfAccounts; i++) {
            if (getAccount(i) instanceof SavingsAccount) {
                s = s + "\n Savings Account with interest rate " + ((SavingsAccount) getAccount(i)).getInterestRate() + "%";
            } else {
                s = s + "\n Checking Account with overdraft $" + ((CheckingAccount) getAccount(i)).getOverdraftAmount();
            }
            s = s + ", balance $" + getAccount(i).getBalance();
        }

        return s;

    }

    public void addAccount(Account acc) {
        accounts.add(acc);
        numOfAccounts++;
    }

}