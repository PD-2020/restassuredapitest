import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DemoTest {



    @Test
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

    @Test
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

    @Test
    public void practiceTest3(){
        RestAssured.baseURI="https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();
        ResponseBody body =httpRequest.get("/api/users/2");
        String data = body.asString();
        System.out.println(data);

    }





}


//1. prepare a request
//2. send the request
//3. convert the response json data into String     //body.asString();
//4. use JsonPath to extract target data
//5. Validate the extracted data with expected data