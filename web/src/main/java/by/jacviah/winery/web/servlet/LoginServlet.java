package by.jacviah.winery.web.servlet;

import by.jacviah.winery.service.ServiceFactory;
import by.jacviah.winery.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        {

            ServiceFactory factory = ServiceFactory.getInstance();
            UserService service = factory.getUserService();
            service.init();

            String errorMessage = "";

            String name = req.getParameter("username");
            String pass = req.getParameter("password");

            if (name == null || name.isEmpty()) {
                errorMessage = "Empty login, please enter your login.";
            }

            if (pass.isEmpty()) {
                errorMessage = "Empty password, please enter your password.";
            }

            if (service.findUser(name) == null) {
                errorMessage = "This user does not exist, please check the login.";
            }

            if (!errorMessage.equals("")) {
                req.setAttribute("errorMessage", errorMessage);
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            } else {
                req.setAttribute("user", service.findUser(name).getUsername());
                req.setAttribute("uuid", service.findUser(name).getUsername());
                req.getRequestDispatcher("/home.jsp").forward(req, resp);
            }
        }
    }
}