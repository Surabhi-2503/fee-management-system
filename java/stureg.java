/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Surabhi
 */
public class stureg extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occursab
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
           out.println("<tr bgcolor=\"magenta\"  >");
           
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
           out.println("<h1 align=\"center\"><strong><i>STUDENT DETAILS</i></strong></h1>");
           out.println("<table border=\"6\">");
           out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">USN:</font></td><td><input type=\"text\" name=\"AID\" placeholder=\"123XYZ\" required><br></td></tr>");
           out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">NAME:</font></td><td><input type =\"text\" name=\"Aname\" placeholder=\"Enter the name\" required><br></td></tr>");
           out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">EMAIL:</font></td><td><input type=\"email\" name=\"smail\" placeholder=\"eg:123qws@***.COM\" required><br></td></tr>");
           out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">COURSE:</font></td><td><select name=\"menu\"><option value=\"none\" selected>(please select:)</option>\n  <option value=\"PCMB\">PCMB</option>\n  <option value=\"PCMC\">PCMC</option>\n  <option value=\"ENGINEERING\">ENGINEERING</option>\n</select></tr>");
           out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">DOB:</font></td><td><input type=\"date\" name=\"dob\" placeholder=\"11/11/1999\" required><br></td></tr>");
           out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">ADDRESS:</font></td><td><textarea rows=\"5\" cols=\"25\" name=\"addr\" placeholder=\"Enter the address\" required></textarea><br></td></tr>");
           out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">PHONE:</font></td><td><input type=\"number\" name=\"phone\" placeholder=\"eg:9638521470\" required><br></td></tr>");
           out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">GENDER:</font></td><td><input type=\"radio\" name=\"gender\" value=\"male\"> Male<br><input type=\"radio\" name=\"gender\" value=\"female\"> Female<br><input type=\"radio\" name=\"gender\" value=\"other\"> Other<br></td></tr>");
           out.println("</table>");
           out.println("<br><input type=\"submit\" value=\"REGISTER\">");
           out.println("<input type=\"reset\" value=\"RESET\">");
           out.println("</center>");    
           out.println("</form>");
           out.println("</td>");
           out.println("</tr>");
            out.println("</table>");
                  
           out.println("<table style=\"margin:0px\">");
           out.println("<tr bgcolor=\"black\"  >");
           out.println("<th style=\"height:15px;width:1490px;padding:20px\"  ><font color=\"white\"><h5>copyright</h5></font></th>");
           out.println("</tr>");
           out.println("</table>");
           
            String SUSN=request.getParameter("AID");
            String SNAME=request.getParameter("Aname");
            String SMAILID=request.getParameter("smail");
            String SCOURSE=request.getParameter("menu");
            String SDOB=request.getParameter("dob");
            String SADDRESS=request.getParameter("addr");
            String SPHONE=request.getParameter("phone");
            String SGENDER=request.getParameter("gender");
            if(!SUSN.equals("")&&!SUSN.equals(null)&&!SNAME.equals(null)&&!SNAME.equals(""))
            {
                if(SPHONE.length()==10)
                {
                    HttpSession s=request.getSession();
                    s.setAttribute("USN", SUSN);
                    s.setAttribute("NAME",SNAME);
                    s.setAttribute("MAIL1",SMAILID);
                    s.setAttribute("COURSE",SCOURSE);
                    s.setAttribute("DOB", SDOB);
                    s.setAttribute("ADDRESS", SADDRESS);
                    s.setAttribute("CONTACT",SPHONE);
                    s.setAttribute("GENDER",SGENDER);
                    response.sendRedirect("studdb");

                
                }else{
                    out.println("enter 10 digit phone number");
                } 
            }else{
                out.println("invalid data");
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
