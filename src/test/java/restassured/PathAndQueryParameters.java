package restassured;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameters {
	
	//https://reqres.in/api/users?page=2&per_page=5
	
	@Test
	public void testPathAndQueryParameters() {
		
		
		
		given()
		      .pathParam("path1", "api")
		      .pathParam("path2", "users")
		      .queryParam("page", 2)
		      .queryParam("per_page", 5)
		
		
		.when()
		      .get("https://reqres.in/{path1}/{path2}")
		
		
		.then()
		    .statusCode(200)
		    .log().all();
		
	}

}
