package restassuredTests;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
/* 
 *  given()
 *  when()
 *  then()
 * 
 * 
 */
public class Demo1_GET_Request {
	
	@Test
	public void getPages()
	{

       given()
       .when()
       			.get("https://reqres.in/api/users?page=1")
        .then()
        		.statusCode(200)
        		.statusLine("HTTP/1.1 200 OK")
        		.header("Content-Type","application/json; charset=utf-8")
        		.header("Connection","keep-alive").log().all();
	}
}

	


