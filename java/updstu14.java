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
public class updstu14 extends HttpServlet {

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
              String AID2=(String)s.getAttribute("USN");
            /* TODO output your page here. You may use following sample code. */
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updacc</title>");            
            out.println("</head>");
                        out.println(" <body style=\"margin:0px;background-color:cyan\">");

 out.println("<table style=\"margin:0px\">");
           out.println("<tr bgcolor=\"black\"  >");
           out.println("<th style=\"height:20px;width:1500px;padding:20px\"  ><font color=\"white\"><h1>ANVESHAN COACHING CENTER</h1></font></th>");
           out.println("</tr>");
           out.println("</table>");
            out.println("<font color=\"red\"><b>HOME::</b></font><a href=\"accpage\"><font color=\"black\">HOME PAGE</font></a>  |  <a href=\"selection\"><font color=\"black\">COURSE CATALOGUE</font></a> | <a href=\"stureg\"><font color=\"black\">ADD STUDENT</font></a>  |  <a href=\"payment2\"><font color=\"black\">FEE PAYMENT</font></a> | <a href=\"viewstu\"><font color=\"black\">VIEW STUDENT</font></a> |  <a href=\"updstu11\"><font color=\"black\">UPPDATE STUDENT</font></a> | <a href=\"delstu\"><font color=\"black\">DELETE STUDENT</font></a> | <a href=\"logout\"><font color=\"black\">LOGOUT</font></a> ");
             
String id1=null;
                        String name1=null;
                        String mail1=null;
                        String sex1=null;
                        String course1=null;
                        String dob1=null;
                        String addr1=null;
                        String phn1=null;
           
                    

                    if(!AID2.equals(null)&&!AID2.equals("")) 
                    {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager"); 
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("select * from studreg where rollno='"+AID2+"' ");
                    while(rs.next()){
                       id1=rs.getString("rollno");
                        name1=rs.getString("name");
                        mail1=rs.getString("EMAILS");
                     sex1=rs.getString("gender");
                         course1=rs.getString("course");
                       dob1=rs.getString("dob");
                      addr1=rs.getString("address");
                        phn1=rs.getString("contact");
                    }
                        
                      //  out.println(id1+name1+mail1+sex1+course1+dob1+addr1+phn1);
                       
                      out.println("<center>");
                        out.println("<p><table border=\"2\"></p>");
                        out.println("<h1><strong>UPDATE STUDENT PROFILE</strong></h1>");
                        
                        out.println("<form method=\"post\">");
                        out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">USN:</font></td><td><input type=\"text\" name=\"sid\" value="+id1+" required><br></td></tr>");
                        out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">NAME:</font></td><td><input type =\"text\" name=\"nameS\" value="+name1+" required><br></td></tr>");
                        out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">MAILID:</font></td><td><input type=\"mail\" name=\"mid\" value="+mail1+" required><br></td></tr>");
                       out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">COURSE:</font></td><td><input type=\"text\" name=\"Scourse\" value="+course1+"  required><br></td></tr>");
                       out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">DOB:</font></td><td><input type=\"date\" name=\"Sdob\" value="+dob1+" required><br></td></tr>"); 
                       out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">ADDRESS:</font></td><td><textarea rows=\"5\" cols=\"25\" name=\"addr\" required>"+addr1+" </textarea><br></td></tr>");
                       out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">CONTACT:</font></td><td><input type =\"number\" name=\"sCphn\" value="+phn1+" required><br></td></tr>");
                       out.println("<tr><td bgcolor=\" black\" ><font color=\"white\">GENDER:</font></td><td><input type=\"radio\" name=\"gender\" value=\"male\"> Male<br><input type=\"radio\" name=\"gender\" value=\"female\"> Female<br><input type=\"radio\" name=\"gender\" value=\"other\"> Other<br></td></tr>");
               
                        out.println("</table>");
                        out.println("<br><input type=\"submit\" value=\"update\">");
                        out.println("</form>"); 
                        out.println("<br>");
                        //out.println("do you want to update account details?<a href=accupd><font color=\"blue\">click here<b></b></font></a><br>");

                        String USN1=request.getParameter("sid");
                        String SNAME1=request.getParameter("nameS");
                        String SMAIL1=request.getParameter("mid");
                        String SCOURSE1=request.getParameter("Scourse");
                        String SDOB1=request.getParameter("Sdob");
                        String SADDRESS1=request.getParameter("addr");
                        String SPHONE1=request.getParameter("sCphn");
                        String SSEX1=request.getParameter("gender");

                       if(!AID2.equals(null)&&!AID2.equals(""))
                        {
                            if(SPHONE1.length()==10)
                            {
                    
                               
                                s.setAttribute("USNS",USN1);
                                s.setAttribute("NAMES", SNAME1);
                                s.setAttribute("MAILS",SMAIL1);
                                s.setAttribute("COURSES",SCOURSE1);
                                s.setAttribute("DOBS", SDOB1);
                                s.setAttribute("ADDRS", SADDRESS1);
                                s.setAttribute("PHONES",SPHONE1);
                                s.setAttribute("SEXS",SSEX1);

                                response.sendRedirect("stuupd");
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
            Logger.getLogger(updstu14.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updstu14.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(updstu14.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updstu14.class.getName()).log(Level.SEVERE, null, ex);
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
