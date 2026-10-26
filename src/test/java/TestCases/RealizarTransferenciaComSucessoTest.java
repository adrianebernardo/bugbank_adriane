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
    private static final String DESCRICAO = "valor para ganhar A na aula";

    // Tempo de espera entre os passos, em milissegundos
    private static final long PAUSA = 1500;

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

    private void pausar(long milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // O BugBank guarda os dados só no navegador, então todo o fluxo roda em um único teste
    @Test
    public void realizarTransferencia() {
        String emailOrigem = "adrianemitinha@bugbank.com";
        String emailDestino = "melhorprofdeteste@bugbank.com";

        pausar(PAUSA);

        // 1 e 2) Cadastra as duas contas, ambas com saldo
        cadastroTask.cadastrarContaComSaldo(emailOrigem, "Adriane", SENHA);
        pausar(PAUSA);
        String[] contaDestino = cadastroTask.cadastrarContaComSaldo(emailDestino, "Fran", SENHA);
        pausar(PAUSA);

        // 3) Acessa a conta de origem e transfere
        loginTask.efetuarLogin(emailOrigem, SENHA, SALDO_INICIAL);
        pausar(PAUSA);
        transferenciaTask.realizarTransferencia(contaDestino, VALOR_TRANSFERENCIA, DESCRICAO);
        pausar(PAUSA);

        // 4) Valida o extrato da conta que enviou o valor
        extratoTask.validarExtrato(SALDO_INICIAL - VALOR_TRANSFERENCIA, DESCRICAO);
        pausar(PAUSA);

        // 5) Fran acessa a conta e mostra o recibo recebido da Adriane
        loginTask.efetuarLogin(emailDestino, SENHA, SALDO_INICIAL + VALOR_TRANSFERENCIA);
        pausar(PAUSA);
        extratoTask.validarExtrato(SALDO_INICIAL + VALOR_TRANSFERENCIA, DESCRICAO);
    }
}