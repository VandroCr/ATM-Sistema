package com.atm.sistema.controller;

import com.atm.sistema.model.ContaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller para criação de conta bancária
 */
@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    private ContaService contaService;
    
    @Override
    public void init() throws ServletException {
        contaService = new ContaService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/registro.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pin = request.getParameter("pin");
        String nomeTitular = request.getParameter("nomeTitular");
        
        String[] resultado = contaService.criarConta(pin, nomeTitular);
        String mensagem = resultado[0];
        String numeroContaGerado = resultado[1];
        
        if (mensagem.contains("sucesso")) {
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("numeroConta", numeroContaGerado);
            request.setAttribute("tipoMensagem", "sucesso");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("tipoMensagem", "erro");
            request.getRequestDispatcher("/registro.jsp").forward(request, response);
        }
    }
}
