<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro - Sistema ATM</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="caixa-principal">
        <h1>Criar Conta</h1>
        <h2>Abra sua conta bancária</h2>
        
        <% if (request.getAttribute("mensagem") != null) { %>
            <div class="caixa-alerta caixa-alerta-<%= request.getAttribute("tipoMensagem") %>">
                <%= request.getAttribute("mensagem") %>
            </div>
        <% } %>
        
        <form action="registro" method="POST">
            <div class="grupo-formulario">
                <label for="pin">PIN (mínimo 4 dígitos):</label>
                <input type="password" id="pin" name="pin" required minlength="4">
            </div>
            
            <div class="grupo-formulario">
                <label for="nomeTitular">Nome do Titular:</label>
                <input type="text" id="nomeTitular" name="nomeTitular" required>
            </div>
            
            <p style="color: #666; font-size: 14px; text-align: center; margin: 15px 0;">
                O número da conta será gerado automaticamente após o registro.
            </p>
            
            <button type="submit" class="botao">Criar Conta</button>
        </form>
        
        <div class="area-link">
            <a href="login">Já tem conta? Faça login</a>
        </div>
        
        <div class="area-link">
            <a href="index.html">Voltar ao início</a>
        </div>
    </div>
</body>
</html>
