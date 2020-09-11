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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Surabhi
 */
public class viewstu extends HttpServlet {

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
               /*String  AID=(String)s.getAttribute("USN1");
               String  SMOP=(String)s.getAttribute("MOP1");
               String  SFA=(String)s.getAttribute("FA1" );
               String SCDN=(String) s.getAttribute("CDN1");
               String SAP=(String)s.getAttribute("AP1" );
               
                String  SNAME=(String)s.getAttribute("NAME");
                String  SMAILID=(String)s.getAttribute("MAIL1" );
                String SCOURSE=(String) s.getAttribute("COURSE");
                String SDOB=(String)s.getAttribute("DOB" );
                String  SADDRESS=(String)s.getAttribute("ADDRESS");
                String  SPHONE=(String)s.getAttribute("CONTACT");
                String  SGENDER=(String)s.getAttribute("GENDER");
               */
              
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println(" <body style=\"margin:0px;background-color:cyan\">");
        
           
           
           out.println("<table style=\"margin:0px\">");
           out.println("<tr bgcolor=\"black\"  >");
           out.println("<th style=\"height:20px;width:1500px;padding:20px\"  ><font color=\"white\"><h1>ANVESHAN COACHING CENTER</h1></font></th> ");
           out.println("</tr>");
           out.println("</table>");
           out.println("<table style=\"margin:0px\">");
         out.println("<font color=\"red\"><b>HOME::</b></font><a href=\"accpage\"><font color=\"black\">HOME PAGE</font></a>  |  <a href=\"selection\"><font color=\"black\">COURSE CATALOGUE</font></a> | <a href=\"stureg\"><font color=\"black\">ADD STUDENT</font></a>  |  <a href=\"payment2\"><font color=\"black\">FEE PAYMENT</font></a> | <a href=\"viewstu\"><font color=\"black\">VIEW STUDENT</font></a> |  <a href=\"updstu11\"><font color=\"black\">UPDATE STUDENT</font></a> | <a href=\"delstu11\"><font color=\"black\">DELETE STUDENT</font></a>  | <a href=\"logout\"><font color=\"black\">LOGOUT</font></a>");

          
           out.println("<td  style=\"height:487px;width:5000px;padding:20px;background-color:cyan\"  >");

           out.println("<center>");
           Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager"); 
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from studreg ");
            out.println("<table border=\"2\"><tr bgcolor=\"GREY\"><th><font color=\"black\">USN</th><th><font color=\"black\">NAME</font></th><th><font color=\"black\">EMAIL</font></th><th><font color=\"black\">GENDER</font></th><th><font color=\"black\">COURSE</font></th><th><font color=\"black\">DOB</font></th><th><font color=\"black\">ADDRESS</font></th><th><font color=\"black\">PHONE</font></th><th><font color=\"black\">DELETE</font></th><th><font color=\"black\">UPDATE_STU_DTLS</font></th><th><font color=\"black\">UPDATE_PMT_DTLS</font></th></tr>");
           while(rs.next()){
               String AID2=rs.getString("rollno");
               String name2=rs.getString("name");
               String email2=rs.getString("EMAILS");
               String sex=rs.getString("gender");
               String course2=rs.getString("course");
               String dob2=rs.getString("dob");
               String address2=rs.getString("address");
               String phone2=rs.getString("contact");
out.println("<tr bgcolor=\"black\"><td><a href=details?id="+AID2+">"+AID2+"</a></td><td><font color=\"white\">"+name2+"</font></td><td><font color=\"white\">"+email2+"</font></td><td><font color=\"white\">"+sex+"</font></td><td><font color=\"white\">"+course2+"</font></td><td><font color=\"white\">"+dob2+"</font></td><td><font color=\"white\">"+address2+"</font></td><td><font color=\"white\">"+phone2+"</font></td><td><a href=delstu?id="+AID2+"><font color=\"white\"><strong>delete</strong></font></a></td><td><a href=updstu1?id="+AID2+"><font color=\"white\"><strong>STU_DETAILS</strong></font></a></td><td><a href=accupd?id="+AID2+"><font color=\"white\"><strong>PMT_DETAILS</strong></font></a></td></tr>");

                      
           }
           
           
          
           out.println("</table>");
          out.println("<h3><b>click here <a href=\"stureg\">register</a>new student</b></h3>");

       
          
          out.println("</center>");    
         
           
          
                  
           
           
          
            out.println("</td>");
           out.println("</tr>");
            out.println("</table>");

         out.println("<table style=\"margin:0px\">");
           out.println("<tr bgcolor=\"black\">");
           out.println("<th style=\"height:15px;width:1490px;padding:20px\"  font color=\"white\"><h5>copyright</h5></font></th>");
           out.println("</tr>");
           out.println("</table>");
            
            
          
      
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
