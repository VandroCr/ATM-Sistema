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
 * Controller para o dashboard principal do ATM
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private ContaService contaService;
    
    @Override
    public void init() throws ServletException {
        contaService = new ContaService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String numeroConta = (String) session.getAttribute("numeroConta");
        
        if (numeroConta == null) {
            response.sendRedirect("login");
            return;
        }
        
        Conta conta = contaService.buscarConta(numeroConta);
        if (conta != null) {
            request.setAttribute("conta", conta);
            request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
        } else {
            session.invalidate();
            response.sendRedirect("login");
        }
    }
}
