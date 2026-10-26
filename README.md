# BugBank - Automação Web (TQS)

Automação Selenium + JUnit 5 + Java 25 do site https://bugbank.netlify.app/

Fluxo testado: cadastrar duas contas com saldo, transferir de uma para a outra e validar o extrato (saldo e transferência) das duas contas.

## Estrutura

- `Framework`: `TestBase`, `DriverManager` e `TypeBrowser` (abertura e fechamento do navegador)
- `PageObjects`: mapeamento dos elementos de cada tela
- `Tasks`: ações do usuário em cada tela
- `Validacao`: asserts
- `TestCases`: `RealizarTransferenciaComSucessoTest`

## Como rodar

```
mvn test
```
