package com.fuyunwang.surveillance.apis.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "kafka.template")
public class KafkaApisTemplateProperties {

    private List<ApisTemplate> templates;
    private int templateResultType; // 0-文件获取 1-数据库获取 2-ES
    private String templateResultFilePath;

    public List<ApisTemplate> getTemplates() {
        return templates;
    }

    @Data
    public static class ApisTemplate{
        private String templateId;
        private String templateFilePath;
        private boolean active;

        public String getTemplateId() {
            return templateId;
        }

        public String getTemplateFilePath() {
            return templateFilePath;
        }

        public boolean isActive() {
            return active;
        }
    }

}
