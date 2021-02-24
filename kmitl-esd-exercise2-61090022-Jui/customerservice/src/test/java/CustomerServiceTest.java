import kmitl.esd.exercise2.model.CustomerService;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import kmitl.esd.exercise2.model.CustomerDTO;
import org.junit.jupiter.api.BeforeEach;


class CustomerServiceTest {

    private CustomerService customer = CustomerService.getInstance();

    @Test
    void getAllCustomer() {
        CustomerDTO customerA = new CustomerDTO(1,"A");
        customer.createCustomer(customerA);

        assertEquals(4,customer.getAllCustomer().size());
    }

    @Test
    void createCustomer() {
        CustomerDTO customerB = new CustomerDTO(1,"B");
        customer.createCustomer(customerB);
        assertEquals(6,customer.getAllCustomer().size());
    }

    @Test
    void updateCustomer() {
        CustomerDTO customerC = new CustomerDTO(1, "C");
        customer.createCustomer(customerC);
        customerC.setId(2L);
        CustomerDTO update=customer.updateCustomer(customerC);

        assertEquals(customerC.getId(),2L);
    }

    @Test
    void deleteCustomer() {
        CustomerDTO customerD = new CustomerDTO(1, "D");
        customer.createCustomer(customerD);
        customer.deleteCustomer(3L);

        List<CustomerDTO> customers = customer.getAllCustomer();

        assertEquals(3,customers.size());

    }
}