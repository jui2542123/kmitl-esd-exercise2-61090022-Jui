package kmitl.esd.exercise2;

import kmitl.esd.exercise2.model.CustomerDTO;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;

import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.logging.Logger;

@SpringBootApplication
public class Client {

    private static final Logger log = (Logger) LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Client.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8089"));
        app.run(args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /**
     * Main entry point for the client 
     */
    @Bean
    public CommandLineRunner GetAll(RestTemplate restTemplate) throws Exception {
        return args -> {
            /**
             * start with get
             */
            String response = callGetAll(restTemplate);
            log.info(String.format("GET call: " + response));
            /**
             * create
             */
            CustomerDTO createCustomer = callCreateCustomer(restTemplate);
            log.info("CREATE: " + createCustomer.toString());
            /**
             * update
             */
            CustomerDTO updateCustomer=callUpdateCustomer(restTemplate);
            log.info("UPDATE: " + updateCustomer.toString());
            /**
             * delete
             */
            ResponseEntity responseEntity =callDeleteCustomer(restTemplate,"0");
            String deleteResponse = callGetAll(restTemplate);
            log.info("DELETE : " +deleteResponse);

        };
    }

    /**
     * get all customers
     * @param restTemplate
     * @return respString
     */
    String callGetAll(RestTemplate restTemplate) {
        StringBuffer url = new StringBuffer("http://localhost:8080/customer");
        String respString = restTemplate.getForObject(
                url.toString(), String.class);
        return respString;
    }

    /**
     * Create the customer
     * @param restTemplate
     * @return
     * @throws JSONException
     */

    CustomerDTO callCreateCustomer(RestTemplate restTemplate) throws JSONException {
        JSONObject customers = new JSONObject();
        customers.put("id",1);
        customers.put("name","A");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(customers.toString(), headers);

        ResponseEntity<CustomerDTO> response = restTemplate.exchange("http://localhost:8080/customer", HttpMethod.POST, request, CustomerDTO.class);
        return response.getBody();

    }

    /**
     * Update customer info
     * @param restTemplate
     * @return
     * @throws JSONException
     */

    CustomerDTO callUpdateCustomer(RestTemplate restTemplate) throws JSONException {
        JSONObject customers = new JSONObject();
        customers.put("id",2);
        customers.put("name","B");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(customers.toString(), headers);

        ResponseEntity<CustomerDTO> response = restTemplate.exchange("http://localhost:8000/customer", HttpMethod.PUT, request, CustomerDTO.class);

        return response.getBody();
    }

    /**
     * delete customer
     * @param restTemplate
     * @param customerId
     */

    ResponseEntity<String> callDeleteCustomer(RestTemplate restTemplate, String customerId) {
        ResponseEntity<String> response=restTemplate.exchange("http://localhost:8000/customer/" + customerId,HttpMethod.DELETE,null,String.class);
        return response;
    }




}