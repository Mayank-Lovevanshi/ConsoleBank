package service;
import exceptions.*;
import java.util.*;
import java.time.LocalDateTime;
import domain.*;
import repository.*;
public class ConsoleBank implements BankService
{
private final AccountRepository accountRepository = new AccountRepository();
private final TransactionRepository transactionRepository  = new TransactionRepository();
private final CustomerRepository customerRepository = new CustomerRepository();

public String openAccount(String name,String email,String accountType)
{
String customerId = UUID.randomUUID().toString();
String accountNumber = getAccountNumber();
Account account = new Account(accountNumber,customerId,(double)0,accountType);
Customer customer = new Customer(customerId,name,email);
accountRepository.save(account);
customerRepository.save(customer);
return accountNumber;
}

public List<Account> getAllAccounts()
{
return accountRepository.findAll();
}

public String getAccountNumber()
{
int size = accountRepository.findAll().size() + 1;
String accountNumber = String.format("AC%06d",size);
return accountNumber;
}

public void deposit(String accountNumber,double amount,String note)
{
Account account = accountRepository.getAccount(accountNumber);
if(account==null) throw new AccountNotFoundException("Invalid Account Number!!");
account.setBalance(account.getBalance()+amount);

Transaction transaction = new Transaction(UUID.randomUUID().toString(),accountNumber,amount,LocalDateTime.now(),note,Type.DEPOSIT);
transactionRepository.add(transaction);
}

public void withdraw(String accountNumber,double amount,String note)
{
Account account = accountRepository.getAccount(accountNumber);
if(account==null) throw new AccountNotFoundException("Invalid account Number!!");
if(account.getBalance()<amount)
{
throw new InsufficientFundsException("Insufficient Balance!!");
}
account.setBalance(account.getBalance()-amount);
Transaction transaction = new Transaction(UUID.randomUUID().toString(),accountNumber,amount,LocalDateTime.now(),"withdrawl",Type.WITHDRAW);
transactionRepository.add(transaction);
}

public void transfer(String from,String to,double amount,String note)
{
if(from.equals(to)) throw new ValidationException("You Cannot transfer to your own Account");
Account fromAccount = accountRepository.getAccount(from);
Account toAccount = accountRepository.getAccount(to);
if(fromAccount==null || toAccount==null) 
{
throw new AccountNotFoundException("Invalid Account Number!!");
}
if(fromAccount.getBalance()<amount)
{
throw new InsufficientFundsException("Insufficient Balance!!");
}
fromAccount.setBalance(fromAccount.getBalance()-amount);
toAccount.setBalance(toAccount.getBalance()+amount);
Transaction transaction1 = new Transaction(UUID.randomUUID().toString(),from,amount,LocalDateTime.now(),"transfer out",Type.TRANSFER_OUT);
Transaction transaction2 = new Transaction(UUID.randomUUID().toString(),to,amount,LocalDateTime.now(),"transfer in",Type.TRANSFER_IN);
transactionRepository.add(transaction1);
transactionRepository.add(transaction2);
}

public List<Transaction> getStatement(String accountNumber)
{
List<Transaction> list = transactionRepository.findByAccount(accountNumber);
if(list==null) throw new AccountNotFoundException("Invalid Account Number !!");
Collections.sort(list);
return list;
}

public List<Account> findAccountsByCustomerName(String customerName)
{
String name = customerName.toLowerCase();
List<Customer> listOfCustomers = customerRepository.findAllCustomer();
List<Account> accountList = new ArrayList<>();
for(Customer customer : listOfCustomers)
{
if(customer.getCustomerName().toLowerCase().contains(name))
{
Account account = accountRepository.getAccountByCustomerId(customer.getCustomerId());
if(account!=null) accountList.add(account);
}
}
return accountList;
}

}
