package login;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Auth auth = new Auth();
        if (auth.loggedIn(cookies)) {
            response.sendRedirect("/page");
            return;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login/loginForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        Auth auth = new Auth();

        if (auth.isAuth(id, pw)) {
            Cookie cookie = new Cookie("stamp", "1234");
            response.addCookie(cookie);
        }
    }
}