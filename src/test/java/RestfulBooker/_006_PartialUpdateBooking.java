package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class _006_PartialUpdateBooking {

    @Test
    public void partialUpdatePATCH(){

        RestAssured
                .given()
                    .log().all()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/{basePath}/{id}")
                    .pathParam("basePath","booking")
                    .pathParam("id",12)
                    .contentType(ContentType.JSON)
                    .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .header("Accept","application/json")
                    .body("{\n" +
                            "    \"firstname\" : \"Candy\",\n" +
                            "    \"lastname\" : \"BrownSugar\"\n" +
                            "}")
                .when()
                    .patch()
                .then()
                    .log().all()
                    .statusCode(200);
    }
}
