package restassured;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetCookiesTest {
	
	//https://reqres.in/api/users?page=2&per_page=5
	
	@Test
	public void getHeadersAndCookiesTest() {
		
		
		
		Response response=given()
		      
		
		.when()
		      .get("https://www.google.com/");
		
		
		String headerValue=response.getHeader("Content-Type");
		System.out.println(headerValue);
		Assert.assertTrue(headerValue.equals("text/html; charset=ISO-8859-1"));
		
		
		String cookieValue=response.getCookie("AEC");
		System.out.println(cookieValue);
		
		
		
		//.then()
		//    .statusCode(200)
		//    .header("Content-Type", "application/json; charset=utf-8")
		//    .header("Transfer-Encoding", "chunked")
		//    .log().all();
		
	}

}
