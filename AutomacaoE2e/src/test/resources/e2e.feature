#Author: fcosta_zo@yahoo.com.br


Feature: Pesquisar no google
  Eu como usuario quero acessar o site para realizar pesquisa

  
  Scenario: Pesquisar o nome da escola no google
    Given que eu esteja no "https://www.google.com.br"
    When pesquisar o nome da escola
    Then valido as informacoes
    

 
