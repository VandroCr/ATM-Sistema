package com.atm.sistema.controller;

import com.atm.sistema.model.Conta;
import com.atm.sistema.model.ContaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Controller para autenticação do usuário
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private ContaService contaService;
    
    @Override
    public void init() throws ServletException {
        contaService = new ContaService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numeroConta = request.getParameter("numeroConta");
        String pin = request.getParameter("pin");
        
        Conta conta = contaService.autenticar(numeroConta, pin);
        
        if (conta != null) {
            HttpSession session = request.getSession();
            session.setAttribute("conta", conta);
            session.setAttribute("numeroConta", numeroConta);
            response.sendRedirect("dashboard");
        } else {
            request.setAttribute("mensagem", "Número de conta ou PIN incorretos");
            request.setAttribute("tipoMensagem", "erro");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
