package restassuredTests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class PostRequest {
	
	
	/*public void getPostMethod() {
		
		
		JSONObject request = new JSONObject();
		request.put("name","Kuntamalla");
		request.put("job", "HouseWared");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given().
		    body(request.toJSONString()).
		    when().
		    post("/users/2").
		    then().
		    statusCode(201).
		    log().all();
	}*/
	@Test
	public void DeleteRequest()
	{
		baseURI="https://reqres.in/api";
		when().
	    delete("/users/2").
	    then().
	    statusCode(200).
	    log().all();
	}

}
