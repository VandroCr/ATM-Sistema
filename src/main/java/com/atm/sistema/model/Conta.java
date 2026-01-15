package com.atm.sistema.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Classe Model que representa uma Conta Bancária
 */
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String numeroConta;
    private String pin;
    private String nomeTitular;
    private BigDecimal saldo;
    
    public Conta() {
        this.saldo = BigDecimal.ZERO;
    }
    
    public Conta(String numeroConta, String pin, String nomeTitular) {
        this.numeroConta = numeroConta;
        this.pin = pin;
        this.nomeTitular = nomeTitular;
        this.saldo = BigDecimal.ZERO;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNumeroConta() {
        return numeroConta;
    }
    
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
    
    public String getPin() {
        return pin;
    }
    
    public void setPin(String pin) {
        this.pin = pin;
    }
    
    public String getNomeTitular() {
        return nomeTitular;
    }
    
    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }
    
    public BigDecimal getSaldo() {
        return saldo;
    }
    
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    
    public void depositar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }
    
    public boolean levantar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0 && valor.compareTo(this.saldo) <= 0) {
            this.saldo = this.saldo.subtract(valor);
            return true;
        }
        return false;
    }
}
