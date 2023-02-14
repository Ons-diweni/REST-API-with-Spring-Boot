package com.example.kaddemprime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableAspectJAutoProxy
@EnableScheduling
@SpringBootApplication
public class KaddemPrimeApplication {

    public static void main(String[] args) {
    SpringApplication.run(KaddemPrimeApplication.class, args);


    }

}
