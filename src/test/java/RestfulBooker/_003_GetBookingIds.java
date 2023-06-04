package RestfulBooker;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class _003_GetBookingIds {

    @Test
    public void getBookingIds(){

        //Build request
        RestAssured
                .given()
                    .log()
                    .all()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking")
//                    .contentType(ContentType.JSON)

        //Hit Request and get the response
                .when()
                    .get()

        //validate the response
                .then()
                    .log()
                    .all()
                    .statusCode(200);
    }
}
