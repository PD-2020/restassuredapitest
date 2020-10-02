package testcases;

import commons.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class PublicContactListTest extends ApiConfig {

    @Test
    public void register_single_user() {
        String payload = "{" +
                "    \"email\": \"nnn1212@example.com\"," +
                "    \"password\": \"SuperSecretPassword123\"" +
                "}";
        RestAssured.baseURI = base_uri;
        RequestSpecification spec = RestAssured.given();
        spec.header("Content-Type", "Application/json");
        spec.body(payload);

        Response response = spec.post("/pcl/auth/register");
        System.out.println(response.getStatusLine());

    }

    @Test
    public void login_registered_user_extract_session() {
        RestAssured.baseURI = base_uri;
        RequestSpecification spec = RestAssured.given();
        spec.header("Content-Type", "Application/json");
        String payload = "{" +
                "    \"email\": \"nnn1212@example.com\"," +
                "    \"password\": \"SuperSecretPassword123\"" +
                "}";
        spec.body(payload);
        Response response = spec.post("/pcl/auth/login");
        System.out.println(response.getStatusLine());
        String sessionToken = response.getBody().asString();
        System.out.println("sessionToken: " + sessionToken);
    }

    @Test
    public void register_single_user_file_payload(){
        String path = System.getProperty("user.dir")+"/src/test/resources/payloads/newUser.json";
        String payload = read(path).trim();
        RestAssured.baseURI = base_uri;
        RequestSpecification spec = RestAssured.given();
        spec.header("Content-Type", "Application/json");
        spec.body(payload);
        System.out.println(payload);

        Response response = spec.post("/pcl/auth/register");
        System.out.println(response.getStatusLine());
    }

    @Test
    public void logout_single_user(){
        //1.login a user
        String path = System.getProperty("user.dir")+"/src/test/resources/payloads/newUser.json";
        String payload = read(path).trim();
        RestAssured.baseURI=base_uri;
        Response response = RestAssured.given()                             // .contentType(ContentType.JSON)
                .contentType("Application/json")       //header("Content-Type","Application/json")
                .body(payload)
                .post("/pcl/auth/login");
        String sessionToken = response.getBody().asString();

        //2. logout a single user
        Response responseLogout= RestAssured.given()
                 .header("Authorization",sessionToken)
                 .get("/pcl/auth/logout");
        System.out.println("Response status line: " +response.getStatusLine());

    }


}
