package chamadas;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.http.ContentType;

public class ApiPost {
	
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
		
		;

	}

	
	public void cadastroZUP() {

		String url = "https://claro.gateway.zup.me/rw-middleware/v1/acquisition";
		String corpo = "{\"email\": \"fcosta@mil.com\", \"senha\": \"12345\"}";
	
	given().log().all()
		.contentType("application/json")
		.body(corpo)
	.when()
		.post(url)
	.then().log().all()
		.statusCode(201)
		
		;

	}

	@Test
	public void testePostZup() {
		
		//Map<String, Object> map = new HashMap<String, Object>();
		
		//map.put("name", "Raghav");
		//map.put("job", "Teacher");
		//System.out.println(map);
		
		JSONObject request = new JSONObject();
		request.put("city", "SANTOS");
		request.put("country", "BR");
		request.put("district", "PONTA DA PRAIA");
		request.put("name", "Principal");
		request.put("number", "00000");
		request.put("state", "SP");
		request.put("street", "DONA MARIA MAXIMO");
		request.put("zipCode", "11030100");
		
		System.out.println(request.toJSONString());
		
		String url = "https://claro.gateway.zup.me/rw-middleware/v1/acquisition";
		
		given().log().all()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post(url)
		.then()
			.statusCode(201)
			.log().all()
			
		
		
		
		
		;
		
	}
	
	
}

