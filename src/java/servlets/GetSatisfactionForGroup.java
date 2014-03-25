/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import entities.Person;
import entities.Vote;
import interfaces.IDataManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mads
 */
@WebServlet(name = "GetSatisfactionShitEllerSådanNoget", urlPatterns = {"/GetSatisfactionShitEllerS_danNoget"})
public class GetSatisfactionForGroup extends HttpServlet {

    private IDataManager dataManager;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String group = request.getParameter("group");

        response.setContentType("text/html;charset=UTF-8");
        Gson gson = new Gson();
        try (PrintWriter out = response.getWriter()) {
            HashMap<String, ArrayList<Person>> result = dataManager.getSatisfaction();

            ArrayList<String[]> data = new ArrayList<>();

            for (Person p : result.get(group)) {
                ArrayList<Vote> votes = new ArrayList<>();
                for (Vote vote : p.getVoteCollection()) {
                    votes.add(vote);
                }

                data.add(new String[]{
                    p.getName(),
                    votes.get(0).getSubject().getSubjectname(),
                    votes.get(1).getSubject().getSubjectname(),
                    votes.get(2).getSubject().getSubjectname(),
                    votes.get(3).getSubject().getSubjectname(),});
            }

            System.out.println(gson.toJson(data));
            out.println(gson.toJson(data));
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
