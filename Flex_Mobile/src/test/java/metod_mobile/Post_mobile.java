package metod_mobile;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post_mobile {
	
	
	
	Response response;
	
	public Response acessarApi(String uri) {
		
		response = RestAssured.get(uri);
		
		return response;
		
	}
	
	
	public void cadastrar() {
		
		//Map<String, Object> map = new HashMap<String, Object>();
		
		//map.put("name", "Raghav");
		//map.put("job", "Teacher");
		//System.out.println(map);
		
		JSONObject request = new JSONObject();
		request.put("name", "Bonzo");
		request.put("birthDate", "03-04-1992");
		request.put("cpfCnpj", "30550944842");
		request.put("emailAddresses", "bonzo234@zeppelin.com.br");
		request.put("subscriptionType", "POS");
		request.put("msisdn", "11957311180");
		request.put("username", "30550944842");
		request.put("password", "secret");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://dev-claro-flex-bff-idm.clarobrasil.mobi/rw-middleware";
		
		given()
			.log().all()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("/v1/mobileusers")
		.then()
			.log().all()
			.statusCode(200)
			.body("name", is("Bonzo"))
			
			
			
		
		
		
		
		;
		
	}

}
