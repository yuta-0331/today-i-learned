package login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet(name = "ImageFile", value = "/ImageFile")
public class ImageFile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "c:\\image\\";
        String fileName = null;

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            fileName = request.getParameter("file");
        }
        if (fileName == null) {
            fileName = "error.jpg";
        }

        int readByte;
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream in = new BufferedInputStream(Files.newInputStream(Paths.get(path + fileName)));
        while ((readByte = in.read()) != -1) {
            out.write(readByte);
        }


    }

}