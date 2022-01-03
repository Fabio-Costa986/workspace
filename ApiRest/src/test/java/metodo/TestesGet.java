package metodo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import java.util.regex.Matcher;

import org.hamcrest.Matchers;
import org.junit.Test;

public class TestesGet {
	
	@Test
	public void testesGet() {
		
		baseURI = "https://reqres.in/";
		
		given().log().all()
			.contentType("application/json")
			
		.when()
			.get("api/users?page=2")
			
		.then()
			.statusCode(200)
			.log().all()
			
			;
	}
	

}


