package testcases;


import com.jayway.jsonpath.JsonPath;
import commons.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GroupProjectContactListTest extends ApiConfig {


    @Test
    public void get_full_contact_list() {
        RestAssured.baseURI = gp_contact_base_uri;
        Response response = RestAssured.given()
                .get("/contacts");
        String statusLine = response.getStatusLine();
        int statusCode = response.getStatusCode();
        String payload = response.body().prettyPrint();
        int expectedCode = 200;
        System.out.println("Payload: " + payload); // why does my payload only work if it is first?
        System.out.println("Status Line: " + statusLine);
        System.out.println("Status Code" + statusCode);
        Assert.assertEquals(statusCode, expectedCode);
    }

    @Test
    public void add_a_contact(){
        String payload =getPayload("newContactList");
        RestAssured.baseURI= gp_contact_base_uri;
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post("/contacts");
        int statusCode = response.getStatusCode();
        String statusLine = response.getStatusLine();

        System.out.println("Status Line is: " +statusCode);
        System.out.println("Status Code is: " + statusLine);
        response.body().prettyPrint();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(statusCode, 200);
        softAssert.assertEquals(statusLine,"HTTP/1.1 200 OK");
        softAssert.assertAll();
    }

    @Test
    public void get_a_contact(){
        //post a contact first
        String payload =getPayload("getRequestContactList");
        RestAssured.baseURI= gp_contact_base_uri;
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post("/contacts");

        String payloadFromResponse = response.getBody().asString();
        String id = JsonPath.read(payloadFromResponse, "$._id");

        //get request with extracted id from post request response
        String endpoint= "/contacts/"+id;
        Response responseGetRequest= RestAssured.given()
                .get(endpoint);
        int statusCode = response.getStatusCode();
        String statusLine = response.getStatusLine();

        System.out.println("Status Line is: " +statusCode);
        System.out.println("Status Code is: " + statusLine);
        response.body().prettyPrint();
        Assert.assertTrue(statusLine.contains("HTTP/1.1 200 OK"));
        Assert.assertEquals(statusCode,200);
    }

    @Test
    public void update_a_single_contact() {
        //POST a new user and get user ID
        String payload = getPayload("newContactList2");
        RestAssured.baseURI= gp_contact_base_uri;
        Response responseForPost = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post("/contacts");
        String responsePayload = responseForPost.body().asString();
        String idNewUser = JsonPath.read(responsePayload, "$._id");
        System.out.println(idNewUser);

        //PUT update on previously extracted user ID
        String updatePayload = getPayload("updateSingleContact");
        String endpoint = "/contacts/" + idNewUser;
        Response response = RestAssured.given()
                .header("Content-Type","application/json")
                .body(updatePayload)
                .put(endpoint);
        response.getBody().prettyPrint();
        String responseStatusLine = response.statusLine();
        int responseStatusCode = response.statusCode();
        System.out.println(responseStatusLine);
        System.out.println(responseStatusCode);

        SoftAssert sassert = new SoftAssert();
        sassert.assertEquals(responseStatusCode, 200);
        sassert.assertEquals(responseStatusLine, "HTTP/1.1 200");
        sassert.assertAll();
    }
    @Test
    public void delete_a_contact(){
        //post a contact first
        String payload =getPayload("deleteRequestContactList");
        RestAssured.baseURI= gp_contact_base_uri;
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post("/contacts");

        String payloadFromResponse = response.getBody().asString();
        String id = JsonPath.read(payloadFromResponse, "$._id");

        //delete contact with extracted id
        RestAssured.baseURI=gp_contact_base_uri;
        String endpoint = "/contacts/" +id;
        Response responseFromDelete = RestAssured.given()
                .delete(endpoint);
        int statusCode = responseFromDelete.getStatusCode();
        String statusLine = responseFromDelete.getStatusLine();

        System.out.println("Status Line is: " +statusCode);
        System.out.println("Status Code is: " + statusLine);
        response.prettyPrint();

        Assert.assertTrue(statusLine.contains("HTTP/1.1 204 No Content"));
        Assert.assertEquals(statusCode,204);
    }









}
