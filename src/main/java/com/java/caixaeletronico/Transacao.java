package com.java.caixaeletronico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
  double quantia;
  String instante;
  String descricao;
  Conta conta;

  /**
   * Metodo Construtor da Transacao.
   **/
  public Transacao(double quantia, String descricao) {
    super();
    this.quantia = quantia;
    this.instante = retornarInstante();
    this.descricao = descricao;
  }

  private String retornarInstante() {
    // TODO Auto-generated method stub
    LocalDateTime dataAgora = LocalDateTime.now();
    DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    return formatadorData.format(dataAgora);
  }

  /**
   * Metodo para pegar os detalhes da transacao.
   **/
  public String retornarResumoTransacao() {
    String resumoTransacao =
        "Data: " + instante + "\nQuantia: " + quantia + "\nDescricao: " + descricao;
    return resumoTransacao;
  }

  public double getQuantia() {
    return quantia;
  }

  public void setQuantia(double quantia) {
    this.quantia = quantia;
  }

  public String getInstante() {
    return instante;
  }

  public void setInstante(String instante) {
    this.instante = instante;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

}

