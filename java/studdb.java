/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class studdb extends HttpServlet {

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
        try {
            HttpSession s=request.getSession();
                String  SUSN=(String)s.getAttribute("USN");
                String  SNAME=(String)s.getAttribute("NAME");
                String  SMAILID=(String)s.getAttribute("MAIL1");
                String SCOURSE=(String) s.getAttribute("COURSE");
                String SDOB=(String)s.getAttribute("DOB" );
                String  SADDRESS=(String)s.getAttribute("ADDRESS");
                String  SPHONE=(String)s.getAttribute("CONTACT");
                String  SGENDER=(String)s.getAttribute("GENDER");
              //out.println("insert into studreg (rollno,name,EMAILS,gender,course,dob,address,contact) values('"+SUSN+"','"+SNAME+"','"+SMAILID+"','"+SGENDER+"','"+SCOURSE+"','"+SDOB+",'"+SADDRESS+"',"+SPHONE+")");
                 
            if(!SUSN.equals(null)&&!SUSN.equals(""))
                {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet studdb</title>");            
                    out.println("</head>");
                    out.println("<body>");
            
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con3=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager"); 
                    Statement stmt3=con3.createStatement();
                    stmt3.executeQuery("insert into studreg (rollno,name,EMAILS,gender,course,dob,address,contact) values('"+SUSN+"','"+SNAME+"','"+SMAILID+"','"+SGENDER+"','"+SCOURSE+"','"+SDOB+"','"+SADDRESS+"',"+SPHONE+")");
                    con3.close();
                
            out.println("<script>alert(\" fill payment details\")</script>");
             out.println("<meta http-equiv='refresh' content='0;URL=payment2'>");
            out.println("</body>");
            out.println("</html>");
        } else{
                    response.sendRedirect("studreg");
                }
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
            Logger.getLogger(studdb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(studdb.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(studdb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(studdb.class.getName()).log(Level.SEVERE, null, ex);
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
