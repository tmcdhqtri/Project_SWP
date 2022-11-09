package servlet;

import DAO.DAO;
import com.google.common.hash.Hashing;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Admin
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        HttpSession session = request.getSession();
        if (session.getAttribute("acc") != null)
            request.getRequestDispatcher("./Homepage/index.jsp").forward(request, response);
        else request.getRequestDispatcher("./Register/Register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cusName = request.getParameter("NAME");
        String cusPhone = request.getParameter("PHONE");
        String cusEmail = request.getParameter("EMAIL");
        String cusAddress = request.getParameter("ADDRESS");
        String cusDateOfBirth = request.getParameter("DATEOFBIRTH");
        String cusUsername = request.getParameter("USERNAME");
        String cusPassword = request.getParameter("PASSWORD");
        String confirmPassword = request.getParameter("CONFIRMPASSWORD");
        DAO dao = new DAO();
        cusPassword = Hashing.sha256().hashString(cusPassword, StandardCharsets.UTF_8).toString();
        dao.registeredCustomer(cusName, cusPhone, cusEmail, cusAddress, cusDateOfBirth, cusUsername, cusPassword, true);
        request.setAttribute("MESSAGE2", "Success");
        response.sendRedirect("login");
        }
}