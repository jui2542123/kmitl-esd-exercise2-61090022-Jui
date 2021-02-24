package th.kmitl.esd.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import kmitl.esd.exercise2.model.CustomerDTO;

import java.util.List;

/**
 * Testing
 */
class CustomerControllerTest {
    /**
     * get
     */

    private CustomerController controller = new CustomerController();
    @Test
    void getAllCustomer() {
        List<CustomerDTO> customers = controller.getAllCustomer();
        assertEquals(customers.size(), 2);
    }

    /**
     * create
     */

    @Test
    void createCustomer() {
        CustomerDTO at=new CustomerDTO(1,"A");
        controller.createCustomer(at);
        assertEquals(controller.getAllCustomer().size(),4);
    }

    /**
     * update
     */
    @Test
    void updateCustomer() {
        CustomerDTO at=new CustomerDTO(1,"A");
        controller.createCustomer(at);
        at.setId(2L);
        CustomerDTO update = controller.updateCustomer(at);
        assertEquals(update.getId(),2L);
    }

    /**
     * delete
     */

    @Test
    void deleteCustomer() {
        CustomerDTO at=new CustomerDTO(1,"A");

        controller.createCustomer(at);
        controller.deleteCustomer(1L);
        assertEquals(controller.getAllCustomer().size(),2);


    }
}