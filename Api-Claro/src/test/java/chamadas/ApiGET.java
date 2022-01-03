package chamadas;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers. *;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiGET {

	@Test
	public void buscarCep() {
		
		baseURI = "https://clarogateway.flexprd.aws.clarobrasil.mobi";
		
		given()
		    .log().all()			
			.header("accept-language", "pt-BR")
			.header("Content-Type", "application/json")
			.header("true-client-ip", "192.141.103.153")
			.header("x-application-id", "flex")
			.header("x-application-key", "553d7640aae601353d75000d3ac06d76")
			.header("x-channel-id", "fb1c289c-5513-4d43-9f38-ed87850a3990")
			.header("x-organization-slug", "claro")
			.header("Cookie", "dtCookie=30$60DF2F43FD851F5327B0F88FEA9E07D7|ea7c4b59f27d43eb|1")
			.header("via", "HTTPS/1.1 ECD (spb/E517)")
			
		.when()
			.get("/ext-application/v1/address/zip-code/01020011")
			
		.then()
		    .log().all()
			.statusCode(200)
			.body("content.zipCode", is("01020010"))
			.body("content.streetName", is("DAS CARMELITAS"))
			
			;
	}
	

}
