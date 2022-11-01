
package servlet;

import DAO.DAO;
import Model.Personnel;
import com.google.common.hash.Hashing;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;


public class UpdatePasswordAdminServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        request.getRequestDispatcher("/AdminPage/page-account-settings.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String old_password = request.getParameter("old-password");
        String new_password = request.getParameter("new_password");
        String re_password = request.getParameter("re-password");
        
        old_password = Hashing.sha256().hashString(old_password, StandardCharsets.UTF_8).toString();        
        DAO dao = new DAO();
        
        if (dao.loginPersonnel(username, old_password) != null )
        {
            if (!new_password.equals(re_password))
            {
                String message = "New password and re-password are not the same";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/AdminPage/page-account-settings.jsp").forward(request, response);
            }
            else
            {
                HttpSession session = request.getSession();
                new_password = Hashing.sha256().hashString(new_password, StandardCharsets.UTF_8).toString();  
                dao.updatePasswordCustomer(username, re_password);
                session.removeAttribute("acc");
                Personnel acc = dao.getPersonnel(id);
                session.setAttribute("acc", acc);
                request.getRequestDispatcher("/AdminPage/page-account-settings.jsp").forward(request, response);
            }
            
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
