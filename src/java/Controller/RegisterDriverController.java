/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DriverRideManagementModule.Driver;
import PassengerRideManagementModule.Passenger;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Tasli
 */
@MultipartConfig
@WebServlet(name = "RegisterDriverController", urlPatterns = {"/RegisterDriverController"})
public class RegisterDriverController extends HttpServlet {

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

        String carModel = request.getParameter("carModel");
        String capacity = request.getParameter("capacity");

        // obtains the upload file part in this multipart request
        Part filePartEID = request.getPart("EID");
        Part filePartLicense = request.getPart("license");
        Part filePartCarReg = request.getPart("carReg");
        System.out.println(filePartCarReg);
        HttpSession session = request.getSession();
        Passenger p = (Passenger) session.getAttribute("passenger");
        Integer carCapacity = Integer.parseInt(capacity);

        boolean checkDetails = p.checkDriverRegistrationDetails(carModel, carCapacity, filePartEID, filePartLicense, filePartCarReg);
        if(checkDetails){
            try {
                System.out.println("Inside");
                Driver d = new Driver();
                boolean success = d.updateDriverProfile(p.getEmailID(), carModel, carCapacity, filePartEID, filePartLicense, filePartCarReg);
                if(success){
                    request.setAttribute("errmsg", "Submitted your application. Please wait for admin to review.");
                }else{
                    System.out.println("Driver did not add");
                    request.setAttribute("errmsg", "Something went wrong. Try again Later");
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterDriverController.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("errmsg", "Something went wrong. If you already submitted a request earlier, please have patience.");
            }
        }else{
            System.out.println("Passenger said false");
             request.setAttribute("errmsg", "Something went wrong. Please enter details correctly.");
        }
        RequestDispatcher rd = request.getRequestDispatcher("RegisterAsDriver.jsp");
        rd.forward(request, response);
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
