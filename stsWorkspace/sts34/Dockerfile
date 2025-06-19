FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/sts34-0.0.1-SNAPSHOT.jar sts34.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar sts34.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar sts34.jar
