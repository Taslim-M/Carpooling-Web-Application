/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DriverRideManagementModule.Driver;
import PassengerRideManagementModule.Passenger;
import UserManagementModule.Account;
import UserManagementModule.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tasli
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

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

        try {
            String userName = request.getParameter("email");
            String password = request.getParameter("pwd");
            boolean isValid= false;
            try {
                isValid = (new Account(userName, password)).login();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (isValid) {//Successful login
                HttpSession session = request.getSession(); 
                if (session != null) //If session is not null
                {
                    //removes all session attributes bound to the session
                    while (session.getAttributeNames().hasMoreElements()) {
                        session.removeAttribute(session.getAttributeNames().nextElement());
                    }
                }
                session.setAttribute("username", userName);
                //If admin, go to the view driver applications page
                if (Admin.isAdmin(userName)) {
   
     
                    RequestDispatcher rd = request.getRequestDispatcher("ViewDriverRequestsController");
                    
                    
                    rd.forward(request, response);
                }
                //else passenger and/or driver login
                Passenger p = Passenger.getPassenger(userName);
                session.setAttribute("passenger", p);
                if (p.isDriver()) {
                    Driver d = new Driver();
                    d.setEmailID(userName);
                    session.setAttribute("driver", d);
                    System.out.println("setting as driver" + userName);
                }
                RequestDispatcher rd = request.getRequestDispatcher("findRide.jsp");
                rd.forward(request, response);
            } else { // GO back to login page
                request.setAttribute("errmsg", "Username or Password is Invalid");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("errmsg", "Connection Error");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
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
