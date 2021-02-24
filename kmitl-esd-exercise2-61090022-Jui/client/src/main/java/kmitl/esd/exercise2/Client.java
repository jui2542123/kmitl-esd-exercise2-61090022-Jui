package client.src.main.java.kmitl.esd.exercise2;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.logging.Logger;

@SpringBootApplication
public class Client {

    private static final Logger log = LoggerFactory.getLogger(Client.class);

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
            String response = callGetAll(restTemplate);
            log.info(String.format("GET call: " + response));
        };
    }

    /**
     * Delete
     */
    @Bean
    public CommandLineRunner Delete(RestTemplate restTemplate) throws Exception {
        return args -> {
            callDeleteCustomer(restTemplate, "1");
            String response = callGetAll(restTemplate);

            log.info(String.format("Delete: " + response));
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
     * delete customer
     * @param restTemplate
     * @param id
     */

    void callDeleteCustomer(RestTemplate restTemplate, String id) {
        String url = "http://localhost:8000/customer/" + id;

        restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
    }




}