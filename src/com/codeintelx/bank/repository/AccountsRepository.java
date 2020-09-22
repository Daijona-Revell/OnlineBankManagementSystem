package com.codeintelx.bank.repository;

import com.codeintelx.bank.models.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class AccountsRepository
{
    public Account createAccount(String customerName, String typeOfAccount, long balance)
    {
        UUID uuid = UUID.randomUUID();
        String accountNumber = (Long.toString(uuid.randomUUID().getMostSignificantBits())
                .substring(1, 11).replace("-", ""));
        Account newUserAccount = new Account(accountNumber, customerName, typeOfAccount, balance);
        System.out.println(newUserAccount.getAccountNumber());
        try {
            //Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBankManagementSystem" +
                            "?serverTimezone=UTC", "root", "Codeintelx");
            Statement statement = conn.createStatement();
            String sql = ("Insert Into Accounts Values('"+accountNumber+"','"+customerName+"','"
                    +typeOfAccount+"','"+balance+"')");
//            String sql = ("Insert Into Accounts( accountNumber,customerName,typeOfAccount,balance)" +
//                    "Values ('"+newUserAccount.getAccountNumber()+"','"+newUserAccount.getCustomerName()+"'," +
//                    "'" + newUserAccount.getTypeOfAccount() + "', '"+ newUserAccount.getBalance()+"')");
            statement.execute(sql);
            System.out.println("Customer added to database");
        } catch (SQLException errorMessage)
        {
            System.out.println("Try again" + errorMessage.getMessage());
        }
        return newUserAccount;

    }
}


