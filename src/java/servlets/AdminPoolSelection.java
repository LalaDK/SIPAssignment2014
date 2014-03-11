/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.Controller;
import interfaces.IController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thomas
 */
@WebServlet(name = "AdminPoolSelectionController", urlPatterns = {"/AdminPoolSelectionController"})
public class AdminPoolSelection extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        IController control = new Controller();
//        request.setAttribute("subjects", control.getSubjectsForRound(2));
//        request.setAttribute("satisfaction", control.getSatisfaction());
        

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/AdminPoolSelection.jsp");
        dispatcher.forward(request, response);
    }
}
