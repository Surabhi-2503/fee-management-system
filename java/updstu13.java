/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Surabhi
 */
public class updstu13 extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
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
           out.println("<a href=payment2><font color=\"black\"><b>FEE PAYMENT></font></a><br>"); 
           out.println("<a href=viewstu><font color=\"black\"><b>VIEW STUDENT</b></font></a><br>");
           out.println("<a href=updstu11><font color=\"black\"><b>UPDATE STUDENT</b></font></a><br>");
           out.println("<a href=delstu11><font color=\"black\"><b>REMOVE STUDENT</b></font></a><br>");
                      out.println("<a href=logout><font color=\"black\"><b>LOGOUT</b></font></a><br>");

           out.println("</td>");
           
         out.println("<td  style=\"height:487px;width:5000px;padding:20px;background-color:cyan\"  >");
           out.println("<form method=\"post\">");
           out.println("<center>");
           out.println("<table border=\"2\">");
           out.println("<b><i>enter the USN of the student to update the details</i></b><br>");
           out.println("<br><tr><td bgcolor=\" black\" ><font color=\"white\">USN:</font></td><td><input type=\"text\" name=\"AID\" placeholder=\"123XYZ\" required><br></td></tr>");
            out.println("</table>");

           out.println("<br><input type=\"submit\" value=\"check\">");
          
           out.println("</center>");    
           out.println("</form>");
           
          
            String SUSN=request.getParameter("AID");      
           
           
            
            out.println("</td>");
           out.println("</tr>");
            out.println("</table>");

          out.println("<table style=\"margin:0px\">");
           out.println("<tr bgcolor=\"black\">");
           out.println("<th style=\"height:15px;width:1490px;padding:20px\"  font color=\"white\"><h5>copyright</h5></font></th>");
           out.println("</tr>");
           out.println("</table>");
            
            
          
           
         if(!SUSN.equals("")&&!SUSN.equals(null))
            {
                HttpSession s=request.getSession();
                s.setAttribute("USN", SUSN);


                Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager"); 
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("select * from studreg where rollno='"+SUSN+"' ");
                    while (rs.next())
                    {
                        String usn=rs.getString("rollno");
                        response.sendRedirect("updstu15");
                    }
                    con.close();
            }
                    else{
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updstu13.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updstu13.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updstu13.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updstu13.class.getName()).log(Level.SEVERE, null, ex);
        }
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
