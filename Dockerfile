FROM openjdk:17.0.2-jdk-slim-buster

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} control-panel.jar

WORKDIR /control-panel

ADD src/main/resources/properties/control-panel.yml /control-panel/properties/control-panel.yml

ENV CONFIG_LOCATION="/control-panel/properties/control-panel.yml"

EXPOSE 3030:3030

ENTRYPOINT ["java","-jar","/control-panel.jar"]