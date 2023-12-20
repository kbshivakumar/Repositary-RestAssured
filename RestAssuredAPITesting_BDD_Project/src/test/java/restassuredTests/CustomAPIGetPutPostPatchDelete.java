package restassuredTests;

import org.apache.http.StatusLine;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


import java.time.chrono.ThaiBuddhistChronology;

public class CustomAPIGetPutPostPatchDelete {
	
	
	//@Test
	public void get()
	{
	baseURI="http://localhost:3000";
	
	given().
	get("/users").then().statusCode(200)
	.log().all();
	
	
	}

	//@Test
	public void post()
	{
		JSONObject obj=new JSONObject();
		
		obj.put("firstName", "Harshika");
		obj.put("lastName", "K");
		obj.put("SubjectId", "1");
		
		baseURI="http://localhost:3000";
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).body(obj.toJSONString()).
		when().post("/users").
		then().statusCode(201); //201 for successful creation in body
		
	}
	
	//@Test
	public void put()
	{
		JSONObject obj=new JSONObject();
		
		obj.put("firstName", "Manasa");
		obj.put("lastName", "K");
		obj.put("SubjectId", "2");
		
		baseURI="http://localhost:3000";
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).body(obj.toJSONString()).
		when().put("/users/3").
		then().statusCode(200)
		.log().all();
	}
	
	//@Test
	public void patch()
	{
		JSONObject obj=new JSONObject();
		
		obj.put("lastName", "Kuntamalla");
		
		baseURI="http://localhost:3000";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).body(obj.toJSONString()).
		when().
			patch("/users/3").
		then().
			statusCode(200).
			log().all();
		
	}
	
	//@Test
	
		public void delete()
		{
		
		baseURI="http://localhost:3000";
		
		when().
			delete("/subjects/2").
		then().
			statusCode(200).
			log().all();
				
		}
		
		//@Test
		public void postSubjects()
		{
			JSONObject obj=new JSONObject();
			
			obj.put("name", "DataScience");
						
			baseURI="http://localhost:3000";
			given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).body(obj.toJSONString()).
			when().post("/subjects").
			then().statusCode(201); //201 for successful creation in body
			
		}
		
		@Test
		public void putSubjects()
		{
			JSONObject obj=new JSONObject();
			
			obj.put("name", "Manual Testing");
						
			baseURI="http://localhost:3000";
			given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).body(obj.toJSONString()).
			when().put("/subjects/2").
			then().statusCode(200); //201 for successful creation in body
			System.out.println("Put request is completed");
		}
	
	
	
}
