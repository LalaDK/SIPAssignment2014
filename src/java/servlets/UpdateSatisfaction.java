package servlets;

import com.google.gson.Gson;
import dataTransferObjects.DtoStudent;
import entities.Person;
import interfaces.IDataManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateSatisfaction", urlPatterns = {"/UpdateSatisfaction"})
public class UpdateSatisfaction extends HttpServlet {
    @EJB
    private IDataManager dataManager;
//    private IDataManager dataManager = DummyData.getInstance();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Gson gson = new Gson();
        try (PrintWriter out = response.getWriter()) {
            HashMap<String, ArrayList<DtoStudent>> result = dataManager.getSatisfaction();
            HashMap<String, Integer> count = new HashMap<>();
            
            for(String key : result.keySet()) {
                count.put(key, result.get(key).size());
            }
            
//            System.out.println(gson.toJson(count));
            out.println(gson.toJson(count));
        }
    }

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
