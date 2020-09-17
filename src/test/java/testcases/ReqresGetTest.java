package testcases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReqresGetTest {



    @Test
    public void client_can_get_all_user_status_line(){
        //Test data
        String baseURI = "https://reqres.in/";
        String endpoint ="/api/users?page=2";
        int expectedStatusCode =200;
        String expectedProtocolVersion= "HTPP/1.1";

        //Test steps
        //1. form a request
        //2. send the request
        //3. capture the request
        //4. extract the data nd store them as actual
        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec =RestAssured.given();
        Response response = reqSpec.request(Method.GET,endpoint);

        //status line    HTTP/1.1 200 OK
        //Headers        Content-Type: Applicaiton/json UTF-8    Server:Apache Tomcat
        //Body    {"key":false, "name":"Nijat"}
        int actualStatusCode = response.getStatusCode();
        boolean actualProtocol =response.getStatusLine().contains(expectedProtocolVersion);
        String allHeaderInfo = response.getHeaders().toString();

        //test assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStatusCode, expectedStatusCode);
        softAssert.assertTrue(actualProtocol);
        softAssert.assertAll();
    }

    @Test
    public void client_can_get_all_user_headers(){
        //Test data
        String baseURI = "https://reqres.in/";
        String endpoint ="/api/users?page=2";
        String expectedContentType ="application/json";
        String expectedServer ="cloudflare";
        String expectedConnection="keep-alive";

        //test steps
        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec =RestAssured.given();
        Response response = reqSpec.request(Method.GET,endpoint);
        String actualContentType =response.headers().getValue("Content-Type");
        String actualServer = response.headers().getValue("Server");
        String actualConnection = response.headers().getValue("Connection");



        //test assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualContentType.contains(expectedContentType));
        softAssert.assertTrue(actualServer.contains(expectedConnection));
        softAssert.assertTrue(actualServer.contains(expectedServer));
        softAssert.assertAll();
    }

    @Test
    public void client_can_get_all_user_body(){
        //Test data
        String baseURI = "https://reqres.in/";
        String endpoint ="/api/users?page=2";

        //test steps
        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec =RestAssured.given();
        Response response = reqSpec.request(Method.GET,endpoint);

        //test assertion
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertAll();
    }

















}
