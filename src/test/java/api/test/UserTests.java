package api.test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userPayload;
	int userid;
	
	@BeforeClass
	public void setup() {
		
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setName("STAD");
		userPayload.setJob("Trainer");
		userPayload.setCountry(faker.address().country());
		userPayload.setCity(faker.address().cityName());
		
	}
	
	/*
	 * //POST Method //@Test(priority=1) public void testPostUser() {
	 * 
	 * Response response=UserEndPoints.testPostRequestUsingPOJO(userPayload);
	 * 
	 * response.then().log().all();
	 * 
	 * Assert.assertEquals(response.getStatusCode(), 201); }
	 */
	
	//POST Method
	@Test(priority=1)
	public void testPostUserWithReturnId() {
		
		userid=UserEndPoints.testPostRequestWithReturnId(userPayload);
		
		
	}
	
	//PUT Method
	@Test(priority=2)
	public void updateUser() {
		
		userPayload.setName("New Stad");
		userPayload.setJob("New Trainer");
		
		
		Response response=UserEndPoints.testPutRequest(userPayload,String.valueOf(userid));
		
		response.then().log().all();
		
		 
		
	}

}
