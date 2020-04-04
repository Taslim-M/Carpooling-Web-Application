/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DriverRideManagementModule.Driver;
import PassengerRideManagementModule.Passenger;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author reem
 */
@WebServlet(name = "ConfirmRemovePassengerController", urlPatterns = {"/ConfirmRemovePassengerController"})
public class ConfirmRemovePassengerController extends HttpServlet {

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
        String Passenger_ID = request.getParameter("passenger_id");
        String Ride_ID = request.getParameter("rideid");
        String Choice = request.getParameter("choice");
        
        HttpSession session = request.getSession();
        Driver d = (Driver) session.getAttribute("driver"); //Get the Driver logged in Right now
        if (d != null) {
            
            if ("Confirm".equals(Choice))
            {
                String Confirmation = d.ConfirmPassengerRequest(Ride_ID, Passenger_ID);
                if("Confirmed".equals(Confirmation))
                {
                String Message = "Passenger Confirmed Successfully!";
                RequestDispatcher rd = request.getRequestDispatcher("RemoveRegisteredPassenger.jsp");
                request.setAttribute("Message", Message);
                request.setAttribute("Ride_ID", Ride_ID);
                request.setAttribute("Passenger_ID", Passenger_ID);
                rd.forward(request, response);
                }
                else if ("No Seats".equals(Confirmation))
                {
                    String Message = "No Seats Available in Requested Ride!";
                    RequestDispatcher rd = request.getRequestDispatcher("PassengerRemovedOrNotConfirmed.jsp");
                    request.setAttribute("Message", Message);
                    request.setAttribute("Ride_ID", Ride_ID);
                    rd.forward(request, response);
                }
            }
            else if("RemoveNew".equals(Choice))
            {
                d.RemovePassenger(Ride_ID, Passenger_ID);
                String Message = "Passenger Request Rejected Successfully!";
                RequestDispatcher rd = request.getRequestDispatcher("PassengerRemovedOrNotConfirmed.jsp");
                request.setAttribute("Message", Message);
                request.setAttribute("Ride_ID", Ride_ID);
                rd.forward(request, response);
            }
            else if("RemoveRegistered".equals(Choice))
            {
                d.RemovePassenger(Ride_ID, Passenger_ID);
                String Message = "Passenger Removed Successfully!";
                RequestDispatcher rd = request.getRequestDispatcher("PassengerRemovedOrNotConfirmed.jsp");
                request.setAttribute("Message", Message);
                request.setAttribute("Ride_ID", Ride_ID);
                rd.forward(request, response);
            }

            
            
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
