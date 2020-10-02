package testcases;

import commons.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class VideoGameDBTest extends ApiConfig {

    @Test
    public void get_all_video_games(){
        RestAssured.baseURI=gameDB_base_uri;
        Response response = RestAssured.given()
                .accept("Application/json")
                .get("/videogames");

        System.out.println(response.getStatusLine());
        response.body().prettyPrint();
    }

    @Test
    public void register_single_game(){
        String path =System.getProperty("user.dir")+"/src/test/resources/payloads/newVideoGame.json";
        String payload = read(path).trim();
        RestAssured.baseURI=gameDB_base_uri;
        Response response = RestAssured
                .given()
                .contentType("application/json; charset=utf-8")
                .accept("application/json")
                .body(payload)
                .post("/videogames");

        System.out.println(response.getStatusLine());
        System.out.println(response.getStatusCode());
        response.getBody().prettyPrint();
    }

    @Test
    public void delete_single_videogame(){
        RestAssured.baseURI=gameDB_base_uri;
        Response response = RestAssured.given()
                                .accept("Application/json")
                                .delete("/videogames/20");
        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();

    }

    @Test
    public void get_single_game(){
        RestAssured.baseURI=gameDB_base_uri;
        Response response = RestAssured.given()
                              .header("Accept","Application/json")
                                .get("/videogames/5");
        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();
    }

    @Test
    public void update_single_game(){
        String payload =getPayload("updateGame");
        RestAssured.baseURI = gameDB_base_uri;
        Response response = RestAssured.given()
                .header("accept","Application/json")
                .contentType("Application/json")
                .body(payload)
                .put("/videogames/9");
        System.out.println(response.getStatusCode());
        response.getBody().prettyPrint();
    }

}


