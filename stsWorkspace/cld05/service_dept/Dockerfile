FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/service_dept-0.0.1-SNAPSHOT.jar servicedept.jar
EXPOSE 7001
ENTRYPOINT exec java $JAVA_OPTS -jar servicedept.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar servicedept.jar
