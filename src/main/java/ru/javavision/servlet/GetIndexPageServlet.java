package ru.javavision.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetIndexPageServlet extends HttpServlet {

    private final static String index = "/WEB-INF/view/index.jsp";

    @Override
    public void init() throws ServletException {
        System.out.println("*************SERVLET IS INIT************");
        System.out.println("FOR PATH '/' WILL RENDER VIEW : " + index);
    }

    /**
     * Multithreading scope.
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("doGet is work!");
        req.getRequestDispatcher(index).forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("*************SERVLET IS DESTROY************");
    }
}
