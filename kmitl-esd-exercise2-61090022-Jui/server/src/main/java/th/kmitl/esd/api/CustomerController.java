package th.kmitl.esd.api;

import kmitl.esd.exercise2.model.CustomerDTO;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;



@RestController
@RequestMapping("/customer")

public class CustomerController {

    private final AtomicLong counter = new AtomicLong();

    private static List<CustomerDTO> customers = new ArrayList<>();

    static{
        CustomerDTO customerT = new CustomerDTO(1,"T");
        customers.add(customerT);

    }

    /**
     *Get all customers details
     * @return customerlist
     */

    @GetMapping("/findall")
    public List<CustomerDTO> getAllCustomer() {
        return CustomerService.INSTANCE.getAllCustomer();
    }

    /**
     *create customer
     *
     * @return customer
     */
    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customer)
    {
        return CustomerService.INSTANCE.createCustomer(customer);
    }
    /**
     *update customer
     *
     * @return customer
     */

    @PutMapping
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customer) {
        return CustomerService.INSTANCE.updateCustomer(customer);
    }

    /**
     * Delete customer
     * @param customerId
     * @return boolean
     */

    @DeleteMapping("/{id}")
    public Boolean deleteCustomer(@PathVariable("id")Long customerId){
        CustomerDTO customerToBeDeleted = customers.stream().filter(c -> c.getId().equals(customerId))
        if(customerToBeDeleted != null){
        }
    }



}
