package com.fuyunwang.surveillance.apis;

import com.fuyunwang.surveillance.apis.entity.Person;
import com.fuyunwang.surveillance.apis.prop.KafkaApisTemplateProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

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

    @RequestMapping("/person")
    public Person getPerson(@RequestBody Person person){
        System.err.println(ToStringBuilder.reflectionToString(person, ToStringStyle.MULTI_LINE_STYLE));
        person.setBirthday(new Date());
        return person;
    }
}
