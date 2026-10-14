package api.endpoints;

import org.testng.annotations.Test;

import api.payload.User;
import io.restassured.response.Response;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class UserEndPoints {
	
	
	
    int id;
	
	//POST Request Using POJO
	
	public static Response testPostRequestUsingPOJO(User payload) {
		
		
		Response response=given()
		      .contentType("application/json")
		      .body(payload)
		
		
	   .when()
		      .post(Routes.post_url);
		      
		
		return response;
		
		
	}
	
    public static int testPostRequestWithReturnId(User payload) {
		
		
		int id=given()
		      .contentType("application/json")
		      .body(payload)
		
		
	   .when()
		      .post(Routes.post_url)
		      .jsonPath().getInt("id");
		      
		
		
		return id;
		
	}
	
	//Update user-Put request
   public static Response testPutRequest(User payload,String userId) {
		
		
		Response response=given()
		      .contentType("application/json")
		      .pathParam("userid", userId)
		      .body(payload)
		
		
	   .when()
		      .put(Routes.put_url);
		      
		
		return response;
		
		
	}

}
