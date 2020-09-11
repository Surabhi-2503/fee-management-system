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
public class preview extends HttpServlet {

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
               String  AID=(String)s.getAttribute("USN1");
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
               
                 int TOTAL=Integer.parseInt(SFA);
                int PAID=Integer.parseInt(SAP);
                int DUE=TOTAL-PAID;
                
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet accpage</title>");            
            out.println("</head>");
            out.println(" <body style=\"margin:0px;background-color:#abcdef\">");
        
           
           
           out.println("<table style=\"margin:0px\">");
           out.println("<tr bgcolor=\"black\"  >");
        

           out.println("<th style=\"height:20px;width:1500px;padding:20px\"  ><font color=\"white\"><h1>ANVESHAN COACHING CENTER</h1></font></th> ");
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
           out.println("<a href=logout><font color=\"blue\"><b>LOGOUT</b></font></a><br>");
           out.println("</td>");
           
           out.println("<td  style=\"height:487px;width:5000px;padding:20px;background-color:cyan\"  >");
           
           out.println("<center>");
           out.println("<table border=\"6\">");
           //out.println("<h1 align=\"center\"><strong><i>PAYMENT DETAILS</i></strong></h1>");
           out.println("<tr><td>STUDENT NAME:"+SNAME+"</td></tr><br>");
           out.println("<td>USN:"+AID+"</td></tr><br>");
           out.println("<td>MAILID:"+SMAILID+"</td></tr><br>");
            out.println("<td>DOB:"+SDOB+"</td></tr><br>");
             out.println("<td>ADDRESS:"+SADDRESS+"</td></tr><br>");
              out.println("<td>PHONE NUMBER:"+SPHONE+"</td></tr><br>");
               out.println("<td>GENDER:"+SGENDER+"</td></tr><br>");
                out.println("<td>MODE OF PAYMENT:"+SMOP+"</td></tr><br>");
                 out.println("<td>TOTAL FeeAmount:"+SFA+"</td></tr><br>");
                  out.println("<td>CHEQUE/DD Number:"+SCDN+"</td></tr><br>");
                   out.println("<td>PAID AMT:"+SAP+"</td></tr><br>");
                    out.println("<td>DUE AMOUNT:"+DUE+"</td></tr><br>");
          
           out.println("</table>");
          out.println("<h3><b>click here <a href=\"stureg\">register</a>new student</b></h3>");

       
          
          out.println("</center>");    
         
           
          
                  
           
           
            String SUSN=request.getParameter("AID");
            out.println("</td>");
           out.println("</tr>");
            out.println("</table>");

        /* out.println("<table style=\"margin:0px\">");
           out.println("<tr bgcolor=\"black\">");
           out.println("<th style=\"height:15px;width:1490px;padding:20px\"  font color=\"white\"><h5>copyright</h5></font></th>");
           out.println("</tr>");
           out.println("</table>");
            */
            
          
      
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
            Logger.getLogger(preview.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(preview.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(preview.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(preview.class.getName()).log(Level.SEVERE, null, ex);
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
