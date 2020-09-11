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
public class addacc extends HttpServlet {

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
            out.println("<title>Servlet addacc</title>");            
            out.println("</head>");
            out.println("<body bgcolor=\"cyan\">");
          
            out.println("<div align=\"top\" style=\"height:100px;width:100%;;color:red;border-collapse: collapse;background-color:black;\"><center><font color=\"white\"><h1>ANVESHAN COACHING CENTER</h1></font></center><right><a href=\"logout\"><font color=\"white\"><h5>LOGOUT</h5></font></right></a>");
            out.println("<font color=\"blue\"><b>HOME::</b></font><a href=\"addacc\"><font color=\"blue\">ADD ACCOUNTANT</font></a>  |  <a href=\"viewacc\"><font color=\"blue\"> VIEW ACCOUNTANT</font></a> | <a href=\"adminlogin\"><font color=\"blue\">ADMIN PANEL</font></a> | <a href=\"logout\"><font color=\"blue\">LOGOUT</font></a>   ");
             out.println("<form method=\"post\">");
            out.println("<center>");
           
            out.println("<p><table border=\"2\"></p>");
            
            out.println("<h1><strong>ADD ACCOUNTANT</strong></h1>");
            out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">ACC ID:</font></td><td><input type=\"number\" name=\"AID\" placeholder=\"123\" required><br></td></tr>");
            out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">NAME:</font></td><td><input type =\"text\" name=\"Aname\" placeholder=\"Enter the name\" required><br></td></tr>");
            out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">PASSWORD:</font></td><td><input type=\"password\" name=\"Apass\" placeholder=\"eg:123qws\" required><br></td></tr>");
            out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">CFMPASWD:</font></td><td><input type=\"password\" name=\"Arepass\" placeholder=\"eg:123qws\" required><br></td></tr>");
            out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">ADDRESS:</font></td><td><textarea rows=\"5\" cols=\"25\" name=\"addr\" placeholder=\"Enter the address\" required></textarea><br></td></tr>");
            out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">PHONE:</font></td><td><input type=\"number\" name=\"phone\" placeholder=\"eg:9638521470\" required><br></td></tr>");
            out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">USERID:</font></td><td><input type =\"text\" name=\"mailid\" placeholder=\"eg:xyz123\" required>@anveshan.com<br></td></tr>");
            out.println("</table>");
            out.println("<br><input type=\"submit\" value=\"REGISTER\">");
            out.println("<input type=\"reset\" value=\"RESET\">");
            out.println("</div>");
            out.println("</form>");
            String AID1=request.getParameter("AID");
            String ANAME1=request.getParameter("Aname");
            String APASSWD1=request.getParameter("Apass");
            String ACFMPWD1=request.getParameter("Arepass");
            String ADDR1=request.getParameter("addr");
            String APHONE1=request.getParameter("phone");
            String AMAILID1=request.getParameter("mailid");
            if(ACFMPWD1.equals(APASSWD1))
            {
                if(APHONE1.length()==10)
                {
                    
                HttpSession s=request.getSession();
                s.setAttribute("AccID", AID1);
                s.setAttribute("AName", ANAME1);
                s.setAttribute("Apassword", APASSWD1);
                s.setAttribute("Arepassword",ACFMPWD1);
                s.setAttribute("Address", ADDR1);
                s.setAttribute("AphoneNumber", APHONE1);
                s.setAttribute("AccMailID",AMAILID1);
                response.sendRedirect("insertaccdb");
                }
                else
                {
                    out.println("enter 10 digit phone number");
                }
                
            }
            else
            {
                out.println("invalid");
              
            }
            
            
            
            
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
