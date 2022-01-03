package Exemplos;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AuthTest {
	
	@Test
	public void deveBucarCep() {
		
		given()
			.log().all()
			//.accept(ContentType.JSON)
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
			.get("https://clarogateway.flexprd.aws.clarobrasil.mobi/ext-application/v1/address/zip-code/06213120?")
		.then()
			.log().all()
			.statusCode(200)
			.body("zip-code", is("06213120"))
			
		
		;
	}

	
	public void deveObterClimaApiChaveGEOGRAFICO() {
		
		given()
			.log().all()
			.queryParam("q", "Osasco,BR")
			.queryParam("appid", "050c10d7156c196a31c7d7d82780d816")
			.queryParam("units", "metric")
			.queryParam("lat", "-23.5325")
			.queryParam("lon", "-46.7917")
				
		.when()
			.get("http://api.openweathermap.org/data/2.5/weather")
		.then()
			.log().all()
			.statusCode(200)
			.body("name", is("Osasco"))
			.body("coord.lon", is(-46.7917f))
			
			
			
		
		;
	}

}
