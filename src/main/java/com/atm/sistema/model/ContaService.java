package com.atm.sistema.model;

import java.math.BigDecimal;

/**
 * Service Layer - Regras de negócio para operações bancárias
 */
public class ContaService {
    private ContaDAO contaDAO;
    
    public ContaService() {
        this.contaDAO = new ContaDAO();
    }
    
    /**
     * Cria uma nova conta bancária
     */
    public String criarConta(String numeroConta, String pin, String nomeTitular) {
        if (numeroConta == null || numeroConta.trim().isEmpty()) {
            return "Número de conta inválido";
        }
        
        if (pin == null || pin.length() < 4) {
            return "PIN deve ter pelo menos 4 dígitos";
        }
        
        if (nomeTitular == null || nomeTitular.trim().isEmpty()) {
            return "Nome do titular é obrigatório";
        }
        
        if (contaDAO.existeConta(numeroConta)) {
            return "Conta já existe";
        }
        
        Conta conta = contaDAO.criarConta(numeroConta, pin, nomeTitular);
        if (conta != null) {
            return "Conta criada com sucesso!";
        }
        
        return "Erro ao criar conta";
    }
    
    /**
     * Autentica um usuário
     */
    public Conta autenticar(String numeroConta, String pin) {
        if (numeroConta == null || pin == null) {
            return null;
        }
        return contaDAO.autenticar(numeroConta, pin);
    }
    
    /**
     * Consulta o saldo de uma conta
     */
    public BigDecimal consultarSaldo(String numeroConta) {
        Conta conta = contaDAO.buscarPorNumeroConta(numeroConta);
        if (conta != null) {
            return conta.getSaldo();
        }
        return null;
    }
    
    /**
     * Realiza um depósito
     */
    public String depositar(String numeroConta, BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            return "Valor inválido para depósito";
        }
        
        Conta conta = contaDAO.buscarPorNumeroConta(numeroConta);
        if (conta == null) {
            return "Conta não encontrada";
        }
        
        conta.depositar(valor);
        contaDAO.atualizarConta(conta);
        return "Depósito realizado com sucesso!";
    }
    
    /**
     * Realiza um levantamento
     */
    public String levantar(String numeroConta, BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            return "Valor inválido para levantamento";
        }
        
        Conta conta = contaDAO.buscarPorNumeroConta(numeroConta);
        if (conta == null) {
            return "Conta não encontrada";
        }
        
        if (valor.compareTo(conta.getSaldo()) > 0) {
            return "Saldo insuficiente";
        }
        
        boolean sucesso = conta.levantar(valor);
        if (sucesso) {
            contaDAO.atualizarConta(conta);
            return "Levantamento realizado com sucesso!";
        }
        
        return "Erro ao realizar levantamento";
    }
    
    /**
     * Busca uma conta pelo número
     */
    public Conta buscarConta(String numeroConta) {
        return contaDAO.buscarPorNumeroConta(numeroConta);
    }
}
