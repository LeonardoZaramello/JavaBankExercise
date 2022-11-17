package com.java.caixaeletronico;

import java.util.ArrayList;

public class Conta {

  String tipoConta;
  String idConta;
  PessoaCliente pessoaCliente;
  ArrayList<Transacao> transacoes = new ArrayList<Transacao>();

  /**
   * Metodo Construtor da Conta.
   **/
  public Conta(String tipoConta, PessoaCliente pessoaCliente, Banco banco) {
    super();
    this.tipoConta = tipoConta;
    this.pessoaCliente = pessoaCliente;
    this.idConta = banco.gerarNumeroNovaConta();
  }

  public void adicionarTransacao(double quantia, String descricao) {
    Transacao transacao = new Transacao(quantia, descricao);
    transacoes.add(transacao);
  }

  /**
   * Metodo para retornar o saldo do cliente.
   **/
  public double retornarSaldo() {
    double saldo = 0;
    for (Transacao transacao : transacoes) {
      saldo = saldo + transacao.getQuantia();
    }

    return Math.round(saldo);
  }


  /**
   * Metodo para retornar o extrato do cliente.
   **/
  public void retornarExtrato() {
    for (Transacao transacao : transacoes) {
      System.out.println(transacao.retornarResumoTransacao());
    }
  }

  /**
   * Metodo para pegar os detalhes das transacoes da conta.
   **/
  public String retornarResumoConta() {
    String resumoTransacao = "Tipo da conta: " + tipoConta + "\nNúmero da conta: " + idConta
        + "\nSaldo: " + retornarSaldo();
    return resumoTransacao;
  }

  public String getTipoConta() {
    return tipoConta;
  }

  public void setTipoConta(String tipoConta) {
    this.tipoConta = tipoConta;
  }

  public String getIdConta() {
    return idConta;
  }

  public void setIdConta(String idConta) {
    this.idConta = idConta;
  }

  public PessoaCliente getPessoaCliente() {
    return pessoaCliente;
  }

  public void setPessoaCliente(PessoaCliente pessoaCliente) {
    this.pessoaCliente = pessoaCliente;
  }

  public ArrayList<Transacao> getTransacoes() {
    return transacoes;
  }

}
