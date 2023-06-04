package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class _007_DeleteBooking {

    @Test
    public void deleteBooking(){

        RestAssured
                .given()
                    .log().all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/3")
                    .contentType(ContentType.JSON)
                    .cookie("token=abc123")
                    .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                    .delete()
                .then()
                    .log().all()
                    .statusCode(201);
    }
}
