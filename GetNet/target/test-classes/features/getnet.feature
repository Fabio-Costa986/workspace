#Author: your.email@your.domain.com

@execucao
Feature: Buscar Professional
  Eu como usuario quero validar a busca do professional via api

	Background: Acessar api
		 Given que acesse api get para consultar profissional
  Scenario: Validar status code
  	
   	Then valido o status code de retorno
    
  Scenario: Validar body response estrutura lista campo email
   
   	Then valido o email "michael.lawson@reqres.in"