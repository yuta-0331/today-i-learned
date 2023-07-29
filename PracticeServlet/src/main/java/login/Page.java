package login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "page", urlPatterns = "/page")
public class Page extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Auth auth = new Auth();
        if (!auth.loggedIn(cookies)) {
            response.sendRedirect("login");
            return;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login/page.jsp");
        dispatcher.forward(request, response);
    }
}