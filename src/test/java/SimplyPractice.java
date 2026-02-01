import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class SimplyPractice {

    @Test()
    public void getRequest() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://apichallenges.eviltester.com";
        String jsonFilePath = "src/test/java/apiCode/PostRequestBody.json";
        String jsonBody = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

        Response response = given().log().all().header("Content-Type", "application/json").
                body(jsonBody).when().post("sim/entities").then().assertThat().statusCode(201).extract().response();

        JsonPath jsonPath = new JsonPath(response.asString());
        System.out.println(response.prettyPrint());
    }
}
