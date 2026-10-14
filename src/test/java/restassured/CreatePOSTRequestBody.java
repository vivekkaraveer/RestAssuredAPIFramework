package restassured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class CreatePOSTRequestBody {
	
	int id;
	
	//POST Request Using POJO
	@Test(priority=1)
	public void testPostRequestUsingPOJO() {
		
		POJOClassTest data=new POJOClassTest();
		
		data.setName("VivekK");
		data.setJob("Trainer");
		data.setCountry("India");
		data.setCity("Bangalore");
		
		given()
		      .contentType("application/json")
		      .body(data)
		
		
	   .when()
		      .post("https://reqres.in/api/users")
		      //.jsonPath().getInt("id");
		
		
		.then()
		      .statusCode(201)
		      .body("job", equalTo("Trainer"))
		      .body("city", equalTo("Bangalore"))
		      .log().all();
		
		
		
		
	}
	
	//DELETE Method
	@Test(priority=2)
	public void deleteUser() {
		
		
		
		given()
		
		
		.when()
		       .delete("https://reqres.in/api/users/"+id)
		
		
		.then()
		       .statusCode(204)
		       .log().all();
		
		
	}

}
