package com.java.caixaeletronico;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.java.caixaeletronico.Banco;
import com.java.caixaeletronico.PessoaCliente;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    Banco banco = new Banco();
    String response = banco.gerarNumeroNovaConta();

    assertEquals(10, response.length());
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    Banco banco = new Banco();
    PessoaCliente response =
        banco.adicionarPessoaCliente("Alexiania Pereira", "Corrente", "842.074.410-77", "1234");
    PessoaCliente expected = new PessoaCliente("Abadiania Silva", "848.725.510-87", "1234");

    assertEquals(expected.getClass(), response.getClass());
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    Banco banco = new Banco();
    banco.adicionarPessoaCliente("Alexiania Pereira", "Corrente", "842.074.410-77", "1234");
    PessoaCliente pessoaCliente = banco.pessoaClienteLogin("842.074.410-77", "1234");

    assertTrue(pessoaCliente != null);
  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    fail("Não implementado");
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    fail("Não implementado");

  }

}
