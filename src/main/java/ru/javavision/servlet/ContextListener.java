package ru.javavision.servlet;

import ru.javavision.model.User;
import ru.javavision.util.Utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class ContextListener implements ServletContextListener {

    private Map<Integer, User> users;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        users = new ConcurrentHashMap<>();

        servletContext.setAttribute("users", users);

        final User user = Utils.createStubUser(1, "Первый", 10);
        this.users.put(user.getId(), user);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Close recourse.
        users = null;
    }
}