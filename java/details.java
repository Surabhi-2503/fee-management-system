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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class details extends HttpServlet {

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
              
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet accpage</title>");            
            out.println("</head>");
            String AID2=request.getParameter("id");
            out.println(" <body style=\"margin:0px;background-color:cyan\">");
        
           
           
           out.println("<table style=\"margin:0px\">");
           out.println("<tr bgcolor=\"black\"  >");
           out.println("<th style=\"height:20px;width:1500px;padding:20px\"  ><font color=\"white\"><h1>ANVESHAN COACHING CENTER</h1></font></th>");
           out.println("</tr>");
           out.println("</table>");
           
           
           out.println("<table style=\"margin:0px\">");
           out.println("<tr bgcolor=\"magenta\">");
           
          out.println("<font color=\"red\"><b>HOME::</b></font><a href=\"accpage\"><font color=\"black\">HOME PAGE</font></a>  |  <a href=\"selection\"><font color=\"black\">COURSE CATALOGUE</font></a> | <a href=\"stureg\"><font color=\"black\">ADD STUDENT</font></a>  |  <a href=\"payment2\"><font color=\"black\">FEE PAYMENT</font></a> | <a href=\"viewstu\"><font color=\"black\">VIEW STUDENT</font></a> |  <a href=\"updstu11\"><font color=\"black\">UPDATE STUDENT</font></a> | <a href=\"delstu11\"><font color=\"black\">DELETE STUDENT</font></a> ");

           
         out.println("<td  style=\"height:487px;width:5000px;padding:20px;background-color:cyan\"  >");
                         
            out.println("<center>");
               
                    
               
                    
                    
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager"); 
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("select * from stuacc where  susn='"+AID2+"' ");
                   out.println("<table border=\"2\"><tr bgcolor=\"GREY\"><th><font color=\"black\">USN</th><th><font color=\"black\">MODE_OF_PAYMENT</font></th><th><font color=\"black\">FEE_AMOUNT</font></th><th><font color=\"black\">CHEQUE_DD_NUMBER</font></th><th><font color=\"black\">AMOUNT_PAID</font></th><th><font color=\"black\">DUE_AMOUNT</font></th><th><font color=\"black\">DATE_OF_PAYMENT</font></th></tr>");
                   String id1=null;
                   String mode_of_payment1=null;
                    String feeamt1=null;
                      String chORdd_no=null;
                      String amt_paid=null;
                      String due_amt=null;
                      String date_of_pay=null;
                    while(rs.next()){
                        id1=rs.getString("susn");
                        mode_of_payment1=rs.getString("mode_of_payment");
                        feeamt1=rs.getString("fee_amt");
                        chORdd_no=rs.getString("check_or_dd_number");
                        amt_paid=rs.getString("amount_paid");
                        due_amt=rs.getString("due_amt");
                         date_of_pay=rs.getString("date_of_payment");
                       
            out.println("<tr bgcolor=\"black\"><td><font color=\"white\">"+id1+"</font></td><td><font color=\"white\">"+mode_of_payment1+"</font></td><td><font color=\"white\">"+feeamt1+"</font></td><td><font color=\"white\">"+chORdd_no+"</font></td><td><font color=\"white\">"+amt_paid+"</font></td><td><font color=\"white\">"+due_amt+"</font></td><td><font color=\"white\">"+date_of_pay+"</font></td><td><a href=delstu2?id="+AID2+"><font color=\"white\"><strong>delete</strong></font></a></td><td><a href=updstu1?id="+AID2+"><font color=\"white\"><strong>update</strong></font></a></t<d></tr>");

                        
                    }     
                               out.println("click <a href=viewstu><font color=\"black\"><b>here</b></font></a>to go to view page <br>" );

                    out.println("</table>");
         
            

          
                  
           
           out.println("</center>");
            
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(details.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(details.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(details.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(details.class.getName()).log(Level.SEVERE, null, ex);
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
