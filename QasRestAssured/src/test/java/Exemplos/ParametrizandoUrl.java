package Exemplos;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ParametrizandoUrl {
	
	
	public void deveCustomizarUrl() {
		
		//baseURI = "https://restapi.wcaquino.me";
		
		given()
			.log().all()
			.contentType("application/json")
			.body("{ \"name\" : \"fabio\", \"age\": 40}")
			
			
		.when()
			.put("https://restapi.wcaquino.me/{entidade}/{userId}", "users","1")
			
		.then()
			.statusCode(200)
			.log().all()
			.body("id", is(1))
			.body("name", is("fabio"))
			.body("age", is(40))
			.body("salary", is(1234.5678f))
			;
	}
	
	@Test
	public void deveCustomizarUrlParte2() {
		
		//baseURI = "https://restapi.wcaquino.me";
		
		given()
			.log().all()
			.contentType("application/json")
			.body("{ \"name\" : \"fabio\", \"age\": 40}")
			.pathParam("entidade", "users")
			.pathParam("userId", 1)
			
		.when()
			.put("https://restapi.wcaquino.me/{entidade}/{userId}", "users","1")
			
		.then()
			.statusCode(200)
			.log().all()
			.body("id", is(1))
			.body("name", is("fabio"))
			.body("age", is(40))
			.body("salary", is(1234.5678f))
			;
	}

}
