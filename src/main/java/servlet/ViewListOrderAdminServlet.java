package servlet;

import DAO.DAO;
import Model.Customer;
import Model.Order;
import Model.Personnel;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

public class ViewListOrderAdminServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        DAO dao = new DAO();
        ArrayList<Order> aAllOrder = dao.getAllOrders();
        HttpSession session = request.getSession();
        Personnel accPer = (Personnel) session.getAttribute("acc");
        Customer accCus = (Customer) session.getAttribute("acc");
        if (accCus!=null || accPer.getRole()==true){
        response.sendRedirect("home");
        } else if (accPer==null || accCus==null){
        response.sendRedirect("login");
        }
        request.setAttribute("aAllOrder", aAllOrder);
        request.getRequestDispatcher("./AdminPage/listOrder.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
