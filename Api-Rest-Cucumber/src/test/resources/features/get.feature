#Author: fscosta114@yahoo.com.br

@executa
Feature: Buscar Professional
  Eu como usuario quero validar a busca do professional via api

	Background: Acessar api
		 Given que acesse api get para consultar profissional
  Scenario: Validar status code
  	
   	Then valido o status code de retorno
    
  Scenario: Validar body response estrutura lista campo name
   
   	Then valido o nome "Professional"