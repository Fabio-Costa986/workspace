package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiGet;

public class ApiGetTest {

	ApiGet apiget = new ApiGet();

	@Given("que acesse api get para consultar profissional")
	public void que_acesse_api_get_para_consultar_profissional() {
		apiget.acessarApi("https://api.trello.com/1/action/592f11060f95a3d3d46a987a/data");

	}

	@Then("valido o status code de retorno")
	public void valido_o_status_code_de_retorno() {

		apiget.statusCode(200);

	}

	@Then("valido o nome {string}")
	public void valido_o_nome(String texto) {

		apiget.body(texto);

	}

}
