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
public class updstu15 extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession s=request.getSession();
                String  AID2=(String)s.getAttribute("USN");
                
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet payment3</title>");            
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
            String amtpaid=null;
           String id2=null;
             String mode   =null;    
                String chORddNO=null;
              String feeamt   =null;
                      String dueamt=null;
                                String dateOFpmt=null;
                    //out.println(AID2);
                  if(!AID2.equals(null)&&!AID2.equals("")) 
                    {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager"); 
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("select * from stuacc where SUSN='"+AID2+"'");
                    while(rs.next()){
                         id2=rs.getString("SUSN");
                      mode=rs.getString("MODE_OF_PAYMENT");
                       feeamt=rs.getString("FEE_AMT");
                       chORddNO=rs.getString("CHECK_OR_DD_NUMBER");
                      amtpaid=rs.getString("AMOUNT_PAID");
                         dueamt=rs.getString("DUE_AMT");
                     dateOFpmt=rs.getString("DATE_OF_PAYMENT");
                    }
                        
                      // out.println(id2+mode+feeamt+chORddNO+amtpaid+dueamt+dateOFpmt);
                       
                        out.println("<center>");
                        out.println("<p><table border=\"2\"></p>");
                        out.println("<h1><strong>UPDATE PAYMENT DETAILS</strong></h1>");
                       
                        out.println("<form method=\"post\">");
                     out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">SUSN:</font></td><td><input type=\"text\" name=\"AID\" value="+AID2+" required><br></td></tr>");
                    out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">MODE OF PAYMENT:</font></td><td><select name=\"mode\"><option value=\"none\" selected>(please select:)</option>\n  <option value=\"CASH\">CASH</option>\n  <option value=\"CHEQUE\">CHEQUE</option>\n  <option value=\"DD\">DD</option>\n</select></tr>");

                    // out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">MODE OF PAYMENT:</font></td><td><input type=\"text\" name=\"mode\" value="+mode+" required><br></td></tr>");
                    out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">FEE AMOUNT:</font></td><td><input type=\"text\" name=\"feamt\" value="+feeamt+" required>{eng:80000 or else 50000}<br></td></tr>");
                    out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">BALANCE AMOUNT:</font></td><td><input type=\"text\" name=\"balance\" value="+dueamt+" required><br></td></tr>");
                    out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">CHEQUE/DD NO:</font></td><td><input type=\"TEXT\" name=\"menu\" placeholder=\"dd45fsg667\" ><br></td></tr>");
                    
//out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">CHEQUE OR DD NUMBER:</font></td><td><select name=\"menu\"><option value=\"none\" selected>(please select:)</option>\n  <option value=\"CASH\">CASH</option>\n  <option value=\"CHEQUE\">CHEQUE</option>\n  <option value=\"DD\">DD</option>\n</select></tr>");
                    out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">AMOUNT PAID:</font></td><td><input type=\"TEXT\" name=\"amtp\" placeholder=\"80000\" required><br></td></tr>");
                   
                    out.println("</table>");
                    out.println("<br><input type=\"submit\" value=\"submit\">");
                    out.println("<input type=\"reset\" value=\"RESET\">");
                    out.println("</center>");   
                    
                        
                        
                    out.println("</form>");
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("</table>");
                        
                out.println("<table style=\"margin:0px\">");
                  out.println("<tr bgcolor=\"black\">");
           out.println("<th style=\"height:15px;width:1490px;padding:20px\"  font color=\"white\"><h5>copyright</h5></font></th>");
           out.println("</tr>");
           out.println("</table>");
                     

                        String USN1=request.getParameter("AID");
                         String MOP=request.getParameter("mode");
                        String FA=request.getParameter("feamt");
                        String CDN=request.getParameter("menu");
                        String AP=request.getParameter("amtp");
                        String bal=request.getParameter("balance");
                        //out.println(USN1+MOP+FA+CDN+AP+bal);
                     if(!MOP.equals(null)&&!MOP.equals(""))
                        {
                            
                    
                                s.setAttribute("USN2", USN1);
                            s.setAttribute("MOP1",MOP);
                            s.setAttribute("FA1",FA);
                            s.setAttribute("CDN1",CDN);
                            s.setAttribute("AP1", AP);
                            s.setAttribute("BAL1", bal);
                            response.sendRedirect("studb");
                            
                
                        }
                        else
                        {
                            out.println("invalid");
              
                        }
      
                    
                    con.close();
                    
             } else{
                   out.println("<script>alert(\"no change in the data\")</script>");
              }
               
            
            
            
            out.println("</body>");
            out.println("</html>");
        }catch(Exception e){
            
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
            Logger.getLogger(updstu15.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updstu15.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(updstu15.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updstu15.class.getName()).log(Level.SEVERE, null, ex);
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
