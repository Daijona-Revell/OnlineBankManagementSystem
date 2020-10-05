package com.codeintelx.bank.repository;

import com.codeintelx.bank.exceptions.AccountNotFoundException;
import com.codeintelx.bank.exceptions.InsufficientFundsException;
import com.codeintelx.bank.models.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsRepository {


    public void createAccount(String accountNumber, String customerName, String typeOfAccount, long balance)
            throws SQLException {
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();

        statement.execute("Insert Into Accounts Values('" + accountNumber + "','" + customerName + "','"
                + typeOfAccount + "','" + balance + "')");

    }


    public Account searchUserAccount(String accountNumberFromUser) throws SQLException, AccountNotFoundException {
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
        Account accounts = new Account();

        ResultSet rs = statement.executeQuery("Select * from Accounts Where accountNumber = '" + accountNumberFromUser + "'");
            while (rs.next()) {
                accounts.setAccountNumber(rs.getString(1));
                accounts.setCustomerName(rs.getString(2));
                accounts.setTypeOfAccount(rs.getString(3));
                accounts.setBalance(rs.getLong(4));
            }

        return accounts;

    }
//// Deposit funds from User in Database

    public void depositFunds(String accountNumberFromUser, long deposit)
            throws SQLException {
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();

        statement.execute("Update Accounts set balance = '" + deposit + "' where accountNumber = '"
                + accountNumberFromUser + "'");

    }


//// Withdraw funds from User in Database

    public void withdrawFunds(String accountNumberFromUser, long withdrawNewBalance)
            throws SQLException {
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();

       statement.execute("Update Accounts set balance = '" + withdrawNewBalance + "' where accountNumber = '"
                + accountNumberFromUser + "'");
    }

    // Remove User from Database
    public void removeUserAccount(String accountNumberFromUser) throws SQLException {
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();

        statement.execute(("Delete from Accounts where accountNumber = '" + accountNumberFromUser + "'"));

    }

//Return List to AccountServices that returns that information to main to print all information from the Database
    public List<Account> searchAccounts() throws SQLException {
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();

        List<Account> userAccounts = new ArrayList<>();
        ResultSet rs = statement.executeQuery("Select * from Accounts");
        while (rs.next()) {
            Account accounts = new Account();
            accounts.setAccountNumber(rs.getString(1));
            accounts.setCustomerName(rs.getString(2));
            accounts.setTypeOfAccount(rs.getString(3));
            accounts.setBalance(rs.getLong(4));
            userAccounts.add(accounts);
        }
        return userAccounts;

    }
}



