API WorkShop:

Please run mvn test command to verify the code works fine

1. Write Basic Automation tests for the given endpoints

GET - retrive a pet detail - https://petstore.swagger.io/v2/pet/1 

GET - inventory details - https://petstore.swagger.io/v2/store/inventory

POST - place an order - https://petstore.swagger.io/v2/store/order
inputs for the post call body ranges from 1

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
