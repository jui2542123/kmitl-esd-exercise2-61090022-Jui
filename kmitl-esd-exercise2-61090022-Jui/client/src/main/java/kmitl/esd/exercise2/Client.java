package kmitl.esd.exercise2;

import client.src.main.java.kmitl.esd.exercise2.LoggerFactory;
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

        // SpringApplication.run(Exercise2Client.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /**
     * Main entry point for the client 
     */
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            String response = callAll(restTemplate, "Tom");
            log.info(String.format("Hello GET call: " + response));
        };
    }

    String callGetAll(RestTemplate restTemplate, String name) {
        StringBuffer url = new StringBuffer("http://localhost:8080/customer");
        if (name != null) {
            url.append("?name=").append(name);
        }
        String respString = restTemplate.getForObject(
                url.toString(), String.class);
        return respString;
    }


}