package restassured;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ParsingJSONResponse {
	
	
	@Test
	public void parseJSONResponseTest() {
		
		
		Response resp=given()
		                     .contentType(ContentType.JSON)
		
		
		               .when()
		                      .get("https://mocki.io/v1/5bd0e59b-ac0b-4932-a4c4-2f738477a116");
		
	
		JSONObject jo=new JSONObject(resp.asString()); //Converting response to JSON object
		
		//1. Print all the book titles
		for(int i=0;i<jo.getJSONArray("book").length();i++) {
			
			String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			
			System.out.println(bookTitle);
			
		}
		
		//2. Print total price in the console
		
		double totalPrice=0;
		
        for(int i=0;i<jo.getJSONArray("book").length();i++) {
			
			String bookPrice=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			
			totalPrice=totalPrice+ Double.parseDouble(bookPrice);
			
		}
        
        System.out.println("Total price of books is: "+totalPrice);
        
        //3.Verify whether a book with title 'The Lord of the Rings' is available in JSON response
		
	}

}
