import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class SampleTest {
    @Test
    public void validateGetResponseBody(){
        RestAssured.given()
                .get(" https://petstore.swagger.io/v2/pet/1")
                // THEN
                .then().log().body()
                .assertThat().statusCode(200)
                .body("id", Matchers.equalTo(1))
                .body("category.id",Matchers.equalTo(0));
    }

    //Assert the status code for Get call
    @Test
    public void validateGetResponse(){
        RestAssured.given().get("https://petstore.swagger.io/v2/pet/1")
                .then().log().body()
                .assertThat().statusCode(200)
                .body("id",Matchers.equalTo(1))
                .body("category.id", Matchers.equalTo(0));

    }
    @Test
    public void createOrderOnlyIfInventoryIsAvailable(){
        /*Run the tests only if available inventory is greater than 0 and print the order ID*/

        String inventory = given()
                .baseUri("https://petstore.swagger.io")
                .when()
                .get("/v2/store/inventory")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .asString();

        JsonPath jsonPath = new JsonPath(inventory);
        int available = jsonPath.getInt("available");

        if (available> 0){
            File loadOrderData = new File("src//main//resources//storeOrderData.json");
            String response = given().baseUri("https://petstore.swagger.io").contentType(ContentType.JSON).body(loadOrderData)
                    .when()
                    .post("/v2/store/order")
                    // THEN
                    .then().log().body()
                    .assertThat().statusCode(200)
                    .extract()
                    .response()
                    .asString();

            jsonPath = new JsonPath(response);
            System.out.println("Order ID --------------> "+jsonPath.getLong("id"));
        }
    }
    @Test
    public void createPet(){
        // File loadPetData = new File("src//main//resources//newPetData.json");
        RestAssured.given().baseUri("https://petstore.swagger.io/v2/store/order").contentType(ContentType.JSON).body("{\n" +
                        "\"id\": 100,\n" +
                        "\"petId\": 0,\n" +
                        "\"quantity\": 0,\n" +
                        "\"shipDate\": \"2021-09-17T05:43:00.987Z\",\n" +
                        "\"status\": \"placed\",\n" +
                        "\"complete\": true\n" +
                        "}")
                .when()
                .post()
                // THEN
                .then().log().body()
                .assertThat().statusCode(200);
    }
}
