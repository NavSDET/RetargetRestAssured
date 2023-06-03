package Booker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class GetBookingById {

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
