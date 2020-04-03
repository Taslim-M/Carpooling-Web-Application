/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import PassengerRideManagementModule.Location;
import PassengerRideManagementModule.Passenger;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author azada
 */
@WebServlet(name = "SearchRidesController", urlPatterns = {"/SearchRidesController"})
public class SearchRidesController extends HttpServlet {

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
        //Collect and parse all form inputs 
        boolean isSingle = request.getParameter("single_or_weekly").equals("single");
        String isToUni = (request.getParameter("to_from_uni").equals("to") ? "1" : "0");
        LocalDate date = null;
        ArrayList<String> days = null;
        if (isSingle){
            date = LocalDate.parse(request.getParameter("ride_date"));
        }
        else{
            days = new ArrayList<>();
            for (String day : request.getParameterValues("ride_days")){
                days.add(day);
            }    
        }
        float longi = Float.parseFloat(request.getParameter("ride_location_longitude"));
        float lati = Float.parseFloat(request.getParameter("ride_location_latitude"));
        Location rideLocation = new Location(longi, lati);
        String rideTime = request.getParameter("ride_time");
        
        Passenger.searchRides(isSingle, isToUni, date, days, rideLocation, rideTime);
        
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
