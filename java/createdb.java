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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Surabhi
 */
public class createdb extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet createdb</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>DB CREATION</h1>");
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
 Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            Statement stmt1=con1.createStatement();
            stmt1.executeQuery("create table actreg (id varchar(50),name varchar(100),passwd varchar(150),address varchar(1000),phone varchar(30),email varchar(30),primary key(id,email))");
           
          out.println("accoutant table  created successfully <br>");
            con1.close();
            
           Connection con2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            Statement stmt2=con2.createStatement();
            
            stmt2.executeQuery("CREATE table studreg(rollno varchar(200),name varchar(250),EMAILS varchar(500),gender varchar(300),course varchar(1000),dob varchar(20),address varchar(1000),contact int,primary key(rollno))");
            out.println("student table  created successfully");
            con2.close();
   
       Connection con3=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            Statement stmt3=con3.createStatement();
            stmt3.executeQuery("CREATE table stuacc(SUSN varchar(200),mode_of_payment varchar(10),fee_amt int,check_OR_DD_number varchar(250),amount_paid int,due_amt int,date_of_payment varchar(100),primary key(check_OR_DD_number,date_of_payment),foreign key(SUSN) references studreg(rollno))");
            
          out.println("stuacc.. table  created successfully <br>");
            con3.close();
           
            out.println("</body>");
            out.println("</html>");
        }catch(Exception e){
            out.print(e);
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
            Logger.getLogger(createdb.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(createdb.class.getName()).log(Level.SEVERE, null, ex);
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
