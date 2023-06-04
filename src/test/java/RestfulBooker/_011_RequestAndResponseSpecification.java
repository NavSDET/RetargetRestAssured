package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class _011_RequestAndResponseSpecification {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @Test
    public void RequestResponseSpec(){

        requestSpecification= RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/2")
//                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .contentType(ContentType.JSON);

        responseSpecification=RestAssured
                .expect()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .time(Matchers.lessThan(5000l));

        //Build Request
        RestAssured
                .given(requestSpecification, responseSpecification)
//                .spec(requestSpecification)
        //Hit Request
                .get()
        //validate Response
                .then()
                .log().all();
//                .spec(responseSpecification)
    }
}
