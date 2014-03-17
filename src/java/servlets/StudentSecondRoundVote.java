package servlets;

import entities.Vote;
import entities.VotePK;
import interfaces.IDataManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomas
 */
@WebServlet(name = "StudentSecondRoundVote", urlPatterns = {"/StudentSecondRoundVote"})
public class StudentSecondRoundVote extends HttpServlet {

    @EJB
    private IDataManager dataManager;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        BigInteger round = new BigInteger("2");
        try {
            BigInteger subjectIdFirstPriorityPoolA = new BigInteger(request.getParameter("priority1poola"));
            BigInteger subjectIdSecondPriorityPoolA = new BigInteger(request.getParameter("priority2poola"));
            BigInteger subjectIdFirstPriorityPoolB = new BigInteger(request.getParameter("priority1poolb"));
            BigInteger subjectIdSecondPriorityPoolB = new BigInteger(request.getParameter("priority2poolb"));
            BigInteger studentId = new BigInteger(request.getParameter("studenid"));
            
            Vote firstPriorityPoolA = new Vote(new VotePK(studentId, subjectIdFirstPriorityPoolA, round),new BigInteger("1"));
            Vote secondPriorityPoolA = new Vote(new VotePK(studentId, subjectIdSecondPriorityPoolA, round),new BigInteger("2"));
            Vote firstPriorityPoolB = new Vote(new VotePK(studentId, subjectIdFirstPriorityPoolB, round),new BigInteger("1"));            
            Vote secondPriorityPoolB = new Vote(new VotePK(studentId, subjectIdSecondPriorityPoolB, round),new BigInteger("2"));

            dataManager.saveVote(firstPriorityPoolA);
            dataManager.saveVote(secondPriorityPoolA);
            dataManager.saveVote(firstPriorityPoolB);
            dataManager.saveVote(secondPriorityPoolB);
        } catch (Exception e) {
            System.out.println("Getting data" + e.getStackTrace());
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