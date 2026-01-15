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
     * Cria uma nova conta bancária com número gerado automaticamente
     * Retorna um array: [0] = mensagem, [1] = número da conta gerado
     */
    public String[] criarConta(String pin, String nomeTitular) {
        if (pin == null || pin.length() < 4) {
            return new String[]{"PIN deve ter pelo menos 4 dígitos", null};
        }
        
        if (nomeTitular == null || nomeTitular.trim().isEmpty()) {
            return new String[]{"Nome do titular é obrigatório", null};
        }
        
        Conta conta = contaDAO.criarConta(pin, nomeTitular);
        if (conta != null) {
            String mensagem = "Conta criada com sucesso! Seu número de conta é: " + conta.getNumeroConta();
            return new String[]{mensagem, conta.getNumeroConta()};
        }
        
        return new String[]{"Erro ao criar conta", null};
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
