/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myBank.data;
import com.myBank.domain.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author koval
 */
public class DataSource {

    private File dataFile;

    public DataSource(String dataFilePath) {
        dataFile = new File(dataFilePath);
    }

    public void loadData() throws IOException {
        Scanner input = new Scanner(dataFile);
        Bank bank = Bank.getBank();

        Customer customer;

        int numOfCustomers = input.nextInt();
        for (int i = 0; i < numOfCustomers; i++) {
            String firstName = input.next();
            String lastName = input.next();
            bank.addCustomer(new Customer(firstName, lastName));
            customer = bank.getCustomer(i);

            int numOfAccounts = input.nextInt();
            while (numOfAccounts-- > 0) {
                char accountType = input.next().charAt(0);
                switch (accountType) {
                    case 'S': {
                        float initBalance = input.nextFloat();
                        float interestRate = input.nextFloat();
                        customer.addAccount(new SavingsAccount(initBalance, interestRate));
                        break;
                    }
                    case 'C': {
                        float initBalance = input.nextFloat();
                        float overdraftAmount = input.nextFloat();
                        customer.addAccount(new CheckingAccount(initBalance, overdraftAmount));
                        break;

                    }
                }
            }
        }
    }

}