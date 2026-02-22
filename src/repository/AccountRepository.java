package repository;
import java.util.*;
import domain.*;
public class AccountRepository
{
private final Map<String,Account> accountRepository = new HashMap<>();
public void save(Account account)
{
String accountNumber = account.getAccountNumber();
if(accountRepository.get(accountNumber)!=null) throw new RuntimeException("Account already exists with this account number");
accountRepository.put(accountNumber,account);
}
public List<Account> findAll()
{
List<Account> allAccounts = new ArrayList<>(accountRepository.values());
Collections.sort(allAccounts);
return allAccounts;
}
public Account getAccount(String accountNumber)
{
return accountRepository.get(accountNumber);
}
public Account getAccountByCustomerId(String customerId)
{
List<Account> accountList = new ArrayList<>(accountRepository.values());
for(Account account : accountList)
{
if(customerId.equals(account.getCustomerId())) return account;
}
return null;
}
}
