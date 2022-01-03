package metodo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class TestePost {

	
	public void cadastro() {

		String url = "https://api.thecatapi.com/v1/user/passwordlesssignup";
		String corpo = "{\"email\": \"fcosta@mil.com\", \"appDescription\": \"teste the cat api\"}";

		given().log().all()
			.contentType("application/json")
			.body(corpo)
		.when()
			.post(url)
		.then().log().all()
			.statusCode(201)
			.body("message", containsString("SUCCESS"))
			.body("id", is(304888))
		;

		
		
	}

	
	@Test
	public void votação() {

		String url = "https://api.thecatapi.com/v1/votes/";
		String corpo = ("{\"image_id\": \"jOi3sh9Ct\", \"value\": \"true\", \"sub_id\": \"demo-975133\"}");

	
				given().log().all()
					.contentType("application/json")
					.body(corpo)
				.when()
					.post(url)
				.then().log().all()
					.statusCode(200)
					.body("message", containsString("SUCCESS"));
		
				
		
		

		
		
	}
}
