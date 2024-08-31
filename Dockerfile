# Use a base image with Java
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/lisys.jar  app.jar

# Specify the command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Expose the port your application will run on
EXPOSE 8080

