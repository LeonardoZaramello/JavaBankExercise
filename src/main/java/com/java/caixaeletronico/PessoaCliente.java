package com.java.caixaeletronico;

import java.util.ArrayList;

public class PessoaCliente {

  String nomeCompleto;
  String cpf;
  String senha;
  ArrayList<Conta> contas = new ArrayList<Conta>();

  /**
   * Metodo Construtor Pessoa Cliente.
   **/
  public PessoaCliente(String nomeCompleto, String cpf, String senha) {
    super();
    this.nomeCompleto = nomeCompleto;
    this.cpf = cpf;
    this.senha = senha;
    System.out.println("Nova pessoa cliente " + nomeCompleto + " com CPF: " + cpf + " criada!");
  }

  /**
   * Metodo para adicionar conta do cliente.
   **/
  public void adicionarConta(Conta novaConta) {
    contas.add(novaConta);
  }

  public int retornaNumeroDeContas() {
    return this.contas.size();
  }

  public double retornarSaldoContaEspecifica(int indice) {
    return this.contas.get(indice).retornarSaldo();
  }

  public String retornarIdContaEspecifica(int indice) {
    return this.contas.get(indice).getIdConta();
  }

  public void retornarExtratoContaEspecifica(int indice) {
    this.contas.get(indice).retornarExtrato();
  }

  public void adicionarTransacaoContaEspecifica(int indice, double quantia, String descricao) {
    this.contas.get(indice).adicionarTransacao(quantia, descricao);
  }

  public boolean validarSenha(String senha) {
    return senha.equals(this.senha);
  }

  /**
   * Metodo para imprimir o histórico da conta.
   **/
  public void retornarResumoContas() {
    for (Conta conta : contas) {
      System.out.println(conta.retornarResumoConta());
    }
  }

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public ArrayList<Conta> getContas() {
    return this.contas;
  }

  public void setContas(ArrayList<Conta> contas) {
    this.contas = contas;
  }

}
