package com.codeintelx.bank.services;

import com.codeintelx.bank.models.Account;

import java.util.*;

public class AccountServices {
//    UUID uuid = UUID.randomUUID();
//    String numericUUID = Long.toString(uuid.getMostSignificantBits())
//            + Long.toString(uuid.getLeastSignificantBits());
//    String ID = numericUUID.substring(0,10).replace("-", "10");
//    //System.out.print(StringID);




    //private Random rand = new Random();

   // private List<Account> accounts = new ArrayList<>();
    private Map<String, Account> userAccounts = new HashMap<>();


    public AccountServices() {

    }

    //Adds customer to account array list.
    public Account createAccount(String name, String type, long balance)
    {
        System.out.println("Create Account Class");
        Account newAccount = new Account(name, type, balance);
        UUID uuid = UUID.randomUUID();
       // String numericUUID = Long.toString(uuid.getMostSignificantBits()) + Long.toString(uuid.getLeastSignificantBits());
        String accountNumber = (Long.toString(UUID.randomUUID().getMostSignificantBits()).substring(1,11).replace("-", ""));
        userAccounts.put(accountNumber, newAccount);

        //Displays Customer name, Account Number, and Balance
        System.out.println("Customer: " + userAccounts.get(accountNumber).getCustomerName());
        System.out.println("Your new account number is " + accountNumber);
        System.out.println("Your balance is: " + balance);

        return newAccount;
    }


            //Search Map for key and returns the accountNumber

    public Account searchAccount(String accountNumber)
    {
        System.out.println("Search Account method");

        for (Map.Entry<String,Account> entry : userAccounts.entrySet())
        {

            if (userAccounts.containsKey(accountNumber) == true)
            {
                return userAccounts.get(accountNumber);
            }
        }
        return null;
    }


    //View Account input from the user

    public Account viewAccount(String accountNumberFromUser)
    {

        System.out.println("we in the view account class");

        Account newAccount;
        newAccount = searchAccount(accountNumberFromUser);

        if (newAccount != null)
        {
            System.out.println(newAccount.getCustomerName());
            System.out.println(newAccount.getBalance());
        }

        return newAccount;



    }

            //Removes element from Map
    public Account removeAccount(String accountNumberFromUser)
    {
    Account newAccount;
    newAccount = searchAccount(accountNumberFromUser);


    if(newAccount!= null)
    {
        System.out.println("Account will be removed: " + userAccounts.remove(accountNumberFromUser).getCustomerName());

    }
    return null;

    }



//        for (int i = 0; i < userAccounts.size(); i++) {
//
//            if (userAccounts.containsKey(accountNumberFromUser) == true)
//            {
//
//
//                return userAccounts.get(accountNumberFromUser);
//                //return userAccounts.get(accountNumberFromUser);


//                result = accounts.get(i);
//                accountIndex = i;
//                System.out.println("Customer Name: " + userAccounts.getCustomerName());
//                System.out.println("Type of Account: " + accounts.get(accountIndex).getTypeOfAccount());
//                System.out.println("Account Number: " + accounts.get(accountIndex).getAccountNumber());
//                System.out.println("Balance: " + accounts.get(accountIndex).getBalance());
        // System.out.println(account);
        //return (true);

        //System.out.println("we in the view account class");
        // break;
//            }

        //return null;


//
//
        public long depositFunds(String accountNumberFromUser, long deposit)
        {
            Account newAccount;
            newAccount = searchAccount(accountNumberFromUser);
//
                if (newAccount!= null)
                {
                    //int accountIndex = i;
                    System.out.println("Name: " + newAccount.getCustomerName());
                    //Adds deposit to balance
                    deposit += newAccount.getBalance() ;
                    //Sets new balance (deposit) in the index
                    userAccounts.get(accountNumberFromUser).setBalance(deposit);
                    //Sets new deposit amount

                    System.out.println( "Balance " + deposit);


                 }
                return 0;
        }

//
//        //Withdraw from amount
//
        public long withdrawFunds ( String accountNumberFromUser, long withdraw)
        {
            //Finds person via account number

            Account newAccount;
            newAccount = searchAccount(accountNumberFromUser);
//
                if (newAccount!= null)
                {
                    //int accountIndex = i;
                    System.out.println("Name: " + newAccount.getCustomerName());
                    // Sets new Balance in newBalance
                   long newBalance = (newAccount.getBalance() - withdraw);
                   //Sets new balance in the array list
                   if(newBalance>0)
                   {
                       System.out.println("Balance " + newBalance);
                      userAccounts.get(accountNumberFromUser).setBalance(newBalance);
                   }
                   else
                   {
                       System.out.println("Insufficient Funds");
                   }



                }

            return 0;
        }
}












