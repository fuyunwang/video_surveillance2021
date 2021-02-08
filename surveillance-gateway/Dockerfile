FROM openjdk:8u212-jre

MAINTAINER 2375872953@qq.om

ENV TZ=Asia/Shanghai

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN mkdir -p /surveillance-apis

WORKDIR /openjdk:8u212-jre

EXPOSE 8888

ADD ./target/surveillance-gateway-2.0.0.jar ./

ENTRYPOINT ["java", "-javaagent:/fuyunwang/sky-agent/agent/skywalking-agent.jar","-Dskywalking.agent.service_name=surveillance-apis","-Dskywalking.collector.backend_service=192.168.33.3:11800", "-Xmx256m", "-jar", "./surveillance-gateway-2.0.0.jar"]
