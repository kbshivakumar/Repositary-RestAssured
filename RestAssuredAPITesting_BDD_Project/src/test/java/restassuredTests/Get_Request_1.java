package restassuredTests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class Get_Request_1 {
	
	//@Test
//	public void getRequest()
//	{
//		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
//		System.out.println(response.statusCode());
//		System.out.println(response.getStatusLine());
//		System.out.println(response.getTime());
//		int statuscode=response.getStatusCode();
//		Assert.assertEquals(statuscode, 200);
//	}
	
	public void testGet()
	{
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").
		then().
		statusCode(200).
		body("data[0].id",equalTo(7)).
		statusLine("HTTP/1.1 200 OK").assertThat().body("data[5].first_name",equalTo("Rachel")).
		body("data.first_name",hasItems("Lindsay","Tobias")).
		log().all();
		
	}
	
	@Test
	public void testPost() // need to provide a body from Post
	{
		//Map<String, Object> map=new HashMap<String, Object>();
		
		//System.out.println(map);
				
		JSONObject request = new JSONObject();
		request.put("name","Raghav");
		request.put("job", "Teacher");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given().
		    body(request.toJSONString()).
		    when().
		    post("/users").
		    then().
		    statusCode(201).
		    log().all();
		    
		    
	}

}
