package pl.com.tt.atp.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mkucharek
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello from Spring Boot app!";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHelloAgain() {
        return "Hello again!";
    }
}
