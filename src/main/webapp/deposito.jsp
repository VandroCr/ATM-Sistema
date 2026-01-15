<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Depósito - Sistema ATM</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="caixa-principal">
        <h1>Depósito</h1>
        <h2>Deposite dinheiro na sua conta</h2>
        
        <% if (request.getAttribute("mensagem") != null) { %>
            <div class="caixa-alerta caixa-alerta-<%= request.getAttribute("tipoMensagem") %>">
                <%= request.getAttribute("mensagem") %>
            </div>
        <% } %>
        
        <form action="deposito" method="POST">
            <div class="grupo-formulario">
                <label for="valor">Valor a Depositar (MT):</label>
                <input type="number" id="valor" name="valor" step="0.01" min="0.01" required>
            </div>
            
            <button type="submit" class="botao">Depositar</button>
        </form>
        
        <a href="dashboard" class="link-voltar">Voltar ao Painel</a>
    </div>
</body>
</html>
