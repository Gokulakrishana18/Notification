# Step 1: Use a lightweight JDK image
#FROM openjdk:17-jdk-slim
FROM eclipse-temurin:17-jdk-jammy


# Step 2: Set a working directory inside the container
# Set working directory
WORKDIR /app

# Copy the built JAR file into the container
# Make sure you build your Spring Boot project first (mvn clean package)
COPY target/*.jar app.jar

# Expose the port your Spring Boot app uses
EXPOSE 8092

# Optional: Set default environment variables (can be overridden)
ENV SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/bookmymovie?useSSL=false&allowPublicKeyRetrieval=true
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=root
ENV SPRING_DATASOURCE_DRIVER_CLASS_NAME=com.mysql.cj.jdbc.Driver

# Run the JAR
ENTRYPOINT ["java","-jar","app.jar"]