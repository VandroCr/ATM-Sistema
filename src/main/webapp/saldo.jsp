<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.atm.sistema.model.Conta" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Saldo - Sistema ATM</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="caixa-principal">
        <h1>Consulta de Saldo</h1>
        <% 
            Conta conta = (Conta) request.getAttribute("conta");
            if (conta != null) {
        %>
            <div class="caixa-saldo">
                <h3>Saldo Disponível</h3>
                <div class="valor"><%= conta.getSaldo() %> MT</div>
            </div>
            
            <div class="info-conta">
                <p><strong>Número da Conta:</strong> <%= conta.getNumeroConta() %></p>
                <p><strong>Titular:</strong> <%= conta.getNomeTitular() %></p>
            </div>
        <% } else { %>
            <p>Erro ao carregar dados da conta.</p>
        <% } %>
        
        <a href="dashboard" class="link-voltar">Voltar ao Painel</a>
    </div>
</body>
</html>
