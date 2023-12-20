package restassuredTests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class PutPatchRequest {
	
	@Test
	public void getPutpatchMethod() {
		
		
		JSONObject request = new JSONObject();
		request.put("name","Shiva");
		request.put("job", "SWE");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given().
		    header("Content-Type","application/json").
		    contentType(ContentType.JSON).
		    accept(ContentType.JSON).
		    body(request.toJSONString()).
		    when().
		    patch("/users/2").
		    then().
		    statusCode(200).
		    log().all();
		System.out.println("patch request is successfully completed");
		    
		 
	}

}
