package com.example.producer;


import com.example.base.dto.WordCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.function.Supplier;

@SpringBootApplication
@RestController
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

//    @Bean
    public Supplier<String> source1() {
        return () -> {
            String message = "FromSource1";
            System.out.println("******************");
            System.out.println("From Source1");
            System.out.println("******************");
            System.out.println("Sending value: " + message);
            return message;

        };
    }


    @Autowired
    private StreamBridge streamBridge;

    @GetMapping("/send")
    public String send() {
        String msg = "FromSource1";

        streamBridge.send("source1-out-0", new WordCount(msg, 1, new Date(), new Date()));

        return msg;
    }
}
