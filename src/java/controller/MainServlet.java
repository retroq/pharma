/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Drug;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.searchengine.SearchEngine;
import model.searchengine.SearchResult;

/**
 *
 * @author anton
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/search"})
public class MainServlet extends HttpServlet {

    
    @EJB
    SearchEngine se;
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf16");
        String searchString = request.getParameter("query");
        SearchResult searchResult;
        if (searchString != null) {
            searchResult = se.findDrugs(searchString);
            if (searchResult.isEmpty()) {
                request.setAttribute("NOTHING_FOUND", true);
            } else {
                request.setAttribute("searchResult", searchResult);
            }
            
            request.setAttribute("searchString", searchString);
            try {
                request.getRequestDispatcher("WEB-INF/view/search.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                request.getRequestDispatcher("WEB-INF/view/mainPage.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/Pharma/search" + "?query=" + request.getParameter("query"));
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
