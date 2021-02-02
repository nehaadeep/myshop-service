# Build and package

```
gradle clean build (If you have java 11 installed)
```

```
gradlew clean build -Dorg.gradle.java.home="D:/Users/Suresh/Downloads/Softwares/jdk-11.0.8_windows-x64_bin/jdk-11.0.8"
```

# Run

```
java -jar build\libs\myshop-service-1.0.0.jar (Using command prompt)
```
# Swagger URL

```
http://localhost:8090/myshop-service/swagger-ui.html
```

# Health check URL

```
http://localhost:8090/myshop-service/actuator/health
```