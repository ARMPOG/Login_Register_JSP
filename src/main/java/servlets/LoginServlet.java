package servlets;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userService.login(email, password);
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        if(user!=null){
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", user);
            resp.sendRedirect("/home");
        }else {
            req.setAttribute("login_errorMessage","Bad credentials!");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
