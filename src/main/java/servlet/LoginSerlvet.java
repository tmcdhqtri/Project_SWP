
package servlet;

import DAO.DAO;
import Model.Customer;
import Model.Personnel;
import com.google.common.hash.Hashing;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "LoginSerlvet", urlPatterns = {"/login"})
public class LoginSerlvet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        
        
        request.getRequestDispatcher("./Login/Login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        password = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        
        DAO dao = new DAO();
        Customer accCus = dao.loginCustomer(username, password);
        Personnel accPerson = dao.loginPersonnel(username, password);
        
        if (accCus!=null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("acc", accCus);
            response.sendRedirect("home");
        }
        else if (accPerson != null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("acc", accPerson);
            if (accPerson.getRole()==true)
                response.sendRedirect("homeadmin");
            else response.sendRedirect("home");
        } 
        
//        String originalString = "abc";
//        String sha256hex = Hashing.sha256()
//                .hashString(originalString, StandardCharsets.UTF_8)
//                .toString();
//        System.out.println("Hash: " + sha256hex);
             
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
