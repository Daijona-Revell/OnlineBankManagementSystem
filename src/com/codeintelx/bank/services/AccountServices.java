package com.codeintelx.bank.services;

import com.codeintelx.bank.exceptions.AccountNotFoundException;
import com.codeintelx.bank.exceptions.InsufficientFundsException;
import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.repository.AccountsRepository;

import javax.swing.text.View;
import java.sql.SQLException;
import java.util.*;


public class AccountServices
{
    //Account newUserAccount;
    AccountsRepository accountsRepository = new AccountsRepository();

   // private Map<String, Account> userAccounts = new HashMap<>();

    public AccountServices()
    {

    }

//Adds customer to Map and returns the account information.
    public Account createAccount(String name, String type, long balance)
    {
        UUID uuid = UUID.randomUUID();
        String accountNumber = (Long.toString(uuid.randomUUID().getMostSignificantBits())
                .substring(1, 11).replace("-", ""));
        Account newUserAccount = new Account(accountNumber, name, type, balance);

        //userAccounts.put(accountNumber, newUserAccount);
        try {
            accountsRepository.createAccount(accountNumber, name, type, balance);
        } catch (SQLException errorMessage) {
            errorMessage.getMessage();
        }
        return newUserAccount;
    }


//Search Map for key and returns the accountNumber (key)

    public Account searchAccount(String accountNumber) throws AccountNotFoundException, SQLException {

        //System.out.println(newUserAccount.getCustomerName());
       return accountsRepository.searchUserAccount(accountNumber);



    }

//View Account input from the user

//    public Account viewUserAccount(String accountNumberFromUser) throws AccountNotFoundException, SQLException {
//        return searchAccount(accountNumberFromUser);
//    }


//Removes element from Map based on the key (account number) provided by the user
    public void removeUserAccount(String accountNumberFromUser) throws AccountNotFoundException, SQLException {
        accountsRepository.removeUserAccount(accountNumberFromUser);
        //userAccounts.remove(accountNumberFromUser);
    }

//Deposits Funds

    public Account depositFunds(String accountNumberFromUser, long deposit)
            throws AccountNotFoundException, InsufficientFundsException, SQLException {
        Account newUserAccount = searchAccount(accountNumberFromUser);

        if (deposit < 0)
        {
            throw new InsufficientFundsException("You cannot enter a negative value");
        }

//Adds deposit amount and updates balance
        //if (newUserAccount != null)
        else if(deposit>0)
        {
            //System.out.println("Deposit");

                deposit = deposit + newUserAccount.getBalance();
                newUserAccount.setBalance(deposit);
               return accountsRepository.depositFunds(accountNumberFromUser, deposit);
            //System.out.println(newUserAccount.getBalance());
                //return newUserAccount;

        }

        return newUserAccount;
    }


// Withdraw funds

    public Account withdrawFunds(String accountNumberFromUser, long withdraw)
            throws InsufficientFundsException, AccountNotFoundException, SQLException {
//Finds person via account number

        Account newUserAccount = searchAccount(accountNumberFromUser);
//
        if (withdraw < 0)
        {
            throw new InsufficientFundsException("You cannot enter a negative number, please try again.");
        }
        else if (newUserAccount != null)
        {
//Sets new Balance in newBalance
            long newBalance = (newUserAccount.getBalance() - withdraw);
//Sets new balance in the Map
            if (newBalance >= 0)
            {
                newUserAccount.setBalance(newBalance);
                return accountsRepository.withdrawFunds(accountNumberFromUser, newBalance);
            }
            else if ((newBalance < 0))
            {
                throw new InsufficientFundsException("Insufficient Funds, You have " +
                        newUserAccount.getBalance() + " in your account.");
            }

        }
//
        return newUserAccount;
    }

//View all keys and information associated in the Map.

    public void viewAllAccountsInDatabase() throws SQLException
    {
      accountsRepository.searchAccounts();
    }



//    public void accounts() throws SQLException {
//        accountsRepository.searchAccounts(accountNumber);
//    }


}












