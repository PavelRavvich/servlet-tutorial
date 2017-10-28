package ru.javavision.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetIndexPageServlet extends HttpServlet {

    private final static String indexPage = "/WEB-INF/view/index.jsp";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        final HttpSession session = req.getSession();

        final String state = (String) session.getAttribute("state");

        if (state != null){
            //Set new session state to request for view.
            req.setAttribute("dataForView", session.getAttribute("state"));
        }

        req.getRequestDispatcher(indexPage).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        //Extract of data from user's input.
        final String dataFromUser = req.getParameter("data");

        //Get session from request.
        final HttpSession session = req.getSession();

        //Get current state from session.
        final String currentState = (String) session.getAttribute("state");

        if (currentState != null) {
            //Update old state value to new.
            session.setAttribute("state", currentState + " : " + dataFromUser);
        } else {
            //Init state value.
            session.setAttribute("state", dataFromUser);
        }

        doGet(req, resp);
    }
}
