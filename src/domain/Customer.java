package domain;

public class Customer
{
private String customerId;
private String customerName;
private String customerEmail;

public Customer(String customerId,String customerName,String customerEmail)
{
this.customerId = customerId;
this.customerName = customerName;
this.customerEmail = customerEmail;
}

public void setCustomerId(String customerID)
{
this.customerId = customerId;
}

public void setCutomerName(String cutomerName)
{
this.customerName = customerName;
}

public void setCustomerEmail(String cutomerEmail)
{
this.customerEmail = customerEmail;
}

public String getCustomerId()
{
return this.customerId;
}

public String getCustomerName()
{
return this.customerName;
}

public String getCustomerEmail()
{
return this.customerEmail;
}

}
