package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestsExemplo {
	
	@Test
	public void teste_1() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println("O tempo de resposta foi: " + response.getTime());
		System.out.println("O retorno do status code é: " + response.getStatusCode());
		System.out.println(response.body().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statuscode = response.getStatusCode();
		assertEquals(statuscode,200);
	}
	
	@Test
	public void teste_2() {
		
		baseURI = "https://reqres.in/api";
		given().get("users?page=2")
		.then()
		.statusCode(200)
		.body("data[1].id", equalTo(8))
		.log().all();
		
	}

}
