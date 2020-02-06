package servlets;


import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        if (currentUser!=null) {
            req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("index.jsp");
        }
    }
}

