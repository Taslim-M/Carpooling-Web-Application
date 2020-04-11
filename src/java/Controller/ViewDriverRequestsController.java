///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//
///**
// *
// * @author ayahal-harthy
// */
//
//package Controller;
//
//import DriverRideManagementModule.Driver;
//import UserManagementModule.Admin;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.sql.rowset.CachedRowSet;
//
///**
// *
// * @author azada
// */
//@WebServlet(name = "ViewDriverRequestsController", urlPatterns = {"/ViewDriverRequestsController"})
//public class ViewDriverRequestsController extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     * @throws java.sql.SQLException
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, SQLException {
//        ArrayList<Driver> names;
//        //ArrayList<WeeklyRide> weeklyRides;
//        //ArrayList<Name ID> name;
//        HttpSession session = request.getSession();
//        //Passenger p = (Passenger) session.getAttribute("passenger"); //Get the Driver logged in Right now
//        Admin a = (Admin) session.getAttribute("admin"); 
//        if(a != null){
//            names = a.retriveDriverRequests();
//
//            RequestDispatcher rd = request.getRequestDispatcher("ViewDriverApplications.jsp");
//
//            request.setAttribute("Name", names);
//            //request.setAttribute("weeklyRides", weeklyRides);
//            rd.forward(request, response);
//        
//        }
//        
//        
//
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}

