package restassured;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import tools.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class SerializationAndDeserialization {
	
	
	//Serialization---> POJO To Json
	@Test
	public void pojoToJson() {
		
        POJOClassTest data=new POJOClassTest(); 
		
        Faker faker=new Faker();
       
		data.setName(faker.name().firstName());
		data.setJob(faker.job().toString());
		data.setCountry(faker.address().country());
		data.setCity(faker.address().cityName());
		
		ObjectMapper objMapper=new ObjectMapper();
		
		String jsonData=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		
		System.out.println(jsonData);
		
		
	}
	
	
	//De-Serialization--->  Json to POJO
	@Test
	public void jsonToPojo() {
		
		
		/*
		 * String jsonData="{\r\n" + "  \"city\" : \"East Spencerville\",\r\n" +
		 * "  \"country\" : \"Netherlands\",\r\n" +
		 * "  \"job\" : \"com.github.javafaker.Job@96a75da\",\r\n" +
		 * "  \"name\" : \"Isis\"\r\n" + "}";
		 */
		
		File file=new File("src/test/resources/testData.json");
		
		ObjectMapper objMapper=new ObjectMapper();
		
		POJOClassTest data=objMapper.readValue(file, POJOClassTest.class);
		
		System.out.println("Name is: "+data.getName());
		System.out.println("Job is: "+data.getJob());
		System.out.println("Country is: "+data.getCountry());
		System.out.println("City is: "+data.getCity());
		
	}

}
