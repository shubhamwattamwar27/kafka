package com.example.kafkaProducer.controller;

import com.example.kafkaProducer.config.KafkaConfiguration;
import com.example.kafkaProducer.dto.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produce")
public class ProducerController {

    //@Autowired
   //private KafkaTemplate<String,Object> kafkaTemplate;

    @Autowired
    private  KafkaConfiguration kafkaConfiguration;


    /*@PostMapping("/{message}")
    public String produce(@PathVariable String message) {
        ListenableFuture<SendResult<String, Object>> future =
                kafkaTemplate.send(KafkaConfiguration.KAFKA_TOPIC, "Hello Today's message is : " + message);
        //async call to check the data is send successfully or not
        //doing async because of performance improvement
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onSuccess(SendResult<String, Object> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });
        return "Data Published";
    }*/

    @GetMapping("/object")
    public String publishMessageWithCustomObject(){
        kafkaConfiguration.greetingKafkaTemplate().send("javaDemo",new Greeting("Shubham","Hi its java custom object greeting"));
        return "Data Published";
    }
}
