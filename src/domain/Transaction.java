package domain;
import java.time.LocalDateTime;
public class Transaction implements Comparable<Transaction>
{
private String transactionId;
private String accountNumber;
private Double amount;
private LocalDateTime timestamp;
private String note;
private Type type;

public String toString()
{
return accountNumber+" | "+amount+" | "+" | "+transactionId+" | "+timestamp+" | "+type+" | "+note;
}

public int compareTo(Transaction transaction)
{
return (this.getTimestamp()).compareTo(transaction.getTimestamp());
}

public Transaction(String transactionId,String accountNumber,Double amount,LocalDateTime timestamp,String note,Type type)
{
this.transactionId = transactionId;
this.accountNumber = accountNumber;
this.amount = amount;
this.timestamp = timestamp;
this.note = note;
this.type = type;
}
public void setTransactionId(String transactionId)
{
this.transactionId = transactionId;
}
public void setAccountNumber(String accountNumber)
{
this.accountNumber = accountNumber;
}
public void setAmount(Double amount)
{
this.amount = amount;
}
public void setTimestamp(LocalDateTime timestamp)
{
this.timestamp = timestamp;
}
public void setNote(String note)
{
this.note = note;
}
public void setType(Type type)
{
this.type = type;
}
public String getTransactionId()
{
return this.transactionId;
}
public String getAccountNumber()
{
return this.accountNumber;
}
public Double getAmount()
{
return this.amount;
}
public LocalDateTime getTimestamp()
{
return this.timestamp;
}
public String getNote()
{
return this.note;
}
public Type getType()
{
return this.type;
}
}
