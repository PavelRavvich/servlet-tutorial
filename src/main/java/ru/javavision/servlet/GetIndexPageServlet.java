package ru.javavision.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class GetIndexPageServlet extends HttpServlet {

    private AtomicBoolean userIsNew;

    private String indexPage;

    @Override
    public void init() throws ServletException {
        userIsNew = new AtomicBoolean(true);
        indexPage = "/WEB-INF/view/index.jsp";
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println(req.getSession(false));
        req.getRequestDispatcher(indexPage).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        final String massage = req.getParameter("massage");

        HttpSession session = req.getSession(false);

        if (session == null) {
            session = req.getSession(true);
            session.setAttribute("data", "Создание сессиию. Если это сообщение выведется повторно значит сессия уже существует");
        }

        final String store = session.getAttribute("data") + massage + "\n";

        session.setAttribute("data", store);


        req.setAttribute("data", store);

        req.getRequestDispatcher(indexPage).forward(req, resp);
    }
}
