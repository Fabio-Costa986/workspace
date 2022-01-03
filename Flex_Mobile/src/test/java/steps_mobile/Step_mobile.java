package steps_mobile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import metod_mobile.Post_mobile;

public class Step_mobile {
	
	
	Post_mobile apimobile = new Post_mobile();
	
	@Given("que eu acessar a API")
	public void que_eu_acessar_a_api() {
		
		 apimobile.acessarApi("https://dev-claro-flex-bff-idm.clarobrasil.mobi/rw-middleware");
	}

	@Then("valido o status code")
	public void valido_o_status_code() {
		 apimobile.cadastrar();
		
		
	}

	

}
