/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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


public class UpdatePasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        
        request.getRequestDispatcher("./Register/updatePass.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        HttpSession session = request.getSession();
        
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String old_password = request.getParameter("old-password");
        String new_password = request.getParameter("new_password");
        String re_password = request.getParameter("re-password");
        
        old_password = Hashing.sha256().hashString(old_password, StandardCharsets.UTF_8).toString();        
        DAO dao = new DAO();
        
        Customer accCus = dao.loginCustomer(username, old_password);
        Personnel accPerson = dao.loginPersonnel(username, old_password);
        
        if (accCus != null)
        {
            if (!new_password.equals(re_password))
            {
                String message = "New password and re-password are not the same";
                request.setAttribute("message", message);
                request.getRequestDispatcher("./Register/updatePass.jsp").forward(request, response);
            }
            else
            {
                new_password = Hashing.sha256().hashString(new_password, StandardCharsets.UTF_8).toString();  
                dao.updatePasswordCustomer(username, re_password);
                session.removeAttribute("acc");
                Customer acc = dao.getCustomer(id);
                session.setAttribute("acc", acc);
                request.getRequestDispatcher("./Register/updateInfor.jsp").forward(request, response);

            }
        }
        else if (accPerson != null)
        {
            if (!new_password.equals(re_password))
            {
                String message = "New password and re-password are not the same";
                request.setAttribute("message", message);
                request.getRequestDispatcher("./Register/updatePass.jsp").forward(request, response);
            }
            else
            {
                new_password = Hashing.sha256().hashString(new_password, StandardCharsets.UTF_8).toString();  
                dao.updatePasswordCustomer(username, re_password);
                session.removeAttribute("acc");
                Personnel acc = dao.getPersonnel(id);
                session.setAttribute("acc", acc);
                request.getRequestDispatcher("./Register/updateInfor.jsp").forward(request, response);

            }
        } 
        else 
        {
            String message = "Wrong old password";
            request.setAttribute("message", message);
            request.getRequestDispatcher("./Register/updatePass.jsp").forward(request, response);
        }
    }


}
