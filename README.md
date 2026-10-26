# BugBank - Automação Web (TQS)

Automação Selenium + JUnit 5 + Java 21 (ou superior) do site https://bugbank.netlify.app/

## Fluxo testado

1. Cadastrar duas contas com saldo: Adriane (origem) e Fran (destino)
2. Acessar a conta da Adriane e transferir R$ 150,00 para a Fran, com a descrição "valor para ganhar A na aula"
3. Validar no extrato da Adriane o saldo (R$ 850,00) e a transferência enviada
4. Acessar a conta da Fran e validar no extrato o saldo (R$ 1.150,00) e o recibo da transferência recebida

## Estrutura

- `Framework`: `TestBase`, `DriverManager` e `TypeBrowser` (abertura e fechamento do navegador)
- `PageObjects`: mapeamento dos elementos de cada tela
- `Tasks`: ações do usuário em cada tela
- `Validacao`: asserts
- `TestCases`: `RealizarTransferenciaComSucessoTest`

## Como rodar

Pelo terminal, com o Maven instalado:

```
mvn test
```

Ou pelo VS Code (Extension Pack for Java): abra a classe `RealizarTransferenciaComSucessoTest` e clique em **Run Test** ao lado do método `realizarTransferencia`.