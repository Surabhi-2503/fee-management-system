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
public class updacc extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updacc</title>");            
            out.println("</head>");
            out.println(" <body style=\"margin:0px;\">");
            out.println(" <table style=\"width:100%;border-collapse: collapse;font:14px comic sans ms,sans-serif;\"><tr><td colspan=\"2\" style=\"padding:5px 5px; background-color:black;\"><center><font color=\"white\"><h1>ANVESHAN COACHING CENTER</h1></font></center><right><a href=\"logout\"><font color=\"white\"><h5>LOGOUT</h5></font></right></a></td></tr>");
            out.println("<tr align=\"top\" style=\"height: 200px;\"><td style=\"width:25%;padding:135px;background-color:cyan;vertical-align: top;\"> ");
            
           
                    String AID2=null;
            
               
                    AID2=request.getParameter("id");
               
                    String iddb=null;
                    String pswd=null;
                   // out.println(AID2);
                    if(!AID2.equals(null)&&!AID2.equals("")) 
                    {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager"); 
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("select * from actreg where id='"+AID2+"' ");
                    while(rs.next()){
                        String id1=rs.getString("id");
                        String name1=rs.getString("name");
                        String passwd1=rs.getString("passwd");
                        String address1=rs.getString("address");
                        String phone1=rs.getString("phone");
                        String email1=rs.getString("email");
                        
                        
                       
                        out.println("<center>");
                        out.println("<p><table border=\"2\"></p>");
                        out.println("<h1><strong>UPDATE ACCOUNTANT PROFILE</strong></h1>");
                        
                        out.println("<form method=\"post\">");
                        out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">ACC ID:</font></td><td><input type=\"number\" name=\"AID\" value="+id1+" disabled><br></td></tr>");
                        out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">NAME:</font></td><td><input type =\"text\" name=\"Aname\" value="+name1+" required><br></td></tr>");
                        out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">PASSWORD:</font></td><td><input type=\"password\" name=\"Apass\" value="+passwd1+" required><br></td></tr>");
                        out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">CFMPASWD:</font></td><td><input type=\"password\" name=\"Arepass\" value="+passwd1+"  required><br></td></tr>");
                        out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">ADDRESS:</font></td><td><textarea rows=\"5\" cols=\"25\" name=\"addr\" required>"+address1+" </textarea><br></td></tr>");
                        out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">PHONE:</font></td><td><input type=\"number\" name=\"phone\" value="+phone1+" required><br></td></tr>");
                        out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">USERID:</font></td><td><input type =\"text\" name=\"mailid\" value="+email1+" required><br></td></tr>");
                        out.println("</table>");
                        out.println("<br><input type=\"submit\" value=\"update\">");
                        out.println("</form>"); 
             
                        String AID1=request.getParameter("AID");
                        String ANAME1=request.getParameter("Aname");
                        String APASSWD1=request.getParameter("Apass");
                        String ACFMPWD1=request.getParameter("Arepass");
                        String ADDR1=request.getParameter("addr");
                        String APHONE1=request.getParameter("phone");
                        String AMAILID1=request.getParameter("mailid");
                        if(ACFMPWD1.equals(APASSWD1))
                        {
                            if(APHONE1.length()==10)
                            {
                    
                                HttpSession s=request.getSession();
                                s.setAttribute("AccID", AID2);
                                s.setAttribute("AName", ANAME1);
                                s.setAttribute("Apassword", APASSWD1);
                                s.setAttribute("Arepassword",ACFMPWD1);
                                s.setAttribute("Address", ADDR1);
                                s.setAttribute("AphoneNumber", APHONE1);
                                s.setAttribute("AccMailID",AMAILID1);
                                response.sendRedirect("updateac");
                            }
                            else
                            {
                                out.println("enter 10 digit phone number");
                            }
                
                        }
                        else
                        {
                            out.println("invalid");
              
            }
      // out.println(address1);
                    }
                    con.close();
                   
               } else{
                   out.println("<script>alert(\"no change in the data\")</script>");
               }
               
            
            
            
            out.println("</body>");
            out.println("</html>");
        } catch(Exception e){
           // out.println(e);
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
