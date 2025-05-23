FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/sts14-0.1.jar sts14.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar sts14.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.secufrity.egd=file:/dev/./urandom -jar sts14.jar
