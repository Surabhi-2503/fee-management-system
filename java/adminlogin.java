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

/**
 *
 * @author Surabhi
 */
public class adminlogin extends HttpServlet {

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
            out.println("<title>Servlet adminlogin</title>");            
            out.println("</head>");
            out.println(" <body style=\"margin:0px;\">");
            
           // out.println(" <center>");
            out.println(" <table style=\"width:100%;border-collapse: collapse;font:14px comic sans ms,sans-serif;\"><tr><td colspan=\"2\" style=\"padding:5px 5px; background-color:black;\"><center><font color=\"white\"><h1>ANVESHAN COACHING CENTER</h1></font></center><right><a href=\"logout\"><font color=\"white\"><h5>LOGOUT</h5></font></right></a></td></tr>");
            out.println("<tr align=\"top\" style=\"height: 120px;\"><td style=\"width:25%;padding:235px;background-color:cyan;vertical-align: top;\"> ");
            out.println("<form method=\"post\">");
            out.println("<center>");
           
            out.println("<p><table border=\"2\"></p>");
            //out.println("<a href=\"logout\"><h5 align=\"top\">LOGOUT</h5></a>");
            out.println("<h1><strong>ADMIN LOGIN PAGE</strong></h1>");
            out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">EMAIL:</font></td><td><input type=\"email\" name=\"email\" placeholder=\"eg:xyz123@anveshan.com\" required><br></td></tr>");
            out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">PASSWORD:</font></td><td><input type =\"password\" name=\"paswd\" placeholder=\"Enter the password\" required><br></td></tr>");
           out.println("</table>");
            out.println("<br><input type=\"submit\" value=\"login\">");
            
            String userid=request.getParameter("email");
            String passwd=request.getParameter("paswd");
             
            if(userid.equals("mfsurabhi@anveshan.com")&&passwd.equals("anveshan")){
                
                response.sendRedirect("adminpage");
            }
            else
            {
                out.println("<script>alert(\"invalid data\")</script>");
                
            }
            out.println("</form>");
            
                    
            
           
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
