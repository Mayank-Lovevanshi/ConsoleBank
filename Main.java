import java.util.Scanner;
import service.*;
import domain.*;
import java.util.*;
public class Main
{
public static void main(String args[])
{
System.out.println("==========================");
System.out.println("WELCOME TO CONSOLE BANK : ");
System.out.println("==========================");
Scanner sc = new Scanner(System.in);
BankService bankService = new ConsoleBank();
while(true)
{
System.out.println("""	
	1) OPEN ACCOUNT
	2) DEPOSIT
	3) WITHDRAW
	4) TRANSFER
	5) ACCOUNT STATEMENT
	6) LIST ACCOUNTS
	7) SEARCH ACCOUNTS BY CUSTOMER NAME
	8) EXIT
""");	
System.out.print("CHOICE : ");

String choice = sc.nextLine().trim();

switch(choice)
{
case "1": 
openAccount(sc,bankService);
break;

case "2":
deposit(sc,bankService);
break;

case "3":
withdraw(sc,bankService);
break;

case "4":
transfer(sc,bankService);
break;

case "5":
accountStatement(sc,bankService);
break;

case "6":
listAccounts(sc,bankService);
break;

case "7":
searchAccount(sc,bankService);
break;

case "8":
System.out.println("=====");
System.out.println("Bye!!");
System.out.println("=====");
return;

default : 
System.out.println("==========================");
System.out.println("Invalid Choice!!");
System.out.println("==========================");
}
}
}
public static void openAccount(Scanner sc,BankService bankService)
{
System.out.print("Customer Name : ");
String customerName = sc.nextLine().trim();
System.out.print("Customer Email : ");
String customerEmail = sc.nextLine().trim();
System.out.print("Account Type(SAVINGS/CURRNT) : ");
String accountType = sc.nextLine().trim();
System.out.print("Initial Deposit : ");
Double initialDeposit = Double.valueOf(sc.nextLine().trim());
String accountNumber = bankService.openAccount(customerName,customerEmail,accountType);
if(initialDeposit>0) 
{
bankService.deposit(accountNumber,initialDeposit,"Initial deposit");
}
System.out.println("ACCOUNT OPENED SUCCESSFULLY!! | "+accountNumber );
}

public static void deposit(Scanner sc,BankService bankService)
{
System.out.print("ACCOUNT NUMBER : ");
String accountNumber = sc.nextLine().trim();
System.out.print("AMOUNT : " );
Double amount = sc.nextDouble();
bankService.deposit(accountNumber,amount,"DEPOSIT");
System.out.println("DEPOSITED SUCCESSFULLY!!");
}

public static void transfer(Scanner sc,BankService bankService)
{
System.out.print("From Account : ");
String fromAccount = sc.nextLine().trim();
System.out.print("To Account : ");
String toAccount = sc.nextLine().trim();
System.out.print("Amount : ");
Double amount = Double.valueOf(sc.nextLine().trim());
bankService.transfer(fromAccount,toAccount,amount,"Transfer");
}

public static void withdraw(Scanner sc,BankService bankService)
{
System.out.print("Account Number : ");
String accountNumber = sc.nextLine().trim();
System.out.print("Enter Amount : ");
Double amount = sc.nextDouble();
bankService.withdraw(accountNumber,amount,"withdrawl");
System.out.println("Withdrwal");
}

public static void listAccounts(Scanner sc,BankService bankService)
{
List<Account> allAccounts = bankService.getAllAccounts();
for(Account account : allAccounts)
{
System.out.println(account);
}
}

public static void accountStatement(Scanner sc,BankService bankService)
{
System.out.print("Account Number : ");
String accountNumber = sc.nextLine().trim();
List<Transaction> list= bankService.getStatement(accountNumber);
for(Transaction transaction : list)
{
System.out.println(transaction);
}
}

public static void searchAccount(Scanner sc,BankService bankService)
{
System.out.print("Customer Name : ");
String customerName = sc.nextLine().trim();
List<Account> list = bankService.findAccountsByCustomerName(customerName);
for(Account account : list)
{
System.out.println(account);
}
}

}
