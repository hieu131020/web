/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieutm.controller;

import hieutm.login.LoginDAO;
import hieutm.login.LoginDTO;
import hieutm.util.MyAppConstants.SearchLastNameFeatures;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.naming.NamingException;
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
@WebServlet(name = "SearchLastnameServlest", urlPatterns = {"/SearchLastnameServlest"})
public class SearchLastnameServlest extends HttpServlet {

//    private final String SEAR_PAGE = "viewSearch";
//    private final String SHOW_RESULT_PAGE = "processSearch";

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
        String searchValue = request.getParameter("txtSearchValue");
        String url = siteMap.getProperty(SearchLastNameFeatures.SEAR_PAGE);
        try {
            if (!searchValue.trim().isEmpty()) {
                // call DAO
                LoginDAO dao = new LoginDAO();
                dao.saerchLastName(searchValue);
                List<LoginDTO> result = dao.getAccountList();
                request.setAttribute("SEARCHRESULT", result);
                
                url = siteMap.getProperty(SearchLastNameFeatures.SHOW_RESULT_PAGE);
            }//end if search value is inputed value from user
        } catch (SQLException ex) {
            log("LoginSevrlet SQL" + ex.getMessage());
        } catch (NamingException ex) {
            log("LoginSevrlet Naming" + ex.getMessage());
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
