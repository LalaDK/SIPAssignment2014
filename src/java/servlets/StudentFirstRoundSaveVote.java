/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Vote;
import entities.VotePK;
import interfaces.IDataManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomas
 */
@WebServlet(name = "StudentFirstRoundSaveVote", urlPatterns = {"/StudentFirstRoundSaveVote"})
public class StudentFirstRoundSaveVote extends HttpServlet {

    @EJB
    private IDataManager dataManager;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        BigInteger round = new BigInteger("1");
        try {
            BigInteger studentId = new BigInteger(request.getParameter("studentid"));
            String[] firstpri = request.getParameterValues("firstpriority");
            String[] secondpri = request.getParameterValues("secondpriority");

            dataManager.removeVotes(studentId, round);
            for(String s : firstpri){
                dataManager.saveVote(new Vote(new VotePK(studentId, round, new BigInteger(s)), new BigInteger("1")));
            }
       
            for(String s : secondpri){
                dataManager.saveVote(new Vote(new VotePK(studentId, round, new BigInteger(s)), new BigInteger("2")));
            }
            
            RequestDispatcher dis = this.getServletContext().getRequestDispatcher("/StudentVoteAccepted.jsp");
            dis.forward(request, response);
        } catch (Exception e) {
            System.out.println("Getting data" + e.getStackTrace());
            RequestDispatcher dis = this.getServletContext().getRequestDispatcher("/StudentVoteNotAccepted.jsp");
            dis.forward(request, response);
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
