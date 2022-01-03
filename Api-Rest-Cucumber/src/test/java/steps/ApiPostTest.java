package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApiPost;

public class ApiPostTest {
	
	ApiPost apipost = new ApiPost();
	
	@Given("que eu cadastre um profissional")
	public void que_eu_cadastre_um_profissional() {
		
		apipost.acessarApi("https://api.trello.com/1/action/592f11060f95a3d3d46a987a/data");
	    
	}
	
	@When("fazer o cadastro")
	public void fazer_o_cadastro() {
		apipost.empregadoCadastrar();
	   
	}

	@Then("valido o status code")
	public void valido_o_status_code() {
		apipost.statusCode(201);
	   
	}


}
