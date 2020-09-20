package testcases;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class GetReqAssignTest {

    @Test
    public void get_berries1(){
        RestAssured.baseURI="https://pokeapi.co/api/v2";
        RequestSpecification req = RestAssured.given();
        Response response = req.get("/berry/1/");
        String statusLine = response.getStatusLine();
        int statusCode = response.getStatusCode();
        Headers headers= response.getHeaders();
        String allHeaders = headers.toString();
        String connection = headers.getValue("Connection");
        String date = headers.getValue("Date");
        String cacheControl = headers.getValue("Cache-Control");
        String payload = response.getBody().asString();
        String firmnessName = JsonPath.read(payload,"$.firmness.name");
        System.out.println("JSON value of berry firmness name: "+firmnessName);

        String itemName = JsonPath.read(payload,"$.item.name");
        System.out.println("JSON value of item name: "+itemName);

        int growthTime = JsonPath.read(payload,"$.growth_time");
        System.out.println("JSON value of growth time: "+growthTime);


        System.out.println("Status Line: " + statusLine);
        System.out.println("Status Code: "+ statusCode);
        System.out.println("Connection Header value:" +connection);
        System.out.println("Date Header value: " +date);
        System.out.println("Cache-Control value: "+cacheControl);
        System.out.println("All Headers:  " + allHeaders);
        response.getBody().prettyPrint();
    }

    @Test
    public void get_contests2(){
        RestAssured.baseURI="https://pokeapi.co/api/v2";
        RequestSpecification req = RestAssured.given();
        Response response = req.get("/contest-type/cool/");
        String statusLine = response.getStatusLine();
        int statusCode = response.getStatusCode();
        Headers headers = response.getHeaders();
        String allHeaders =headers.toString();
        String contentType= headers.getValue("Content-Type");
        String transferEncoding = headers.getValue("Transfer-Encoding");
        String xCache=headers.getValue("X-Cache");
        String payload = response.getBody().asString();
        String berryFlaverName = JsonPath.read(payload,"$.berry_flavor.name");
        String namesColor = JsonPath.read(payload, "$.names[1].color");
        String namesName = JsonPath.read(payload, "$.names[0].name");



        System.out.println("Status Line: " +statusLine);
        System.out.println("Status Code: "+statusCode);
        System.out.println("Content Type Header: " +contentType);
        System.out.println("Transfer Encoding Header: "+ transferEncoding);;
        System.out.println("X-Cache Header: "+xCache);
        System.out.println("Json value of Berry flavor name: "+berryFlaverName);
        System.out.println("Json value of names color: " + namesColor);
        System.out.println("Json value of names name: " +namesName);
        System.out.println("Headers: "+allHeaders);
        response.getBody().prettyPrint();
    }

    @Test
    public void get_encounter_methods3(){
        RestAssured.baseURI="https://pokeapi.co/api/v2";
        RequestSpecification req = RestAssured.given();
        Response response = req.get("/encounter-method/walk/");
        String statusLine = response.getStatusLine();
        int statusCode = response.getStatusCode();
        Headers headers = response.getHeaders();
        String allHeaders =headers.toString();
        String contentType= headers.getValue("Content-Type");
        String transferEncoding = headers.getValue("Transfer-Encoding");
        String server=headers.getValue("Server");
        String payload = response.getBody().asString();
        String languagede = JsonPath.read(payload,"$.names[0].language.name");
        int order= JsonPath.read(payload,"$.order");
        int id =JsonPath.read(payload,"$.id");


        System.out.println("Status Line: " +statusLine);
        System.out.println("Status Code: "+statusCode);
        System.out.println("Content Type Header: " +contentType);
        System.out.println("Transfer Encoding Header: "+ transferEncoding);;
        System.out.println("X-Cache Header: "+server);
        System.out.println("Json value of Language in de: "+languagede);
        System.out.println("Json value of order: " + order);
        System.out.println("Json value of id: " + id);
        System.out.println("Headers: "+allHeaders);
        response.getBody().prettyPrint();
    }

    @Test
    public void get_evaluation_chains4(){
        RestAssured.baseURI="https://pokeapi.co/api/v2";
        RequestSpecification req = RestAssured.given();
        Response response = req.get("/evolution-chain/7/");
        String statusLine = response.getStatusLine();
        int statusCode = response.getStatusCode();
        Headers headers = response.getHeaders();
        String allHeaders =headers.toString();
        String contentType= headers.getValue("Content-Type");
        String age = headers.getValue("Age");
        String server=headers.getValue("Server");
        String payload = response.getBody().asString();
        String speciesName = JsonPath.read(payload,"$.chain.species.name");
        boolean isBaby = JsonPath.read(payload,"$.chain.is_baby");
        int id =JsonPath.read(payload,"$.id");


        System.out.println("Status Line: " +statusLine);
        System.out.println("Status Code: "+statusCode);
        System.out.println("Content Type Header: " +contentType);
        System.out.println("Age Header: "+ age);;
        System.out.println("X-Cache Header: "+server);
        System.out.println("Json value of Species Name : "+speciesName);
        System.out.println("Json value of is baby : " + isBaby);
        System.out.println("Json value of id: " + id);
        System.out.println("Headers: "+allHeaders);
        response.getBody().prettyPrint();

    }

    @Test
    public void get_games_version_groups5(){
        RestAssured.baseURI="https://pokeapi.co/api/v2";
        RequestSpecification req = RestAssured.given();
        Response response = req.get("/version-group/1/");
        String statusLine = response.getStatusLine();
        int statusCode = response.getStatusCode();
        Headers headers = response.getHeaders();
        String allHeaders =headers.toString();
        String contentType= headers.getValue("Content-Type");
        String transferEncoding = headers.getValue("Transfer-Encoding");
        String server=headers.getValue("Server");
        String payload = response.getBody().asString();
        String name = JsonPath.read(payload,"$.name");
        int order= JsonPath.read(payload,"$.order");
        String regionsName = JsonPath.read(payload,"$.regions[0].name");


        System.out.println("Status Line: " +statusLine);
        System.out.println("Status Code: "+statusCode);
        System.out.println("Content Type Header: " +contentType);
        System.out.println("Transfer Encoding Header: "+ transferEncoding);;
        System.out.println("X-Cache Header: "+server);
        System.out.println("Json value of name: "+name);
        System.out.println("Json value of order: " + order);
        System.out.println("Json value of regions name: " + regionsName);
        System.out.println("Headers: "+allHeaders);
        response.getBody().prettyPrint();
    }

    @Test
    public void get_item_categories6(){
        RestAssured.baseURI="https://pokeapi.co/api/v2";
        RequestSpecification req = RestAssured.given();
        Response response = req.get("/item-category/1/");
        String statusLine = response.getStatusLine();
        int statusCode = response.getStatusCode();
        Headers headers = response.getHeaders();
        String allHeaders =headers.toString();
        String contentType= headers.getValue("Content-Type");
        String contentEncoding = headers.getValue("Content-Encoding");
        String server=headers.getValue("Server");
        String payload = response.getBody().asString();
        String xdefense = JsonPath.read(payload,"$.items[3].name");
        String pocketName = JsonPath.read(payload,"$.pocket.name");
        int id =JsonPath.read(payload,"$.id");


        System.out.println("Status Line: " +statusLine);
        System.out.println("Status Code: "+statusCode);
        System.out.println("Content Type Header: " +contentType);
        System.out.println("Content-Encoding Header: "+ contentEncoding);;
        System.out.println("X-Cache Header: "+server);
        System.out.println("Json value of x-defense: "+xdefense);
        System.out.println("Json value of pocket name: " + pocketName);
        System.out.println("Json value of id: " + id);
        System.out.println("Headers: "+allHeaders);
        response.getBody().prettyPrint();

    }

    @Test
    public void get_locations7(){
        RestAssured.baseURI="https://pokeapi.co/api/v2";
        RequestSpecification req = RestAssured.given();
        Response response = req.get("/location/1/");
        String statusLine = response.getStatusLine();
        int statusCode = response.getStatusCode();
        Headers headers = response.getHeaders();
        String allHeaders =headers.toString();
        String contentType= headers.getValue("Content-Type");
        String vary = headers.getValue("Vary");
        String date=headers.getValue("Date");
        String payload = response.getBody().asString();
        String areasName = JsonPath.read(payload,"$.areas[0].name");
        String regionName= JsonPath.read(payload,"$.region.name");
        int gameIndex =JsonPath.read(payload,"$.game_indices[0].game_index");


        System.out.println("Status Line: " +statusLine);
        System.out.println("Status Code: "+statusCode);
        System.out.println("Content Type Header: " +contentType);
        System.out.println("Vary Header: "+ vary);;
        System.out.println("Date Header: "+date);
        System.out.println("Json value of areas name: "+areasName);
        System.out.println("Json value of region name: " + regionName);
        System.out.println("Json value of game index: " + gameIndex);
        System.out.println("Headers: "+allHeaders);
        response.getBody().prettyPrint();
    }


    @Test
    public void get_machines8(){
        RestAssured.baseURI="https://pokeapi.co/api/v2";
        RequestSpecification req = RestAssured.given();
        Response response = req.get("/machine/1/");
        String statusLine = response.getStatusLine();
        int statusCode = response.getStatusCode();
        Headers headers = response.getHeaders();
        String allHeaders =headers.toString();
        String contentType= headers.getValue("Content-Type");
        String date = headers.getValue("Date");
        String server=headers.getValue("Server");
        String payload = response.getBody().asString();
        String moveName = JsonPath.read(payload,"$.move.name");
        String itemURL = JsonPath.read(payload,"$.item.url");
        int id =JsonPath.read(payload,"$.id");


        System.out.println("Status Line: " +statusLine);
        System.out.println("Status Code: "+statusCode);
        System.out.println("Content Type Header: " +contentType);
        System.out.println("Date Header: "+ date);;
        System.out.println("X-Cache Header: "+server);
        System.out.println("Json value of move name: "+moveName);
        System.out.println("Json value of item URL: " + itemURL);
        System.out.println("Json value of id: " + id);
        System.out.println("Headers: "+allHeaders);
        response.getBody().prettyPrint();

    }


    @Test
    public void get_move_targets9(){
        RestAssured.baseURI="https://pokeapi.co/api/v2";
        RequestSpecification req = RestAssured.given();
        Response response = req.get("/move-target/1/");
        String statusLine = response.getStatusLine();
        int statusCode = response.getStatusCode();
        Headers headers = response.getHeaders();
        String allHeaders =headers.toString();
        String contentType= headers.getValue("Content-Type");
        String contentEncoding = headers.getValue("Content-Encoding");
        String server=headers.getValue("Server");
        String payload = response.getBody().asString();
        String description = JsonPath.read(payload,"$.descriptions[0].description");
        String name = JsonPath.read(payload,"$.name");
        String curse =JsonPath.read(payload,"$.moves[1].name");


        System.out.println("Status Line: " +statusLine);
        System.out.println("Status Code: "+statusCode);
        System.out.println("Content Type Header: " +contentType);
        System.out.println("Content-Encoding Header: "+ contentEncoding);;
        System.out.println("X-Cache Header: "+server);
        System.out.println("Json value of description: "+description);
        System.out.println("Json value of name: " + name);
        System.out.println("Json value of curse: " + curse);
        System.out.println("Headers: "+allHeaders);
        response.getBody().prettyPrint();


    }


    @Test
    public void pokemon_characteristics10(){
        RestAssured.baseURI="https://pokeapi.co/api/v2";
        RequestSpecification req = RestAssured.given();
        Response response = req.get("/characteristic/1/");
        String statusLine = response.getStatusLine();
        int statusCode = response.getStatusCode();
        Headers headers = response.getHeaders();
        String allHeaders =headers.toString();
        String contentType= headers.getValue("Content-Type");
        String cfRay = headers.getValue("CF-RAY");
        String acceptRanges=headers.getValue("Accept-Ranges");
        String payload = response.getBody().asString();
        String description = JsonPath.read(payload,"$.descriptions[0].description");
        int gene_module = JsonPath.read(payload,"$.gene_modulo");
        int possibleValue =JsonPath.read(payload,"$.possible_values[5]");


        System.out.println("Status Line: " +statusLine);
        System.out.println("Status Code: "+statusCode);
        System.out.println("Content Type Header: " +contentType);
        System.out.println("CF-RAY Header: "+ cfRay);;
        System.out.println("Accept-Ranges Header: "+acceptRanges);
        System.out.println("Json value of description: "+description);
        System.out.println("Json value of gene-module: " + gene_module);
        System.out.println("Json value of possible value: " + possibleValue);
        System.out.println("Headers: "+allHeaders);
        response.getBody().prettyPrint();
    }
}
