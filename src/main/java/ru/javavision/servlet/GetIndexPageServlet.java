package ru.javavision.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetIndexPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        req.setAttribute("simpleOutput", new Poem());

        final List<String> operations = new ArrayList<>();
        operations.add("eq – проверка на равенство");
        operations.add("ne – проверка на неравенство");
        operations.add("lt – строго менее чем");
        operations.add("gt – строго более чем");
        operations.add("le – меньше либо равно чему-то");
        operations.add("ge – больше или равно чему-то");
        req.setAttribute("operations", operations);

        req.setAttribute("condition", true);

        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }

    public static class Poem {
        private String text = "Я помню море пред грозою: \n" +
                "Как я завидовал волнам, \n" +
                "Бегущим бурной чередою \n" +
                "С любовью лечь к ее ногам! \n" +
                "А. С. Пушкин";

        public String getText() {
            return text;
        }
    }
}
