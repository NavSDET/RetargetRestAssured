package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _010_ResponseSpecificationMultipleRequests {

    ResponseSpecification responseSpecification;

    @BeforeClass
    public void ExpectResponseSpec(){

        responseSpecification = RestAssured.expect()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .time(Matchers.lessThan(2000l));
    }

    @Test
    public void createBooking(){
        //Build Request
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
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
                .spec(responseSpecification);
    }

    @Test
    public void retrieveBooking(){
        //Build Request
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/2")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
        //hit request and get response
                .when()
                .get()
        //validate response
                .then()
                .log()
                .all()
                .spec(responseSpecification);
    }

}
