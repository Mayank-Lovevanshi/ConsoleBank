package domain;

public class Account implements Comparable<Account>
{
private String accountNumber;
private String customerId;
private double balance;
private String accountType;

public String toString()
{
return accountNumber+" | "+customerId+" | "+balance+" | "+accountType;
}
public int compareTo(Account account)
{
return this.getAccountNumber().compareTo(account.getAccountNumber());
}

public Account(String accountNumber,String customerId,Double balance,String accountType)
{
this.accountNumber = accountNumber;
this.customerId = customerId;
this.balance = balance;
this.accountType = accountType;
}

public void setAccountNumber(String accountNumber)
{
this.accountNumber = accountNumber;
}

public void setCustomerId(String customerId)
{
this.customerId = customerId;
}

public void setBalance(Double balance)
{
this.balance = balance;
}

public void setAccountType(String accountType)
{
this.accountType = accountType;
}

public String getAccountNumber()
{
return this.accountNumber;
}

public String getCustomerId()
{
return this.customerId;
}

public Double getBalance()
{
return this.balance;
}

public String getAccountType()
{
return this.accountType;
}

}
