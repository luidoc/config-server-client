package com.example.demo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("nested")
@RefreshScope
public class TestPropsAnidadas {

    private String test1;
    private String test2;

    private ObjetoAnidado object = new ObjetoAnidado();

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public ObjetoAnidado getObject() {
        return object;
    }

    public void setObject(ObjetoAnidado object) {
        this.object = object;
    }
    public void setTest2(String test2) {
        this.test2 = test2;
    }

    public static class ObjetoAnidado {
        public String getTest3() {
            return test3;
        }

        public void setTest3(String test3) {
            this.test3 = test3;
        }

        public String getTest4() {
            return test4;
        }

        public void setTest4(String test4) {
            this.test4 = test4;
        }

        private String test3;
        private String test4;
    }

}
