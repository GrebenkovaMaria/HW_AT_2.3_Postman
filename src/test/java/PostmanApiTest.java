import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanApiTest {
    private final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://postman-echo.com")
            .build();

    @Test
    void shouldPostedData() {
        given()
                .spec(requestSpec)
                .body("some data")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .header("content-length", equalTo("419"))
                .body("data", containsString("some data"));

    }
}
