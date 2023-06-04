package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _009_RequestSpecificationMultipleRequests {

    RequestSpecification requestSpecification;

    @BeforeClass
    public void RequestSpec(){
        requestSpecification=RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON);
    }

    @Test
    public void createBooking(){
        //Build Request
        RestAssured
                .given()
                .spec(requestSpecification)
                .basePath("/booking")
                .body("{\n" +
                        "    \"firstname\" : \"Dattaraj\",\n" +
                        "    \"lastname\" : \"Burungale\",\n" +
                        "    \"totalprice\" : 14,\n" +
                        "    \"depositpaid\" : false,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2023-03-06\",\n" +
                        "        \"checkout\" : \"2023-03-07\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Tomato\"\n" +
                        "}")
        //hit request and get response
                .when()
                .post()
        //validate response
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void updateBooking(){
        //Build Request
        RestAssured
                .given()
                .spec(requestSpecification)
                .basePath("/booking/6")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .body("{\n" +
                        "    \"firstname\" : \"Dattaraj\",\n" +
                        "    \"lastname\" : \"B\",\n" +
                        "    \"totalprice\" : 14,\n" +
                        "    \"depositpaid\" : false,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2023-03-06\",\n" +
                        "        \"checkout\" : \"2023-03-07\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Dinner\"\n" +
                        "}")
        //hit request and get response
                .when()
                .put()
        //validate response
                .then()
                .log()
                .all()
                .statusCode(200);
    }

}
