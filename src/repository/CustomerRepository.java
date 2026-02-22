package repository;
import java.util.*;
import domain.*;
public class CustomerRepository
{
private final Map<String,Customer> customerRepository = new HashMap<>();

public Customer findCustomerById(String customerId)
{
Customer customer = customerRepository.get(customerId);
if(customer==null) throw new RuntimeException("Invalid Customer id!!");
return customer;
}

public void save(Customer customer)
{
String customerId = customer.getCustomerId();
customerRepository.put(customerId,customer);
}

public List<Customer> findAllCustomer()
{

List<Customer> list = new ArrayList<>(customerRepository.values());
return list;
}


}
