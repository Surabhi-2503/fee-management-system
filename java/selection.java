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
public class selection extends HttpServlet {

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
            out.println("<title>Servlet selection</title>");            
            out.println("</head>");
            out.println(" <body style=\"margin:0px;background-color:black\">");
            
            
            
            out.println("<table style=\"margin:0px\">");
           out.println("<tr bgcolor=\"black\"  >");
           out.println("<th style=\"height:20px;width:1500px;padding:20px\"  ><font color=\"white\"><h1>ANVESHAN COACHING CENTER</h1></font></th>");
           out.println("</tr>");
           out.println("</table>");
           
          
           
           out.println("<table style=\"margin:0px\">");
           out.println("<tr bgcolor=\"magenta\"  >");
           out.println("<td  style=\"height:487px;width:1500px;padding:20px;background-color:#ecf87f\"  >");
           out.println("<a href=selection><font color=\"black\"><b> COURSE INFORMATION</b></font></a><br>");
           out.println("<a href=stureg><font color=\"black\"><b>ADD STUDENT</b></font></a><br>");
            out.println("<a href=payment2><font color=\"black\"><b>FEE PAYMENT</b></font></a><br>");      
           out.println("<a href=viewstu><font color=\"black\"><b>VIEW STUDENT</b></font></a><br>");
           out.println("<a href=updstu11><font color=\"black\"><b>UPDATE STUDENT</b></font></a><br>");
           out.println("<a href=delstu11><font color=\"black\"><b>REMOVE STUDENT</b></font></a><br>");
                      out.println("<a href=logout><font color=\"black\"><b>LOGOUT</b></font></a><br>");

           out.println("</td>");
          
            out.println("<td  style=\"height:487px;width:5000px;padding:20px;background-color:cyan\"  >");
            out.println("<h1 align=\"TOP LEFT\"><strong><i>COURSE INFORMATION</i></strong></h1>");
            out.println("   <form ><div><select name=\"menu\"><option value=\"none\" selected>(please select:)</option><option value=\"PCMB\">PCMB</option><option value=\"PCMC\">PCMC</option><option value=\"ENGINEERING\">ENGINEERING</option></select><div><input type=\"submit\" value=\"view\"></div></form>");
            String opt=request.getParameter("menu");
               if(opt.equals("(please select:)")){
                
            }
            else if(opt.equals("PCMB")||opt.equals("PCMC"))
            {
                out.println("<p>PCMB/PCMC:it covers physics,chemistry,mathematics and biology</p><p>fee:50000/- only</p><p>duration:9 months including sunday</p>");
                
            }
            else{
            out.println("<p>ENGINEERING:(based on branch) teaching will be done</p><p>fee:80000/- only</p><p>duration:4 months including sunday</p>");

            }
         
            out.println("</td>");
            out.println("</table>");
           
           
           
           
           
           
           out.println("<table style=\"margin:0px\">");
           out.println("<tr bgcolor=\"black\"  >");
           out.println("<th style=\"height:15px;width:1485px;padding:20px\"  ><font color=\"white\"><h5>copyright</h5></font></th>");
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
