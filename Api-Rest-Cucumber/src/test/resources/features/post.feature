#Author: your.email@your.domain.com

@executa
Feature: Cadastrar Cliente
  Eu como usuario quero cadastrar cliente

    Background: Acessar api
		 Given que eu cadastre um profissional
		 
  Scenario: Cadastrar Profissional
  	When fazer o cadastro
   	Then valido o status code 
  