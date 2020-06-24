package com.wangyousong.microservice.nacos.serviceregister;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bob
 * @version 1.0
 * @date 2020/6/20 17:26
 */
@RestController
@RequestMapping("/echo")
public class EchoController {

    @Value("${server.port}")
    private String port;


    @GetMapping("/{name}")
    public String echo(@PathVariable String name) {
        return "Hello " + name + " , from port -> " + port;
    }
}
