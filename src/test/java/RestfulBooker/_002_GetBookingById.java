package RestfulBooker;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class _002_GetBookingById {

    @Test
    public void retrieveBookingById(){

        //Build request
        RestAssured
                .given()
                    .log()
                    .all()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking/{id}")
                    .pathParam("id",3)
//                    .contentType(ContentType.JSON)

        //Hit Request and get the response
                .when()
                    .get()

        //validate response
                .then()
                    .log()
                    .all()
                    .statusCode(200);
    }
}
