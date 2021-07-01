import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

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
}
