<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.atm.sistema.model.Conta" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Sistema ATM</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="caixa-principal caixa-grande">
        <h1>Painel</h1>
        <% 
            Conta conta = (Conta) request.getAttribute("conta");
            if (conta != null) {
        %>
            <h2>Bem-vindo, <%= conta.getNomeTitular() %>!</h2>
            
            <div class="info-conta">
                <p><strong>Número da Conta:</strong> <%= conta.getNumeroConta() %></p>
                <p><strong>Saldo Disponível:</strong> <%= conta.getSaldo() %> MT</p>
            </div>
            
            <div class="menu-painel">
                <a href="saldo" class="item-menu saldo">
                    Consultar Saldo
                </a>
                
                <a href="deposito" class="item-menu deposito">
                    Depósito
                </a>
                
                <a href="levantamento" class="item-menu levantamento">
                    Levantamento
                </a>
                
                <a href="logout" class="item-menu sair">
                    Sair
                </a>
            </div>
        <% } else { %>
            <p>Erro ao carregar dados da conta.</p>
            <a href="login" class="link-voltar">Voltar ao Login</a>
        <% } %>
    </div>
</body>
</html>
