package com.wangyousong.microservice.nacos.servicecomsumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Bob
 * @version 1.0
 * @date 2020/6/20 17:44
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private final RestTemplate template;

    public HelloController(RestTemplate template) {
        this.template = template;
    }

    @GetMapping("/echo/{name}")
    public String echoHello(@PathVariable String name) {
        return template.getForObject("http://nacos-service-provider/echo/" + name, String.class);
    }
}
