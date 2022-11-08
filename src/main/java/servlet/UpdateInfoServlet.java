package servlet;

import DAO.DAO;
import Model.Customer;
import Model.Personnel;
import com.google.common.hash.Hashing;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

public class UpdateInfoServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
                
        request.getRequestDispatcher("./Register/updateInfor.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        
        DAO dao = new DAO();
        Customer accCus = dao.loginCustomer(username, password);
        Personnel accPerson = dao.loginPersonnel(username, password);
        if (accCus != null)
        {
            System.out.println("update Cus");
            dao.updateCustomer(id, name, phone, email, address, dob);
            session.setAttribute("acc", accCus);
            session.removeAttribute("acc");
            Customer acc = dao.getCustomer(id);
            session.setAttribute("acc", acc);
            response.sendRedirect("info");
        }
        else if (accPerson != null)
        {
            System.out.println("Update personnel");
            dao.updatePersonnnel(id, name, phone, email, address, dob, "");
            session.removeAttribute("acc");
            Personnel acc = dao.getPersonnel(id);
            session.setAttribute("acc", acc);
            response.sendRedirect("info");
        }
        else
        {

            System.out.println("Wrong username or password");
//            request.setAttribute("message", message);
            request.getRequestDispatcher("/Login/Login.jsp").forward(request, response);
        }  
        
    }



}
