package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.http.ContentType;

public class PuteDeleteExemplos {
	
public void testeGet() {
		
		baseURI = "https://reqres.in/api";
		
		given()
			.get("users?page=2")
		.then()
			.statusCode(200)
			.body("data[4].first_name", equalTo("George"))
			.body("data.first_name", hasItems("George", "Rachel"))
			.log().all()
			;
	}
	
	@Test
	public void testPut() {
		
		
		
		JSONObject request = new JSONObject();
		request.put("name", "Raghav");
		request.put("job", "Jogadora");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("/users/2")
		.then()
			.statusCode(200)
			.log().all()
			
		
		
		
		
		;
		
	}

	
	

	public void testDelete() {
		
		
		baseURI = "https://reqres.in/api";
		
		given()
			
		.when()
			.delete("/users/2")
		.then()
			.statusCode(204)
			.log().all()
			
		
		
		
		
		;
		
	}

}
