package com.atm.sistema.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Data Access Object para gestão de contas bancárias
 * Simula um banco de dados em memória
 */
public class ContaDAO {
    private static final ConcurrentHashMap<String, Conta> contas = new ConcurrentHashMap<>();
    private static final AtomicLong idCounter = new AtomicLong();
    private static final AtomicLong numeroContaSequencial = new AtomicLong(1);
    
    /**
     * Gera um número de conta automaticamente no padrão: YYYY + 5 dígitos sequenciais
     * Exemplo: 202600001, 202600002, etc.
     */
    private String gerarNumeroConta() {
        int ano = java.time.Year.now().getValue();
        long sequencial = numeroContaSequencial.getAndIncrement();
        return String.format("%d%05d", ano, sequencial);
    }
    
    /**
     * Cria uma nova conta bancária com número gerado automaticamente
     */
    public Conta criarConta(String pin, String nomeTitular) {
        String numeroConta = gerarNumeroConta();
        
        // Garantir que o número gerado não existe (caso raro, mas possível)
        while (contas.containsKey(numeroConta)) {
            numeroConta = gerarNumeroConta();
        }
        
        Conta conta = new Conta(numeroConta, pin, nomeTitular);
        conta.setId(idCounter.incrementAndGet());
        contas.put(numeroConta, conta);
        return conta;
    }
    
    /**
     * Cria uma nova conta bancária com número específico (método mantido para compatibilidade)
     */
    public Conta criarConta(String numeroConta, String pin, String nomeTitular) {
        if (contas.containsKey(numeroConta)) {
            return null; // Conta já existe
        }
        
        Conta conta = new Conta(numeroConta, pin, nomeTitular);
        conta.setId(idCounter.incrementAndGet());
        contas.put(numeroConta, conta);
        return conta;
    }
    
    /**
     * Busca uma conta pelo número da conta
     */
    public Conta buscarPorNumeroConta(String numeroConta) {
        return contas.get(numeroConta);
    }
    
    /**
     * Autentica um usuário com número de conta e PIN
     */
    public Conta autenticar(String numeroConta, String pin) {
        Conta conta = buscarPorNumeroConta(numeroConta);
        if (conta != null && conta.getPin().equals(pin)) {
            return conta;
        }
        return null;
    }
    
    /**
     * Atualiza uma conta
     */
    public void atualizarConta(Conta conta) {
        contas.put(conta.getNumeroConta(), conta);
    }
    
    /**
     * Lista todas as contas (útil para testes)
     */
    public List<Conta> listarTodas() {
        return new ArrayList<>(contas.values());
    }
    
    /**
     * Verifica se um número de conta já existe
     */
    public boolean existeConta(String numeroConta) {
        return contas.containsKey(numeroConta);
    }
}
