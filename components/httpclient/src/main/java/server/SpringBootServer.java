package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@SpringBootApplication
@EnableWebMvc
public class SpringBootServer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootServer.class, args);
    }

    @GetMapping("/hello")
    public String getHello(@RequestBody String reqBody) {
        return reqBody;
    }

    @PostMapping("/hello")
    public String postHello(@RequestBody String reqBody) {
        return reqBody;
    }

}
