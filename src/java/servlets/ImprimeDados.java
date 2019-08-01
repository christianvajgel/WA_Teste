package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImprimeDados extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Dados</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Dados cadastrados:</h1>");
            out.println("Nome: " + request.getParameter("nome"));
            out.println("<br>");
            out.println("Email: " + request.getParameter("email"));
            out.println("<br>");
            out.println("Endereco L1: " + request.getParameter("endereco1"));
            out.println("<br>");
            out.println("Endereco L2: " + request.getParameter("endereco2"));
            out.println("<br>");
            out.println("UF: " + request.getParameter("uf"));
            out.println("<br>");
            out.println("Idade: " + request.getParameter("idade"));
            out.println("<br>");
            out.println("Gênero: " + request.getParameter("genero"));
            out.println("<br>");
            for (int i = 1; i < 6; i++){
                String esporte = "esporte";
                esporte += String.valueOf(i);
                if (esporte != null) {
                   out.println("Esporte: " + request.getParameter(esporte));
                   out.println("<br>"); 
                }
            }
            String[] filmes = request.getParameterValues("filmes");
            for (int i = 0; i < filmes.length; i++) {
                if (filmes[i] != null){
                    out.println("Filme: " + filmes[i]);
                    out.println("<br>");
                }
            }
            out.println("Deseja receber e-mail?: " + request.getParameter("newsletter"));
            out.println("<br>");
            out.println("Observação: " + request.getParameter("observacao"));
            out.println("<br>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}