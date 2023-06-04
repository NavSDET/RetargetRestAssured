package RestfulBooker;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class _004_PathParamDemo {

    @Test
    public void NamedPathParam(){

        RestAssured
                .given()
                    .log().all()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/{basePath}/{bookingId}")
                    .pathParam("basePath","booking")
                    .pathParam("bookingId",2)
                .when()
                    .get()
                .then()
                    .log().all()
                    .statusCode(200);
    }

    @Test
    public void IndexPathParam(){

        RestAssured
                .given()
                    .log().all()
                .when()
                    .get("https://restful-booker.herokuapp.com/{basePath}/{bookingId}","booking",2)
                .then()
                    .log().all()
                    .statusCode(200);

    }

    @Test
    public void CombinationOfNamedAndIndex(){
        RestAssured
                .given()
                    .log().all()
                    .baseUri("https://restful-booker.herokuapp.com")
                .when()
                    .get("/{basePath}/{bookingId}","booking",2)
                .then()
                    .log().all()
                    .statusCode(200);
    }

    @Test
    public void ByUsingHashMap(){

        Map<String, Object> pathParameters=new HashMap<>();
        pathParameters.put("basePath","booking");
        pathParameters.put("id",2);

        RestAssured
                .given()
                    .log().all()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/{basePath}/{id}")
                    .pathParams(pathParameters)
                .when()
                    .get()
                .then()
                    .log().all()
                    .statusCode(200);
    }
}
