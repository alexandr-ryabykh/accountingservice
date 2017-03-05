package org.mainacad.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.mainacad")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
