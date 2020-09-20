package testcases;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GETRequestPracticeTest {

    @Test
    public void get_request_practice1(){
        //1. Register a base URI where the request will be sent
        RestAssured.baseURI="https://reqres.in";

        //2. Specify the request that will be sent
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/users/2");

        //3. using the response object, let's extract each part
        //    of the response (Status line, headers, body)
       // System.out.println(response.statusLine());
       // System.out.println(response.getStatusCode());

        //headers
        //System.out.println(response.headers());
        Headers headers = response.getHeaders();
        String entireHeaders = headers.toString();
     //   System.out.println(entireHeaders);
        String expectCT = headers.getValue("Expect-CT");
        //System.out.println(specificHeader);
        String server = headers.getValue("Server");
        String date = headers.getValue("Date");

        //body
        //ResponseBody responseBody = response.getBody();
        //String prettyBody = responseBody.prettyPrint();
        String payload = response.getBody().asString();
        //to extract a specific data from payload
        String emailVal = JsonPath.read(payload, "$.data.email");
        String firstNameVal = JsonPath.read(payload,"$.data.first_name");
        String lastNameVal = JsonPath.read(payload,"$.data.last_name");
        String adCompanyVal = JsonPath.read(payload,"$.ad.company");

      //  System.out.println(payload);
        System.out.println("Email: " +emailVal);
        System.out.println("First Name: " +firstNameVal);
        System.out.println("Last Name: " + lastNameVal);
        System.out.println("Company: "+adCompanyVal);
    }


}
