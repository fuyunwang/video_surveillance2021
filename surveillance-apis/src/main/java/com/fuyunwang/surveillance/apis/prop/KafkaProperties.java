package com.fuyunwang.surveillance.apis.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "kafka.apis")
public class KafkaProperties {

    private String bootstrapServers;
    private String acksConfig;
    private String partitionerClass;

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public String getAcksConfig() {
        return acksConfig;
    }

    public String getPartitionerClass() {
        return partitionerClass;
    }
}
