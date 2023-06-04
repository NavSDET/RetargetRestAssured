package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class _005_UpdateBooking {

    @Test
    public void updateBooking(){

        RestAssured
                .given()
                    .log().all()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking/19")
                    .contentType(ContentType.JSON)
                    .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .body("{\n" +
                            "    \"firstname\" : \"Nisha\",\n" +
                            "    \"lastname\" : \"Brown\",\n" +
                            "    \"totalprice\" : 111,\n" +
                            "    \"depositpaid\" : true,\n" +
                            "    \"bookingdates\" : {\n" +
                            "        \"checkin\" : \"2018-01-01\",\n" +
                            "        \"checkout\" : \"2019-01-01\"\n" +
                            "    },\n" +
                            "    \"additionalneeds\" : \"Breakfast\"\n" +
                            "}")
                .when()
                    .put()
                .then()
                    .log().all()
                    .statusCode(200);
    }
}
