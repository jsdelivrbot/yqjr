FROM java:8
VOLUME ["/tmp", "/logs"]
ADD fin.qcms-credit-1.0.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 30001
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=${dockerfile-profile}","-Devo-appname=fin.qcms-credit","-Xms512m","-Xmx1024m","-Duser.timezone=GMT+08","-jar","/app.jar"]
