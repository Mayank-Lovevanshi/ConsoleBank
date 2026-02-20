package repository;
import java.util.*;
import domain.*;

public class TransactionRepository
{
private final Map<String,List<Transaction>> transactionRepository = new HashMap<>();
public List<Transaction> getTransaction(String accountNumber)
{
return transactionRepository.get(accountNumber);
}
public void add(Transaction transaction)
{
String accountNumber = transaction.getAccountNumber();
List<Transaction> list = transactionRepository.get(accountNumber);
if(list==null) 
{
list = new ArrayList<>();
list.add(transaction);
transactionRepository.put(accountNumber,list);
}
else list.add(transaction);
}
public List<Transaction> findByAccount(String accountNumber)
{
List<Transaction> list = transactionRepository.get(accountNumber);
if(list==null) throw new RuntimeException("No Records for this Account | "+accountNumber);
return list;
}
}
