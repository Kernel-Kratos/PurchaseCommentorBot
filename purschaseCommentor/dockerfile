#BUILDING the App

FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .

#Skipping tests to speed up the process in cloud

RUN mvn clean package -DskipTests

#Running the app

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

