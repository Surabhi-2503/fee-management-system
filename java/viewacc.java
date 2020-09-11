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
public class viewacc extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try  {
             HttpSession s=request.getSession();
                String  AID1=(String)s.getAttribute("AccID");
                String  ANAME1=(String)s.getAttribute("AName");
                String  APASSWD1=(String)s.getAttribute("Apassword" );
                String ACFMPWD1=(String) s.getAttribute("Arepassword");
                String ADDR1=(String)s.getAttribute("Address" );
                String  APHONE1=(String)s.getAttribute("AphoneNumber");
                String  AMAILID1=(String)s.getAttribute("AccMailID");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet viewacc</title>");            
            out.println("</head>");
            out.println("<body bgcolor=\"cyan\">");
           
            out.println("<div align=\"top\" style=\"height:100px;width:100%;;color:red;border-collapse: collapse;background-color:black;\"><center><font color=\"white\"><h1>ANVESHAN COACHING CENTER</h1></font></center><right><a href=\"logout\"><font color=\"white\"><h5>LOGOUT</h5></font></right></a>");
            out.println("<font color=\"blue\"><b>HOME::</b></font><a href=\"addacc\"><font color=\"blue\">ADD ACCOUNTANT</font></a>  |  <a href=\"viewacc\"><font color=\"blue\"> VIEW ACCOUNTANT</font></a> | <a href=\"adminlogin\"><font color=\"blue\">ADMIN PANEL</font></a> | <a href=\"logout\"><font color=\"blue\">LOGOUT</font></a> ");
            out.println("<h1><center><font color=\"black\">ACCOUNTANT LIST</font></center></h1>");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager"); 
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from actreg ");
            out.println("<table border=\"2\"><tr bgcolor=\"pink\"><th><font color=\"black\">ID</th><th><font color=\"black\">NAME</font></th><th><font color=\"black\">PASSWORD</font></th><th><font color=\"black\">ADDRESS</font></th><th><font color=\"black\">PHONE</font></th><th><font color=\"black\">EMAILID</font></th></tr>");
             while(rs.next())
             {
                 
                 String AID2=rs.getString("id");
                 String ANAME2=rs.getString("name");
                 String APASS2=rs.getString("passwd");
                 String ADDR2=rs.getString("address");
                 String APHONE2=rs.getString("phone");
                 String AMAIL2=rs.getString("email");
                 
                 out.println("<tr bgcolor=\"black\"><td><font color=\"white\">"+AID2+"</font></td><td><font color=\"white\">"+ANAME2+"</font></td><td><font color=\"white\">"+APASS2+"</font></td><td><font color=\"white\">"+ADDR2+"</font></td><td><font color=\"white\">"+APHONE2+"</font></td><td><font color=\"white\">"+AMAIL2+"</font></td><td><a href=delacc?id="+AID2+"><font color=\"white\"><strong>delete</strong></font></a></td><td><a href=updacc?id="+AID2+"><font color=\"white\"><strong>update</strong></font></a></td></tr>");
                 }
             out.println("</table>");
            con.close();
            
            out.println("</body>");
            out.println("</html>");
        } catch(Exception e){
            out.println(e);
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
            Logger.getLogger(viewacc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(viewacc.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(viewacc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(viewacc.class.getName()).log(Level.SEVERE, null, ex);
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
