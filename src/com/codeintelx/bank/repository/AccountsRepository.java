package com.codeintelx.bank.repository;

import com.codeintelx.bank.exceptions.InsufficientFundsException;
import com.codeintelx.bank.models.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsRepository {


    List<Account> userAccounts = new ArrayList<>();
    //Account newUserAccount;


    // AccountServices accountServices = new AccountServices();

    // private static Connection con = null;
//
    //static

    // String url = "jdbc:mysql:// localhost:3306/org";
    // String user = "root";
    //String pass = "root";
//       {
//           try {
//               //Class.forName("com.mysql.jdbc.Driver");
//               Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBankManagementSystem" +
//                       "?serverTimezone=UTC", "root", "Codeintelx");
//               Statement statement = conn.createStatement();
//           } catch (SQLException errorMessage) {
//               errorMessage.getMessage();
//           }
//       }


//        try
//        {
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBankManagementSystem" +
//                    "?serverTimezone=UTC", "root", "Codeintelx");
//            Statement statement = conn.createStatement();
//        } catch (SQLException errorMessage)
//        {
//            System.out.println(errorMessage.getMessage());
//        }


    //public AccountServices


    public void connectionAccounts(String sql) throws SQLException
    {
        // try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBankManagementSystem" +
                "?serverTimezone=UTC", "root", "Codeintelx");
        Statement statement = conn.createStatement();
        statement.execute(sql);
//        ResultSet rs = statement.executeQuery(sql);
//
//        while (rs.next()) {
//            //Account newAccounts = new Account
//            System.out.println((rs.getString(1) +
//                    rs.getString(2) + rs.getString(3) +
//                    rs.getLong(4)));
//           // userAccounts.add(newAccounts);
//        }


                //ResultSet rs = statement.executeQuery(sql);
//        while (rs.next())
//        {
//            userAccounts.add(rs.getString("accountNumber"));
//            System.out.println(userAccounts.);
//        }


                //ResultSet rs = statement.executeQuery(sql);


//        while(rs.next())
//        {
//            String accountNumber = rs.getString("accountNumber");
//            String customerName = rs.getString("customerName");
//            String typeOfAccount = rs.getString("typeOfAccount");
//            long balance = rs.getLong("balance");
//            System.out.println(accountNumber + customerName + typeOfAccount + balance);
//        }

                // } catch (SQLException errorMessage)
                //{
                //  System.out.println(errorMessage.getMessage());
                //}
                //return newAccounts;




    }
       // return newAccounts;



    public void createAccount(String accountNumber, String customerName, String typeOfAccount, long balance)
            throws SQLException {

        //try {
        //Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBankManagementSystem" +
//                    "?serverTimezone=UTC", "root", "Codeintelx");
//            Statement statement = conn.createStatement();
        //Account sql;
        //Account newUserAccount = new Account (accountNumber, customerName, typeOfAccount, balance);

        String sql = ("Insert Into Accounts Values('" + accountNumber + "','" + customerName + "','"
                + typeOfAccount + "','" + balance + "')");
        connectionAccounts(sql);
        System.out.println("Entered into database");

//        while (rst.next()) {
//            Account newAccounts = new Account(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
//            customerList.add(customer);


        //userAccounts.add(newUserAccount);



        //System.out.println("Entered into database");
        // statement = conn.createStatement();

        //statement.execute(sql);
        // }
        // catch (SQLException errorMessage)
        //{
        // errorMessage.getMessage();
        //}

//        String sql = ("Insert Into Accounts Values('"+accountNumber+"','"+customerName+"','"
//                    +typeOfAccount+"','"+balance+"')");
//        Statement statement = conn.createStatement();
//
//        statement.execute(sql);


//        UUID uuid = UUID.randomUUID();
//        String accountNumber = (Long.toString(uuid.randomUUID().getMostSignificantBits())
//                .substring(1, 11).replace("-", ""));
//        // newUserAccount = new Account(accountNumber, customerName, typeOfAccount, balance);
//        try {
//            //Class.forName("com.mysql.jdbc.Driver");
//
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBankManagementSystem" +
//                            "?serverTimezone=UTC", "root", "Codeintelx");
//            Statement statement = conn.createStatement();
//            String sql = ("Insert Into Accounts Values('"+accountNumber+"','"+customerName+"','"
//                    +typeOfAccount+"','"+balance+"')");
////            String sql = ("Insert Into Accounts( accountNumber,customerName,typeOfAccount,balance)" +
////                    "Values ('"+newUserAccount.getAccountNumber()+"','"+newUserAccount.getCustomerName()+"'," +
////                    "'" + newUserAccount.getTypeOfAccount() + "', '"+ newUserAccount.getBalance()+"')");
//            statement.execute(sql);
//            //System.out.println("Customer added to database");
//        } catch (SQLException errorMessage)
//        {
//            System.out.println("Try again" + errorMessage.getMessage());
//        }
       // return newUserAccount;
    }

    //
    public String searchUserAccount(String accountNumberFromUser) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBankManagementSystem" +
                "?serverTimezone=UTC", "root", "Codeintelx");
        Statement statement = conn.createStatement();
        //statement.execute(sql);
        ResultSet rs = statement.executeQuery("Select * from Accounts Where accountNumber = '" + accountNumberFromUser + "'");
        //Account balance = rs.getString(4);
        while(rs.next())
        {
            if(rs.getString(1) == accountNumberFromUser)
            {
                //System.out.println(rs.);
                return rs.getString(4);
            }
        }

//        if(userAccounts.contains(accountNumberFromUser))
//        {
            //return userAccounts;
           // String sql = ("Select * from Accounts Where accountNumber = '" + accountNumberFromUser + "'");
            //userAccounts.add(sql);
           // connectionAccounts(sql);
//            if(!sql.isEmpty())
//            {
//                //Account searchAvailable = true;
//                return true;
//            }

            //return userAccounts;


//        }


           // return newAccounts;



        //        try
//        {
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBankManagementSystem" +
//                    "?serverTimezone=UTC", "root", "Codeintelx");
        // Statement statement = conn.createStatement();

//        String sql = ("Select * from Accounts Where accountNumber = '" + accountNumberFromUser + "'");
//        //userAccounts.add(sql);
//        connectionAccounts(sql);
        //if()


        //connectionAccounts(sql);
//            statement.execute(sql);
//
//        } catch (SQLException errorMessage)
//        {
//            System.out.println(errorMessage.getMessage());
//        }
//        return newUserAccount;
//    }
        // return
//

        //return searchUserAccount(accountNumberFromUser);
        //return accountNumberFromUser;
        //;

        //return (Account) sql;
        //return userAccounts.add();
       // return false;
        //return newAccounts;
        //return userAccounts;
        return "Account Not Found";

    }

    public void depositFunds(String accountNumberFromUser, long deposit)
            throws SQLException {
        //Account newUserAccount;
        //try {
        //Account newUserAccount = connectionAccounts();
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBankManagementSystem" +
//                    "?serverTimezone=UTC", "root", "Codeintelx");
//            Statement statement = conn.createStatement();

        //Account newUserAccount;
        //searchUserAccount(accountNumberFromUser);

//        if (deposit < 0) {
//            throw new InsufficientFundsException("You cannot enter a negative value");
//        } else if (deposit > 0) {
//            deposit = deposit + newUserAccount.getBalance();
//                newUserAccount.setBalance(deposit);
            String sql = ("Update Accounts set balance = '" + deposit + "' where accountNumber = '"
                    + accountNumberFromUser + "'");
            connectionAccounts(sql);
//                statement.executeUpdate(sql);
//                System.out.println("Deposit added");
//            }
//
//        } catch (SQLException errorMessage) {
//            System.out.println("Try again" + errorMessage.getMessage());
//        }
//
//
////Adds deposit amount and updates balance
////        if (newUserAccount != null)
////        {
////            Statement statement
//////            deposit += newUserAccount.getBalance();
//////            newUserAccount.setBalance(deposit);
////        }
//
//            return newUserAccount;
        }

        //
//
//// Withdraw funds
//
//    public Account withdrawFunds(String accountNumberFromUser, long withdraw)
//            throws InsufficientFundsException, AccountNotFoundException
//    {
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBankManagementSystem" +
//                    "?serverTimezone=UTC", "root", "Codeintelx");
//            Statement statement = conn.createStatement();
//
////Finds person via account number
//
////        Account newUserAccount;
////        newUserAccount = searchAccount(accountNumberFromUser);
//
//            if (withdraw < 0) {
//                throw new InsufficientFundsException("You cannot enter a negative number, please try again.");
//            } else if (withdraw > 0) {
////Sets new Balance in newBalance
//                long newBalance = (newUserAccount.getBalance() - withdraw);
////Sets new balance in the Map
//                if (newBalance >= 0) {
//                    newUserAccount.setBalance(newBalance);
//                    String sql = ("Update Accounts set balance = '" + newBalance + "' where accountNumber = '"
//                            + accountNumberFromUser + "'");
//                    statement.executeUpdate(sql);
//                } else if ((newBalance < 0)) {
//                    throw new InsufficientFundsException("Insufficient Funds, You have " +
//                            newUserAccount.getBalance() + " in your account.");
//                }
//
//            }
//        } catch (SQLException errorMessage)
//        {
//            System.out.println("Try again" + errorMessage.getMessage());
//        }
//
//        return newUserAccount;
//    }

//
        public void removeUserAccount (String accountNumberFromUser) throws SQLException {
//        try {
//
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBankManagementSystem" +
//                    "?serverTimezone=UTC", "root", "Codeintelx");
//            Statement statement = conn.createStatement();
            String sql = ("Delete from Accounts where accountNumber = '" + accountNumberFromUser + "'");
            connectionAccounts(sql);
//            statement.execute(sql);
//
//        } catch (SQLException errorMessage)
//        {
//            System.out.println(errorMessage.getMessage());
//        }
//
//    }
//
//    public Account viewAllAccounts()
//    {
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBankManagementSystem" +
//                    "?serverTimezone=UTC", "root", "Codeintelx");
//            Statement statement = conn.createStatement();
//            String sql = ("Select * from Accounts");
//            statement.execute(sql);
//
//        } catch (SQLException errorMessage)
//        {
//            System.out.println(errorMessage.getMessage());
//        }
//        return newUserAccount;
//    }


        }



        public void searchAccounts() throws SQLException
        {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBankManagementSystem" +
                    "?serverTimezone=UTC", "root", "Codeintelx");
            Statement statement = conn.createStatement();
            //statement.execute(sql);
            ResultSet rs = statement.executeQuery("Select * from Accounts");

            while (rs.next()) {
                //Account newAccounts = new Account
                System.out.println((rs.getString(1) + " " +
                        rs.getString(2) + " " + rs.getString(3) + " " +
                        rs.getLong(4)));
                // userAccounts.add(newAccounts);
            }
        }
    }



