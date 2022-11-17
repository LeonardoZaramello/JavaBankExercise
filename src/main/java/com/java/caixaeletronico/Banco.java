package com.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Random;

public class Banco {

  ArrayList<PessoaCliente> pessoasClientes = new ArrayList<PessoaCliente>();
  ArrayList<Conta> contas = new ArrayList<Conta>();

  /**
   * Metodo para gerar os numeros da conta do usuário.
   **/
  public String gerarNumeroNovaConta() {
    Random objGenerator = new Random();
    String accountNumbers = "";

    for (int i = 0; i < 10; i++) {
      int randomNumber = objGenerator.nextInt(10);
      accountNumbers = accountNumbers + randomNumber;
      // System.out.println("Random No : " + randomNumber);
    }

    // System.out.println(accountNumbers);
    return accountNumbers;
  }

  /**
   * Metodo para adicionar pessoa cliente.
   **/
  public PessoaCliente adicionarPessoaCliente(String nome, String tipoConta, String cpf,
      String senha) {

    PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);
    pessoasClientes.add(pessoaCliente);

    Conta conta = new Conta(tipoConta, pessoaCliente, this);
    this.adicionarConta(conta);
    pessoaCliente.adicionarConta(conta);

    return pessoaCliente;
  }


  /**
   * Metodo logar cliente.
   **/
  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    for (PessoaCliente pessoaCliente : pessoasClientes) {
      if (pessoaCliente.getCpf() == cpf && pessoaCliente.getSenha() == senha) {
        return pessoaCliente;
      }
    }
    return null;
  }

  /**
   * Metodo para depositar fundos.
   **/
  public void depositar(PessoaCliente pessoaCliente, int paraConta, Double quantia) {

  }

  /**
   * Metodo para sacar fundos.
   **/
  public void sacar(PessoaCliente pessoaCliente, int daConta, Double quantia) {


  }

  /**
   * Metodo para transferir fundos.
   **/
  public void transferirFundos(PessoaCliente pessoaCliente, int daConta, int paraConta,
      Double quantia) {

    System.out.println("entrou");
    for (PessoaCliente cliente : pessoasClientes) {
      System.out.println(cliente);
      if (cliente == pessoaCliente) {
        System.out.println(cliente.getCpf());
        System.out.println(cliente.contas.get(daConta));

      }
    }

    System.out.println("saiu");
  }


  public void adicionarConta(Conta novaConta) {
    contas.add(novaConta);
  }

}
