Spring Integration Java DSL

Tech Stack:
```
Java- 8
Spring Boot- 2.7.2
Spring Integration

```

MongoDB collect stored under schema folder

Endpoints
```
GET: localhost:8080/integration/grocery/2
POST: localhost:8080/integration/grocery
PUT: localhost:8080/integration/grocery
DELETE: localhost:8080/integration/grocery/2
```

POST Payload:
```
"grocery": {
    "name" : "Sugar",
    "description": "1KG Sugar",
    "ratings": 4,
    "price": 1.0,
    "currency": "USD",
    "promoAvailable": true,
    "discountAvailable": true,
    "image": "sdfdsf",
    "shopId": "234324234"
}

shop": {
    "id" : "234324234"
    "shopName": "Shopno",
    "distance": "3km",
    "time": "23m",
    "shopType": "Mart"
}
```
