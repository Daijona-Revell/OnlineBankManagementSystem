package com.codeintelx.bank.repository;

import com.codeintelx.bank.exceptions.AccountNotFoundException;
import com.codeintelx.bank.exceptions.InsufficientFundsException;
import com.codeintelx.bank.models.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsRepository {


//get rid of this expeditiously
//    private void connectionAccounts(String sql) throws SQLException {
//
//        //Connection conn = DatabaseConnection.getInstance().getConnection();
//        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
//        statement.execute(sql);
//        if (sql.contains("Select")) {
//
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                accounts.setAccountNumber(rs.getString(1));
//                accounts.setCustomerName(rs.getString(2));
//                accounts.setTypeOfAccount(rs.getString(3));
//                accounts.setBalance(rs.getLong(4));
//                userAccounts.add(accounts);
//
//                System.out.println((rs.getString(1) + " " +
//                        rs.getString(2) + " " + rs.getString(3) + " " +
//                    rs.getLong(4)));
//
//            }
//        }
//       // return accounts;
//
//    }


    public void createAccount(String accountNumber, String customerName, String typeOfAccount, long balance)
            throws SQLException {
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();

        statement.execute ("Insert Into Accounts Values('" + accountNumber + "','" + customerName + "','"
                + typeOfAccount + "','" + balance + "')");
        //connectionAccounts(sql);
        System.out.println("Entered into database");



        //return accounts;

    }


    public Account searchUserAccount(String accountNumberFromUser) throws SQLException, AccountNotFoundException {
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
        Account accounts = new Account();

        //statement.executeQuery(("Select * from Accounts Where accountNumber = '" + accountNumberFromUser + "'");
        List<Account> userAccounts = new ArrayList<>();
        ResultSet rs = statement.executeQuery("Select * from Accounts Where accountNumber = '" + accountNumberFromUser + "'");
            while (rs.next()) {
                accounts.setAccountNumber(rs.getString(1));
                accounts.setCustomerName(rs.getString(2));
                accounts.setTypeOfAccount(rs.getString(3));
                accounts.setBalance(rs.getLong(4));
                userAccounts.add(accounts);
            }

        return accounts;

    }

    public void depositFunds(String accountNumberFromUser, long deposit)
            throws SQLException {
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();

        statement.execute("Update Accounts set balance = '" + deposit + "' where accountNumber = '"
                + accountNumberFromUser + "'");
        //connectionAccounts(sql);
        //return accounts;
    }

    //
//
//// Withdraw funds
//
    public void withdrawFunds(String accountNumberFromUser, long withdrawNewBalance)
            throws SQLException {
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();

       statement.execute("Update Accounts set balance = '" + withdrawNewBalance + "' where accountNumber = '"
                + accountNumberFromUser + "'");
        //connectionAccounts(sql);

        //return accounts;
    }

    //
    public void removeUserAccount(String accountNumberFromUser) throws SQLException {
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();

        statement.execute(("Delete from Accounts where accountNumber = '" + accountNumberFromUser + "'"));
       // connectionAccounts(sql);

    }


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



