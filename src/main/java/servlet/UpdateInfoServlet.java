package servlet;

import DAO.DAO;
import Model.Customer;
import Model.Personnel;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
            dao.updateCustomer(id, name, phone, email, address, dob);
            session.setAttribute("acc", accCus);
            session.removeAttribute("acc");
            Customer acc = dao.getCustomer(id);
            session.setAttribute("acc", acc);
            request.getRequestDispatcher("./Register/updateInfor.jsp").forward(request, response);
        }
        else if (accPerson != null)
        {
            dao.updatePersonnnel(id, name, phone, email, address, dob, "");
            session.removeAttribute("acc");
            Personnel acc = dao.getPersonnel(id);
            session.setAttribute("acc", acc);
            request.getRequestDispatcher("./Register/updateInfor.jsp").forward(request, response);
        }
        else
        {

            String message = "Wrong username or password";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/Login/Login.jsp").forward(request, response);
        }  
        
    }



}
