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
