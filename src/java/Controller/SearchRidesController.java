/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DriverRideManagementModule.Ride;
import PassengerRideManagementModule.Location;
import PassengerRideManagementModule.Passenger;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
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
        
        float homeLongitude = Float.parseFloat(request.getParameter("home_location_longitude"));
        float homeLatitude = Float.parseFloat(request.getParameter("home_location_latitude"));
        Location homeLocation = new Location(homeLatitude, homeLongitude);
        float uniLongitude = Float.parseFloat(request.getParameter("uni_location_longitude"));
        float uniLatitude = Float.parseFloat(request.getParameter("uni_location_latitude"));
        Location uniLocation = new Location(uniLatitude, uniLongitude);
        
        String rideTime = request.getParameter("ride_time");
        ArrayList<Ride> foundRides;
        if (isToUni.equals("1")){
            foundRides = Passenger.searchRides(isSingle, isToUni, date, days, homeLocation, uniLocation, rideTime);
            request.setAttribute("pickup_location", (request.getParameter("home_location_latitude") + ", " + request.getParameter("home_location_longitude")));
            request.setAttribute("dropoff_location", (request.getParameter("uni_location_latitude") + ", " + request.getParameter("uni_location_longitude")));

        }
        else{
            foundRides = Passenger.searchRides(isSingle, isToUni, date, days, uniLocation, homeLocation, rideTime);
            request.setAttribute("dropoff_location", (request.getParameter("home_location_latitude") + ", " + request.getParameter("home_location_longitude")));
            request.setAttribute("pickup_location", (request.getParameter("uni_location_latitude") + ", " + request.getParameter("uni_location_longitude")));
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("MakeRideRequest.jsp");
        request.setAttribute("found_rides", foundRides);
        rd.forward(request,response);
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
