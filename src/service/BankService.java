package service;
import java.util.*;
import domain.*;
public interface BankService
{
public String openAccount(String name,String email,String accountType);
public List<Account> getAllAccounts();
public void deposit(String accountNumber,double amount,String note);
public void withdraw(String accountNumber,double amount,String note);
public void transfer(String from,String to,double amount,String note);
public List<Transaction> getStatement(String accountNumber);
public List<Account> findAccountsByCustomerName(String customerName);
}
