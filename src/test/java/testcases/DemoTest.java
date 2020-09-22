package testcases;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import utility.Steps;

public class DemoTest  {



    //@Test
    public void practice_test(){
        String url = "https://reqres.in/api/users/2";

        Response response = RestAssured.given().get(url).andReturn();
        response.getBody().prettyPrint();

        RestAssured.get();
        RestAssured.post();
        RestAssured.delete();
        RestAssured.put();

        //3 Sections of Request
        //1) Request line   GET url
        //2) Request Header
        //3) Request Body

        //status line
        response.getStatusLine();

        //header
        response.getContentType();
        response.getHeaders();
        response.getHeader("Content-Type");

        //body
        response.getBody();

    }

   // @Test
    public void starwars_test(){
        String url = "https://swapi.dev/api/people/1/";
        Response response = RestAssured.given().get(url).andReturn();
        String responseBodyPayload = response.getBody().asString();
        System.out.println("I got the following data back from te server: ");
        System.out.println(responseBodyPayload);
        response.getBody().prettyPrint();

    }
    //DSL, making code reading easier
    //Given: prepare request
    // when: sending request
    //then: validate response

   // @Test
    public void practiceTest3(){
        RestAssured.baseURI="https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();
        ResponseBody body =httpRequest.get("/api/users/2");
        String data = body.asString();
        System.out.println(data);

    }


    @Test
    public void practiceTest4(){
        RestAssured.baseURI="https://reqres.in";
        RequestSpecification spec = RestAssured.given();
        Steps.log("Preparing GET Request to endpoint /api/users/2");

        Response response = spec.request(Method.GET,"/api/users/2");
        Steps.log("Received a Response from server");

        String statusLine = response.getStatusLine();
        Steps.log(statusLine);

        String headers = response.headers().toString();
        String age = response.headers().getValue("Age");
        String server = response.headers().getValue("Server");
        Steps.log("Here is the body");
        Steps.logJson(response.prettyPrint());

        //System.out.println(statusLine);
       // System.out.println(headers);
        //System.out.println(age);
       // System.out.println(server);


    }


}


//1. prepare a request
//2. send the request
//3. convert the response json data into String     //body.asString();
//4. use JsonPath to extract target data
//5. Validate the extracted data with expected data