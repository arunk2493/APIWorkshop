API WorkShop:

Please run mvn test command to verify the code works fine

Write Basic Automation tests for the given endpoints

* GET - retrive a pet detail - https://petstore.swagger.io/v2/pet/1 
  -> Assert the status of the response
  -> Print the status and error message if invalid input is passed - Negative numbers, float numbers and invalid characters and invalid data
  -> Access the "tags" from response body and print and validate the values

Sample Response:
{
  "id": 1,
  "category": {
    "id": 1,
    "name": "string"
  },
  "name": "doggie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 1,
      "name": "string"
    }
  ],
  "status": "available"
}


* POST - place an order - https://petstore.swagger.io/v2/store/order
  
  -> Test script for creating an order when the inventory is available. FOr this hit "https://petstore.swagger.io/v2/store/inventory" call and verify and create an       order

* GET - retrive a pet detail - https://petstore.swagger.io/v2/pet/1 
    -> Hit this api "n" number of times and extract the response time for all the hit and display the least response time taken value and hit count


"inputs for the post call body ranges from 1"

Please use the created classes for the test cases

request body for post:
{
"id": 0,
"petId": 0,
"quantity": 0,
"shipDate": "2021-09-17T05:43:00.987Z",
"status": "placed",
"complete": true
}
