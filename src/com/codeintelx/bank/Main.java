package com.codeintelx.bank;

import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.AccountServices;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter choice");
        System.out.println("1.Create an Account \n" +
                "2.View Account by Account Number \n" +
                "3.Withdraw from Account \n" +
                "4.Deposit from Account");
        // scanner.next(); //git

        switch (scanner.nextInt()) {
            case 1:
                //Account account = new Account(scanner.nextLine(), scanner.nextInt(), scanner.nextLine(), scanner.nextLine());
                System.out.println("Account will be created");
                scanner.nextLine();
                System.out.println("Please enter your name");
                Account account = new Account(scanner.nextLine(), scanner.nextInt(), scanner.nextLine(), scanner.nextLine());

                break;
            case 2:
                System.out.println("Please enter your account number");
                scanner.hasNext();
                break;
            case 3:
                System.out.println("Please enter balance");
                AccountServices accountServices = new AccountServices(scanner.nextInt());
                System.out.println("How much do you want to withdraw from your account?");
                //AccountServices accountServices = new AccountServices(scanner.nextInt());
                accountServices.withdrawFunds(scanner.nextInt());
                break;
            default:
                System.out.println("Please enter balance");
                AccountServices accountServices1 = new AccountServices(scanner.nextInt());
                System.out.println("How much do you want to deposit into your account?");
                accountServices1.depositFunds(scanner.nextInt());


        }
    }
}

