package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import metodos.GetApi;

public class Steps {

	GetApi apiget = new GetApi();

@Given("que acesse api get para consultar profissional")
public void que_acesse_api_get_para_consultar_profissional() {
	apiget.acessarApi("https://reqres.in/api/users?page=2");
}

@Then("valido o status code de retorno")
public void valido_o_status_code_de_retorno() {
   apiget.statusCode(200);
}

@Then("valido o email {string}")
public void valido_o_email(String texto) {
	apiget.body(texto);
    
}

	
}
