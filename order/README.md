# ORDER MICROSERVICE
***
> Port: 8094 \
> DB name: order \
> Framework: Spring WebFlux 
```diff
- This microservice is dependent on Inventory and Delivery microservices, to create an order make sure the other two microservices are running.
```
***
## POST

### Url
```javascript
http://localhost:8094/v1/order
```
### RequestBody:
```json
{
  "userName": "Parvez",
  "itemId": "1",
  "itemName": "Pizza",
  "description": "Food",
  "quantity": 4,
  "address": {
    "street": "ABC",
    "city": "noida",
    "state": "Delhi",
    "zipCode": "762134"
  }
}
```


### Case 1: if itemId is present and quantity is available

>Status Code: 200 Ok

* ### Response:
```json
{
    "id": "642ffa2acb7ac734e35e5b53",
    "userName": "Parvez",
    "itemId": "1",
    "itemName": "Pizza",
    "description": "Food",
    "quantity": 4,
    "orderDate": "2023-04-13T07:55:34.378+00:00",
    "address": {
        "street": "ABC",
        "city": "noida",
        "state": "Delhi",
        "zipCode": "762134"
    }
}
```

### Case 2: if quantity not available
>Status Code: 403 Forbidden
* ### Response:
```json
{
  "message": "Insufficient Quantity for itemId : 1"
}
```

### Case 3: if itemId not present
>Status Code: 404 Not Found
* ### Response:
```json
{
  "message": "Item Not Found for itemId : 1"
}
```
---
## GET
### Url
```javascript
http://localhost:8094/v1/orders
```
>Status Code 200 Ok

### Response:
```json
[
  {
    "id": "642fdae527904d0f8024ea16",
    "userName": "Parvez",
    "itemId": "1",
    "itemName": "Pizza",
    "description": "Food",
    "quantity": 1,
    "orderDate": "2023-04-13T07:55:34.378+00:00",
    "address": {
      "street": "xsdadayz",
      "city": "nbs",
      "state": "saeq",
      "zipCode": "09813"
    }
  },
  {
    "id": "642fdc35ab91fa4948b425d5",
    "userName": "Parvez",
    "itemId": "1",
    "itemName": "Pizza",
    "description": "Food",
    "quantity": 1,
    "orderDate": "2023-04-13T07:55:34.378+00:00",
    "address": {
      "street": "xyz",
      "city": "nbs",
      "state": "saeq",
      "zipCode": "09813"
    }
  },
  {
    "id": "642fdc76ab91fa4948b425d6",
    "userName": "Parvez",
    "itemId": "1",
    "itemName": "Pizza",
    "description": "Food",
    "quantity": 1,
    "orderDate": "2023-04-13T07:55:34.378+00:00",
    "address": {
      "street": "ABC",
      "city": "noida",
      "state": "state",
      "zipCode": "762134"
    }
  }
]
```
---
## GET
### Url
```javascript
http://localhost:8094/v1/order/{orderId}
```

### Case 1: if orderId present
>Status Code 200 Ok
* ### Response
```json
{
    "id": "642ffa2acb7ac734e35e5b53",
    "userName": "Parvez",
    "itemId": "1",
    "itemName": "Pizza",
    "description": "Food",
    "quantity": 4,
    "orderDate": "2023-04-13T07:55:34.378+00:00",
    "address": {
        "street": "ABC",
        "city": "noida",
        "state": "Delhi",
        "zipCode": "762134"
    }
}
```

### Case 2: if orderId is not present
>Status Code 404 Not Found
* ### Response:
```json
{
  "message": "Order Details Not Found for orderId : 6437b57637e0cb6746ee1a6c"
}
```
---
## PUT
### Url
```javascript
http://localhost:8094/v1/order/{orderId}
```

### RequestBody:
```json
{
  "street": "xyz",
  "city": "abc",
  "state": "assam",
  "zipCode": "09813"
}
```
### Case 1: if orderId is present
>Status Code 200 Ok

* ### Response
```json
{
  "id": "642fdae527904d0f8024ea16",
  "userName": "Parvez",
  "itemId": "1",
  "itemName": "Pizza",
  "description": "Food",
  "quantity": 1,
  "orderDate": "2023-04-13T07:55:34.378+00:00",
  "address": {
    "street": "xyz",
    "city": "abc",
    "state": "assam",
    "zipCode": "09813"
  }
}
```

### Case 2: if orderId is not present
>Status Code 404 Not Found
* ### Response:
```json
{
  "message": "Order Details Not Found for orderId: 6437b57637e0cb6746ee1a6c | Can't update the address"
}
```
---
## DELETE

### Url
```javascript
http://localhost:8094/v1/order/{orderId}
```

>Status Code 200 Ok

### RequestBody: NA
### ResponseBody: NA

---
