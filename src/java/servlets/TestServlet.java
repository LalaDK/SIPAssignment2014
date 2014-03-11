/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dummyData.DummyData;
import entities.Person;
import entities.Subject;
import interfaces.IDataManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mads
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

//    @EJB
    private IDataManager entityManager = DummyData.getInstance();

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
        try (PrintWriter out = response.getWriter()) {

            
            // getAllSubjectsFromRound(2)
            String subjectFromRound2 = "";
            Collection<Subject> subjects = entityManager.getAllSubjectsFromRound(2);
            for (Subject value : subjects) {
                subjectFromRound2 += value.getSubjectname() + "<br>";
            }
            
            // getAmountOfVotesFromSubject
            int amountOfVotesFromRound2Subject6 = entityManager.getAmountOfVotesFromSubject(2, 6);

            
            // getAllPersonsInRound
            Collection<Person> persons = entityManager.getAllPersonsInRound(2);
            String personsInRound2 = "";
            for(Person person : persons) {
                personsInRound2 += person.getName() + "<br>";
            }
            
            
            
            // Test utility class
            ArrayList<Subject> allSubjects = new ArrayList<>();
            allSubjects.addAll(entityManager.getAllSubjects());
            
            ArrayList<Person> allPersons = new ArrayList<>();
            allPersons.addAll(entityManager.getAllPersons());
            
            utilities.Utilities.getSatisfaction(allSubjects, allPersons);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<b>getAllSubjectsFromRound(2)</b><br>" + subjectFromRound2 + "<br><br>");
            
            out.println("<b>amountOfVotesFromRound2Subject6</b><br>" + amountOfVotesFromRound2Subject6 + "<br><br>");
            
            out.println("<b>getAllPersonsInRound(2)</b><br>" + personsInRound2 + "<br><br>");
                        
            out.println("<b>Subjects in round 2:</b><br>" + subjectFromRound2);
            out.println("</body>");
            out.println("</html>");
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
