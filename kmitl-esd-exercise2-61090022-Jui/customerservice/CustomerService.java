package customerservice;


import model.src.main.java.kmitl.esd.exercise2.model.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    /**
     * Singleton service
     */
    public static CustomerService INSTANCE = new CustomerService();

    /**
     * Customer list to represent the database containing customers
     */
    private static List<CustomerDTO> customers = new ArrayList<>();

    /**
     * Create customer + add to list
     */
    static {
        CustomerDTO customerA = new CustomerDTO(1,"A");
        CustomerDTO customerB = new CustomerDTO(2,"B");

        customers.add(customerA);
        customers.add(customerB);
    }
    /**
     * Private constructor - singleton pattern
     */
    private CustomerService() {}

    /**
     * get customer
     * @return list of customers
     */
    public List<CustomerDTO> getAllCustomers() {
        return customers;
    }

    /**
     * create customer
     * @return customer
     */
    public CustomerDTO createCustomer(CustomerDTO customer) {
        customers.add(customer);
        return customer;
    }

    /**
     * update customer
     * @return customer
     */
    public CustomerDTO updateCustomer(CustomerDTO customer) {
        try {
            CustomerDTO customerTobeUpdated = customers.stream().filter(c -> c.getId().equals(customer.getId())).findFirst().get();
            customers.remove(customerTobeUpdated);
            customers.add(customer);
        } catch (Exception e) {
            customers.add(customer);
        }

        return customer;
    }

    /**
     * delete customer
     * @param customerId
     * @return boolean - the result of deletion
     */
    public boolean deleteCustomer(Long customerId) {
        try {
            CustomerDTO customerTobeDeleted = customers.stream().filter(c -> c.getId().equals(customerId)).findFirst().get();
            customers.remove(customerTobeDeleted);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
