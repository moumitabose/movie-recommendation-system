FROM amazoncorretto:11

WORKDIR /app

COPY target/movie-recommendation-0.0.1-SNAPSHOT.jar  /app/movie-recommendation.jar

ENTRYPOINT ["java","-jar","//app/movie-recommendation.jar"]

#COPY target/support-ticket-system-0.0.1-SNAPSHOT.jar  /app/support-ticket-system.jar
#
#ENTRYPOINT ["java", "-jar", "/app/support-ticket-system.jar"]