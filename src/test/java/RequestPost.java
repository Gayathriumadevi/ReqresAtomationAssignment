import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RequestPost {
    @Test
    public void post_Create_Test() {
        RestAssured.baseURI = "https://reqres.in";
        String reqBody = "{\n" +
                "\"name\": \"morpheus\"," +
                "\"job\": \"leader\"" +

                "  }";
        Response postResponse = (Response) given()
                .header("content-type","application/json")
                .body(reqBody)
                .post("/api/users");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(),201,"Expected 201"+postResponse.getStatusCode());

    }
    @Test
    public void post_Register_Succesful_Test() {
        RestAssured.baseURI = "https://reqres.in";
        String reqBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\"," +
                "    \"password\": \"pistol\"\n" +

                "  }";
        Response postResponse = (Response) given()
                .header("content-type","application/json")
                .body(reqBody)
                .post("/api/register");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(),200,"Expected 200"+postResponse.getStatusCode());

    }
    @Test
    public void post_Register_UnSuccesful_Test() {
        RestAssured.baseURI = "https://reqres.in";
        String reqBody = "{\n" +
                "        \"email\": \"sydney@fife\"\n" +

                "  }";
        Response postResponse = (Response) given()
                .header("content-type","application/json")
                .body(reqBody)
                .post("/api/register");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(),400,"Expected 400"+postResponse.getStatusCode());

    }
    @Test
    public void post_Login_Succesful_Test() {
        RestAssured.baseURI = "https://reqres.in";
        String reqBody = "{\n" +
                "            \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n"+

                "  }";
        Response postResponse = (Response) given()
                .header("content-type","application/json")
                .body(reqBody)
                .post("/api/login");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(),200,"Expected 200"+postResponse.getStatusCode());

    }
    @Test
    public void post_Login_UnSuccesful_Test() {
        RestAssured.baseURI = "https://reqres.in";
        String reqBody = "{\n" +
                "                \"email\": \"peter@klaven\"\n" +

                "  }";
        Response postResponse = (Response) given()
                .header("content-type","application/json")
                .body(reqBody)
                .post("/api/login");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(),400,"Expected 400"+postResponse.getStatusCode());

    }

}
