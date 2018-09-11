FROM centos

RUN yum install -y java

VOLUME /tmp

ADD target/*.jar app.jar

RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java" , "-Djava.security.egd=file:/dev/dev/./urandom", "-jar", "/app.jar"]

EXPOSE 8080

