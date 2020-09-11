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

/**
 *
 * @author Surabhi
 */
public class delstu11 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet accpage</title>");            
            out.println("</head>");
            out.println(" <body style=\"margin:0px;background-color:#abcdef\">");
        
           
           
           out.println("<table style=\"margin:0px\">");
           out.println("<tr bgcolor=\"black\"  >");
           out.println("<th style=\"height:20px;width:1500px;padding:20px\"  ><font color=\"white\"><h1>ANVESHAN COACHING CENTER</h1></font></th>");
           out.println("</tr>");
           out.println("</table>");
           
           
           out.println("<table style=\"margin:0px\">");
           out.println("<tr bgcolor=\"magenta\">");
           
           out.println("<td  style=\"height:487px;width:1500px;padding:20px;background-color:#ecf87f\"  >");
           out.println("<a href=selection><font color=\"black\"><b>SELECT COURSE</b></font></a><br>");
           out.println("<a href=stureg><font color=\"black\"><b>ADD STUDENT</b></font></a><br>");
           out.println("<a href=payment2><font color=\"black\"><b>FEE PAYMENT</b></font></a><br>"); 
           out.println("<a href=viewstu><font color=\"black\"><b>VIEW STUDENT</b></font></a><br>");
           out.println("<a href=updstu11><font color=\"black\"><b>UPDATE STUDENT</b></font></a><br>");
          // out.println("<a href=delstu1><font color=\"black\"><b>REMOVE STUDENT</b></font></a><br>");
           out.println("</td>");
           
        out.println("<td  style=\"height:487px;width:5000px;padding:20px;background-color:cyan;vertical-align: center;\"><a href=\"delstu12\"><h1><i><b><font color=\"black\">delete student details</font></b></i></h1></a><a href=\"delstu13\"><h1><i><b><font color=\"black\">delete student fee details</font></b></i></h1></a>    ");
           
         // out.println("<td style=\"width:25%;padding:232px;background-color:cyan;vertical-align: top;\"><a href=\"updstu12\"><h1><i><b><font color=\"black\">update student details</font></b></i></h1></a><a href=\"updstu13\"><h1><i><b><font color=\"black\">update fee details</font></b></i></h1></a>  </td>\n");
                  
           
           
          
            out.println("</td>");
           out.println("</tr>");
            out.println("</table>");

          out.println("<table style=\"margin:0px\">");
           out.println("<tr bgcolor=\"black\">");
           out.println("<th style=\"height:15px;width:1490px;padding:20px\"  font color=\"white\"><h5>copyright</h5></font></th>");
           out.println("</tr>");
           out.println("</table>");
            
            
          
            out.println("</body>");
            out.println("</html>");
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
