package repository;
import java.util.*;
import domain.*;
public class AccountRepository
{
private final Map<String,Account> accountRepository = new HashMap<>();
public void save(Account account)
{
String accountNumber = account.getAccountNumber();
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
}
