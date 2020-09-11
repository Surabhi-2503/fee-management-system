/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Surabhi
 */
public class insertaccdb extends HttpServlet {

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
                if(APASSWD1.equals(ACFMPWD1))
                {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet insertaccdb</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Servlet insertaccdb at " + request.getContextPath() + "</h1>");
             
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection con3=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager"); 
                        Statement stmt3=con3.createStatement();
                        stmt3.executeQuery("insert into actreg (id,name,passwd,address,phone,email ) values('"+AID1+"','"+ANAME1+"','"+APASSWD1+"','"+ADDR1+"','"+APHONE1+"','"+AMAILID1+"@anveshan.com')");
                        con3.close();
                
                            out.println("<script>alert(\" successfully accountant registered\")</script>");
                            out.println("<meta http-equiv='refresh' content='0;URL=addacc'>");
            out.println("</body>");
            out.println("</html>");
        
                }else{
                    response.sendRedirect("addacc");
                }
    }catch(Exception e){
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
