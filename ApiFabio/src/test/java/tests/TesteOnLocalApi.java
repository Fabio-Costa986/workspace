package tests;

import org.json.simple.JSONObject;
import org.junit.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class TesteOnLocalApi {
	@Test
	public void get() {
		
		baseURI = "http://localhost:3000";
		
		given().get("/users").then().statusCode(200).log().all();
		
	}

	@Test
	public void Post() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Francielle");
		request.put("lastName", "Felix");
		request.put("subjectid", 1);
		
		given()
			.contentType(ContentType.JSON).accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			
		;
	}
	
	
}
