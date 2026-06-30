FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/hospital-0.0.1-SNAPSHOT.jar hospital.jar
ENTRYPOINT ["java", "-jar", "hospital.jar"]