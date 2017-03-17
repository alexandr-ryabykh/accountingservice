package org.mainacad.accGoods.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Primary;

@Primary
@SpringBootApplication(scanBasePackages = "org.mainacad")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);         
    }

}