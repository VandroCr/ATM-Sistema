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
import java.math.BigDecimal;

/**
 * Controller para operação de levantamento
 */
@WebServlet("/levantamento")
public class LevantamentoServlet extends HttpServlet {
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
        
        request.getRequestDispatcher("/levantamento.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String numeroConta = (String) session.getAttribute("numeroConta");
        
        if (numeroConta == null) {
            response.sendRedirect("login");
            return;
        }
        
        try {
            String valorStr = request.getParameter("valor");
            BigDecimal valor = new BigDecimal(valorStr);
            
            String resultado = contaService.levantar(numeroConta, valor);
            
            if (resultado.contains("sucesso")) {
                // Atualizar a conta na sessão
                Conta conta = contaService.buscarConta(numeroConta);
                session.setAttribute("conta", conta);
                
                request.setAttribute("mensagem", resultado);
                request.setAttribute("tipoMensagem", "sucesso");
            } else {
                request.setAttribute("mensagem", resultado);
                request.setAttribute("tipoMensagem", "erro");
            }
            
            request.getRequestDispatcher("/levantamento.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("mensagem", "Valor inválido");
            request.setAttribute("tipoMensagem", "erro");
            request.getRequestDispatcher("/levantamento.jsp").forward(request, response);
        }
    }
}
