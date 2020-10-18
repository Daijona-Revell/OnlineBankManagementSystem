package com.codeintelx.bank.services;

import com.codeintelx.bank.exceptions.AccountNotFoundException;
import com.codeintelx.bank.exceptions.InsufficientFundsException;
import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.repository.AccountsRepository;

import java.sql.SQLException;
import java.util.*;


public class AccountServices
{

    AccountsRepository accountsRepository = new AccountsRepository();

    public AccountServices()
    {

    }

//Adds customer to Database and returns the account information.
    public Account createAccount(String name, String type, double balance)
    {
        UUID uuid = UUID.randomUUID();
        String accountNumber = (Long.toString(uuid.randomUUID().getMostSignificantBits())
                .substring(1, 11).replace("-", ""));
        Account newUserAccount = new Account(accountNumber, name, type, balance);

        try {
            accountsRepository.createAccount(accountNumber, name, type, balance);
        } catch (SQLException errorMessage) {
            errorMessage.getMessage();
        }
        return newUserAccount;
    }


//Search Database for key and returns the accountNumber

    public Account searchAccount(String accountNumber) throws AccountNotFoundException, SQLException {
        Account newUserAccount = accountsRepository.searchUserAccount(accountNumber);

        if(newUserAccount.getAccountNumber()== null)
        {
            throw new AccountNotFoundException("Account not found. Try again");
        }

       return newUserAccount;

    }


//Removes element from Database based on the key (account number) provided by the user
    public Account removeUserAccount(String accountNumberFromUser) throws AccountNotFoundException, SQLException {
        Account newUserAccount = searchAccount(accountNumberFromUser);
        accountsRepository.removeUserAccount(accountNumberFromUser);
        return newUserAccount;
    }

//Deposits Funds

    public Account depositFunds(String accountNumberFromUser, double deposit)
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
                deposit = deposit + newUserAccount.getBalance();
                newUserAccount.setBalance(deposit);
                accountsRepository.depositFunds(accountNumberFromUser, deposit);

        }

        return newUserAccount;
    }


// Withdraw funds

    public Account withdrawFunds(String accountNumberFromUser, double withdraw)
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
            double newBalance = (newUserAccount.getBalance() - withdraw);
//Sets new balance in the Map
            if (newBalance >= 0)
            {
                newUserAccount.setBalance(newBalance);
                accountsRepository.withdrawFunds(accountNumberFromUser, newBalance);
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

    public List<Account> viewAllAccountsInDatabase() throws SQLException
    {
       return accountsRepository.searchAccounts();
    }



}












