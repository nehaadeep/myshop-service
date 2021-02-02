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
=======
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

```
http://localhost:8090/myshop-service/actuator/health

{"status":"UP"}


_Example request 1:_ 

curl -X POST "http://localhost:8090/myshop-service/myshop/cart/total" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"products\": [ { \"id\": 1, \"name\": \"T-shirt\", \"price\": 500 }, { \"id\": 1, \"name\": \"T-shirt\", \"price\": 500 }, { \"id\": 4, \"name\": \"Shoes\", \"price\": 5000 }, { \"id\": 3, \"name\": \"Jacket\", \"price\": 2500 } ]}"

_Swagger request payload 1:_ 

{
  "products": [
    {
      "id": 1,
      "name": "T-shirt",
      "price": 500
    },
    {
      "id": 1,
      "name": "T-shirt",
      "price": 500
    },
    {
      "id": 4,
      "name": "Shoes",
      "price": 5000
    },
    {
      "id": 3,
      "name": "Jacket",
      "price": 2500
    }
  ]
}

_Example response 1:_

{
  "subtotal": 8500,
  "tax": 1530,
  "total": 8280,
  "comments": "2 eligible offers",
  "discounts": [
    "10% off on shoes: Rs, 500",
    "50% off on Jacket: Rs, 1250"
  ]
}

_Example request 2:_ 

curl -X POST "http://localhost:8090/myshop-service/myshop/cart/total" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"products\": [ { \"id\": 1, \"name\": \"T-shirt\", \"price\": 500 }, { \"id\": 2, \"name\": \"Trousers\", \"price\": 1500 } ]}"

_Swagger request payload 2:_

{
  "products": [
    {
      "id": 1,
      "name": "T-shirt",
      "price": 500
    },
    {
      "id": 2,
      "name": "Trousers",
      "price": 1500
    }
  ]
}

_Example response 2:_ 

{
  "subtotal": 2000,
  "tax": 360,
  "total": 2360,
  "comments": "No eligible offers",
  "discounts": []
}
```

