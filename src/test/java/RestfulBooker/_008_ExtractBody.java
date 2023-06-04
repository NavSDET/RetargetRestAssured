package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class _008_ExtractBody {

    @Test
    public void extractBody(){

        String responseBody = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/7")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract()
                .body()
                .asPrettyString();
        //asString();
        System.out.println(responseBody);
    }
}
