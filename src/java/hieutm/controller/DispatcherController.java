/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieutm.controller;

import hieutm.util.MyAppConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hieu1
 */
@WebServlet(name = "DispatcherController", urlPatterns = {"/DispatcherController"})
public class DispatcherController extends HttpServlet {

//    private final String LOGIN_PAGE = "";
//    private final String LOGIN_SERVLET = "processLogin";
//    private final String SEARCH_LASTNAME_CONTROLLER = "processSearchLastname";
//    private final String DELETE_ACCOUNT_CONTROLLER = "processDeleteAccount";
//    private final String UPDATE_ACCOUNT_CONTROLLER = "processUpdateAccount";
//    private final String STARUP_CONTROLER = "processSatarup";
//    private final String ADD_BOOK_TO_CART = "processAddBookToCart";
//    private final String VIEW_CART_PAGE = "processViewCart";
//    private final String REMOVE_BOOK_FROM_CART = "processRemoveBookFromCart";
//    private final String CREATE_ACCOUNT_CONTROLLER = "processCreateAccount";

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
        
        ServletContext context = this.getServletContext();
        Properties siteMap = (Properties)context.getAttribute("SITEMAP");

        String button = request.getParameter("btAction");
        String url = siteMap.getProperty(MyAppConstants.LOGIN_PAGE);
        try {
            if (button == null) {
                //check cooking
                url = siteMap.getProperty(MyAppConstants.STARUP_CONTROLER);
            } else if (button.equals("login")) {
                url = siteMap.getProperty(MyAppConstants.LOGIN_SERVLET);
            } else if (button.equals("Search")) {
                url = siteMap.getProperty(MyAppConstants.SEARCH_LASTNAME_CONTROLLER);
            } else if (button.equals("Delete")) {
                url = siteMap.getProperty(MyAppConstants.DELETE_ACCOUNT_CONTROLLER);
            } else if (button.equals("Update")) {
                url = siteMap.getProperty(MyAppConstants.UPDATE_ACCOUNT_CONTROLLER);
            } else if (button.equals("Add Book to Your Cart")) {
                url = siteMap.getProperty(MyAppConstants.ADD_BOOK_TO_CART);
            } else if (button.equals("View Your Cart")) {
                url = siteMap.getProperty(MyAppConstants.VIEW_CART_PAGE);
            } else if (button.equals("Remove Selected Books")) {
                url = siteMap.getProperty(MyAppConstants.REMOVE_BOOK_FROM_CART);
            } else if (button.equals("Create New Account")) {
                url = siteMap.getProperty(MyAppConstants.CREATE_ACCOUNT_CONTROLLER);
            }

        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
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
