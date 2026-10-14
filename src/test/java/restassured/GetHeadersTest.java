package restassured;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetHeadersTest {
	
	//https://reqres.in/api/users?page=2&per_page=5
	
	@Test
	public void testPathAndQueryParameters() {
		
		
		
		Response response=given()
		      .pathParam("path1", "api")
		      .pathParam("path2", "users")
		      .queryParam("page", 2)
		      .queryParam("per_page", 5)
		
		
		.when()
		      .get("https://reqres.in/{path1}/{path2}");
		
		
		String headerValue=response.getHeader("Content-Type");
		Assert.assertTrue(headerValue.equals("application/json; charset=utf-8"));
		
		
		
		
		//.then()
		//    .statusCode(200)
		//    .header("Content-Type", "application/json; charset=utf-8")
		//    .header("Transfer-Encoding", "chunked")
		//    .log().all();
		
	}
	
}