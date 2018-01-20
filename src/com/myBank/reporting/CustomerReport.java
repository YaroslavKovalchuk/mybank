/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myBank.reporting;

/**
 *
 * @author koval
 */
import com.myBank.domain.*;
import java.text.DecimalFormat;

public class CustomerReport {

    public CustomerReport() {
    }

    public void generateReport() {

        // Print report header
        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");

        Bank bank = Bank.getBank();

        // For each customer...
        for (int cust_idx = 0;
                cust_idx < bank.getNumOfClients();
                cust_idx++) {
            Customer customer = bank.getCustomer(cust_idx);

            // Print the customer's name
            System.out.println();
            System.out.println("Customer: "
                    + customer.getLastName() + ", "
                    + customer.getFirstName());

            // For each account for this customer...
            for (int acct_idx = 0;
                    acct_idx < customer.getNumOfAccounts();
                    acct_idx++) {
                Account account = customer.getAccount(acct_idx);
                String account_type = "";
                String account_params = "";

                DecimalFormat rateFormat = new DecimalFormat("###%");
                DecimalFormat amountFormat = new DecimalFormat("$00.00");

                // Determine the account type
                if (account instanceof SavingsAccount) {
                    account_type = "Savings Account";
                    account_params =", interest rate is "+rateFormat.format(((SavingsAccount)account).getInterestRate());
                } else if (account instanceof CheckingAccount) {
                    account_type = "Checking Account";
                    account_params =", overdraft amount is "+amountFormat.format(((CheckingAccount)account).getOverdraftAmount());
                } else {
                    account_type = "Unknown Account Type";
                }

                // Print the current balance of the account
                System.out.println("    " + account_type + ": current balance is "
                        + amountFormat.format(account.getBalance())+account_params);
            }
        }
    }
}