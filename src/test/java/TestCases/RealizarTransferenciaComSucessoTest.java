package TestCases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import Framework.TestBase;
import Tasks.CadastroTask;
import Tasks.ExtratoTask;
import Tasks.LoginTask;
import Tasks.TransferenciaTask;

public class RealizarTransferenciaComSucessoTest extends TestBase {

    private static final String SENHA = "Senha@123";
    private static final double SALDO_INICIAL = 1000.00;
    private static final double VALOR_TRANSFERENCIA = 150.00;

    private WebDriver driver;
    private CadastroTask cadastroTask;
    private LoginTask loginTask;
    private TransferenciaTask transferenciaTask;
    private ExtratoTask extratoTask;

    @BeforeEach
    public void setUpTasks() {
        driver = getDriverManager();
        cadastroTask = new CadastroTask(driver);
        loginTask = new LoginTask(driver);
        transferenciaTask = new TransferenciaTask(driver);
        extratoTask = new ExtratoTask(driver);
    }

    // O BugBank guarda os dados só no navegador, então todo o fluxo roda em um único teste
    @Test
    public void realizarTransferencia() {
        long id = System.currentTimeMillis();
        String emailOrigem = "origem" + id + "@bugbank.com";
        String emailDestino = "destino" + id + "@bugbank.com";
        String descricao = "Transferencia TQS " + id;

        // 1 e 2) Cadastra as duas contas, ambas com saldo
        cadastroTask.cadastrarContaComSaldo(emailOrigem, "Conta Origem", SENHA);
        String[] contaDestino = cadastroTask.cadastrarContaComSaldo(emailDestino, "Conta Destino", SENHA);

        // 3) Acessa a conta de origem e transfere
        loginTask.efetuarLogin(emailOrigem, SENHA, SALDO_INICIAL);
        transferenciaTask.realizarTransferencia(contaDestino, VALOR_TRANSFERENCIA, descricao);

        // 4) Valida o extrato da conta que enviou o valor
        extratoTask.validarExtrato(SALDO_INICIAL - VALOR_TRANSFERENCIA, descricao);

        // 5) Valida o extrato da conta que recebeu o valor
        loginTask.efetuarLogin(emailDestino, SENHA, SALDO_INICIAL + VALOR_TRANSFERENCIA);
        extratoTask.validarExtrato(SALDO_INICIAL + VALOR_TRANSFERENCIA, descricao);
    }
}
