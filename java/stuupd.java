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
public class stuupd extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
                  HttpSession s=request.getSession();
                String USN1=(String)s.getAttribute("USNS");
                String  SNAME1=(String)s.getAttribute("NAMES1");
                String  SMAIL1=(String)s.getAttribute("MAILS1" );
                String SCOURSE1=(String) s.getAttribute("COURSES");
                String SDOB1=(String)s.getAttribute("DOBS" );
                String  SADDRESS1=(String)s.getAttribute("ADDRS");
                String  SPHONE1=(String)s.getAttribute("PHONES");
                String  SSEX1=(String)s.getAttribute("SEXS");

              //  out.println(USN1+SNAME1+SMAIL1+SCOURSE1+SDOB1+SADDRESS1+SPHONE1+SSEX1);
               if(!USN1.equals(null)&&!USN1.equals(""))
                 {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet insertaccdb</title>");            
                    out.println("</head>");
                    out.println("<body>");
                  
             
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager"); 
                        Statement stmt=con.createStatement();
                   out.println(USN1);

                        stmt.executeQuery("update studreg set  rollno='"+USN1+"', name='"+SNAME1+"' ,emails='"+SMAIL1+"' ,gender='"+SSEX1+"', course='"+SCOURSE1+"',dob='"+SDOB1+"',address='"+SADDRESS1+"' where rollno='"+USN1+"'");
                        con.close();
                
                            out.println("<script>alert(\" successfully accountant updated\")</script>");
                            out.println("<meta http-equiv='refresh' content='0;URL=viewstu'>");
                            out.println("</body>");
                            out.println("</html>");
       }
    else{
                   
                    response.sendRedirect("viewacc");
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
            Logger.getLogger(stuupd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(stuupd.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(stuupd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(stuupd.class.getName()).log(Level.SEVERE, null, ex);
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
