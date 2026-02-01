package apiCode;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class PostAPI {

    @Test()
    public void postAPIRequest() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();;
        RestAssured.baseURI = "https://apichallenges.eviltester.com";
        String jsonPath = "src/test/java/apiCode/PostRequestBody.json";
        String requestBody = new String(Files.readAllBytes(Paths.get(jsonPath)));

        Response response = given().log().all().header("Content-Type", "Application/json")
                .body(requestBody).when().post("sim/entities").then().assertThat().statusCode(201).extract().response();

        System.out.println("Response is : " + response.prettyPrint());
        System.out.println("Response code : " + response.statusCode());
    }
}
