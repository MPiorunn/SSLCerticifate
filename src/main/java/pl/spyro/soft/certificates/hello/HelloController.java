package pl.spyro.soft.certificates.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public HelloDto hello() {
        return new HelloDto("Hello from HelloController");
    }
}

