package apiCode;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class PutAPI {

    @Test()
    public void putAPIRequest() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://apichallenges.eviltester.com";
        String filepath = "src/test/java/apiCode/PutRequest.json";
        String payload = new String(Files.readAllBytes(Paths.get(filepath)));

        Response response = given().log().all().header("Content-Type", "application/json")
                .body(payload).when().put("sim/entities/10").then().assertThat().statusCode(200).extract().response();

        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
    }
}
