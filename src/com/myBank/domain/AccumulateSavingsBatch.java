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
import com.myBank.domain.*;

public class AccumulateSavingsBatch {

  public AccumulateSavingsBatch() {
  }

  public void doBatch() {

      Bank bank= Bank.getBank();
    // For each customer...
    for ( int cust_idx = 0;
          cust_idx < bank.getNumOfClients();
          cust_idx++ ) {
      Customer customer = bank.getCustomer(cust_idx);

      // For each account for this customer...
      for ( int acct_idx = 0;
            acct_idx < customer.getNumOfAccounts();
            acct_idx++ ) {
        Account account = customer.getAccount(acct_idx);
        String  account_type = "";

        // Determine the account type
        if ( account instanceof SavingsAccount ) {
          SavingsAccount savings = (SavingsAccount) account;
	  savings.addInterestRate();
        } else {
          // ignore all other account types
        }
      }
    }
  }
}
