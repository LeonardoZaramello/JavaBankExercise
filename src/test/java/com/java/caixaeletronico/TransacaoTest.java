package com.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.java.caixaeletronico.Transacao;

@DisplayName("Testes dos métodos da classe Transacao")
class TransacaoTest {


  @Test
  @DisplayName("21 - Testa o método construtor da classe Transacao.")
  void construtorTest() {
    Transacao transacao = new Transacao(35.87, "Transacao teste");

    LocalDateTime dataAgora = LocalDateTime.now();
    DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    assertEquals(transacao.getInstante(), formatadorData.format(dataAgora));
    assertEquals(transacao.getDescricao(), "Transacao teste");
    assertEquals(transacao.getQuantia(), 35.87);
  }


  @Test
  @DisplayName("22 - Testa o método Getter do atributo quantia.")
  void getQuantiaTest() {
    Transacao transacao = new Transacao(356547.98, "Transacao teste");
    assertEquals(transacao.getQuantia(), 356547.98);
  }

  @Test
  @DisplayName("23 - Testa o método retornar resumo transacao.")
  void retornarResumoTransacaoTest() {
    Transacao transacao = new Transacao(35.87, "Transacao teste");
    System.out.println(transacao.retornarResumoTransacao());

  }

  @Test
  @DisplayName("24 - Testa o método instante está gerando o instante corretamente.")
  void retornarInstanteTest() {
    Transacao transacao = new Transacao(35.87, "Transacao teste");

    LocalDateTime dataAgora = LocalDateTime.now();
    DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    assertEquals(transacao.getInstante(), formatadorData.format(dataAgora));
  }

}
