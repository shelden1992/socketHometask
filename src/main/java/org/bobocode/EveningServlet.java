package org.bobocode;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/evening")
public class EveningServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String nameParam = req.getParameter("name");
        String nameSession = (String) session.getAttribute("name");
        String name;
        if (StringUtils.isBlank(nameSession)) {
            name = nameParam;
            session.setAttribute("name", nameParam);
        } else {
            name = nameSession;
        }

        String goodEvening = String.format("Good evening, %s", name);
        PrintWriter writer = resp.getWriter();
        writer.println(goodEvening);
        System.out.println(goodEvening);
        writer.flush();
    }
}

