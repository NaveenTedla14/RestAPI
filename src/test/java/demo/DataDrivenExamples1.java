package demo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DataDrivenExamples1 extends DataForTests {

    @Test(dataProvider = "DataForPost")
    public void test_post(String firstName,String lastName,int subject){
        JSONObject request = new JSONObject();
        request.put("firstName",firstName);
        request.put("lastName",lastName);
        request.put("subjectId",subject);

        baseURI="http://localhost:3000";

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).log().all();

    }

    @Test(dataProvider = "DeleteData")
    public void test_delete1(int userId){
        baseURI="http://localhost:3000";
        when().delete("/users/"+userId).
                then().
                statusCode(200).log().all();
    }
    @Parameters({"userId"})
    @Test()
    public void test_delete2(int userId){
        baseURI="http://localhost:3000";
        when().delete("/users/"+userId).
                then().
                statusCode(200).log().all();
    }
}
