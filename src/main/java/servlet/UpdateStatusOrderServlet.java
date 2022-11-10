package servlet;

import DAO.DAO;
import Model.Customer;
import Model.Personnel;
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
        
        Personnel personnel = dao.getPersonnelByUsername(username);
        Customer customer = dao.getCustomerByUsername(username);
        System.out.println(username);
        
        if (personnel != null) //Neu nguoi cap nhap la Personnel
        {

            if (personnel.getRole())  //Neu la Admin
                response.sendRedirect("detailOrder?orderid="+orderId);
            else //Neu la staff
                request.getRequestDispatcher("viewDetailAdmin?orderid="+orderId).forward(request, response);
        }
        else if (customer != null) //Neu nguoi cap nhap la Customer
        {
            response.sendRedirect("detailOrder?orderid="+orderId);
        }
        else
        {
            response.sendRedirect("login");
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
