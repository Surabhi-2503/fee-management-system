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
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Surabhi
 */
public class accdb extends HttpServlet {

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
        try {
            HttpSession s=request.getSession();
               String  AID=(String)s.getAttribute("USN1");
                String  SMOP=(String)s.getAttribute("MOP1");
                String  SFA=(String)s.getAttribute("FA1" );
                String SCDN=(String) s.getAttribute("CDN1");
                String SAP=(String)s.getAttribute("AP1" );
                //String  SDA=(String)s.getAttribute("DA1");
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                
              int TOTAL=Integer.parseInt(SFA);
                int PAID=Integer.parseInt(SAP);
                int DUE=TOTAL-PAID;
              
               if(!AID.equals(null)&&!AID.equals(""))
                {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet studdb</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println(date);
                   
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con3=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager"); 
                    Statement stmt3=con3.createStatement();
                    stmt3.executeQuery("insert into stuacc(SUSN ,mode_of_payment ,fee_amt ,check_OR_DD_number ,amount_paid ,due_amt ,date_of_payment) values ('"+AID+"','"+SMOP+"',"+SFA+",'"+SCDN+"',"+SAP+","+DUE+",'"+date+"')");
                    con3.close();
                
                    out.println("<script>alert(\" entry successfull\")</script>");
                    out.println("<meta http-equiv='refresh' content='0;URL=addfee'>");
                    out.println("</body>");
                    out.println("</html>");
        } else{
                    response.sendRedirect("preview");
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
