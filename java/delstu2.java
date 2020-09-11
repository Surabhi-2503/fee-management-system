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
public class delstu2 extends HttpServlet {

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
                String ID1=null;
                
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet delacc</title>");            
            out.println("</head>");
            out.println(" <body style=\"margin:0px;\">");
            out.println(" <table style=\"width:100%;border-collapse: collapse;font:14px comic sans ms,sans-serif;\"><tr><td colspan=\"2\" style=\"padding:5px 5px; background-color:black;\"><center><font color=\"white\"><h1>ANVESHAN COACHING CENTER</h1></font></center><right><a href=\"logout\"><font color=\"white\"><h5>LOGOUT</h5></font></right></a></td></tr>");
            out.println("<tr align=\"top\" style=\"height: 200px;\"><td style=\"width:25%;padding:315px;background-color:cyan;vertical-align: top;\"> ");
           
           
             
             ID1=request.getParameter("id");
             out.println(ID1);
                if(!ID1.equals(null)&&!ID1.equals("")) 
                {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager"); 
                    Statement stmt1=con1.createStatement();
                    ResultSet rs1=stmt1.executeQuery("delete from stuacc where SUSN='"+ID1+"'");
                    con1.close();
             
            out.println("<script>alert(\" deleted successfully\")</script>");
                out.println("<meta http-equiv='refresh' content='0;URL=viewstu'>");
            }   else{
                    
                    out.println("<script>alert(\" invalid ID\")</script>");
                out.println("<meta http-equiv='refresh' content='0;URL=viewstu'>");
                }
           
            out.println("</body>");
            out.println("</html>");
        }catch(Exception e){
            out.println(e);
           // out.println("<script>alert(\" Data Not Deleted \t"+e+"\")</script>");
               // out.println("<meta http-equiv='refresh' content='0;URL=viewstu'>");
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
            Logger.getLogger(delstu2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(delstu2.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(delstu2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(delstu2.class.getName()).log(Level.SEVERE, null, ex);
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
