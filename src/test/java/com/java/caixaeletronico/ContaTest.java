package com.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

@DisplayName("Teste da classe Conta")
class ContaTest {
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
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Corrente", pessoaCliente, banco);
    Conta conta2 = new Conta("Poupança", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    pessoaCliente.adicionarConta(conta2);
    // banco.adicionarPessoaCliente("Abadiania Silva", "Corrente", "848.725.510-87", "1234");


    assertEquals(conta.getPessoaCliente().getNomeCompleto(), pessoaCliente.getNomeCompleto());
    assertEquals(conta.getPessoaCliente().getCpf(), pessoaCliente.getCpf());
    assertEquals(conta.getPessoaCliente().getSenha(), pessoaCliente.getSenha());
    assertEquals(conta.getPessoaCliente().getContas(), pessoaCliente.getContas());
    assertEquals(2, pessoaCliente.getContas().size());
    assertEquals(2, conta.getPessoaCliente().getContas().size());
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Corrente", pessoaCliente, banco);

    conta.adicionarTransacao(98.23, "deposito");
    conta.adicionarTransacao(-58.23, "saque");

    assertEquals(40.0, conta.retornarSaldo());
  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Corrente", pessoaCliente, banco);
    conta.adicionarTransacao(98.23, "deposito");
    conta.adicionarTransacao(-58.23, "saque");

    assertTrue(conta.retornarResumoConta().contains("Tipo da conta: " + conta.getTipoConta()));
    assertTrue(conta.retornarResumoConta().contains("Número da conta: " + conta.getIdConta()));
    assertTrue(conta.retornarResumoConta().contains("Saldo: " + conta.retornarSaldo()));
  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Corrente", pessoaCliente, banco);

    conta.adicionarTransacao(98.23, "deposito");
    conta.adicionarTransacao(-58.23, "saque");
    conta.retornarExtrato();

    String retorno = outputStreamCaptor.toString().strip();

    assertTrue(retorno.contains("Quantia:"));
    assertTrue(retorno.contains("Descricao:"));
    assertTrue(retorno.contains("Data:"));

  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Corrente", pessoaCliente, banco);

    assertEquals(10, conta.getIdConta().length());
  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    Conta conta = new Conta("Corrente", pessoaCliente, banco);

    assertEquals(pessoaCliente, conta.getPessoaCliente());
  }
}
