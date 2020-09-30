package com.codeintelx.bank.repository;

import com.codeintelx.bank.exceptions.AccountNotFoundException;
import com.codeintelx.bank.exceptions.InsufficientFundsException;
import com.codeintelx.bank.models.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsRepository {


    List<Account> userAccounts = new ArrayList<>();
    Account accounts = new Account();

    private void connectionAccounts(String sql) throws SQLException
    {
        // try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBankManagementSystem" +
                "?serverTimezone=UTC", "root", "Codeintelx");
        Statement statement = conn.createStatement();
        statement.execute(sql);
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next())
        {
            accounts.setAccountNumber(rs.getString(1));
            accounts.setCustomerName(rs.getString(2));
            accounts.setTypeOfAccount(rs.getString(3));
            accounts.setBalance(rs.getLong(4));
//
            userAccounts.add(accounts);
        }


    }


    public Account createAccount(String accountNumber, String customerName, String typeOfAccount, long balance)
            throws SQLException
    {

        String sql = ("Insert Into Accounts Values('" + accountNumber + "','" + customerName + "','"
                + typeOfAccount + "','" + balance + "')");
        connectionAccounts(sql);
        System.out.println("Entered into database");

        return accounts;

    }

    //
    public Account searchUserAccount(String accountNumberFromUser) throws SQLException {


        String sql = ("Select * from Accounts Where accountNumber = '" + accountNumberFromUser + "'");
        connectionAccounts(sql);

        return accounts;

    }

    public Account depositFunds(String accountNumberFromUser, long deposit)
            throws SQLException
    {

            String sql = ("Update Accounts set balance = '" + deposit + "' where accountNumber = '"
                    + accountNumberFromUser + "'");
            connectionAccounts(sql);
        return accounts;
        }

        //
//
//// Withdraw funds
//
    public Account withdrawFunds(String accountNumberFromUser, long withdrawNewBalance)
            throws SQLException
    {

        String sql = ("Update Accounts set balance = '" + withdrawNewBalance + "' where accountNumber = '"
                + accountNumberFromUser + "'");
        connectionAccounts(sql);

        return accounts;
    }

//
        public void removeUserAccount (String accountNumberFromUser) throws SQLException
        {

            String sql = ("Delete from Accounts where accountNumber = '" + accountNumberFromUser + "'");
            connectionAccounts(sql);

        }



        public void searchAccounts() throws SQLException
        {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBankManagementSystem" +
                    "?serverTimezone=UTC", "root", "Codeintelx");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * from Accounts");

            while (rs.next()) {
                //return ;
                //Account newAccounts = new Account
                System.out.println((rs.getString(1) + " " +
                        rs.getString(2) + " " + rs.getString(3) + " " +
                        rs.getLong(4)));
                // userAccounts.add(newAccounts);
            }
           // return accounts;
        }
    }



