FROM openjdk:11
WORKDIR usr/src
COPY ./target/movie-service-0.0.1-SNAPSHOT.jar /usr/src/movie-service-0.0.1-SNAPSHOT.jar
ENV MYSQL_DATABASE=movieDB
ENV MYSQL_USER=root-app
ENV MYSQL_PASSWORD=root123
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/movieDB
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/movie-service-0.0.1-SNAPSHOT.jar"]
