import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestPatch {
    @Test
    public void patch_Update_Test() {
        RestAssured.baseURI = "https://reqres.in";
        String reqBody = "{\n" +
                "            \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n"+

                "  }";
        Response postResponse = (Response) given()
                .header("content-type","application/json")
                .body(reqBody)
                .patch("/api/users/2");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(),200,"Expected 200"+postResponse.getStatusCode());

    }

}
