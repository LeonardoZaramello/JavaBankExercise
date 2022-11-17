package com.java.caixaeletronico;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.java.caixaeletronico.Banco;
import com.java.caixaeletronico.Conta;
import com.java.caixaeletronico.PessoaCliente;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {

  // https://www.baeldung.com/java-testing-system-out-println
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }


  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {
    PessoaCliente pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");

    assertEquals("Alexiania Pereira", pessoaCliente.getNomeCompleto());
    assertEquals("842.074.410-77", pessoaCliente.getCpf());
    assertEquals("1234", pessoaCliente.getSenha());
    assertEquals("Nova pessoa cliente Alexiania Pereira com CPF: 842.074.410-77 criada!",
        outputStreamCaptor.toString().trim());
  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Corrente", pessoaCliente, banco);

    pessoaCliente.adicionarConta(conta);
    assertEquals(1, pessoaCliente.retornaNumeroDeContas());

    Conta conta2 = new Conta("Poupança", pessoaCliente, banco);

    pessoaCliente.adicionarConta(conta2);
    assertEquals(2, pessoaCliente.retornaNumeroDeContas());
  }

  @Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Corrente", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    Conta conta2 = new Conta("Poupanca", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta2);

    assertEquals(0, pessoaCliente.retornarSaldoContaEspecifica(0));
    assertEquals(0, pessoaCliente.retornarSaldoContaEspecifica(1));
  }


  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Corrente", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    Conta conta2 = new Conta("Poupanca", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta2);


    assertEquals(conta.getPessoaCliente().getContas().get(1).getIdConta(),
        pessoaCliente.retornarIdContaEspecifica(1));

    assertNotEquals(conta.getPessoaCliente().getContas().get(0).getIdConta(),
        pessoaCliente.retornarIdContaEspecifica(1));
    assertNotEquals(conta.getPessoaCliente().getContas().get(1).getIdConta(),
        pessoaCliente.retornarIdContaEspecifica(0));
  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Corrente", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    Conta conta2 = new Conta("Poupanca", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta2);

    pessoaCliente.adicionarTransacaoContaEspecifica(1, 1325, "Deposito");
    pessoaCliente.retornarExtratoContaEspecifica(1);


    assertTrue(outputStreamCaptor.toString().contains("Data:"));
    assertTrue(outputStreamCaptor.toString().contains("Quantia: 1325"));
    assertTrue(outputStreamCaptor.toString().contains("Descricao: Deposito"));
  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Corrente", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    Conta conta2 = new Conta("Poupanca", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta2);

    pessoaCliente.adicionarTransacaoContaEspecifica(1, 1325, "Deposito");
    pessoaCliente.adicionarTransacaoContaEspecifica(0, 756, "Deposito");
    assertEquals(1325, pessoaCliente.retornarSaldoContaEspecifica(1));
    assertEquals(756, pessoaCliente.retornarSaldoContaEspecifica(0));

  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    PessoaCliente pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");

    assertTrue(pessoaCliente.validarSenha(pessoaCliente.getSenha()));
    assertTrue(pessoaCliente.validarSenha("1234"));
    assertFalse(pessoaCliente.validarSenha("12345"));
  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Corrente", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    Conta conta2 = new Conta("Poupanca", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta2);

    pessoaCliente.adicionarTransacaoContaEspecifica(1, 1325, "Deposito");
    pessoaCliente.adicionarTransacaoContaEspecifica(0, -756, "Saque");
    pessoaCliente.retornarResumoContas();

    assertTrue(outputStreamCaptor.toString().contains("Tipo da conta: Corrente"));
    assertTrue(outputStreamCaptor.toString().contains("Número da conta: " + conta.getIdConta()));
    assertTrue(outputStreamCaptor.toString().contains("Saldo: 1325"));
    assertTrue(outputStreamCaptor.toString().contains("Tipo da conta: Poupanca"));
    assertTrue(outputStreamCaptor.toString().contains("Número da conta: " + conta2.getIdConta()));
    assertTrue(outputStreamCaptor.toString().contains("Saldo: -756"));
  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    PessoaCliente pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");

    assertEquals("842.074.410-77", pessoaCliente.getCpf());
    assertNotEquals("1234", pessoaCliente.getCpf());
  }
}
