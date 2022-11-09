package servlet;

import DAO.DAO;
import Model.Customer;
import Model.Personnel;
import com.google.common.hash.Hashing;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import Model.Item;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        HttpSession session = request.getSession();
        if (session.getAttribute("acc") == null)
            request.getRequestDispatcher("./Login/Login.jsp").forward(request, response);
        else response.sendRedirect("home");
            
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username);
        
        password = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        System.out.println("password: " + password);
        
        DAO dao = new DAO();
        Personnel accPerson = (Personnel) dao.loginPersonnel(username, password);
        Customer accCus = dao.loginCustomer(username, password);
        ArrayList<Item> cart = new ArrayList<>();
        
        if (accCus != null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("acc", accCus);
            session.setAttribute("cart", cart);
            response.sendRedirect("./home");
        }
        else if (accPerson != null)
        {
            System.out.println("accPerson");
            HttpSession session = request.getSession();
            session.setAttribute("acc", accPerson);
            session.setAttribute("cart", cart);
            if (accPerson.getRole()==false)
                response.sendRedirect("HomeAdminServlet");
            else response.sendRedirect("./home");
        }
        else
        {

            String message = "Wrong username or password";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/Login/Login.jsp").forward(request, response);
        }  
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
