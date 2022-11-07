package servlet;

import DAO.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateStatusOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String orderId = request.getParameter("orderid");
        String status = request.getParameter("status");
        String username = request.getParameter("username");
        
        
        DAO dao = new DAO();
        dao.updateOrderStatus(Integer.parseInt(orderId), Integer.parseInt(status));
        
        if (dao.getPersonnelByUsername(username) != null)
        {
            request.getRequestDispatcher("viewDetailAdmin?orderid="+orderId).forward(request, response);
        }
        else if (dao.getCustomerByUsername(username) != null)
        {
            request.getRequestDispatcher("detailOrder?orderid="+orderId).forward(request, response);
        }
        else
        {
            request.getRequestDispatcher("login").forward(request, response);
        }
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
