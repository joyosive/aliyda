package com.gdprapp;

import com.gdprapp.kafka.bo.TaskBO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

//import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class GDPRApplication {

    public static void main(String[] args) {
        SpringApplication.run(GDPRApplication.class, args);

    }

//    @KafkaListener(topics = KafkaController.TOPIC_TASK, groupId = "group_json",
//            containerFactory = "userKafkaListenerFactory")
//    public void consumeJson(TaskBO user) {
//
//        System.out.println("Consumed JSON Message: " + user);
//    }

}

