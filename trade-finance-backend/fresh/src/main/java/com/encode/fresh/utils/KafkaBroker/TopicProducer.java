package com.encode.fresh.utils.KafkaBroker;//package com.emtechhouse.usersservice.utils.KafkaBroker;
//
//import com.emtechhouse.usersservice.PersonalDetailsDTO.Mailparams;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class TopicProducer {
//    @Value("${topic.name.producer}")
//    private String topicName;
//    @Autowired
//    KafkaTemplate<String, Mailparams> KafkaJsontemplate;
//    public void send(Mailparams message){
//        log.info("Payload enviado: {}",  message);
//        KafkaJsontemplate.send(topicName, message);
//        log.info("--------Email Sent to: "+message.getEmail()+ "at " +LocalDateTime.now()+"-----------------");
//    }
//
//}