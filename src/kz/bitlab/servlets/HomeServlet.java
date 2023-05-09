package kz.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.Blog;
import kz.bitlab.db.DBConnection;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ArrayList<Blog> blogs = DBConnection.getAllBlogs();
        request.setAttribute("blogs", blogs);
        request.getRequestDispatcher("/blog.jsp").forward(request, response);
    }
}
