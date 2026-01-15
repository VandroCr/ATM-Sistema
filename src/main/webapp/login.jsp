<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Sistema ATM</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="caixa-principal">
        <h1>Login</h1>
        <h2>Acesse sua conta bancária</h2>
        
        <% if (request.getAttribute("mensagem") != null) { %>
            <div class="caixa-alerta caixa-alerta-<%= request.getAttribute("tipoMensagem") %>">
                <%= request.getAttribute("mensagem") %>
            </div>
        <% } %>
        
        <form action="login" method="POST">
            <div class="grupo-formulario">
                <label for="numeroConta">Número da Conta:</label>
                <input type="text" id="numeroConta" name="numeroConta" required>
            </div>
            
            <div class="grupo-formulario">
                <label for="pin">PIN:</label>
                <input type="password" id="pin" name="pin" required minlength="4">
            </div>
            
            <button type="submit" class="botao">Entrar</button>
        </form>
        
        <div class="area-link">
            <a href="registro">Não tem conta? Registre-se</a>
        </div>
        
        <div class="area-link">
            <a href="index.html">Voltar ao início</a>
        </div>
    </div>
</body>
</html>
