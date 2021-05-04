import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestGet {
    @Test
    public void get_List_Users_Test() {
        Response response = given()
                .header("content-type","application/json")
                .get("https://reqres.in/api/users?page=2");
        System.out.println("******** "+response.asString());
        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());

    }
    @Test
    public void get_Single_User_Test() {
        Response response = given()
                .header("content-type","application/json")
                .get("https://reqres.in/api/users/2");
        System.out.println("******** "+response.asString());
        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());

    }
    @Test
    public void get_Single_User_Not_Found_Test() {
        Response response = given()
                .header("content-type","application/json")
                .get("https://reqres.in/api/users/23");
        System.out.println("******** "+response.asString());
        Assert.assertEquals(response.statusCode(),404,"Expected response code is 404 but found "+response.statusCode());

    }
    @Test
    public void get_List_Resource_Test() {
        Response response = given()
                .header("content-type","application/json")
                .get("https://reqres.in/api/unknown");
        System.out.println("******** "+response.asString());
        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());

    }
    @Test
    public void get_Single_Resource_Test() {
        Response response = given()
                .header("content-type","application/json")
                .get("https://reqres.in/api/unknown/2");
        System.out.println("******** "+response.asString());
        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());

    }
    @Test
    public void get_Single_Resource_Not_Found_Test() {
        Response response = given()
                .header("content-type","application/json")
                .get("https://reqres.in/api/unknown/23");
        System.out.println("******** "+response.asString());
        Assert.assertEquals(response.statusCode(),404,"Expected response code is 404 but found "+response.statusCode());

    }
    @Test
    public void get_Delayed_Response_Test() {
        Response response = given()
                .header("content-type","application/json")
                .get("https://reqres.in/api/users?delay=3");
        System.out.println("******** "+response.asString());
        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());

    }


}
