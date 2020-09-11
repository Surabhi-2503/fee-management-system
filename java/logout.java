/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logout extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession p=request.getSession();
                
                
          p.setAttribute("USN1",null);
             p.setAttribute("MOP1",null);
              p.setAttribute("FA1",null );
               p.setAttribute("CDN1",null);
              p.setAttribute("AP1",null );
     p.setAttribute("NAME",null);
                p.setAttribute("MAIL1",null );
                p.setAttribute("COURSE",null);
                p.setAttribute("DOB",null );
              p.setAttribute("ADDRESS",null);
                p.setAttribute("CONTACT",null);
              p.setAttribute("GENDER",null);
              p.setAttribute("AccID", null);
                p.setAttribute("AName", null);
                p.setAttribute("Apassword",null);
                p.setAttribute("Arepassword",null);
                p.setAttribute("Address", null);
                p.setAttribute("AphoneNumber", null);
                p.setAttribute("AccMailID",null);
                              response.sendRedirect("index.html");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
