package kmitl.esd.exercise2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import kmitl.esd.exercise2.model.CustomerDTO;


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
     * Singleton
     * @return INSTANCE
     */

    public static CustomerService getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }

        INSTANCE = new CustomerService();

        return INSTANCE;
    }

    /**
     * get customer
     * @return list of customers
     */
    public List<CustomerDTO> getAllCustomer() {
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
            Optional<CustomerDTO> found = Optional.empty();
            for (CustomerDTO c : customers) {
                if (Objects.equals(c.getId(), customer.getId())) {
                    found = Optional.of(c);
                    break;
                }
            }
            CustomerDTO customerTobeUpdated = found.get();
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
            Optional<CustomerDTO> found = Optional.empty();
            for (CustomerDTO c : customers) {
                if (!Objects.equals(c.getId(), customerId)) {
                } else {
                    found = Optional.of(c);
                    break;
                }
            }
            CustomerDTO customerTobeDeleted = found.get();
            customers.remove(customerTobeDeleted);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
