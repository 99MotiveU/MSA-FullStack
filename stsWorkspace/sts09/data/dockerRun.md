### 
```
docker run -it -p 8080:8080 --network net01 -v D:\stsWorkspace\sts05:/data maven:3.9.9-amazoncorretto-8-alpine sh

cd /data
mvn package

wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.105/bin/apache-tomcat-9.0.105.tar.gz
tar -zxvf apache-tomcat-9.0.105.tar.gz
sh ./apache-tomcat-9.0.105/bin/startup.sh
cp /data/target/sts05-1.0.0-BUILD-SNAPSHOT.war ./apache-tomcat-9.0.105/webapps/ROOT.war


```
