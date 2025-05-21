FROM maven:3.9.9-amazoncorretto-8-alpine

WORKDIR /workspace
# ENTRYPOINT wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.105/bin/apache-tomcat-9.0.105.tar.gz
RUN ["/bin/sh", "-c", "wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.105/bin/apache-tomcat-9.0.105.tar.gz" ]
# ENTRYPOINT tar -zxvf apache-tomcat-9.0.105.tar.gz
RUN ["/bin/sh", "-c", "tar -zxvf apache-tomcat-9.0.105.tar.gz" ]
COPY target/sts-1.0.0-BUILD-SNAPSHOT.war /workspace/apache-tomcat-9.0.105/webapps/ROOT.war
EXPOSE 8080
# ENTRYPOINT sh /workspace/apache-tomcat-9.0.105/bin/startup.sh
RUN [ "/bin/sh","-c","/workspace/apache-tomcat-9.0.105/bin/startup.sh" ]
