package Exemplos;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import io.restassured.http.ContentType;

public class Auth {
	
	
	public void nãoDeveAcessarSemSenha() {
		
		//baseURI = "https://restapi.wcaquino.me";
		
		given()
			.log().all()
			
			
		.when()
			.get("https://restapi.wcaquino.me/basicauth")
			
		.then()
			.statusCode(401)
			.log().all()
			
			;
	}

	
	public void deveFazerAutenticacao() {
		
		//baseURI = "https://restapi.wcaquino.me";
		
		given()
			.log().all()
			
			
		.when()
			.get("https://admin:senha@restapi.wcaquino.me/basicauth")
			
		.then()
			.statusCode(200)
			.log().all()
			.body("status", is("logado"))
			
			;
	}
	
	
	public void deveFazerAutenticacao2() {
		
		//baseURI = "https://restapi.wcaquino.me";
		
		given()
			.log().all()
			.auth().basic("admin", "senha")
			
			
		.when()
			.get("https://admin:senha@restapi.wcaquino.me/basicauth")
			
		.then()
			.statusCode(200)
			.log().all()
			.body("status", is("logado"))
			
			;
	}
	
	
	public void deveFazerAutenticacaoChallenge() {
		
		//baseURI = "https://restapi.wcaquino.me";
		
		given()
			.log().all()
			.auth().preemptive().basic("admin", "senha")
			
			
		.when()
			.get("https://admin:senha@restapi.wcaquino.me/basicauth2")
			
		.then()
			.statusCode(200)
			.log().all()
			.body("status", is("logado"))
			
			;
	}
	

	public void deveFazerAutenticaçãoComTokenJWT() {
		
		//baseURI = "https://restapi.wcaquino.me";
		
				Map<String, String> login = new HashMap<String, String>();
				login.put("email", "fabiocosta@gmail");
				login.put("senha", "123456");
				
		
				String token = given()
					.log().all()
					.body(login)
					.contentType(ContentType.JSON)
					
					
				.when()
					.post("http://barrigarest.wcaquino.me/signin")
					
				.then()
					.log().all()
					.statusCode(200)
					.extract().path("token");
										
					
			given()
				.log().all()
				.header("Authorization", "JWT " + token)
	
			.when()
				.get("http://barrigarest.wcaquino.me/contas")
				
			.then()
				.log().all()
				.statusCode(200)
				.body("nome", hasItem("conta de teste"))
				.body("id", hasItem(774590))
									
				;
	
	}
	
	@Test
	public void deveAcessarAplicacaoWeb() {
		
		
	given()
		.log().all()
		.formParam("email", "fabiocosta@gmail")
		.formParam("senha", "123456")
		.contentType(ContentType.URLENC.withCharset("UTF-8"))
		

	.when()
		.post("http://seubarriga.wcaquino.me/logar")
		
	.then()
		.log().all()
		//.statusCode(200)
		
							
		;

		
	}
	
}
