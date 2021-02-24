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



    @GetMapping("/findall")
    public List<CustomerDTO> getAllCustomer(Object customerId){
        return customers;


    @DeleteMapping("/{id}")
    public Boolean deleteCustomer(@PathVariable("id")Long customerId){
        CustomerDTO customerToBeDeleted = customers.stream().filter(c -> c.getId().equals(customerId))
        if(customerToBeDeleted != null){

        }
    }


    }
}
