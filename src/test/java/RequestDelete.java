import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestDelete {
    @Test
    public void delete_Test() {
        RestAssured.baseURI = "https://reqres.in";
        Response postResponse = (Response) given()
                .header("content-type","application/json")
                .delete("/api/users/2");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(),204,"Expected 204"+postResponse.getStatusCode());

    }

}
