FROM java:8
VOLUME /tmp
ADD scfw-zuul-1.0.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 50001
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=sit","-jar","/app.jar"]
