package com.codeintelx.bank.exceptions;

public class AccountNotFoundException extends Exception
{
    public AccountNotFoundException(String errorMessage)
    {
        super(errorMessage);
        //System.out.println("Account Not Found, try again");
        //super(errorMessage);

    }

}
