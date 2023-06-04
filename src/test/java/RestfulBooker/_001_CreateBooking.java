package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class _001_CreateBooking {

    @Test
    public void createBooking(){

        //Build request
        RestAssured
                .given()
                    .log()
                    .all()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking")
                    .body("{\n" +
                        "    \"firstname\" : \"Navnath\",\n" +
                        "    \"lastname\" : \"Burungale\",\n" +
                        "    \"totalprice\" : 24,\n" +
                        "    \"depositpaid\" : false,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2023-03-06\",\n" +
                        "        \"checkout\" : \"2023-03-07\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Lunch\"\n" +
                        "}")
                    .contentType(ContentType.JSON)

        //hit request and get response
                .when()
                    .post()

        //validate response
                .then()
                    .log()
                    .all()
                    .statusCode(200);
    }
}
