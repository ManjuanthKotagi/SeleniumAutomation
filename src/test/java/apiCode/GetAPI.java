package apiCode;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAPI {

    @Test()
    public void getAPIRequest() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://apichallenges.eviltester.com";

        Response response = given().log().all().header("Content-Type", "Application/json")
                .when().get("sim/entities").then().assertThat().statusCode(200).extract().response();

        Headers headers = response.getHeaders();
        headers.forEach(header -> System.out.println(header.getName() + " " + header.getValue()));

        JsonPath jsonPath = new JsonPath(response.asString());
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());

        String firstId = jsonPath.getString("entities.id[0]");
        String firstName = jsonPath.getString("entities.name[0]");
        String firstDescription = jsonPath.getString("entities.description[0]");

        Assert.assertEquals("7", firstId, "Id is not equal");

        System.out.println(firstId + " " + firstName + " " + firstDescription);
    }
}
