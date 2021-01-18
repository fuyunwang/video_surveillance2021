package com.fuyunwang.surveillance.apis;

import com.fuyunwang.surveillance.apis.prop.KafkaApisTemplateProperties;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2020/12/29 19:31
 */
@RestController
public class IndexController {

//    @Value("${foo}")
//    String foo;
//
//    @GetMapping("/foo")
//    public String foo(){
//        return foo;
//    }

    @Autowired
    private KafkaApisTemplateProperties kafkaApisTemplateProperties;

    @Autowired
    private Producer producer;

    @GetMapping("/kafka/prop")
    public Object kafkaProp(){
        String topicName="demo-topic";
        ProducerRecord<String,String> topicRecord=new ProducerRecord(topicName,"templateId1",kafkaApisTemplateProperties.getTemplates().stream().filter(KafkaApisTemplateProperties.ApisTemplate::isActive).findFirst().get());

        return kafkaApisTemplateProperties.getTemplates();
    }
}
