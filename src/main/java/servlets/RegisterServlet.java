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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        User user = User.builder()
                .name(req.getParameter("name"))
                .surname(req.getParameter("surname"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .build();

         userService.register(user);

        if(user!=null){
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", user);
            req.getRequestDispatcher("/home").forward(req,resp);
        }else {
            req.setAttribute("login_errorMessage","Bad credentials!");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
