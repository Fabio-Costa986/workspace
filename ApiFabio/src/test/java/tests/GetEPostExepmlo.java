package tests;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.nio.channels.AcceptPendingException;
import java.util.HashMap;
import java.util.Map;

public class GetEPostExepmlo {
	
	
	
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
	
	
	public void testPost() {
		
		//Map<String, Object> map = new HashMap<String, Object>();
		
		//map.put("name", "Raghav");
		//map.put("job", "Teacher");
		//System.out.println(map);
		
		JSONObject request = new JSONObject();
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all()
			
		
		
		
		
		;
		
	}
	
		@Test
		public void testeGetClaro() {
		
		baseURI = "https://clarogateway.flexdev.aws.clarobrasil.mobi";
		
		given()
			.log().all()
			.contentType(ContentType.JSON)
			.queryParam("x-application-key", "94123330f9470134bcbb021e75abe44c")
			.queryParam("x-application-id", "ac76a7739985cdacad94eecd7f04ff64a97e0e93")
			.queryParam("x-organization-slug", "claro")
			.queryParam("x-channel-id", "6062f134-b4b1-41db-98ad-c3b289fed970")
			.pathParam("zipCode", "38081230")
		
			
			
		.when()
			.get("/ext-application/v1/address/zip-code/:zipCode")
			
		.then()
			.statusCode(200)
			.log().all()
			;
	}
		
		
		@Test
		public void testePost() {
			
			//Map<String, Object> map = new HashMap<String, Object>();
			
			//map.put("name", "Raghav");
			//map.put("job", "Teacher");
			//System.out.println(map);
			
			JSONObject request = new JSONObject();
			request.put("password", "985130fa*");
			request.put("uid", "fscosta114@gmail.com");
			
			System.out.println(request.toJSONString());
			
			baseURI = "https://clarogateway.flexdev.aws.clarobrasil.mobi";
			
			given().log().all()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString())
			.when()
				.post("/rw-middleware/v1/auth")
			.then()
				.statusCode(201)
				.log().all()
				
			
			
			
			
			;
			
		}
		
	
		public void testeGetClaroPublico() {
			
			baseURI = "https://clarogateway.flexdev.aws.clarobrasil.mobi";
					
			
			given()
				.log().all()
				.contentType("application/json")
				.queryParam("type", "JOIN")
				.queryParam("status", "OPENED")
				
			
			.when()
				.get("/rw-middleware/v1/cart-id")
				
			.then()
				.statusCode(200)
				.log().all()
				;
		}
		
		
	
}


