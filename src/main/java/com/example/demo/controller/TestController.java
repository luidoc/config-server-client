package com.example.demo.controller;

import com.example.demo.model.TestPropsAnidadas;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Value("${clave:}")
    private String clave;

    TestPropsAnidadas propsAnidadas;

    public TestController(TestPropsAnidadas testPropsAnidadas) {
        this.propsAnidadas = testPropsAnidadas;
    }
    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String index() {
        return "DEMO APP";
    }

    @GetMapping(value = "/getkey", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getClave() {
        return String.format("key: %s", clave);
    }

    @GetMapping(value = "/properties", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getProperties() {
        return String.format("clave: %s", clave + "\n")
                + String.format("test1: %s", propsAnidadas.getTest1() + "\n")
                + String.format("test2: %s", propsAnidadas.getTest2() + "\n")
                + String.format("object test3: %s", propsAnidadas.getObject().getTest3() + "\n")
                + String.format("objet test4: %s", propsAnidadas.getObject().getTest4() + "\n");
    }
}
