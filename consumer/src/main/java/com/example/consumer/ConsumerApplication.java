package com.example.consumer;


import com.example.base.dto.WordCount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }


    @Bean
    public Consumer<WordCount> sink1() {
        return message -> {
            System.out.println("******************");
            System.out.println("At Sink1");
            System.out.println("******************");
            System.out.println("Received message " + message);
        };
    }
}
