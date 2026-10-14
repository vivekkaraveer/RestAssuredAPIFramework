package restassured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

/*given() 
 *      content-type, set cookies, auth, parameters, headers


when()
     get,put,post,patch,delete


then()
       Validate status code, extract response body,extract headers, cookies 
*
*/



public class HTTPMethods {
	
	int id;
	
	//GET Method
	//@Test
	public void getUser() {
		
		
		given()
		
		.when().get("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(200)
		.log().all();
		
			
	}
	
	
	//GET Method
	//@Test
	public void listUsers() {
		
		given()
		
		
		.when().get("https://reqres.in/api/users?page=2")
		
		
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();
		
		
	}
	
    //POST Method
	@Test(priority=1)
	public void createUser() {
		
		
		Map<String,String> data=new HashMap<>();
		data.put("name","Vivek");
		data.put("job", "QA");
		
		
		
		id=given()
		      .contentType("application/json")
		      .body(data)
		
		
		.when()
		      .post("https://reqres.in/api/users")
		      .jsonPath().getInt("id");
		
		
		//.then()
		//      .statusCode(201)
		//      .log().all();
		      
		
	}
	
	//PUT Method
	@Test(priority=2)
	public void updateUser() {
		
		
		Map<String,String> data=new HashMap<>();
		data.put("name","Vivek Karaveer");
		data.put("job", "Automation Tester");
		
		
		given()
		      .contentType("application/json")
		      .body(data)
		
		
		.when()
		      .put("https://reqres.in/api/users/"+id)
		      
		
		
		.then()
		      .statusCode(200)
		      .log().all();
		      
		
	}
	
	//DELETE Method
	@Test(priority=3)
	public void deleteUser() {
		
		
		
		given()
		
		
		.when()
		       .delete("https://reqres.in/api/users/"+id)
		
		
		.then()
		       .statusCode(204)
		       .log().all();
		
		
	}
	
}
